package Miscellaneous.UniqueConcepts;

/**
 * @author gaurav kabra
 * @since 08 Jan 2022
 **/

public class IntToHex {

    private static String toHex(int num) {
        // built-in method
        return Integer.toHexString(num);
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASES
        System.out.println(toHex(-1));
        System.out.println(toHex(26));
    }
}
