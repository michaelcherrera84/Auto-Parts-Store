package com.michaelcherrera.autopartsstore.entities;

import jakarta.persistence.*;

import java.util.UUID;

/**
 * Entity class for the employee table containing employees who work at the auto parts store, including salesman,
 * administrators, and the supervisors.
 */
@Entity
public class Employee {

    // Fields

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String firstName;

    private String lastName;

    @ManyToOne
    @JoinColumn(name = "zip_code")
    private ZipCode zipCode;  // includes city and state

    private String phoneNumber;

    private String email;

    @Enumerated(EnumType.STRING)
    private Role role;

    /// Employee's immediate supervisor.
    @ManyToOne
    @JoinColumn(name = "supervisor")
    private Employee supervisor;


    // Constructors

    public Employee() {}

    public Employee(String firstName, String lastName, ZipCode zipCode, String phoneNumber, String email) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.zipCode = zipCode;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }


    // Setters and Getters

    public UUID getId() {return id;}

    public void setId(UUID id) {this.id = id;}

    public String getFirstName() {return firstName;}

    public void setFirstName(String firstName) {this.firstName = firstName;}

    public String getLastName() {return lastName;}

    public void setLastName(String lastName) {this.lastName = lastName;}

    public ZipCode getZipCode() {return zipCode;}

    public void setZipCode(ZipCode zipCode) {this.zipCode = zipCode;}

    public String getPhoneNumber() {return phoneNumber;}

    public void setPhoneNumber(String phoneNumber) {this.phoneNumber = phoneNumber;}

    public String getEmail() {return email;}

    public void setEmail(String email) {this.email = email;}

    public Role getRole() {return role;}

    public void setRole(Role role) {this.role = role;}

    public Employee getSupervisor() {return supervisor;}

    public void setSupervisor(Employee supervisor) {this.supervisor = supervisor;}

    /**
     * Employee's Role (salesman or administrator)
     */
    public enum Role {
        SALESMAN,
        ADMINISTRATOR
    }
}
