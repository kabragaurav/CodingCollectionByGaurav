/*
Given a string s. In one step you can insert any character at any index of the string.

Return the minimum number of steps to make s palindrome.
 */
package Company.Microsoft;

import java.util.Arrays;

/**
 * @author gaurav kabra
 * @since 08/Apr/2022
 **/

public class MinInsertToMakePalindrome {

    /*
        TC : O(N^2)
        SC : O(N^2)

        Excellent video : https://tinyurl.com/min-insert-to-make-palindrome
     */
    private static int minInsertions(String s) {
        int N = s.length();
        int[][] cache = new int[N+1][N+1];
        Arrays.stream(cache)
                .forEach(x -> Arrays.fill(x, -1));
        int L = lps(s, 0, s.length()-1, cache);
        return N-L;
    }

    private static int lps(String s, int l, int r, int[][] cache) {
        if (l > r) {
            return 0;
        }

        if (cache[l][r] != -1) {
            return cache[l][r];
        }

        char ch1 = s.charAt(l);
        char ch2 = s.charAt(r);
        int a = 0, b = 0, c = 0;

        if (ch1 == ch2) {
            a = lps(s, l+1, r-1, cache);
            a += (l == r ? 1 : 2);
        }
        b = lps(s, l+1, r, cache);
        c = lps(s, l, r-1, cache);

        return cache[l][r] = Math.max(a, Math.max(b,c));
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASE(S)
        System.out.println(minInsertions("abcaa"));
    }

}
