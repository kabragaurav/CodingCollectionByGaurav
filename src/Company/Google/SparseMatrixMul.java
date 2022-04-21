/*
Given two Sparse Matrix A and B, return the result of AB.
You may assume that A's column number is equal to B's row number.
 */
package Company.Google;

import java.util.Arrays;

/**
 * @author gaurav kabra
 * @since 21/Apr/2022
 **/

public class SparseMatrixMul {

    private static int[][] multiply(int[][] a, int[][] b) {
        int[][] ans = new int[a.length][b[0].length];

        for (int i=0; i<a.length; i++) {
            for (int j=0; j<b[0].length; j++) {
                int row = 0;
                int sum = 0;

                for (int k=0; k<a[0].length; k++) {
                    sum += a[i][k] * b[row++][j];
                }

                ans[i][j] = sum;
            }
        }

        return ans;
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASE(S)
        System.out.println(Arrays.deepToString(multiply(new int[][] {
                {1,0,0},
                {-1,0,3}
        }, new int[][] {
                {7,0,0},
                {0,0,0},
                {0,0,1}
        })));
    }

}
