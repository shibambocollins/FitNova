package za.ac.cput.repository.impl;

import za.ac.cput.entity.ContactDetails;
import za.ac.cput.repository.ContactDetailsRepository;

import java.util.HashSet;
import java.util.Set;

/*
ContactDetailsRepositoryImp.java
RepositoryImp for Contact Details
Author: Inga Plati (230126634)
Date: 27 March 2026
*/

public class ContactDetailsRepositoryImpl implements ContactDetailsRepository {

    private static ContactDetailsRepositoryImpl repository = null;
    private Set<ContactDetails> contactDB;

    private ContactDetailsRepositoryImpl(){
        contactDB = new HashSet<>();
    }

    public static ContactDetailsRepositoryImpl getRepository(){
        if(repository == null){
            repository = new ContactDetailsRepositoryImpl();
        }
        return repository;
    }

    public ContactDetails create(ContactDetails contactDetails){
        contactDB.add(contactDetails);
        return contactDetails;
    }

    public ContactDetails read(String contactId){
        for(ContactDetails c : contactDB){
            if(c.getContactId().equals(contactId)){
                return c;
            }
        }
        return null;
    }

    public ContactDetails update(ContactDetails contactDetails){

        ContactDetails old = read(contactDetails.getContactId());

        if(old != null){
            contactDB.remove(old);
            contactDB.add(contactDetails);
        }

        return contactDetails;
    }

    public boolean delete(String contactId){

        ContactDetails contact = read(contactId);

        if(contact != null){
            contactDB.remove(contact);
            return true;
        }

        return false;
    }

    public Set<ContactDetails> getAll(){
        return contactDB;
    }
}
