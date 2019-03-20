
import java.util.Random;

/**
 * File: Generator
 *  Generates a Salt string with reference from https://stackoverflow.com/questions/20536566/creating-a-random-string-with-a-z-and-0-9-in-java
 * @author Ha Tran
 * @author Kalsang Sherpa
 *
 * @date 12/09/2018
 * CPSC 385
 */

public class Generator {
    private int passLen = 5;
    
    /*Method to generate a random salt string
    * @return String saltSr
    */
    public String getSaltString() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < passLen) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;

    }
}