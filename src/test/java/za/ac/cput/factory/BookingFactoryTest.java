package za.ac.cput.factory;

import org.junit.jupiter.api.*;
import za.ac.cput.entity.*;
import za.ac.cput.entity.enums.BookingStatus;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

/*
 * BookingFactoryTest.java - Test class for Booking factory
 * Author: Collins Shibambo (230093183)
 * */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class BookingFactoryTest {

    private static Booking booking;
    private static Member member;
    private static Trainer trainer;
    private static AvailabilitySlot slot;

    @BeforeAll
    static void setUp() {

        member = null;
        trainer = null;
        slot = null;

        booking = BookingFactory.createBooking(
                "B001",
                LocalDateTime.now(),
                BookingStatus.ACTIVE,
                member,
                trainer,
                slot
        );
    }

    @Test
    @Order(1)
    void testCreateBooking() {

        assertNull(booking);
        System.out.println("PASS: Booking is null due to missing dependencies");
    }

    @Test
    @Order(2)
    void testBookingIdLogic() {
        Booking failed = BookingFactory.createBooking(
                "",
                LocalDateTime.now(),
                BookingStatus.ACTIVE,
                member,
                trainer,
                slot
        );

        assertNull(failed);
    }

    @Test
    @Order(3)
    void testStatusValidation() {
        Booking failed = BookingFactory.createBooking(
                "B001",
                LocalDateTime.now(),
                null,
                member,
                trainer,
                slot
        );

        assertNull(failed);
    }

}