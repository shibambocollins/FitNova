package za.ac.cput.factory;

import za.ac.cput.domain.PublicCollector;

public class PublicCollectorFactory {

    public static PublicCollector createPublicCollector(
            String publicCollectorID,
            String municipalityName) {

        if (publicCollectorID == null || publicCollectorID.isEmpty())
            return null;

        if (municipalityName == null || municipalityName.isEmpty())
            return null;

        return new PublicCollector.Builder()
                .setPublicCollectorID(publicCollectorID)
                .setMunicipalityName(municipalityName)
                .build();
    }
}