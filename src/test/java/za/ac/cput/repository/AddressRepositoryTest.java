/*
 * AddressRepositoryTest.java
 * Author: Athi Sintiya (220212317)
 * Date: March 2026
 */
package za.ac.cput.repository;

import za.ac.cput.entity.Address;
import za.ac.cput.factory.AddressFactory;
import za.ac.cput.repository.impl.AddressRepositoryImpl;
import org.junit.jupiter.api.*;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class AddressRepositoryTest {

    private static AddressRepository repository;
    private static Address address;

    @BeforeAll
    static void setUp() {
        repository = AddressRepositoryImpl.getInstance();
        address = AddressFactory.createAddress(
                "143", "Sir Lawry", "Woodstock", "Cape Town",
                "8001", "Western Cape", "South Africa");
    }

    @Test
    @Order(1)
    void create() {
        Address created = repository.create(address);
        assertNotNull(created);
        System.out.println(created);
    }

    @Test
    @Order(2)
    void read() {
        repository.create(address);
        Address read = repository.read(address.getAddressId());
        assertNotNull(read);
        System.out.println(read);
    }

    @Test
    @Order(3)
    void update() {
        Address updated = new Address.Builder()
                .copy(address)
                .setStreetNumber("123")
                .setStreetName("Updated Street")
                .setPostalCode("8001")
                .build();
        repository.create(address);
        Address result = repository.update(updated);
        assertNotNull(result);
        System.out.println(result);
    }

    @Test
    @Order(4)
    void delete() {
        repository.create(address);
        boolean success = repository.delete(address.getAddressId());
        assertTrue(success);
        System.out.println("Deleted: " + success);
    }

    @Test
    @Order(5)
    void getAll() {
        repository.create(address);
        List<Address> all = repository.getAll();
        assertFalse(all.isEmpty());
        System.out.println(all);
    }
}