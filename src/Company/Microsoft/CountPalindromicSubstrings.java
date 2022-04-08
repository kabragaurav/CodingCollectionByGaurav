/*
Given a string s, return the number of palindromic substrings in it.
 */
package Company.Microsoft;

/**
 * @author gaurav kabra
 * @since 08/Apr/2022
 **/

public class CountPalindromicSubstrings {

    /*
        TC : O(N^2)
        SC : O(N^2)

        Excellent video : https://tinyurl.com/count-palindromic-substrings
     */
    private static int countSubstrings(String s) {
        int N = s.length();
        boolean[][] cache = new boolean[N][N];
        int count = 0;
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
                    count++;
                }
            }
        }
        return count;
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASE(S)
        System.out.println(countSubstrings("lasagna"));
        System.out.println(countSubstrings("a"));
        System.out.println(countSubstrings("aaa"));
        System.out.println(countSubstrings("abc"));
    }

}
