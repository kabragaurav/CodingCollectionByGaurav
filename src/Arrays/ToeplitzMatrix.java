/**
 * Given an m x n matrix,
 * return true if the matrix is Toeplitz. Otherwise, return false.
 * A matrix is Toeplitz if every diagonal from top-left to bottom-right has the
 * same elements.
 */
package Arrays;

/**
 * @author gkabra
 * @since 11-02-2022 Fri
 **/

public class ToeplitzMatrix {

    private static boolean isSafe(int i, int j, int M, int N) {
        return i<M && j<N;
    }

    /**
     * Logic:
     * Draw a dia, you will see in each diagonal row and col values increase by 1
     * We just have to start for first row and first col.
     *
     * TC : O(M*N) since overall we will iterate M*N numbers
     * SC : O(1)
     */
    private static boolean isToeplitzMatrix(int[][] matrix) {
        int M = matrix.length;
        int N = matrix[0].length;

        for(int row=0; row<M; row++) {
            int j = 0;
            int r = row;
            int num = matrix[r][j];
            while(true) {
                if(!isSafe(r, j, M, N)) {
                    break;
                }
                if(matrix[r][j] != num) {
                    return false;
                }
                j++;
                r++;
            }
        }

        for(int col=1; col<N; col++) {
            int i = 0;
            int c = col;
            int num = matrix[i][c];
            while(true) {
                if(!isSafe(i, c, M, N)) {
                    break;
                }
                if(matrix[i][c] != num) {
                    return false;
                }
                i++;
                c++;
            }
        }

        return true;
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASE
        System.out.println(isToeplitzMatrix(new int[][] {
                {1,2,3,4},
                {5,1,2,3},
                {9,5,1,2}
        }));
    }

}
