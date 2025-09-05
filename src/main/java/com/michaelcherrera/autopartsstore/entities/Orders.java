package com.michaelcherrera.autopartsstore.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

/**
 * Entity class for the orders table containing customer orders.
 */
@Entity
public class Orders {

    // Fields

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "customer")
    private Customer customer;

    private LocalDateTime orderDate;
    private LocalDateTime expectedShipDate;
    private LocalDateTime shippedDate;


    // Constructors

    public Orders() {}
    public Orders(Customer customer, LocalDateTime orderDate, LocalDateTime expectedShipDate, LocalDateTime shippedDate) {
        this.customer = customer;
        this.orderDate = orderDate;
        this.expectedShipDate = expectedShipDate;
        this.shippedDate = shippedDate;
    }

    // Setters and Getters

    public Long getId() {return id;}

    public void setId(Long id) {this.id = id;}

    public Customer getCustomer() {return customer;}

    public void setCustomer(Customer customer) {this.customer = customer;}

    public LocalDateTime getOrderDate() {return orderDate;}

    public void setOrderDate(LocalDateTime orderDate) {this.orderDate = orderDate;}

    public LocalDateTime getExpectedShipDate() {return expectedShipDate;}

    public void setExpectedShipDate(LocalDateTime expectedShipDate) {this.expectedShipDate = expectedShipDate;}

    public LocalDateTime getShippedDate() {return shippedDate;}

    public void setShippedDate(LocalDateTime shippedDate) {this.shippedDate = shippedDate;}
}
