/*
 * AddressFactoryTest.java - Test class for AddressFactory
 * Author: Athi Sintiya (220212317)
 * Date: March 2026
 */
package za.ac.cput.factory;

import za.ac.cput.entity.Address;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class AddressFactoryTest {

    private static Address address;

    @BeforeAll
    static void setUp() {
        address = AddressFactory.createAddress(
                "143", "Sir Lawry Street", "Woodstock",
                "Cape Town", "8001", "Western Cape", "South Africa");
    }

    @Test
    @Order(1)
    void testCreateAddress() {
        assertNotNull(address);
        System.out.println(address);
    }

    @Test
    @Order(2)
    void testCreateAddressWithAllAttributes() {
        assertNotNull(address.getAddressId());
        assertEquals("143", address.getStreetNumber());
        assertEquals("Sir Lawry Street", address.getStreetName());
        assertEquals("Woodstock", address.getSuburbName());
        assertEquals("Cape Town", address.getCity());
        assertEquals("8001", address.getPostalCode());
        assertEquals("Western Cape", address.getProvince());
        assertEquals("South Africa", address.getCountry());
        System.out.println(address);
    }

    @Test
    @Order(3)
    void testCreateAddressThatFails() {
        Address failed = AddressFactory.createAddress(
                "", "Sir Lawry Street", "Woodstock",
                "Cape Town", "8001", "Western Cape", "South Africa");
        assertNull(failed);
        System.out.println("Expected null: " + failed);
    }

}