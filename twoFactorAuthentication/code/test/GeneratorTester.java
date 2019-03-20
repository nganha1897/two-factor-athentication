/**
 * File: GeneratorTester.java
 * Prints the returned string from Generator.java
 * @author Ha Tran
 * @author Kalsang Sherpa
 *
 * @date 12/09/2018
 * CPSC 385
 */
public class GeneratorTester {

    public static void main (String args[]) {
        Generator gr = new Generator();
        System.out.println("The one-time pad is: " + gr.getSaltString());
    }
}
