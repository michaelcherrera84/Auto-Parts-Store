package com.michaelcherrera.autopartsstore.entities;

import jakarta.persistence.*;

import java.io.Serializable;

/**
 * Entity class for the supplier-part relationship table containing suppliers and the parts they supply.
 */
@Entity
public class SupplierPart {

    // Fields

    @EmbeddedId
    private SupplierPartPK id;

    private Double price;

    private Integer quantity;


    // Constructors

    public SupplierPart() {}

    public SupplierPart(SupplierPartPK supplierPartPK, Double price, Integer quantity) {

        this.id = supplierPartPK;
        this.price = price;
        this.quantity = quantity;
    }

    public SupplierPart(Supplier supplier, Part part, Double price, Integer quantity) {

        this.id = new SupplierPartPK(supplier, part);
        this.price = price;
        this.quantity = quantity;
    }


    // Setters and Getters

    public SupplierPartPK getId() {return id;}

    public void setId(SupplierPartPK id) {this.id = id;}

    public Double getPrice() {return price;}

    public void setPrice(Double price) {this.price = price;}

    public Integer getQuantity() {return quantity;}

    public void setQuantity(Integer quantity) {this.quantity = quantity;}

    /**
     * Multi-attribute primary key class for the {@link SupplierPart} class.
     */
    @Embeddable
    public static class SupplierPartPK implements Serializable {

        // Fields

        @ManyToOne
        @JoinColumn(name = "supplier")
        private Supplier supplier;

        @ManyToOne
        @JoinColumn(name = "part")
        private Part part;


        // Constructors

        public SupplierPartPK() {}

        public SupplierPartPK(Supplier supplier, Part part) {

            this.supplier = supplier;
            this.part = part;
        }


        // Overrides

        @Override
        public boolean equals(Object o) {

            if (o == null || getClass() != o.getClass()) return false;

            SupplierPartPK that = (SupplierPartPK) o;
            return supplier.equals(that.supplier) && part.equals(that.part);
        }

        @Override
        public int hashCode() {

            int result = supplier.hashCode();
            result = 31 * result + part.hashCode();
            return result;
        }
    }
}
