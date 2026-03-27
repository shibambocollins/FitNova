package za.ac.cput.repository.impl;

import za.ac.cput.entity.AvailabilitySlot;
import za.ac.cput.repository.AvailabilitySlotRepository;

import java.util.ArrayList;
import java.util.List;
/*
 * Author: Phumelela Sakie (240040546)
 * */

public class AvailabilitySlotRepositoryImpl implements AvailabilitySlotRepository {
    private static AvailabilitySlotRepositoryImpl repository = null;
    private List<AvailabilitySlot> slotList;

    private AvailabilitySlotRepositoryImpl() {
        slotList = new ArrayList<>();
    }

    public static AvailabilitySlotRepositoryImpl getRepository() {
        if (repository == null) {
            repository = new AvailabilitySlotRepositoryImpl();
        }
        return repository;
    }

    @Override
    public AvailabilitySlot create(AvailabilitySlot entity) {
        return null;
    }

    @Override
    public AvailabilitySlot read(String s) {
        return null;
    }

    @Override
    public AvailabilitySlot save(AvailabilitySlot slot) {
        slotList.add(slot);
        return slot;
    }

    @Override
    public AvailabilitySlot findById(String slotId) {
        for (AvailabilitySlot slot : slotList) {
            if (slot.getSlotId().equals(slotId)) {
                return slot;
            }
        }
        return null;
    }

    @Override
    public List<AvailabilitySlot> findAll() {
        return slotList;
    }

    @Override
    public AvailabilitySlot update(AvailabilitySlot slot) {
        AvailabilitySlot existing = findById(slot.getSlotId());

        if (existing != null) {
            slotList.remove(existing);
            slotList.add(slot);
            return slot;
        }

        return null;
    }

    @Override
    public boolean delete(String slotId) {
        AvailabilitySlot slot = findById(slotId);

        if (slot != null) {
            slotList.remove(slot);
            return true;
        }

        return false;
    }


    public void clear() {
        slotList.clear();
    }
}