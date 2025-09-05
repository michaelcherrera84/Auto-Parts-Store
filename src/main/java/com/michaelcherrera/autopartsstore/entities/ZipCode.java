package com.michaelcherrera.autopartsstore.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

/**
 * Entity class for the ZipCode table containing US postal codes, the cities associated with each postal code, and the
 * state where each postal code exists.
 */
@Entity
public class ZipCode {

    // Fields

    @Id
    private String zipCode;

    private String city;

    private String state;


    // Constructors

    public ZipCode() {}

    public ZipCode(String zipCode, String city, String state) {

        this.zipCode = zipCode;
        this.city = city;
        this.state = state;
    }


    // Setters and Getters

    public String getZipCode() {return zipCode;}

    public void setZipCode(String zipCode) {this.zipCode = zipCode;}

    public String getCity() {return city;}

    public void setCity(String city) {this.city = city;}

    public String getState() {return state;}

    public void setState(String state) {this.state = state;}
}
