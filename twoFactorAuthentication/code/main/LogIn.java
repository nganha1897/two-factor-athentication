
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * File: LogIn.java
 * Class containing hashmap of users to verify username and password
 * @author Ha Tran
 * @author Kalsang Sherpa
 *
 * @date 12/09/2018
 * CPSC 385
 */

public class LogIn {

    private Map<String, User> manager = new HashMap<>();
    Hash hsh;
    UserRepository ur;
    PhoneVerification pv;
    User user;
    
    /*Constructor
    * @param ur   object of UserRepository class
    * @param user object of User class
    */   
    public LogIn(UserRepository ur, User user) {
        hsh = new Hash();
        this.ur = ur;
        this.user = user;
        pv = new PhoneVerification(user.getPhoneNumber());
    }
    
    /* Method to return if password and username are valid
    * @param username   
    * @param password
    * @return boolean true if password is equal to the hashed password from database else false
    */
    public boolean firstFactorVerify(String username, String password) {
        Map<String, User> manager = ur.getManager();
        if (!manager.containsKey(username)) {
            System.out.println("This username does not exist");
            return false;
        } else {
            if (manager.get(username).getPassword().equals(hsh.hash(password)))
                return true;
            else {
                System.out.println("Wrong password");
                return false;
            }
        }
    }
    
    /* Method to return if pad is valid
    * @param pv        object from PhoneVerification.java  
    * @param username
    * @param password
    * @return boolean true if pad is valid
    */
    public boolean verifyPad(PhoneVerification pv, String username, String pad) {
        Map<String, String> padManager = pv.getPadManager();
        if (!padManager.containsKey(username)) {
            System.out.println("This username does not exist");
            return false;
        } else {
            if (padManager.get(username).equals(hsh.hash(pad)))
                return true;
            else {
                System.out.println("Wrong pad");
                return false;
            }
        }
    }
}
