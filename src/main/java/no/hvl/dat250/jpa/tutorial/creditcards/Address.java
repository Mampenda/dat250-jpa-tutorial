package no.hvl.dat250.jpa.tutorial.creditcards;

import java.util.Collection;

import jakarta.persistence.*;

@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String street;
    private Integer number;

    @ManyToMany
    private Collection<Customer> residents;

    @OneToMany
    private Collection<CreditCard> creditCards;


    //Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getStreet() { return street; }
    public void setStreet(String street) { this.street = street; }

    public Integer getNumber() { return number; }
    public void setNumber(Integer number) { this.number = number; }

    public Collection<Customer> getOwners() { return residents; }
    public void setOwners( Collection<Customer> residents) { this.residents = residents; }

    public Collection<CreditCard> getCreditCards() { return creditCards; }
    public void setCreditCards( Collection<CreditCard> creditCards) { this.creditCards = creditCards; }
}
