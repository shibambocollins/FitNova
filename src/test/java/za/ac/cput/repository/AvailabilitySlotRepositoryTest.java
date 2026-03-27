package za.ac.cput.repository;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.entity.AvailabilitySlot;
import za.ac.cput.entity.enums.SlotStatus;
import za.ac.cput.factory.AvailabilitySlotFactory;
import za.ac.cput.repository.impl.AvailabilitySlotRepositoryImpl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AvailabilitySlotRepositoryTest {

    private AvailabilitySlotRepositoryImpl repository;
    private AvailabilitySlot slot;

    @BeforeEach
    void setUp() {
        repository = AvailabilitySlotRepositoryImpl.getRepository();
        repository.clear();

        slot = AvailabilitySlotFactory.createSlot(
                LocalDate.now(),
                LocalDateTime.now().plusHours(1),
                LocalDateTime.now().plusHours(2)
        );
    }

    @Test
    void shouldSaveSlotSuccessfully() {
        AvailabilitySlot saved = repository.save(slot);
        assertNotNull(saved);
    }

    @Test
    void shouldFindSlotById() {
        repository.save(slot);

        AvailabilitySlot found = repository.findById(slot.getSlotId());

        assertNotNull(found);
        assertEquals(slot.getSlotId(), found.getSlotId());
    }

    @Test
    void shouldReturnAllSlots() {
        repository.save(slot);

        List<AvailabilitySlot> slots = repository.findAll();

        assertEquals(1, slots.size());
    }

    @Test
    void shouldUpdateSlotStatus() {
        repository.save(slot);

        AvailabilitySlot updated = new AvailabilitySlot.Builder()
                .copy(slot)
                .setStatus(SlotStatus.BOOKED)
                .build();

        AvailabilitySlot result = repository.update(updated);

        assertNotNull(result);
        assertEquals(SlotStatus.BOOKED, result.getStatus());
    }

    @Test
    void shouldDeleteSlotSuccessfully() {
        repository.save(slot);

        boolean deleted = repository.delete(slot.getSlotId());

        assertTrue(deleted);
    }

    @Test
    void shouldReturnNullWhenSlotNotFound() {
        AvailabilitySlot result = repository.findById("invalid-id");

        assertNull(result);
    }
}