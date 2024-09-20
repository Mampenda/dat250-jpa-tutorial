package no.hvl.dat250.jpa.tutorial.creditcards;

import java.util.Collection;
import java.util.HashSet;

import jakarta.persistence.*;

@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String street;
    private Integer number;

    @ManyToMany
    private Collection<Customer> owners = new HashSet<>();


    //Getters and Setters
    public Long getId() { return id; }

    public String getStreet() { return street; }
    public void setStreet(String street) { this.street = street; }

    public Integer getNumber() { return number; }
    public void setNumber(Integer number) { this.number = number; }

    public Collection<Customer> getOwners() { return owners; }
    public void setOwners( Customer customer) { owners.add(customer); }
}
