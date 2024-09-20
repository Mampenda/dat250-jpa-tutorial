package no.hvl.dat250.jpa.tutorial.creditcards;

import jakarta.persistence.*;


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
    private Bank owningBank;

    @ManyToOne
    private Customer cardOwner;


    // Getters and Setters
    public Long getId() { return id; }

    public Integer getNumber() { return number; }
    public void setNumber(Integer number) { this.number = number; }

    public Integer getBalance() { return balance; }
    public void setBalance(Integer balance) { this.balance = balance; }

    public Integer getCreditLimit() { return creditLimit; }
    public void setCreditLimit(Integer creditLimit) { this.creditLimit = creditLimit; }

    public Pincode getPincode() { return pincode; }
    public void setPincode(Pincode pincode) { this.pincode = pincode; }

    public Bank getOwningBank() { return owningBank; }
    public void setOwningBank(Bank bank) { this.owningBank = bank; }

    public Customer getCardOwner() { return cardOwner; }
    public void setCardOwner(Customer customer) { this.cardOwner = customer; }
}
