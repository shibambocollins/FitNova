package za.ac.cput.repository;
import za.ac.cput.entity.AvailabilitySlot;

import java.util.List;
public interface AvailabilitySlotRepository extends IRepository<AvailabilitySlot, String> {
AvailabilitySlot save(AvailabilitySlot slot);
AvailabilitySlot findById(String slotId);
List<AvailabilitySlot>findAll();
AvailabilitySlot update(AvailabilitySlot slot);
boolean delete(String slotId);
}
