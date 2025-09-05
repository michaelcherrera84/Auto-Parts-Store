package com.michaelcherrera.autopartsstore.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

/**
 * Entity class for the country table containing countries where parts are made.
 */
@Entity
public class Country {

    // Fields

    @Id
    private String country;

    private String currency;


    // Constructors

    public Country() {}

    public Country(String country, String currency) {

        this.country = country; this.currency = currency;
    }


    // Setters and Getters

    public String getCountry() {return country;}

    public void setCountry(String country) {this.country = country;}

    public String getCurrency() {return currency;}

    public void setCurrency(String currency) {this.currency = currency;}
}
