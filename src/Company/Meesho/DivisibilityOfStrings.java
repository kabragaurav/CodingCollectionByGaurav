/*
Given two strings, s and t, create a function that operates per the following rules:
Find whether string s is divisible by string t.  String s divisible by string t if string t can be
concatenated some number of times to obtain the string s.
If s is divisible, find the smallest string, u, such that it can be concatenated some number of times to
obtain both s and t.
If it is not divisible, set the return value to -1. Return the length of the string u or -1.
 */
package Company.Meesho;

/**
 * @author gaurav kabra
 * @since 18/May/2022
 *
 * Ref: https://tinyurl.com/string-divisibility
 **/

public class DivisibilityOfStrings {

    private static int stringDivisibility(String s, String t) {
        int lenS = s.length();
        int lenT = t.length();

        if (lenS % lenT != 0) {
            return -1;
        }

        String repeatT = t.repeat(lenS/lenT);

        if (!s.equals(repeatT)) {
            return -1;
        }

        for (int i=0; i<=lenT; i++) {
            String temp = t.substring(0, i);
            if (temp.length() != 0 && temp.repeat(lenT/temp.length()).equals(t)) {
                return temp.length();
            }
        }

        return -1;
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASE(S)
        System.out.println(stringDivisibility("bcdbcdbcdbcd", "bcdbcd"));
        System.out.println(stringDivisibility("bcdbcdbcd", "bcdbcd"));
        System.out.println(stringDivisibility("lrbblrbb", "lrbb"));
        System.out.println(stringDivisibility("rbrb", "rbrb"));
    }

}
