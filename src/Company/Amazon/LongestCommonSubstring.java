/**
 * Version 1:
 *
 * Given two strings.
 * The task is to find the length of the longest common substring.
 *
 * Version 2:
 * Given two integer arrays S1 and S2,
 * return the maximum length of a subarray that appears in both arrays.
 */
package Company.Amazon;

/**
 * @author gkabra
 * @since 31-01-2022 Mon
 **/

public class LongestCommonSubstring {

    // TC : O(M*N)
    // SC : O(M*N)
    private static int findLength(int[] S1, int[] S2) {
        int[][] matr = new int[S2.length][S1.length];
        int max = Integer.MIN_VALUE;

        for(int i=0; i<S2.length; i++) {
            for(int j=0; j<S1.length; j++) {
                if(S2[i] == S1[j]) {
                    if(i>=1 && j>=1 && matr[i-1][j-1] > 0) {
                        matr[i][j] = 1+matr[i-1][j-1];
                    } else {
                        matr[i][j] = 1;
                    }
                }
                max = Math.max(max, matr[i][j]);
            }
        }
        return max;
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASE
        System.out.println(findLength(new int[] {70,39,25,40,7},
                new int[] {52,20,67,5,31}));
    }

}
