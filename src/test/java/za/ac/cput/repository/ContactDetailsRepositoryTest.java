package za.ac.cput.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.entity.ContactDetails;
import za.ac.cput.factory.ContactDetailsFactory;
import za.ac.cput.repository.impl.ContactDetailsRepositoryImpl;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

/*
ContactDetailsRepositoryTest.java
RepositoryTest for Contact Details
Author: Inga Plati (230126634)
Date: 27 March 2026
*/

class ContactDetailsRepositoryTest {

    private ContactDetailsRepository repository;
    private ContactDetails contact;

    @BeforeEach
    void setUp() {
        repository = ContactDetailsRepositoryImpl.getRepository();
        repository.getAll().forEach(c -> repository.delete(c.getContactId()));

        contact = ContactDetailsFactory.createContactDetails(
                "1",
                "0812345678",
                "0712345678",
                "John"
        );
    }

    @Test
    void create() {
        ContactDetails created = repository.create(contact);
        assertNotNull(created);
        assertEquals(contact.getContactId(), created.getContactId());
        assertEquals(contact.getCellphoneNumber(), created.getCellphoneNumber());
        assertEquals(contact.getEmergencyContactNumber(), created.getEmergencyContactNumber());
        assertEquals(contact.getEmergencyContactName(), created.getEmergencyContactName());
    }

    @Test
    void read() {
        repository.create(contact);
        ContactDetails read = repository.read(contact.getContactId());
        assertNotNull(read);
        assertEquals(contact.getContactId(), read.getContactId());
        assertEquals(contact.getCellphoneNumber(), read.getCellphoneNumber());
        assertEquals(contact.getEmergencyContactNumber(), read.getEmergencyContactNumber());
        assertEquals(contact.getEmergencyContactName(), read.getEmergencyContactName());
    }

    @Test
    void update() {
        repository.create(contact);

        ContactDetails updated = ContactDetailsFactory.createContactDetails(
                "1",
                "0822222222",
                "0712345678",
                "John Updated"
        );

        ContactDetails result = repository.update(updated);
        assertNotNull(result);
        assertEquals("1", result.getContactId());
        assertEquals("0822222222", result.getCellphoneNumber());
        assertEquals("0712345678", result.getEmergencyContactNumber());
        assertEquals("John Updated", result.getEmergencyContactName());
    }

    @Test
    void delete() {
        repository.create(contact);
        boolean success = repository.delete(contact.getContactId());
        assertTrue(success);
        assertNull(repository.read(contact.getContactId()));
    }

    @Test
    void getAll() {
        repository.create(contact);
        Set<ContactDetails> all = repository.getAll();
        assertFalse(all.isEmpty());
        assertTrue(all.contains(contact));
    }
}
