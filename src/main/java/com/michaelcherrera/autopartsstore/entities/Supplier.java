package com.michaelcherrera.autopartsstore.entities;

import jakarta.persistence.*;

import java.util.UUID;

/**
 * Entity class for the supplier table containing suppliers who supply parts for the store.
 */
@Entity
public class Supplier {

    // Fields

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String firstName;

    private String lastName;

    private String phoneNumber;

    private String address1;

    private String address2;

    @ManyToOne
    @JoinColumn(name = "zip_code")
    private ZipCode zipCode;  // includes city and state

    private String email;


    // Constructors

    public Supplier() {}

    public Supplier(String firstName, String lastName, String phoneNumber, String address1, String address2,
                    ZipCode zipCode) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.address1 = address1;
        this.address2 = address2;
        this.zipCode = zipCode;
    }


    // Setters and Getters

    public UUID getId() {return id;}

    public void setId(UUID id) {this.id = id;}

    public String getFirstName() {return firstName;}

    public void setFirstName(String firstName) {this.firstName = firstName;}

    public String getLastName() {return lastName;}

    public void setLastName(String lastName) {this.lastName = lastName;}

    public String getPhoneNumber() {return phoneNumber;}

    public void setPhoneNumber(String phoneNumber) {this.phoneNumber = phoneNumber;}

    public String getAddress1() {return address1;}

    public void setAddress1(String address1) {this.address1 = address1;}

    public String getAddress2() {return address2;}

    public void setAddress2(String address2) {this.address2 = address2;}

    public ZipCode getZipCode() {return zipCode;}

    public void setZipCode(ZipCode zipCode) {this.zipCode = zipCode;}

    public String getEmail() {return email;}

    public void setEmail(String email) {this.email = email;}
}
