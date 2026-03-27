package za.ac.cput.factory;

/**
 *
 * 25 March 2026
 * Author: Avuyile Sitoyi
 * (240971051)
 */
import za.ac.cput.entity.UserProfile;
import za.ac.cput.util.Helper;

import java.time.LocalDate;

public class UserProfileFactory {
    public static UserProfile CreateUserProfile(String profileId,
                                                String firstName,
                                                String lastName, String gender, LocalDate dateOfBirth) {
        if (Helper.isNullOrEmpty(profileId))
            throw new IllegalArgumentException("memberId required");
        if (Helper.isNullOrEmpty(firstName))
            throw new IllegalArgumentException("firstName required");
        if (Helper.isNullOrEmpty(lastName))
            throw new IllegalArgumentException("lastName required");
        if (Helper.isNullOrEmpty(gender))
            throw new IllegalArgumentException("gender required");
        return new UserProfile.Builder().profileId(profileId).firstName(firstName).
                lastName(lastName).gender(gender).dateOfBirth(dateOfBirth).build();


    }
}
