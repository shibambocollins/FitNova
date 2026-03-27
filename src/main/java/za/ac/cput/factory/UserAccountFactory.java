package za.ac.cput.factory;
/**
 *
 * 25 March 2026
 * Author: Avuyile Sitoyi
 * (240971051)
 */
import za.ac.cput.entity.UserAccount;
import za.ac.cput.entity.enums.RoleType;
import za.ac.cput.util.Helper;

import java.time.LocalDate;

public class UserAccountFactory
{
    public static UserAccount CreateUserAccount(String accountId,
     String email, String password,
    RoleType role, LocalDate registrationDate
    ) {
    if(Helper.isNullOrEmpty(accountId))
        throw new IllegalArgumentException("AccountId required");
     if(Helper.isNullOrEmpty(email))
         throw new IllegalArgumentException(" email required");
     if(Helper.isNullOrEmpty(password))
         throw new IllegalArgumentException("Password is required");

return new UserAccount.Builder().accountId(accountId).email(email).
        password(password).role(role).registrationDate(registrationDate).build();
}

}
