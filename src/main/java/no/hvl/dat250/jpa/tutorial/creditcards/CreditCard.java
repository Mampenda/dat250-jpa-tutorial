package no.hvl.dat250.jpa.tutorial.creditcards;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class CreditCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer number;
    private Integer balance;
    private Integer creditLimit;

    @ManyToOne
    private Pincode pincode;

    @ManyToOne
    private Bank bank;

    @ManyToOne
    private Customer cardOwner;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Integer getNumber() { return number; }
    public void setNumber(Integer number) { this.number = number; }

    public Integer getBalance() { return balance; }
    public void setBalance(Integer balance) { this.balance = balance; }

    public Integer getCreditLimit() { return creditLimit; }
    public void setCreditLimit(Integer creditLimit) { this.creditLimit = creditLimit; }

    public Pincode getPincode() { return pincode; }

    public void setPincode(Pincode pincode) { this.pincode = pincode; }

    public Bank getOwningBank() { return bank; }
    public void setOwningBank(Bank bank) { this.bank = bank; }

    public Customer getCardOwner() { return cardOwner; }
    public void setCardOwner(Customer cardOwner) { this.cardOwner = cardOwner; }
}
