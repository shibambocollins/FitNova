package za.ac.cput.repository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.entity.ContactDetails;
import za.ac.cput.entity.Trainer;
import za.ac.cput.entity.UserAccount;
import za.ac.cput.entity.UserProfile;
import za.ac.cput.entity.enums.RoleType;
import za.ac.cput.factory.TrainerFactory;
import za.ac.cput.repository.impl.TrainerRepositoryImpl;
import java.time.LocalDate;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

/**
 * 26 March 2026
 * Author: Lisakhanya Tshokolo
 * (220239215)
 */
public class TrainerRepositoryTest {

        private TrainerRepositoryImpl repo;
        private Trainer trainer1;
        private Trainer trainer2;

        @BeforeEach
        void setUp() {
            repo = TrainerRepositoryImpl.getRepository();
          //  repo = TrainerRepositoryImpl.getRepository();
            repo.delete("T001");
            repo.delete("T002");

            trainer1 = TrainerFactory.createTrainer(
                    "T001",
                    new UserAccount.Builder()
                            .accountId("ACC001")
                            .email("trainer@gmail.com")
                            .password("TrainerPass123")
                            .role(RoleType.TRAINER)
                            .registrationDate(LocalDate.of(2024, 1, 10))
                            .build(),
                    new UserProfile.Builder()
                            .profileId("P001")
                            .firstName("Sam")
                            .lastName("Ndlela")
                            .gender("Male")
                            .dateOfBirth(LocalDate.of(1999, 5, 20))
                            .build(),
                    new ContactDetails.Builder()
                            .setContactId("C001")
                            .setCellphoneNumber("0712345678")
                            .setEmergencyContactNumber("0798765432")
                            .setEmergencyContactName("Nomawethu Ndlela")
                            .build());

            trainer2 = TrainerFactory.createTrainer(
                    "T002",
                    new UserAccount.Builder()
                            .accountId("ACC002")
                            .email("trainer@gmail.com")
                            .password("TrainerPass456!")
                            .role(RoleType.TRAINER)
                            .registrationDate(LocalDate.of(2024, 6, 20))
                            .build(),
                    new UserProfile.Builder()
                            .profileId("P002")
                            .firstName("Sigcobile")
                            .lastName("Tshokolo")
                            .gender("Male")
                            .dateOfBirth(LocalDate.of(1995, 11, 9))
                            .build(),
                    new ContactDetails.Builder()
                            .setContactId("CN002")
                            .setCellphoneNumber("0823456789")
                            .setEmergencyContactNumber("0834567890")
                            .setEmergencyContactName("Vivian Tshokolo")
                            .build());
        }


        @Test
        void testGetRepository_ReturnsSameInstance() {
            TrainerRepositoryImpl instance1 = TrainerRepositoryImpl.getRepository();
            TrainerRepositoryImpl instance2 = TrainerRepositoryImpl.getRepository();
            assertSame(instance1, instance2);
        }


        @Test
        void testCreate_NotNull() {
            Trainer created = repo.create(trainer1);
            assertNotNull(created);
        }

        @Test
        void testCreate_ReturnsCorrectTrainer() {
            Trainer created = repo.create(trainer1);
            assertEquals(trainer1.getTrainerId(), created.getTrainerId());
        }

        @Test
        void testCreate_StoresTrainer() {
            repo.create(trainer1);
            assertNotNull(repo.read("T001"));
        }

        @Test
        void testCreate_CorrectEmail() {
            repo.create(trainer1);
            assertEquals("trainer@gmail.com", repo.read("T001").getAccount().getEmail());
        }

        @Test
        void testCreate_CorrectRole() {
            repo.create(trainer1);
            assertEquals(RoleType.TRAINER, repo.read("T001").getAccount().getRole());
        }

        @Test
        void testCreate_CorrectFirstName() {
            repo.create(trainer1);
            assertEquals("Sam", repo.read("T001").getProfile().getFirstName());
        }

        @Test
        void testCreate_CorrectCellphoneNumber() {
            repo.create(trainer1);
            assertEquals("0712345678", repo.read("T001").getContactDetails().getCellphoneNumber());
        }

        @Test
        void testCreate_MultipleTrainers() {
            repo.create(trainer1);
            repo.create(trainer2);
            assertNotNull(repo.read("T001"));
            assertNotNull(repo.read("T002"));
        }


        @Test
        void testRead_ExistingTrainer_NotNull() {
            repo.create(trainer1);
            assertNotNull(repo.read("T001"));
        }

        @Test
        void testRead_ExistingTrainer_CorrectTrainerId() {
            repo.create(trainer1);
            assertEquals("T001", repo.read("T001").getTrainerId());
        }

        @Test
        void testRead_ExistingTrainer_CorrectEmail() {
            repo.create(trainer1);
            assertEquals("trainer@gmail.com", repo.read("T001").getAccount().getEmail());
        }

        @Test
        void testRead_ExistingTrainer_CorrectPassword() {
            repo.create(trainer1);
            assertEquals("TrainerPass123", repo.read("T001").getAccount().getPassword());
        }

        @Test
        void testRead_ExistingTrainer_CorrectRole() {
            repo.create(trainer1);
            assertEquals(RoleType.TRAINER, repo.read("T001").getAccount().getRole());
        }

        @Test
        void testRead_ExistingTrainer_CorrectRegistrationDate() {
            repo.create(trainer1);
            assertEquals(LocalDate.of(2024, 1, 10),
                    repo.read("T001").getAccount().getRegistrationDate());
        }

        @Test
        void testRead_ExistingTrainer_CorrectFirstName() {
            repo.create(trainer1);
            assertEquals("Sam", repo.read("T001").getProfile().getFirstName());
        }

        @Test
        void testRead_ExistingTrainer_CorrectLastName() {
            repo.create(trainer1);
            assertEquals("Ndlela", repo.read("T001").getProfile().getLastName());
        }

        @Test
        void testRead_ExistingTrainer_CorrectGender() {
            repo.create(trainer1);
            assertEquals("Male", repo.read("T001").getProfile().getGender());
        }

        @Test
        void testRead_ExistingTrainer_CorrectDateOfBirth() {
            repo.create(trainer1);
            assertEquals(trainer1.getProfile().getDateOfBirth(), repo.read("T001").getProfile().getDateOfBirth());
        }

        @Test
        void testRead_ExistingTrainer_CorrectCellphoneNumber() {
            repo.create(trainer1);
            assertEquals("0712345678",
                    repo.read("T001").getContactDetails().getCellphoneNumber());
        }

        @Test
        void testRead_ExistingTrainer_CorrectEmergencyContactName() {
            repo.create(trainer1);
            assertEquals("Nomawethu Ndlela",
                    repo.read("T001").getContactDetails().getEmergencyContactName());
        }

        @Test
        void testRead_ExistingTrainer_CorrectEmergencyContactNumber() {
            repo.create(trainer1);
            assertEquals("0798765432",
                    repo.read("T001").getContactDetails().getEmergencyContactNumber());
        }

        @Test
        void testRead_NonExistentTrainer_ReturnsNull() {
            assertNull(repo.read("DOES_NOT_EXIST"));
        }


        @Test
        void testUpdate_NotNull() {
            repo.create(trainer1);
            trainer1.setProfile(new UserProfile.Builder()
                    .profileId("P001")
                    .firstName("Updated")
                    .lastName("Ndlela")
                    .gender("Male")
                    .dateOfBirth(LocalDate.of(1999, 5, 20))
                    .build());
            assertNotNull(repo.update(trainer1));
        }

        @Test
        void testUpdate_CorrectFirstName() {
            repo.create(trainer1);
            trainer1.setProfile(new UserProfile.Builder()
                    .profileId("P001")
                    .firstName("Updated")
                    .lastName("Ndlela")
                    .gender("Male")
                    .dateOfBirth(LocalDate.of(1999, 5, 20))
                    .build());
            repo.update(trainer1);
            assertEquals("Updated", repo.read("T001").getProfile().getFirstName());
        }

        @Test
        void testUpdate_CorrectCellphoneNumber() {
            repo.create(trainer1);
            trainer1.setContactDetails(new ContactDetails.Builder()
                    .setContactId("C001")
                    .setCellphoneNumber("076543218")
                    .setEmergencyContactNumber("0798765432")
                    .setEmergencyContactName("Nomawethu Ndlela")
                    .build());
            repo.update(trainer1);
            assertEquals("076543218",
                    repo.read("T001").getContactDetails().getCellphoneNumber());
        }

        @Test
        void testUpdate_NonExistentTrainer_ReturnsNull() {
            assertNull(repo.update(trainer1));
        }


        @Test
        void testDelete_ExistingTrainer_ReturnsTrue() {
            repo.create(trainer1);
            assertTrue(repo.delete("T001"));
        }

        @Test
        void testDelete_ExistingTrainer_NoLongerExists() {
            repo.create(trainer1);
            repo.delete("T001");
            assertNull(repo.read("T001"));
        }

        @Test
        void testDelete_NonExistentTrainer_ReturnsFalse() {
            assertFalse(repo.delete("DOES_NOT_EXIST"));
        }

        @Test
        void testGetAll_NotNull() {
            assertNotNull(repo.getAll());
        }

        @Test
        void testGetAll_ReturnsAllTrainers() {
            repo.create(trainer1);
            repo.create(trainer2);
            List<Trainer> all = repo.getAll();
            assertEquals(2, all.size());
        }

        @Test
        void testGetAll_EmptyStore_ReturnsEmptyList() {
            List<Trainer> all = repo.getAll();
            assertTrue(all.isEmpty());
        }

        @Test
        void testGetAll_ContainsCreatedTrainer() {
            repo.create(trainer1);
            assertTrue(repo.getAll().stream()
                    .anyMatch(t -> t.getTrainerId().equals("T001")));
        }
    }