/*
 * AddressTest.java - Test class for Address
 * Author: Athi Sintiya (220212317)
 * Date: March 2026
 */
package za.ac.cput.entity;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class AddressTest {

    private static Address address;

    @BeforeAll
    static void setUp() {
        address = new Address.Builder()
                .setAddressId("1")
                .setStreetNumber("143")
                .setStreetName("Sir Lawry Street")
                .setSuburbName("Woodstock")
                .setCity("Cape Town")
                .setPostalCode("8001")
                .setProvince("Western Cape")
                .setCountry("South Africa")
                .build();
    }

    @Test
    @Order(1)
    void build() {
        assertNotNull(address);
        System.out.println(address);
    }

    @Test
    @Order(2)
    void getAddressId() {
        assertEquals("1", address.getAddressId());
        System.out.println(address.getAddressId());
    }

    @Test
    @Order(3)
    void getStreetNumber() {
        assertEquals("143", address.getStreetNumber());
        System.out.println(address.getStreetNumber());
    }

    @Test
    @Order(4)
    void getStreetName() {
        assertEquals("Sir Lawry Street", address.getStreetName());
        System.out.println(address.getStreetName());
    }

    @Test
    @Order(5)
    void getSuburbName() {
        assertEquals("Woodstock", address.getSuburbName());
        System.out.println(address.getSuburbName());
    }

    @Test
    @Order(6)
    void getCity() {
        assertEquals("Cape Town", address.getCity());
        System.out.println(address.getCity());
    }

    @Test
    @Order(7)
    void getPostalCode() {
        assertEquals("8001", address.getPostalCode());
        System.out.println(address.getPostalCode());
    }

    @Test
    @Order(8)
    void getProvince() {
        assertEquals("Western Cape", address.getProvince());
        System.out.println(address.getProvince());
    }

    @Test
    @Order(9)
    void getCountry() {
        assertEquals("South Africa", address.getCountry());
        System.out.println(address.getCountry());
    }

    @Test
    @Order(10)
    void copy() {
        Address copied = new Address.Builder()
                .copy(address)
                .setStreetName("Updated Street")
                .build();
        assertNotNull(copied);
        assertEquals("Updated Street", copied.getStreetName());
        System.out.println(copied);
    }
}