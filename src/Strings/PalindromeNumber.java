/**
 * Given an integer x, return true if x is palindrome integer.
 */
package Strings;

/**
 * @author gaurav kabra
 * @since 01 Jan 2022
 **/

public class PalindromeNumber {

    private static boolean isPalindrome(int x) {
        // prevent NegativeArraySizeException (Can't create array of negative size)
        if(x < 0) {
            return false;
        }
        // if you directly write new StringBuilder(x), x will be treated as capacity
        StringBuilder sb = new StringBuilder(Character.toString(x));
        // comparing stringbuilder - StringBuilder does not override Object class's equals()
        return sb.toString().equals(sb.reverse().toString());
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASES
        System.out.println(isPalindrome(121));
        System.out.println(isPalindrome(-121));
    }
}
