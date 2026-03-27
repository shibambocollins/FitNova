package za.ac.cput.repository;

import org.junit.jupiter.api.Test;
import za.ac.cput.entity.ContactDetails;
import za.ac.cput.factory.ContactDetailsFactory;
import za.ac.cput.repository.impl.ContactDetailsRepositoryImpl;

import static org.junit.jupiter.api.Assertions.*;

/*
ContactDetailsRepositoryTest.java
RepositoryTest for Contact Details
Author: Inga Plati (230126634)
Date: 27 March 2026
*/

class ContactDetailsRepositoryTest {

    private ContactDetailsRepository repository =
            ContactDetailsRepositoryImpl.getRepository();

    private ContactDetails contact =
            ContactDetailsFactory.createContactDetails(
                    "1",
                    "0812345678",
                    "0712345678",
                    "John"
            );

    @Test
    void create(){
        ContactDetails created = repository.create(contact);
        assertNotNull(created);
    }

    @Test
    void read(){
        repository.create(contact);
        ContactDetails read = repository.read("1");
        assertNotNull(read);
    }

    @Test
    void update(){

        ContactDetails updated = ContactDetailsFactory.createContactDetails(
                "1",
                "0822222222",
                "0712345678",
                "John"
        );

        repository.create(contact);
        ContactDetails result = repository.update(updated);

        assertNotNull(result);
    }

    @Test
    void delete(){
        repository.create(contact);
        boolean success = repository.delete("1");
        assertTrue(success);
    }

    @Test
    void getAll(){
        repository.create(contact);
        assertFalse(repository.getAll().isEmpty());
    }
}

