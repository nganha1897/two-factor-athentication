
/**
 * File: UserTester.java
 * 
 * @author Ha Tran
 * @author Kalsang Sherpa
 *
 * @date 12/09/2018
 * CPSC 385
 */

public class UserTester {
    public static void main (String[] args) {
        System.out.println("Let's test the user class.");
        User user1 = new User ("Google", "Larry Page", "12456");
        System.out.println(user1);
        User user2 = new User ("Facebook", "Mark Zuckerberg", "124567");
        System.out.println(user2);
        User user3 = new User ("Snapchat", "Evan Spiegel", "1245678");
        System.out.println(user3);
    }
}
