package Arrays;

/**
 * @author gaurav kabra
 * @since 18 Dec 2021
 **/

import java.util.Arrays;

public class FlippingAnImage {

    /**
     * TC : O(N^2)
     * SC : (N^2)
     */
    private static int[][] flipAndInvertImage(int[][] image) {
        int N = image.length;
        int[][] ans = new int[N][N];
        for(int i=0; i<N; i++) {
            for(int j=N-1; j>=0; j--) {
                ans[i][N-1-j] = 1-image[i][j];
            }
        }
        return ans;
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASE
        System.out.println(Arrays.deepToString(flipAndInvertImage(
                new int[][] {{1,1,0},{1,0,1},{0,0,0}}
        )));
    }
}
