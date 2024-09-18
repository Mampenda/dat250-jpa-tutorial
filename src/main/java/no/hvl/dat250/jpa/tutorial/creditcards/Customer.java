package no.hvl.dat250.jpa.tutorial.creditcards;

import java.util.Collection;
import jakarta.persistence.*;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "cardOwner")
    private Collection<CreditCard> creditCard;

    @ManyToMany(mappedBy = "residents")
    private Collection<Address> addressList;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Collection<Address> getAddresses() { return addressList; }
    public void setAddresses(Collection<Address> addressList) { this.addressList = addressList; }

    public Collection<CreditCard> getCreditCards() { return creditCard; }
    public void setCreditCards(Collection<CreditCard> creditCard) { this.creditCard = creditCard; }
}
