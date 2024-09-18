package no.hvl.dat250.jpa.tutorial.creditcards.driver;

import jakarta.persistence.Query;
import no.hvl.dat250.jpa.tutorial.creditcards.*;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import no.hvl.dat250.jpa.tutorial.relationshipexample.Family;
import no.hvl.dat250.jpa.tutorial.relationshipexample.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class CreditCardsMainTest {

    private EntityManagerFactory factory;

    @BeforeEach
    public void setUp() {
        factory = Persistence.createEntityManagerFactory(CreditCardsMain.PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();

        // Begin a new local transaction so that we can persist a new entity
        em.getTransaction().begin();

        // Read the existing entries
        Query q = em.createQuery("select m from Customer m");
        // Customer should be empty

        // Do we have any entries?
        boolean createNewEntries = (q.getResultList().size() == 0);

        // No, so let's create new entries
        if (createNewEntries) {
            assertEquals(0, q.getResultList().size());
            Customer customer = new Customer();
            customer.setName("Kari Nordmann");
            em.persist(customer);
        }
        // Commit the transaction, which will cause the entity to be stored in the database
        em.getTransaction().commit();

        // It is always good practice to close the EntityManager so that resources are conserved.
        em.close();
    }

    @Test
    public void testDomainModelPersistence() {
        // Run the main class to persist the objects.
        CreditCardsMain.main(new String[]{});

        EntityManager em = factory.createEntityManager();

        // Load customer
        Customer customer = em.find(Customer.class, 1L);

        // Test person data
        assertEquals(customer.getName(), "Max Mustermann");

        // Test address
        assertEquals(customer.getAddresses().size(), 1);
        Address address = customer.getAddresses().iterator().next();

        assertEquals(address.getStreet(), "Inndalsveien");
        assertEquals(address.getNumber(), 28);
        assertEquals(address.getOwners(), Set.of(customer));

        // Test credit cards
        assertEquals(customer.getCreditCards().size(), 2);
        CreditCard firstCard = getCardWithNumber(customer, 12345);
        CreditCard secondCard = getCardWithNumber(customer, 123);

        assertEquals(firstCard.getNumber(), 12345);
        assertEquals(firstCard.getBalance(), -5000);
        assertEquals(firstCard.getCreditLimit(), -10000);

        assertEquals(secondCard.getNumber(), 123);
        assertEquals(secondCard.getBalance(), 1);
        assertEquals(secondCard.getCreditLimit(), 2000);

        // Test pincode
        Pincode firstCardPincode = firstCard.getPincode();

        assertEquals(firstCardPincode.getId(), secondCard.getPincode().getId()); // Pincode objects of the two cards are identical!
        assertEquals(firstCardPincode.getCode(), "123");
        assertEquals(firstCardPincode.getCount(), 1);

        // Test bank
        Bank bank = firstCard.getOwningBank();
        assertEquals(bank.getId(),secondCard.getOwningBank().getId()); // Bank objects of the two cards are identical!
        assertEquals(bank.getName(), "Pengebank");
        assertEquals(bank.getOwnedCards(), Set.of(firstCard, secondCard));
    }

    private CreditCard getCardWithNumber(Customer customer, int cardNumber) {
        Optional<CreditCard> optionalCard = customer.getCreditCards().stream()
                .filter(creditCard -> creditCard.getNumber() == cardNumber)
                .findFirst();
        if (optionalCard.isEmpty()) {
            throw new RuntimeException(
                    String.format("Card with number %s was not found for the person %s!",
                            cardNumber,
                            customer.getName()));
        }
        return optionalCard.get();
    }
}