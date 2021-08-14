/**
 * Google
 * Given two strings s and t return whether or not s is a subsequence of t.
 * Both s and t only consist of lowercase characters and both have a length of at least one.
 */
package Strings;

/**
 * @author gaurav kabra
 * @since 14 August 2021
 */

public class IsSubsequence {
    private static boolean isSubsequence(String s, String t) {
        /**
         * Logic:
         * for each character in s, we see if this character is present in t.
         * If not then return false.
         * Else we truncate t from that index to end, so that this character index is not duplicated. E.g. s="aa" and t="a", unless we truncate t, we will get true, which is clearly wrong.
         */
        for(char ch : s.toCharArray()) {
            int index = t.indexOf(ch);
            if(index == -1) {
                return false;
            } else {
                t = t.substring(index+1);
            }
        }
        return true;
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASE
        System.out.println(isSubsequence("abc", "ahbgdc"));
        System.out.println(isSubsequence("cpu", "computer"));
        System.out.println(isSubsequence("xyz", "axbyc"));
    }
}
