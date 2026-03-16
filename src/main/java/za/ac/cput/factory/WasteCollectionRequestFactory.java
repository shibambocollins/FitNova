package za.ac.cput.factory;

import za.ac.cput.domain.PickUpSchedule;
import za.ac.cput.domain.PublicCollector;
import za.ac.cput.domain.WasteCollectionRequest;

public class WasteCollectionRequestFactory {
    public static WasteCollectionRequest createPublicRequest(String requestID,PickUpSchedule pickUpSchedule, PublicCollector publicCollector) {
        return new WasteCollectionRequest.Builder()
                .setRequestId(requestID)
                .setSchedule(pickUpSchedule)
                .setPublicCollector(publicCollector)
                .build();
    }
}
