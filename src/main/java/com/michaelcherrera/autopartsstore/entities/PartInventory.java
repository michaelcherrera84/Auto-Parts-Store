package com.michaelcherrera.autopartsstore.entities;

import jakarta.persistence.*;

/**
 * Entity class for the inventory table containing parts in the store's inventory.
 */
@Entity
public class PartInventory {

    // Fields

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "part")
    private Part part;

    @ManyToOne
    @JoinColumn(name = "supplier")
    Supplier supplier;

    private Double price;

    @ManyToOne
    @JoinColumn(name = "country")
    private Country country;

    private Boolean Sold;


    // Constructors

    public PartInventory() {}

    public PartInventory(Part part, Supplier supplier, Country country, Double price, Boolean Sold) {

        this.part = part;
        this.supplier = supplier;
        this.country = country;
        this.price = price;
        this.Sold = Sold;
    }


    // Setters and Getters

    public Long getId() {return id;}

    public void setId(Long id) {this.id = id;}

    public Part getPart() {return part;}

    public void setPart(Part part) {this.part = part;}

    public Supplier getSupplier() {return supplier;}

    public void setSupplier(Supplier supplier) {this.supplier = supplier;}

    public Double getPrice() {return price;}

    public void setPrice(Double price) {this.price = price;}

    public Country getCountry() {return country;}

    public void setCountry(Country country) {this.country = country;}

    public Boolean getSold() {return Sold;}

    public void setSold(Boolean sold) {Sold = sold;}
}
