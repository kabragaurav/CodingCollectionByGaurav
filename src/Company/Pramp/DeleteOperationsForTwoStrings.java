package Company.Pramp;

import java.util.Arrays;

/**
 * @author gaurav kabra
 * @since 17/Apr/2022
 **/

public class DeleteOperationsForTwoStrings {

    // TC : O(l1*l2)
    // SC : O(l1*l2)
    private static int minDistance(String str1, String str2) {
        if (str1.equals(str2)) {
            return 0;
        }

        int l1 = str1.length();
        int l2 = str2.length();
        int[][] cache = new int[l1+1][l2+1];
        Arrays.stream(cache)
                .forEach(x -> Arrays.fill(x, -1));
        return helper(str1, 0, l1-1, str2, 0, l2-1, cache);
    }

    private static int helper(String str1, int curr1, int l1, String str2, int curr2, int l2, int[][] cache) {

        if (curr2 > l2) {
            if (curr1 <= l1) {
                return cache[curr1][curr2] = l1 - curr1 + 1;
            }
            return 0;    // don't forget this stmt
        }

        if (curr1 > l1) {
            if (curr2 <= l2) {
                return cache[curr1][curr2] = l2 - curr2 + 1;
            }
            return 0;
        }

        if (cache[curr1][curr2] != -1) {
            return cache[curr1][curr2];
        }

        int ch1 = str1.charAt(curr1);
        int ch2 = str2.charAt(curr2);

        if (ch1 == ch2) {
            return cache[curr1][curr2] = helper(str1, curr1 + 1, l1, str2, curr2 + 1, l2, cache);
        } else {
            int a = 1 + helper(str1, curr1 + 1, l1, str2, curr2, l2, cache);
            int b = 1 + helper(str1, curr1, l1, str2, curr2 + 1, l2, cache);
            int c = 2 + helper(str1, curr1 + 1, l1, str2, curr2 + 1, l2, cache);
            return cache[curr1][curr2] = Math.min(a, Math.min(b, c));
        }
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASE(S)
        System.out.println(minDistance("dog", "frog"));
        System.out.println(minDistance("", ""));
    }

}
