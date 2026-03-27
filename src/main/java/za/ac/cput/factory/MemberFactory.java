package za.ac.cput.factory;

import za.ac.cput.entity.ContactDetails;
import za.ac.cput.entity.Member;
import za.ac.cput.entity.UserAccount;
import za.ac.cput.entity.UserProfile;
import za.ac.cput.util.Helper;

/**
 * MemberFactory.java
 * 25 March 2026
 * Author: Lisakhanya Tshokolo
 * (220239215)
 */

public class MemberFactory {

    public static Member createMember(String memberId,
                                      UserAccount account,
                                      UserProfile profile,
                                      ContactDetails contact) {

        if (Helper.isNullOrEmpty(memberId))
            throw new IllegalArgumentException("Member ID is required");
        if (account == null)
            throw new IllegalArgumentException("Account is required");
        if (profile == null)
            throw new IllegalArgumentException("Profile is required");
        if (contact == null)
            throw new IllegalArgumentException("Contact details is required");

        return new Member.Builder()
                .memberId(memberId)
                .account(account)
                .profile(profile)
                .contact(contact)
                .build();
    }
}
