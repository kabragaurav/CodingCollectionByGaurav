/**
 * Version 1:
 * Given two string s1 and s2, find if s1 is rotation of s2.
 *
 *
 * Version 2:
 * Given two strings s and goal, return true if and only if s can become goal
 * after some number of shifts on s.
 * A shift on s consists of moving the leftmost character of s to the rightmost position.
 * For example, if s = "abcde", then it will be "bcdea" after one shift.
 */
package Company.Amazon;

/**
 * @author gkabra
 * @since 30-01-2022 Sun
 **/

public class StringRotationOfOther {

    /**
     * Logic:
     * All rotations of A are contained in A+A.
     * Thus, we can simply check whether B is a substring of A+A.
     *
     * TC : O(N^2) for contains() method which internally uses brute force (C++ uses KMP, which is O(N))
     * SC : O(N) for (s+s)
     */
    private static boolean rotateString(String s, String goal) {
        return s.length() != goal.length() ? false : (s+s).contains(goal);
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASES
        System.out.println(rotateString("aa", "a"));
        System.out.println(rotateString("abcd", "cdab"));
    }

}
