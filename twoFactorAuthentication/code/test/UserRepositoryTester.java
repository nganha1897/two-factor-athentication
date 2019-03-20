
/**
 * File: UserRepositoryTester.java
 * 
 * @author Ha Tran
 * @author Kalsang Sherpa
 *
 * @date 12/09/2018
 * CPSC 385
 */


public class UserRepositoryTester {
    public static void main (String[] args) {
        UserRepositoryTester urt = new UserRepositoryTester();
        UserRepository ur = new UserRepository();
        urt.testAddUser(ur); 
        urt.testUpdateUser(ur);
        urt.testDeleteUser(ur);
        urt.testRetrieveUser(ur);
    }
    
    private void testAddUser(UserRepository ur) {
        System.out.println("--- TEST ADD USER ---");
        ur.createUser("user1","pw1","+11234567890");
        ur.createUser("user2","pw2","+12147483648");
        ur.createUser("user3","pw3","+1e1245");
        ur.createUser("user2", "pw4", "123456");
        ur.createUser("user5", "pw5", "123");
        ur.createUser("user6", "pw6", "123");
    }
    
    private void testUpdateUser(UserRepository ur) {
        System.out.println("\n--- TEST UPDATE USER ---");
        ur.updateUser("user1", "updatedPw", "+11234567890");
        ur.updateUser("user2", "updatedPw2", "+11234567890");
        ur.updateUser("user2", "updatedPw2", "+11234567894");
    }
    
    private void testDeleteUser(UserRepository ur) {
        System.out.println("\n--- TEST DELETE USER ---");
        ur.deleteUser("user2");       
    }
    
    private void testRetrieveUser(UserRepository ur) {
        System.out.println("\n--- TEST RETRIEVE USER ---");
        System.out.println("Retrieve: " + ur.retrieveUser("user1"));
    }
}
