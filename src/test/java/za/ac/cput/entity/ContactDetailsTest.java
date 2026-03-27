package za.ac.cput.entity;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/*
ContactDetailsTest.java
Test for Contact Details
Author: Inga Plati (230126634)
Date: 27 March 2026
*/

class ContactDetailsTest {

    @Test
    void testBuilder() {
        ContactDetails contact = new ContactDetails.Builder()
                .setContactId("1")
                .setCellphoneNumber("0812345678")
                .setEmergencyContactNumber("0712345678")
                .setEmergencyContactName("John")
                .build();

        assertNotNull(contact);
        assertEquals("1", contact.getContactId());
        assertEquals("0812345678", contact.getCellphoneNumber());
        assertEquals("0712345678", contact.getEmergencyContactNumber());
        assertEquals("John", contact.getEmergencyContactName());

        System.out.println(contact);
    }
}

