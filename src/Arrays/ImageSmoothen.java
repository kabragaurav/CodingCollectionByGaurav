/**
 * An image smoother is a filter of the size 3 x 3 that can be applied to each cell of an image
 * Average = sum of cells (including the cell) and its 8 neighbors. If neighbours < 8,
 * then take only available ones. E.g. if cell is corner cell, then include the cell and its
 * 3 neighbors in the sum. So if sum is say S then avearage at cell will be S/4.
 *
 * While calculating average at each cell, consider original values in the given matrix.
 */
package Arrays;

import Arrays.Utils.ArrayUtils;

import java.util.Arrays;

/**
 * @author gkabra
 * @since 11-03-2022 Fri
 **/

public class ImageSmoothen {

    // TC : O(N^2)
    // SC : O(N^2)
    private static int[][] dirs = {
            {-1,-1},
            {-1,0},
            {-1,1},
            {0,-1},
            {0,1},
            {1,-1},
            {1,0},
            {1,1}
    };

    private static int[][] imageSmoother(int[][] img) {
        int M = img.length;
        int N = img[0].length;

        int[][] ans = new int[M][N];

        for(int i=0; i<M; i++) {
            for(int j=0; j<N; j++) {
                setAvg(img, M, N, i, j, ans);
            }
        }

        return ans;
    }


    private static void setAvg(int[][] img, int M, int N, int i, int j, int[][] ans) {
        int sum = img[i][j];
        int countCells = 1;

        for(int[] dir : dirs) {
            if(isSafe(M, N, i+dir[0], j+dir[1])) {
                sum += img[i+dir[0]][j+dir[1]];
                countCells++;
            }
        }

        ans[i][j] = sum/countCells;
    }

    private static boolean isSafe(int M, int N, int i, int j) {
        return i >= 0 &&
                j >= 0 &&
                i < M &&
                j < N;
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASE
        ArrayUtils.printArray(imageSmoother(new int[][] {{1,1,1},{1,0,1},{1,1,1}}));
    }

}
