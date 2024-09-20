package no.hvl.dat250.jpa.tutorial.creditcards;

import java.util.Collection;
import java.util.HashSet;

import jakarta.persistence.*;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany
    private Collection<CreditCard> creditCards = new HashSet<>();

    @ManyToMany(mappedBy = "owners")
    private Collection<Address> addresses = new HashSet<>();

    // Getters and Setters
    public Long getId() { return id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Collection<Address> getAddresses() { return addresses; }
    public void setAddresses(Address address) { addresses.add(address); }

    public Collection<CreditCard> getCreditCards() { return creditCards; }
    public void setCreditCards(CreditCard creditCard) { creditCards.add(creditCard); }
}
