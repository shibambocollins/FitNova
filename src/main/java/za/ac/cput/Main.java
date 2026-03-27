package za.ac.cput;

import za.ac.cput.entity.Address;
import za.ac.cput.factory.AddressFactory;
import za.ac.cput.repository.impl.AddressRepositoryImpl;

public class Main {
    public static void main(String[] args) {

       /*AddressRepositoryImpl repository = AddressRepositoryImpl.getInstance();

        Address address1 = AddressFactory.createAddress(
                "143", "Sir Lawry Street", "Woodstock",
                "Cape Town", "8001", "Western Cape", "South Africa");

        Address address2 = AddressFactory.createAddress(
                "456", "Oak Avenue", "Gardens",
                "Cape Town", "8001", "Western Cape", "South Africa");

        Address address3 = AddressFactory.createAddress(
                "789", "Pine Street", "Sea Point",
                "Cape Town", "8005", "Western Cape", "South Africa");

        System.out.println("Create ");
        System.out.println("Created: " + repository.create(address1));
        System.out.println("Created: " + repository.create(address2));
        System.out.println("Created: " + repository.create(address3));

        System.out.println("\n Read ");
        System.out.println("Read address1: " + repository.read(address1.getAddressId()));

        System.out.println("\nGet All ");
        repository.getAll().forEach(address -> System.out.println(address));

        System.out.println("\nUpdate");
        Address updated = new Address.Builder()
                .copy(address1)
                .setStreetNumber("123")
                .setStreetName("Updated Main Street")
                .setPostalCode("8001")
                .build();
        System.out.println("Updated: " + repository.update(updated));
        System.out.println("Verified from repo: " + repository.read(address1.getAddressId()));

        System.out.println("\nDelete ");
        System.out.println("Deleted address1: " + repository.delete(address1.getAddressId()));
        System.out.println("Read address1 after delete (should be null): "
                + repository.read(address1.getAddressId()));

        System.out.println("\nRemaining Addresses ");
        repository.getAll().forEach(address -> System.out.println(address));*/
    }
}