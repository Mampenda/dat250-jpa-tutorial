package no.hvl.dat250.jpa.tutorial.creditcards;

import java.util.Collection;
import java.util.List;

import jakarta.persistence.*;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "cardOwner")
    private Collection<CreditCard> creditCards;

    @ManyToMany(mappedBy = "residents")
    private Collection<Address> adressList;


    // Getters and Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Collection<Address> getAddresses() { return adressList; }
    public void setAddresses(Collection<Address> adresses) { this.adressList = adresses; }

    public Collection<CreditCard> getCreditCards() { return creditCards; }
    public void setCreditCards(Collection<CreditCard> cards) { this.creditCards = cards; }
}
