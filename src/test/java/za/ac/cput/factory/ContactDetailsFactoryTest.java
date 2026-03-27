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
    void testFactory() {
        ContactDetails contact = ContactDetailsFactory.createContactDetails(
                "1",
                "0812345678",
                "0712345678",
                "John"
        );

        assertNotNull(contact);
        assertEquals("1", contact.getContactId());
        assertEquals("0812345678", contact.getCellphoneNumber());
        assertEquals("0712345678", contact.getEmergencyContactNumber());
        assertEquals("John", contact.getEmergencyContactName());
    }
}
