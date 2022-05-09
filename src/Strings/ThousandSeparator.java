/*
Given an integer n, add a comma (",") as the thousands separator and return it in string format.
 */
package Strings;

/**
 * @author gaurav kabra
 * @since 09/May/2022
 **/

public class ThousandSeparator {

    // TC : O(D), D = number of digits in n, i.e., length of n
    // SC : O(D) for answer
    private static String thousandSeparator(int n) {

        if (n < 1000) {
            return Integer.toString(n);
        }

        StringBuilder sb = new StringBuilder();
        int count = 0;

        while (n > 0) {
            int mod = n % 10;
            sb.append(mod);
            n /= 10;
            count++;
            if (n > 0 && count % 3 == 0) {
                sb.append(",");
            }
        }

        return sb.reverse().toString();
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASE(S)
        System.out.println(thousandSeparator(989));
        System.out.println(thousandSeparator(1001));
        System.out.println(thousandSeparator(0));
        System.out.println(thousandSeparator(10011001));
    }

}
