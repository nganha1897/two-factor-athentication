I. File list
------------
1) User.java                      Contains get and set methods
2) Usertester.java                Test methods in User.java
3) UserRepository.java            Returns a password hashed as a string. Contains methods to modify, delete and retrieve user
4) UserRepositoryTester.java      Tests methods createUser(), updateUser(), deleteUser() and retrieveUser() from UserRepository.java
5) Generator.java                 Generates a Salt String
6) GeneratorTester.java           Prints the returned string from Generator.java
7) PhoneVerification.java         Twilio API is used to send SMS to mobile phones with verification code.
8) PhoneVerificationTester.java   Tester for PhoneVerification.java
9) BasicFileConverter.java        Writing user and pad to database   
10) FileConverter.java            Interface
11) Hash.java                     Class to hash password
12) LogIn.java                    Class containing hashmap of users to verify username and password
13) LoginTester.java              Input Verification code
14) oneTimePad.txt
15) twilio-7.9.1-alpha-1-jar-with-dependencies.jar
16) user.txt
17) kalsang-ha-finalproject.pdf 



II. How to implement
--------------------
To test the application, run the LogInTester.java file. This file creates one user with the author's phone number. The file tests 2 cases. The first case is when the password is incorrect. The program terminates right after it checks the first factor bacause the password is wrong. The second case is when the password is correct. It leads to the second factor authentication. A one-time pad is sent to the author's phone and if this pad is entered correctly, the app will print a message saying that the authentication process has succeeded. Otherwise, it fails to authenticate. In order to test the second factor of the app, change the phone number in line 8 and 9 to a usable phone number. The app will send a 5-digit pad to this number and you can use this pad to continue the authentication. 
 

More detailed information in the project report (skalsang-ha-finalproject.pdf) about goals, tools used and results.