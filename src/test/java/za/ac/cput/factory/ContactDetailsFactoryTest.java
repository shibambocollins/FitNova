package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.entity.ContactDetails;

import static org.junit.jupiter.api.Assertions.*;

/*
ContactDetailsFactoryTest.java
FactoryTest for Contact Details
Author: Inga Plati (230126634)
Date: 27 March 2026
*/

class ContactDetailsFactoryTest {

    @Test
    void createContactDetails() {
        ContactDetails contact = ContactDetailsFactory.createContactDetails(
                "1",
                "0812345678",
                "0712345678",
                "John"
        );

        assertNotNull(contact);
        System.out.println(contact);
    }
}

