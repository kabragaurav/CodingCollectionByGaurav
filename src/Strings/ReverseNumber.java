/**
 * Apple
 *  Given a 32 bit signed integer, reverse it and return the result.
 *   If reversing x causes the value to go outside
 *   the signed 32-bit integer range [-2^31, 2^31 - 1], then return 0.
 */
package Strings;

/**
 * @author gaurav kabra
 * @since 25 Aug 2021
 **/
public class ReverseNumber {

    private static String regex = "^0+(?!$)";

    private static int reverse(String s) {
        /**
         * Logic:
         * Consider case when number is 15000. Answer should be 51 on reversing.
         * So we have to remove leading 0s.
         * In such case, it is always handy to use regex to identify pattern.
         */
        if(s.charAt(0) == '-') {
            return -1 * Integer.parseInt(new StringBuilder(s.substring(1)).reverse().toString().replaceAll(regex, ""));
        } else {
            return Integer.parseInt(new StringBuilder(s).reverse().toString().replaceAll(regex, ""));
        }
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASES
        System.out.println(reverse("-123"));
        System.out.println(reverse("150"));
        System.out.println(reverse("0"));
        System.out.println(reverse("1"));
        System.out.println(reverse("9646324351"));      // if this is provided as integer, NumberFormatException will be resulted since it does not fit in Integer.
    }
}

























