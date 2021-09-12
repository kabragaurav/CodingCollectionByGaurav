/**
 * Given a string s, check if it can be constructed by taking a proper substring of it
 * and appending it multiple times.
 */
package Strings;

/**
 * @author gaurav kabra
 * @since 12 Sept 2021
 **/

public class RepeatProperSubstring {

    private static boolean repeatProperSubstring(String s) {
        /**
         * Logic:
         * We take a proper substring, and repeat it to product string.
         * So the maximum length of substring can be half the length of original string (len/2).
         * Now if we repeat it some times and we get string, that means the length of original string
         * is divisible by length of substring (len%i).
         *
         * Time Complexity : O(N^2) due to for loop O(N) and substring will be O(N) as new copy will be created
         * Space Complexity : O(1)
         *
         * Here is the excellent video: https://tinyurl.com/repeat-proper-substring
         */
        int len = s.length();
        for(int i=1; i<=len/2; i++) {
            if(len%i == 0) {
                String subStr = s.substring(0, i);
                if(subStr.repeat(len/i).equals(s)) {
                    return true;
                }
            }
        }
        return false;
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASES
        System.out.println(repeatProperSubstring("a"));
        System.out.println(repeatProperSubstring("abab"));
        System.out.println(repeatProperSubstring("aba"));
    }
}
