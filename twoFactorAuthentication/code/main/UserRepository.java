import java.io.*;
import java.util.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * File: UserRepository.java
 * Returns a password hashed as a string. Contains methods to modify, delete and retrieve user
 * @author Ha Tran
 * @author Kalsang Sherpa
 *
 * @date 12/09/2018
 * CPSC 385
 */

public class UserRepository {

    private static final String USER_FILE_NAME = "src/main/java/user.txt";
    private FileConverter fileConverter;
    private Map<String, User> manager = new HashMap<>();
    Hash hsh;
    /*Constructor*/
    public UserRepository() {
        hsh = new Hash();
        fileConverter = new BasicFileConverter(USER_FILE_NAME);
        try {
            BufferedReader br = new BufferedReader(new FileReader(USER_FILE_NAME));
            if (fileConverter.doesFileExist() && br.readLine() != null) {
                Map<String, User> original = fileConverter.deserializeUser();
                manager = original == null ? new HashMap<>() : manager;
            }
        } catch (IOException e) {
            Logger.getLogger(UserRepository.class.getName()).log(Level.SEVERE, "Error reading file", e);
        }
    }
    /*Method to create user
    * @param username
    * @param password
    * @param phoneNumber
    * @return boolean */
    public boolean createUser(String username, String password, String phoneNumber) {
        if (!isUsernameValid(username) || !isPasswordValid(password) || !isPhoneNumberValid(phoneNumber)) {
            System.out.println("Failed to create this user: " + new User(username, password, phoneNumber));          
            return false;
        }    
        manager.put(username, new User(username, hsh.hash(password), phoneNumber));
        fileConverter.serializeUser(manager);
        System.out.println("Created: " + new User (username, password, phoneNumber));     
        return true;
    }
    
     /*Method to check is username is valid
    * @param username
    * @return boolean */
    private boolean isUsernameValid(String username) {
        if (username == null || username.length() == 0 || manager.containsKey(username))
            return false;
        return true;
    }
     /*Method to check is passwordis valid
    * @param password
    * @return boolean 
    */
    private boolean isPasswordValid(String password) {
        if (password == null || password.length() == 0)
            return false;
        return true;
    }

    /*Method to check is phoneNumber is valid
    * @param phoneNumber
    * @return boolean 
    */
    private boolean isPhoneNumberValid(String phoneNumber) {
        if (phoneNumber == null || phoneNumber.length() != 12) {
            System.out.println("The format of the phone number is wrong. The format should be: +1xxxxxxxxxx");
            return false;
        }
        char[] phoneC = phoneNumber.toCharArray();
        if (phoneC[0] != '+' || phoneC[1] != '1') {
            System.out.println("The first characters of the phone number should be +1");
            return false;
        }
        try { 
            Long.parseLong(phoneNumber.substring(2)); 
        }  
        catch (NumberFormatException e)  { 
            System.out.println(phoneNumber + " is not a valid phone number");
            return false;
        } 
        for (User user : manager.values()) {
            if (user.getPhoneNumber().equals(phoneNumber)) 
                return false;
        }
        return true;
    }
    
    /*Method to update user
    * @param username
    * @param newPassword
    * @param newPhoneNumber
    * @return boolean 
    */
    public boolean updateUser(String username, String newPassword, String newPhoneNumber) {
        if (!manager.containsKey(username)) {
            System.out.println("Error in updating user: This user does not exist");
            return false;
        }
        if (!manager.get(username).getPhoneNumber().equals(newPhoneNumber) && !isPhoneNumberValid(newPhoneNumber)) {
            System.out.println("Error in updating user: The phone number already exists or does not have a proper form");
            return false;
        }
        manager.put (username, new User(username, hsh.hash(newPassword), newPhoneNumber));
        System.out.println("Updated user: " + new User(username, newPassword, newPhoneNumber));
        fileConverter.serializeUser(manager);
        return true;
    }

    /*Method to delete user
    * @param username
    * @return boolean 
    */
    public boolean deleteUser(String username) {
        if (!manager.containsKey(username)) {
            System.out.println("Error in deleting user: This user does not exist");
            return false;
        }
        System.out.println("Delete: " + manager.remove(username));  
        fileConverter.serializeUser(manager);
        return true;
    }
     /*Method to retrieve user
    * @param username
    * @return User
    */
    public User retrieveUser(String username) {
        return manager.get(username);
    }

    public void displayManager() {
        for (HashMap.Entry<String, User> user : manager.entrySet()) {
            System.out.println("Key: " + user.getKey() + " Value: " + user.getValue());
        }
    }
    
    public Map<String, User> getManager() {
        return manager;
    }
    
}