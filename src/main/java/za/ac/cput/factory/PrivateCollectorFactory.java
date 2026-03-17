package za.ac.cput.factory;

import za.ac.cput.domain.PrivateCollector;

public class PrivateCollectorFactory {

    public static PrivateCollector createPrivateCollector(
            String privateCollectorID,
            String companyName,
            double monthlyPrice,
            double commissionRate) {

        if (privateCollectorID == null || privateCollectorID.isEmpty())
            return null;

        if (companyName == null || companyName.isEmpty())
            return null;

        if (monthlyPrice <= 0)
            return null;

        if (commissionRate < 0)
            return null;

        return new PrivateCollector.Builder()
                .setPrivateCollectorID(privateCollectorID)
                .setCompanyName(companyName)
                .setMonthlyPrice(monthlyPrice)
                .setCommissionRate(commissionRate)
                .build();
    }
}