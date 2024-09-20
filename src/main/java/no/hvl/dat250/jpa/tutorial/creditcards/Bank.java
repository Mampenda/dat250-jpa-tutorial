package no.hvl.dat250.jpa.tutorial.creditcards;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.HashSet;

@Entity
public class Bank {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "owningBank")
    private Collection<CreditCard> creditCards = new HashSet<>();


    // Getters and Setters
    public Long getId() {
        return id;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Collection<CreditCard> getOwnedCards() { return creditCards; }
    public void setOwnedCards(CreditCard creditCard) { creditCards.add(creditCard); }
}
