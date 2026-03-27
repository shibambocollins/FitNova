package za.ac.cput.factory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.entity.ContactDetails;
import za.ac.cput.entity.Trainer;
import za.ac.cput.entity.UserAccount;
import za.ac.cput.entity.UserProfile;
import za.ac.cput.entity.enums.RoleType;
import static org.junit.jupiter.api.Assertions.*;
import za.ac.cput.factory.TrainerFactory;
import java.time.LocalDate;


/**
 * 27 March 2026
 * Author: Lisakhanya Tshokolo
 * (220239215)
 */

public class TrainerFactoryTest {
    private static final String TRAINER_ID= "T001";
        private UserAccount account;
        private UserProfile profile;
        private ContactDetails contactDetails;
        private Trainer trainer;

        @BeforeEach
        void setUp() {
            account = new UserAccount.Builder()
                    .accountId("ACC001")
                    .email("trainer@gmail.com")
                    .password("TrainerPass123")
                    .role(RoleType.TRAINER)
                    .registrationDate(LocalDate.of(2024, 1, 10))
                    .build();

            profile = new UserProfile.Builder()
                    .profileId("P001")
                    .firstName("Sam")
                    .lastName("Ndlela")
                    .gender("Male")
                    .dateOfBirth(LocalDate.of(1999, 5, 20))
                    .build();

            contactDetails = new ContactDetails.Builder()
                    .setContactId("C001")
                    .setCellphoneNumber("0712345678")
                    .setEmergencyContactNumber("0798765432")
                    .setEmergencyContactName("Nomawethu Ndlela")
                    .build();

            trainer = TrainerFactory.createTrainer(TRAINER_ID, account, profile, contactDetails);
        }


        @Test
        void testCreateTrainer_Success_NotNull() {
            assertNotNull(trainer);
        }

        @Test
        void testCreateTrainer_Success_TrainerId() {
            assertEquals("T001", trainer.getTrainerId());
        }

        @Test
        void testCreateTrainer_Success_Account() {
            assertEquals(account, trainer.getAccount());
        }

        @Test
        void testCreateTrainer_Success_Profile() {
            assertEquals(profile, trainer.getProfile());
        }

        @Test
        void testCreateTrainer_Success_ContactDetails() {
            assertEquals(contactDetails, trainer.getContactDetails());
        }

        @Test
        void testCreateTrainer_Fail_NullTrainerId() {
            assertThrows(IllegalArgumentException.class, () ->
                    TrainerFactory.createTrainer(null, account, profile, contactDetails));
        }

        @Test
        void testCreateTrainer_Fail_EmptyTrainerId() {
            assertThrows(IllegalArgumentException.class, () ->
                    TrainerFactory.createTrainer("", account, profile, contactDetails));
        }

        @Test
        void testCreateTrainer_Fail_NullAccount() {
            assertThrows(IllegalArgumentException.class, () ->
                    TrainerFactory.createTrainer("T001", null, profile, contactDetails));
        }

        @Test
        void testCreateTrainer_Fail_NullProfile() {
            assertThrows(IllegalArgumentException.class, () ->
                    TrainerFactory.createTrainer("T001", account, null, contactDetails));
        }

        @Test
        void testCreateTrainer_Fail_NullContactDetails() {
            assertThrows(IllegalArgumentException.class, () ->
                    TrainerFactory.createTrainer("T001", account, profile, null));
        }


        @Test
        void testSetTrainerId() {
            trainer.setTrainerId("T999");
            assertEquals("T999", trainer.getTrainerId());
        }

        @Test
        void testSetAccount() {
            UserAccount newAccount = new UserAccount.Builder()
                    .accountId("ACC002")
                    .email("new.trainer@gmail.com")
                    .password("NewPass456!")
                    .role(RoleType.TRAINER)
                    .registrationDate(LocalDate.of(2025, 3, 1))
                    .build();
            trainer.setAccount(newAccount);
            assertEquals(newAccount, trainer.getAccount());
        }

        @Test
        void testSetProfile() {
            UserProfile newProfile = new UserProfile.Builder()
                    .profileId("P002")
                    .firstName("Updated")
                    .lastName("Trainer")
                    .gender("Male")
                    .dateOfBirth(LocalDate.of(1990, 5, 20))
                    .build();
            trainer.setProfile(newProfile);
            assertEquals(newProfile, trainer.getProfile());
        }

        @Test
        void testSetContactDetails() {
            ContactDetails newContact = new ContactDetails.Builder()
                    .setContactId("CN002")
                    .setCellphoneNumber("0868219751")
                    .setEmergencyContactNumber("0651098528")
                    .setEmergencyContactName("Updated Contact")
                    .build();
            trainer.setContactDetails(newContact);
            assertEquals(newContact, trainer.getContactDetails());
        }

        @Test
        void testBuilderToString_NotNullOrEmpty() {
            String result = new Trainer.Builder()
                    .setTrainerId("T001")
                    .setAccount(account)
                    .setProfile(profile)
                    .setContactDetails(contactDetails)
                    .toString();
            assertNotNull(result);
            assertFalse(result.isEmpty());
        }


        @Test
        void testTwoTrainers_AreIndependent() {
            Trainer trainer2 = TrainerFactory.createTrainer(
                    "T002",
                    new UserAccount.Builder()
                            .accountId("ACC002")
                            .email("trainer.two@gmail.com")
                            .password("TrainerPass456!")
                            .role(RoleType.TRAINER)
                            .registrationDate(LocalDate.of(2024, 6, 20))
                            .build(),
                    new UserProfile.Builder()
                            .profileId("P002")
                            .firstName("Inga")
                            .lastName("platyi")
                            .gender("Female")
                            .dateOfBirth(LocalDate.of(1995, 8, 14))
                            .build(),
                    new ContactDetails.Builder()
                            .setContactId("CN003")
                            .setCellphoneNumber("0823456789")
                            .setEmergencyContactNumber("0834567890")
                            .setEmergencyContactName("Zoleka platy")
                            .build());

            assertNotEquals(trainer.getTrainerId(),      trainer2.getTrainerId());
            assertNotEquals(trainer.getAccount(),        trainer2.getAccount());
            assertNotEquals(trainer.getProfile(),        trainer2.getProfile());
            assertNotEquals(trainer.getContactDetails(), trainer2.getContactDetails());
        }
    }
