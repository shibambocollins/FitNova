package za.ac.cput.entity;

import org.junit.jupiter.api.Test;
import za.ac.cput.entity.enums.SlotStatus;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class AvailabilitySlotTest {

    @Test
    void shouldBuildValidAvailabilitySlot() {
        AvailabilitySlot slot = new AvailabilitySlot.Builder()
                .setSlotId("S1")
                .setDate(LocalDate.now())
                .setStartTime(LocalDateTime.now().plusHours(1))
                .setEndTime(LocalDateTime.now().plusHours(2))
                .setStatus(SlotStatus.AVAILABLE)
                .build();

        assertNotNull(slot);
        assertEquals("S1", slot.getSlotId());
        assertEquals(SlotStatus.AVAILABLE, slot.getStatus());
    }

    @Test
    void shouldReturnTrueWhenSlotIsAvailable() {
        AvailabilitySlot slot = new AvailabilitySlot.Builder()
                .setSlotId("S2")
                .setDate(LocalDate.now())
                .setStartTime(LocalDateTime.now().plusHours(1))
                .setEndTime(LocalDateTime.now().plusHours(2))
                .setStatus(SlotStatus.AVAILABLE)
                .build();

        assertTrue(slot.isAvailable());
    }

    @Test
    void shouldReturnFalseWhenSlotIsBooked() {
        AvailabilitySlot slot = new AvailabilitySlot.Builder()
                .setSlotId("S3")
                .setDate(LocalDate.now())
                .setStartTime(LocalDateTime.now().plusHours(1))
                .setEndTime(LocalDateTime.now().plusHours(2))
                .setStatus(SlotStatus.BOOKED)
                .build();

        assertFalse(slot.isAvailable());
    }

    @Test
    void shouldCopyAndModifySlot() {
        AvailabilitySlot original = new AvailabilitySlot.Builder()
                .setSlotId("S4")
                .setDate(LocalDate.now())
                .setStartTime(LocalDateTime.now().plusHours(1))
                .setEndTime(LocalDateTime.now().plusHours(2))
                .setStatus(SlotStatus.AVAILABLE)
                .build();

        AvailabilitySlot updated = new AvailabilitySlot.Builder()
                .copy(original)
                .setStatus(SlotStatus.BOOKED)
                .build();

        assertEquals(original.getSlotId(), updated.getSlotId());
        assertEquals(SlotStatus.BOOKED, updated.getStatus());
    }
}