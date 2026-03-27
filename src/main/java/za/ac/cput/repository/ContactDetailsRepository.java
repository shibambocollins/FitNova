package za.ac.cput.repository;

import za.ac.cput.entity.ContactDetails;
import java.util.Set;

/*
ContactDetailsRepository.java
Repository for Contact Details
Author: Inga Plati (230126634)
Date: 27 March 2026
*/

public interface ContactDetailsRepository {

    ContactDetails create(ContactDetails contactDetails);

    ContactDetails read(String contactId);

    ContactDetails update(ContactDetails contactDetails);

    boolean delete(String contactId);

    Set<ContactDetails> getAll();
}

