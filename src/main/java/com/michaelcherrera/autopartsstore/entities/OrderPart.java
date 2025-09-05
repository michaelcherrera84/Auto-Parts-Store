package com.michaelcherrera.autopartsstore.entities;

import jakarta.persistence.*;

import java.io.Serializable;

/**
 * Entity class for the order-part relationship table container orders and the parts included in each order.
 */
@Entity
public class OrderPart {

    // Fields

    @EmbeddedId
    private OrderPartPK id;

    private Integer quantity;


    // Constructors

    public OrderPart() {}

    public OrderPart(OrderPartPK id, int quantity) {

        this.id = id; this.quantity = quantity;
    }

    public OrderPart(Orders orders, Part part, int quantity) {

        this.id = new OrderPartPK(orders, part); this.quantity = quantity;
    }


    // Setters and Getters

    public OrderPartPK getId() {return id;}

    public void setId(OrderPartPK id) {this.id = id;}

    public Integer getQuantity() {return quantity;}

    public void setQuantity(Integer quantity) {this.quantity = quantity;}

    /**
     * Multi-attribute primary key class for the {@link OrderPart} class.
     */
    @Embeddable
    public static class OrderPartPK implements Serializable {

        // Fields

        @ManyToOne
        @JoinColumn(name = "orders")
        private Orders orders;

        @ManyToOne
        @JoinColumn(name = "part")
        private Part part;


        // Constructors

        public OrderPartPK() {}

        public OrderPartPK(Orders orders, Part part) {

            this.orders = orders;
            this.part = part;
        }


        // Overrides

        @Override
        public boolean equals(Object o) {

            if (o == null || getClass() != o.getClass()) return false;

            OrderPartPK that = (OrderPartPK) o;
            return orders.equals(that.orders) && part.equals(that.part);
        }

        @Override
        public int hashCode() {

            int result = orders.hashCode();
            result = 31 * result + part.hashCode();
            return result;
        }
    }
}
