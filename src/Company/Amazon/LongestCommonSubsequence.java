package Company.Amazon;

/**
 * @author gkabra
 * @since 31-01-2022 Mon
 **/

public class LongestCommonSubsequence {

    private static int helper(String text1, int curr1, String text2, int curr2, int[][] cache) {
        if(curr1 == text1.length() || curr2 == text2.length()) {
            return 0;
        }
        if(cache[curr1][curr2] != 0) {
            return cache[curr1][curr2];
        }
        int with = 0, without = 0;
        if(text1.charAt(curr1) == text2.charAt(curr2)) {
            with = 1 + helper(text1, curr1+1, text2, curr2+1, cache);
        }
        without = Math.max(helper(text1, curr1, text2, curr2+1, cache),
                helper(text1, curr1+1, text2, curr2, cache)
        );
        return cache[curr1][curr2] = Math.max(with, without);
    }


    private static int longestCommonSubsequence(String text1, String text2) {
        int[][] cache = new int[text1.length()+1][text2.length()+1];
        return helper(text1, 0, text2, 0, cache);
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASE
        System.out.println(longestCommonSubsequence("abcde", "ace"));
    }

}
