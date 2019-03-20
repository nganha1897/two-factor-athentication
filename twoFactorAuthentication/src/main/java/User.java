
import java.io.Serializable;

/**
 * File: User.java
 * Contains get and set methods
 * @author Ha Tran
 * @author Kalsang Sherpa
 *
 * @date 12/09/2018
 * CPSC 385
 */

public class User implements Serializable {
    private String username;
    private String password;
    private String phoneNumber;
    /*Constructor
    * @param username
    * @param password
    * @param phoneNumber
    */
    public User(String username, String password, String phoneNumber){
        this.username = username;
        this.password = password;
        this.phoneNumber = phoneNumber; 
    }
    /* Method to get username
    * @return String
    */
    public String getUsername() {
        return username;
    }  
    /* Method to get new password
    * @return String
    */
    public String getPassword() {
        return password;
    } 
    /* Method to get PhoneNumber
    * @return String
    */
    public String getPhoneNumber() {
        return phoneNumber;
    }   
    /* Method to set new username
    * @param username
    */
    public void setName (String username) {
        this.username = username;
    } 
    /* Method to set new password
    * @param password
    */
    public void setPassword ( String password ) {
        this.password = password;
    } 
    /* Method to set new phoneNumber
    * @param phoneNumber
    */
    public void setPhoneNumber(String phoneNumber) {
        
        this.phoneNumber = phoneNumber;
    } 
    /* Method to display username, password and phone number
    * @return String
    */
    public String toString() {
        return "username: " + username + ", password: " + password + ", phone number: " + phoneNumber;
    }
}
