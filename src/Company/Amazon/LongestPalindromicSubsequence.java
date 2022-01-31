/**
 * Given a string s, find the longest palindromic subsequence's length in s.
 */
package Company.Amazon;

/**
 * @author gkabra
 * @since 31-01-2022 Mon
 **/

public class LongestPalindromicSubsequence {

    private static int helper(String s, int first, int last, int[][] cache) {
        if(first > last) {
            return 0;
        }
        if(first == last) {
            return 1;
        }
        if(cache[first][last] != 0) {
            return cache[first][last];
        }
        int with = 0, without = 0;
        if(s.charAt(first) == s.charAt(last)) {
            with = 2 + helper(s, first+1, last-1, cache);
        }
        without = Math.max(helper(s, first+1, last, cache),
                helper(s, first, last-1, cache)
        );
        return cache[first][last] = Math.max(with, without);
    }

    private static int longestPalindromeSubseq(String s) {
        if(s.length() <= 1) {
            return s.length();
        }
        int[][] cache = new int[s.length()+1][s.length()+1];
        return helper(s, 0, s.length()-1, cache);
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASE
        System.out.println(longestPalindromeSubseq("bbbab"));
    }

}
