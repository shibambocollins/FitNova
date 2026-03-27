package za.ac.cput.factory;

import za.ac.cput.entity.Trainer;
import za.ac.cput.entity.ContactDetails;
import za.ac.cput.entity.UserAccount;
import za.ac.cput.entity.UserProfile;
import za.ac.cput.util.Helper;

/**
 * TrainerFactory.java
 * 25 March 2026
 * Author: Lisakhanya Tshokolo
 * (220239215)
 */

public class TrainerFactory {

    public static Trainer createTrainer(String trainerId,
                                        UserAccount account,
                                        UserProfile profile,
                                        ContactDetails contact) {

        if (Helper.isNullOrEmpty(trainerId))
            throw new IllegalArgumentException("Trainer ID is required");
        if (account == null)
            throw new IllegalArgumentException("Account is required");
        if (profile == null)
            throw new IllegalArgumentException("Profile is required");
        if (contact == null)
            throw new IllegalArgumentException("Contact details is required");

        return new Trainer.Builder()
                .setTrainerId(trainerId)
                .setAccount(account)
                .setProfile(profile)
                .setContactDetails(contact)
                .build();
    }
}
