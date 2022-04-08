package Company.Microsoft;

/**
 * @author gaurav kabra
 * @since 08/Apr/2022
 **/

public class LongestPalindromicSubstring {

    /*
        This question is "exact" of CountPalindromicSubstrings.java
     */
    private static String longestPalindrome(String s) {
        int N = s.length();
        boolean[][] cache = new boolean[N][N];
        String ans = null;
        for (int g=0; g<N; g++) {
            for (int i=0, j=g; j<N; i++, j++) {
                if (g == 0) {
                    cache[i][j] = true;
                } else if (g == 1) {
                    if (s.charAt(i) == s.charAt(j)) {
                        cache[i][j] = true;
                    }
                } else {
                    if (s.charAt(i) == s.charAt(j) && cache[i+1][j-1]) {
                        cache[i][j] = true;
                    }
                }
                if (cache[i][j]) {
                    ans = s.substring(i, j+1);
                }
            }
        }
        return ans;
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASE(S)
        System.out.println(longestPalindrome("abba"));
        System.out.println(longestPalindrome("abc"));
        System.out.println(longestPalindrome("a"));
    }

}
