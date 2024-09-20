package no.hvl.dat250.jpa.tutorial.creditcards.driver;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import no.hvl.dat250.jpa.tutorial.creditcards.*;

import java.util.Collection;

public class CreditCardsMain {

  static final String PERSISTENCE_UNIT_NAME = "jpa-tutorial";

  public static void main(String[] args) {
    try (EntityManagerFactory factory = Persistence.createEntityManagerFactory(
        PERSISTENCE_UNIT_NAME); EntityManager em = factory.createEntityManager()) {
      em.getTransaction().begin();
      createObjects(em);
      em.getTransaction().commit();
    }
  }

  private static void createObjects(EntityManager em) {

    // Create customer
    Customer customer = new Customer();
    customer.setName("Max Mustermann");

    // Create address
    Address address = new Address();
    address.setStreet("Inndalsveien");
    address.setNumber(28);
    address.setOwners(customer);

    // Add address to customers list of addresses
    customer.setAddresses(address);

    // Create new bank and implement fields
    Bank bank = new Bank();
    bank.setName("Pengebank");

    // Implement pincode
    Pincode pincode = new Pincode();
    pincode.setCode("123");
    pincode.setCount(1);

    // Create 2 credit cards
    CreditCard creditcard1 = new CreditCard();
    CreditCard creditcard2 = new CreditCard();

    // Implement fields for credit card 1
    creditcard1.setNumber(12345);
    creditcard1.setBalance(-5000);
    creditcard1.setCreditLimit(-10000);
    creditcard1.setPincode(pincode);
    creditcard1.setCardOwner(customer);
    creditcard1.setOwningBank(bank);

    // Implement fields for credit card 2
    creditcard2.setNumber(123);
    creditcard2.setBalance(1);
    creditcard2.setCreditLimit(2000);
    creditcard2.setPincode(pincode);
    creditcard2.setCardOwner(customer);
    creditcard2.setOwningBank(bank);

    // Add credit cards to banks list of cards
    bank.setOwnedCards(creditcard1);
    bank.setOwnedCards(creditcard2);

    // Add credit cards to customers list of cards
    customer.setCreditCards(creditcard1);
    customer.setCreditCards(creditcard2);

    // Persist the objects
    em.persist(customer);
    em.persist(address);
    em.persist(pincode);
    em.persist(creditcard1);
    em.persist(creditcard2);
    em.persist(bank);
  }
}