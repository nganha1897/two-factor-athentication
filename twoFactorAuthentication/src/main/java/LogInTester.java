import java.util.Scanner;


/**
 * File: LogInTester.java
 * Input verification code
 * @author Ha Tran
 * @author Kalsang Sherpa
 *
 * @date 12/09/2018
 * CPSC 385
 */

public class LogInTester {
    public static void main(String[] args) {  
        LogInTester lit = new LogInTester();
        UserRepository ur = new UserRepository();
        User user = new User ("user1","pw1","+17185935682");
        ur.createUser("user1","pw1","+17185935682");
        LogIn login = new LogIn(ur,user);   
        PhoneVerification pv = new PhoneVerification(user.getPhoneNumber());
        lit.twoFactorAuthentication(login, user, pv, user.getUsername(), "Wrong password");
        lit.twoFactorAuthentication(login, user, pv, user.getUsername(), user.getPassword());       
    }
    public void twoFactorAuthentication(LogIn login, User user, PhoneVerification pv, String username, String password) {
        if (login.firstFactorVerify(username, password)) {
            System.out.println("Verification for " + username + ": " + login.firstFactorVerify(username,password));
            pv.sendOneTimePad(user);
            Scanner reader = new Scanner(System.in); 
            System.out.println("Enter the one-time pad sent to your phone: ");
            String input = reader.next();
            if (login.verifyPad(pv, user.getUsername(), input))
                System.out.println("The pad is correct. You have successfully logged in!!");
            else
                System.out.println("Attempt to log in failed because the one-time pad is incorrect!");
            reader.close();
        } else {
            System.out.println("First factor password: wrong. The application will not test 2nd factor authorization");
        }      
    }
}
