package za.ac.cput.factory;
import za.ac.cput.domain.Address;
import za.ac.cput.domain.ContactDetails;
import za.ac.cput.domain.User;

public class UserFactory {
    public static User createUser(String userID, String name) {
        return new User.Builder()
                .userID(userID)
                .name(name).build();
    }

    public static User createUserWithContactDetails(String userID, String name, ContactDetails contactDetails) {
        return new User.Builder()
                .userID(userID)
                .name(name)
                .contactdetails(contactDetails)
                .build();
    }
    public static User createUserWithAddress(String userID, String name, Address address) {
        return new User.Builder()
                .userID(userID)
                .name(name)
                .address(address)
                .build();
    }
    public static User createFullUser(String userID, String name, Address address, ContactDetails contactDetails) {
        return new User.Builder()
                .userID(userID)
                .name(name)
                .address(address)
                .contactdetails(contactDetails)
                .build();
    }
}
