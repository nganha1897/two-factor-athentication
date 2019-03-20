
/**
 * File: PhoneVerificationTester.java
 *
 * @author Ha Tran
 * @author Kalsang Sherpa
 *
 * @date 12/09/2018
 * CPSC 385
 */

public class PhoneVerificationTester {
    public static void main (String args[]) {
        User user = new User("user1", "pw1", "+18609774823");
        PhoneVerification pv = new PhoneVerification(user.getPhoneNumber());
        pv.sendOneTimePad(user);
        pv.displayPadManager();
    }
}
