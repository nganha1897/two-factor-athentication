import java.io.*;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * File: BasicFileConverter.java
 * Creating a hashmap of users and pad to write store it in database.
 *
 * @author Ha Tran
 * @author Kalsang Sherpa
 *
 * @date 12/09/2018
 * CPSC 385
 */
public class BasicFileConverter implements FileConverter {

    private String fileName;
    private File file;
    private boolean fileExisted = false;
    
    /*Constructor
    * @param filName name of file
    */
    public BasicFileConverter(String fileName) {
        this.fileName = fileName;
        this.file = new File(fileName);
        try {
            fileExisted = !this.file.createNewFile();
        } catch (IOException e) {
            Logger.getLogger(BasicFileConverter.class.getName()).log(Level.SEVERE, "Error initializing file converter", e);
        }
    }
    /* Method to check whether file exists
    * @return true if file exists else false
    */
    public boolean doesFileExist() {
        return fileExisted;
    }
    
    /* Writing user to database
    * @param manager hashmap of users
    */
    public void serializeUser(Map<String, User> manager) {
        try {
            FileOutputStream fileOut = new FileOutputStream(fileName, false);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(manager);
            out.close();
            fileOut.close();
        } catch (IOException e) {
            Logger.getLogger(BasicFileConverter.class.getName()).log(Level.SEVERE, "Error serializing the user map", e);
        }
    }
    
    /* Writing pads to database
    * @param padManager hashmap of pad
    */
    public void serializePad(Map<String, String> padManager) {
        try {
            FileOutputStream fileOut = new FileOutputStream(fileName, false);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(padManager);
            out.close();
            fileOut.close();
        } catch (IOException e) {
            Logger.getLogger(BasicFileConverter.class.getName()).log(Level.SEVERE, "Error serializing the pad map", e);
        }
    }
    
    /* 
    * @return Map<String, User>
    */
    public Map<String, User> deserializeUser() {
        Map<String, User> manager = null;
        try {
            FileInputStream fileIn = new FileInputStream(fileName);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            manager = (Map<String, User>) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException | ClassNotFoundException e) {
            Logger.getLogger(BasicFileConverter.class.getName()).log(Level.SEVERE, "Error deserializing the user map", e);
        }
        return manager;
    }

    /* 
    * @return Map<String, String>
    */
    public Map<String, String> deserializePad() {
        Map<String, String> padManager = null;
        try {
            FileInputStream fileIn = new FileInputStream(fileName);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            padManager = (Map<String, String>) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException | ClassNotFoundException e) {
            Logger.getLogger(BasicFileConverter.class.getName()).log(Level.SEVERE, "Error deserializing the pad map", e);
        }
        return padManager;
    }
    
    public void fileClose() {
        this.file.delete();
    }
}
