package com.michaelcherrera.autopartsstore.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

/**
 * Entity class for the part table containing parts sold at the store.
 */
@Entity
public class Part {

    // Fields

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;

    private String make;

    private String model;

    private LocalDate year;

    @ManyToMany
    @JoinTable(
            name = "part_country",
            joinColumns = @JoinColumn(name = "part"),
            inverseJoinColumns = @JoinColumn(name = "country")
    )
    private List<Country> country;


    // Constructors

    public Part() {}

    public Part(String name, String make, String model, LocalDate year) {

        this.name = name;
        this.make = make;
        this.model = model;
        this.year = year;
    }


    // Setters and Getters

    public UUID getId() {return id;}

    public void setId(UUID id) {this.id = id;}

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public String getMake() {return make;}

    public void setMake(String make) {this.make = make;}

    public String getModel() {return model;}

    public void setModel(String model) {this.model = model;}

    public LocalDate getYear() {return year;}

    public void setYear(LocalDate year) {this.year = year;}

    public List<Country> getCountry() {return country;}

    public void setCountry(List<Country> country) {this.country = country;}
}
