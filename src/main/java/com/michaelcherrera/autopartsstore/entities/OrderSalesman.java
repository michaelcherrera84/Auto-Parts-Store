package com.michaelcherrera.autopartsstore.entities;

import jakarta.persistence.*;

import java.io.Serializable;

/**
 * Entity class for the orders-salesman relationship table containing orders that were made through a salesman.
 */
@Entity
public class OrderSalesman {

    // Fields

    @EmbeddedId
    private OrderSalesmanPK id;


    // Constructors

    public OrderSalesman() {}

    public OrderSalesman(OrderSalesmanPK id) {this.id = id;}

    public OrderSalesman(Orders orders, Employee employee) {

        this.id = new OrderSalesmanPK(orders, employee);
    }


    // Setters and Getters

    public OrderSalesmanPK getId() {return id;}

    public void setId(OrderSalesmanPK id) {this.id = id;}

    /**
     * Multi-attribute primary key class for the {@link OrderSalesman} class.
     */
    @Embeddable
    public static class OrderSalesmanPK implements Serializable {

        // Fields

        @OneToOne
        @JoinColumn(name = "orders")
        private Orders orders;

        @ManyToOne
        @JoinColumn(name = "salesman")
        private Employee employee;


        // Constructors

        public OrderSalesmanPK() {}

        public OrderSalesmanPK(Orders orders, Employee employee) {

            this.orders = orders;
            this.employee = employee;
        }


        // Overrides

        @Override
        public boolean equals(Object o) {

            if (o == null || getClass() != o.getClass()) return false;

            OrderSalesmanPK that = (OrderSalesmanPK) o;
            return orders.equals(that.orders) && employee.equals(that.employee);
        }

        @Override
        public int hashCode() {

            int result = orders.hashCode();
            result = 31 * result + employee.hashCode();
            return result;
        }
    }
}
