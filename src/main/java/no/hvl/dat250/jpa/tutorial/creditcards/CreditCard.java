package no.hvl.dat250.jpa.tutorial.creditcards;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class CreditCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer number;


//    @ManyToOne(mappedBy = "creditcards")
//    private Customer cardOwner;

    public Integer getNumber() {
        // TODO: implement method!
        return null;
    }

    public Integer getBalance() {
        // TODO: implement method!
        return null;
    }

    public Integer getCreditLimit() {
        // TODO: implement method!
        return null;
    }

    public Pincode getPincode() {
        // TODO: implement method!
        return null;
    }

    public Bank getOwningBank() {
        // TODO: implement method!
        return null;
    }
}
