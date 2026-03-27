package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.entity.AvailabilitySlot;
import za.ac.cput.entity.enums.SlotStatus;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class AvailabilitySlotFactoryTest {

    @Test
    void shouldCreateSlotWhenInputsAreValid() {
        AvailabilitySlot slot = AvailabilitySlotFactory.createSlot(
                LocalDate.now(),
                LocalDateTime.now().plusHours(1),
                LocalDateTime.now().plusHours(2)
        );

        assertNotNull(slot);
        assertEquals(SlotStatus.AVAILABLE, slot.getStatus());
    }

    @Test
    void shouldThrowExceptionWhenEndTimeIsBeforeStartTime() {
        assertThrows(IllegalArgumentException.class, () -> {
            AvailabilitySlotFactory.createSlot(
                    LocalDate.now(),
                    LocalDateTime.now().plusHours(2),
                    LocalDateTime.now().plusHours(1)
            );
        });
    }

    @Test
    void shouldThrowExceptionWhenDateDoesNotMatchStartTime() {
        assertThrows(IllegalArgumentException.class, () -> {
            AvailabilitySlotFactory.createSlot(
                    LocalDate.now(),
                    LocalDateTime.now().plusDays(1),
                    LocalDateTime.now().plusDays(1).plusHours(1)
            );
        });
    }

    @Test
    void shouldThrowExceptionWhenInputsAreNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            AvailabilitySlotFactory.createSlot(
                    null,
                    null,
                    null
            );
        });
    }
}