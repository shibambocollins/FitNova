package za.ac.cput.repository;

import org.junit.jupiter.api.*;
import za.ac.cput.entity.Booking;
import za.ac.cput.entity.enums.BookingStatus;
import za.ac.cput.repository.impl.BookingRepositoryImpl;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
/*
 * BookingRepositoryTest.java - Test class for Booking repo
 * Author: Collins Shibambo (230093183)
 * */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class BookingRepositoryTest {

    private static BookingRepository repository;
    private static Booking booking;

    @BeforeAll
    static void setUp() {

        repository = BookingRepositoryImpl.getRepository();

        booking = new Booking.Builder()
                .bookingId("B001")
                .bookingDateTime(LocalDateTime.now())
                .status(BookingStatus.ACTIVE)
                .member(null)
                .trainer(null)
                .slot(null)
                .build();
    }

    @Test
    @Order(1)
    void testCreate() {
        Booking created = repository.create(booking);
        assertNotNull(created);
        System.out.println(created);
    }

    @Test
    @Order(2)
    void testRead() {
        repository.create(booking);
        Booking read = repository.read("B001");

        assertNotNull(read);
        assertEquals("B001", read.getBookingId());
    }

    @Test
    @Order(3)
    void testUpdate() {
        repository.create(booking);

        Booking updated = new Booking.Builder()
                .bookingId("B001")
                .bookingDateTime(LocalDateTime.now())
                .status(BookingStatus.CANCELLED)
                .member(null)
                .trainer(null)
                .slot(null)
                .build();

        Booking result = repository.update(updated);

        assertNotNull(result);
        assertEquals(BookingStatus.CANCELLED, result.getStatus());
    }

    @Test
    @Order(4)
    void testDelete() {
        repository.create(booking);

        boolean success = repository.delete("B001");

        assertTrue(success);
    }

    @Test
    @Order(5)
    void testGetAll() {
        repository.create(booking);

        List<Booking> list = repository.getAll();

        assertFalse(list.isEmpty());
        System.out.println(list);
    }
}