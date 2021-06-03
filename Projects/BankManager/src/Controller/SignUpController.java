package Controller;

import Model.Accounts;
import Model.Login;
import Model.User;

import java.net.PasswordAuthentication;
import java.sql.ResultSet;

public class SignUpController {

    public static void initialSignUp(String UserID, String UserName, int genderValue, String birthday, String userAddress, String userPhone, String userAccount, String password) {
        System.out.println("Tạo Người Dùng");
        User.insertNewUser(UserID, UserName, birthday, genderValue, userAddress, userPhone);
        String accountNumber = TransactionsController.randomID(0, 9, 10);
        while (AccountController.searchAccountNumber(accountNumber)) {
            accountNumber = TransactionsController.randomID(0, 9, 10);
        }
        System.out.println("Tạo Account");
        Accounts.insertAccount(accountNumber, UserID);
        System.out.println("Tạo Login Account");
        Login.insertNewLoginAccount(userAccount, password, accountNumber);
    }
}
