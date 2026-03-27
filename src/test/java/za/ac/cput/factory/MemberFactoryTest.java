package za.ac.cput.factory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.entity.ContactDetails;
import za.ac.cput.entity.Member;
import za.ac.cput.entity.UserAccount;
import za.ac.cput.entity.UserProfile;
import za.ac.cput.entity.enums.RoleType;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class MemberFactoryTest {
    private static final String MEMBER_ID = "MEM01";
    private UserAccount account;
    private UserProfile profile;;
    private ContactDetails contact;
    private Member member;

    @BeforeEach
    void setUp(){
      account = new UserAccount.Builder()
              .accountId("ACC001")
              .email("lisakhanya@gmail.com")
              .password("Password123")
              .role(RoleType.MEMBER)
              .registrationDate(LocalDate.of(2025,10,22))
              .build();

      profile = new UserProfile.Builder()
              .profileId("PR001")
              .firstName("Lisakhanya")
              .lastName("Tshokolo")
              .dateOfBirth(LocalDate.of(2001,11,9))
              .gender("Female")
              .build();

      contact = new ContactDetails.Builder()
              .setContactId("CN01")
              .setCellphoneNumber("0815659910")
              .setEmergencyContactNumber("0783726156")
              .setEmergencyContactName("Mom")
              .build();

        member = MemberFactory.createMember(MEMBER_ID, account, profile, contact);
    }
    @Test
    void testCreateMember_success_NotNull(){
        assertNotNull(member);
    }
    @Test
    void testCreateMember_success_CorrectMemberId(){
        assertEquals(MEMBER_ID, member.getMemberId());;
    }
    @Test
    void testCreateMember_success_CorrectAccount(){
        assertEquals(account, member.getAccount());
    }
    @Test
    void testCreateMember_success_CorrectProfile(){
        assertEquals(profile, member.getProfile());
    }
    @Test
    void testCreateMember_success_CorrectContactDetails(){
        assertEquals(contact, member.getContact());
    }

    @Test
    void testCreateMember_fail_NullMemberId(){
        assertThrows(IllegalArgumentException.class, () -> MemberFactory.createMember(null, account, profile, contact));
    }
    @Test
    void testCreateMember_fail_EmptyMemberId(){
        assertThrows(IllegalArgumentException.class, () -> MemberFactory.createMember("", account, profile, contact));
    }
    @Test
    void testCreateMember_fail_NullAccount(){
        assertThrows(IllegalArgumentException.class, () -> MemberFactory.createMember(MEMBER_ID, null, profile, contact));
    }

    @Test
    void testCreateMember_fail_NullProfile(){
        assertThrows(IllegalArgumentException.class, () -> MemberFactory.createMember(MEMBER_ID, account, null, contact));

    }
    @Test
    void testCreateMember_fail_NullContactDetails(){
        assertThrows(IllegalArgumentException.class, () -> MemberFactory.createMember(MEMBER_ID, account, null, contact));
    }

    @Test
    void testSetMemberId(){
        member.setMemberId(MEMBER_ID);
        assertEquals(MEMBER_ID, member.getMemberId());
    }
    @Test
    void testSetAccount(){
        UserAccount newAccount = new UserAccount.Builder()
                .accountId("ACC02")
                .email("zinathi@gmail.com")
                .password("ZEE34")
                .role(RoleType.TRAINER)
                .registrationDate(LocalDate.of(2026,01,12))
                .build();
        member.setAccount(newAccount);
        assertEquals(newAccount, member.getAccount());
    }
    @Test
    void testSetProfile(){
        UserProfile newProfile = new UserProfile.Builder()
                .profileId("PR002")
                .firstName("Avuyile")
                .lastName("Sitoyi")
                .gender("Male")
                .dateOfBirth(LocalDate.of(2005,04,22))
                .build();
        member.setProfile(newProfile);
        assertEquals(newProfile, member.getProfile());
    }
    @Test
    void testSetContact(){
        ContactDetails newContact = new ContactDetails.Builder()
                .setContactId("CN02")
                .setCellphoneNumber("0982346721")
                .setEmergencyContactNumber("0761258234")
                .setEmergencyContactName("Zizipho")
                .build();
        member.setContact(newContact);
        assertEquals(newContact, member.getContact());
    }

    @Test
    void testBuilderToString_NotNullOrEmpty(){
        String result = new Member.Builder()
                .memberId(MEMBER_ID)
                .account(account)
                .profile(profile)
                .contact(contact)
                .toString();
        assertNotNull(result);
        assertFalse(result.isEmpty());
    }
    @Test
    void testTwoMembers_AreIndependent(){
       UserAccount account2 = new UserAccount.Builder()
               .accountId("ACC003")
               .email("athi@gmail.com")
               .password("ath123")
               .role(RoleType.TRAINER)
               .registrationDate(LocalDate.of(2026,01,01))
               .build();

       UserProfile profile2 = new UserProfile.Builder()
               .profileId("PR003")
               .firstName("Athi")
               .lastName("Sintiya")
               .gender("Male")
               .dateOfBirth(LocalDate.of(1998,06,21))
               .build();

       ContactDetails contact2 = new ContactDetails.Builder()
               .setContactId("CN003")
               .setCellphoneNumber("0812349876")
               .setEmergencyContactName("Avyile")
               .setEmergencyContactNumber("0641984523")
               .build();

       Member member2 = MemberFactory.createMember("MEM02", account2, profile2, contact2);
       assertNotNull(member.getMemberId(),member2.getMemberId());
       assertNotEquals(member.getAccount(),member2.getAccount());
       assertNotEquals(member.getProfile(),member2.getProfile());
       assertNotEquals(member.getContact(),member2.getContact());
    }


}
