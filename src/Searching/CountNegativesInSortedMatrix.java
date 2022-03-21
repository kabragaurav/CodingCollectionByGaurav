/**
 * Given a m x n matrix grid which is sorted in
 * non-increasing order both row-wise and column-wise, return the number of negative numbers in grid.
 */
package Searching;

/**
 * @author gauravkabra
 * @since 21/Mar/2022
 **/

public class CountNegativesInSortedMatrix {

    // TC : O(MlogN)
    // SC : O(1)
    private static int countNegatives(int[][] grid) {
        int M = grid.length;
        int N = grid[0].length;

        int count = 0;

        int lastRight = N-1;

        for (int i=0; i<M; i++) {
            if (grid[i][0] < 0) {
                count += N;
                continue;
            }
            if (grid[i][N-1] >= 0) {
                continue;
            }
            int left = 0;
            int right = lastRight;

            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (grid[i][mid] < 0) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            count += (N - left);
            lastRight = left;
        }

        return count;
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASE
        System.out.println(countNegatives(new int[][] {
                {8,-2,-2,-2,-4,-5,-5},
                {-2,-3,-3,-4,-4,-5,-5},
                {-2,-5,-5,-5,-5,-5,-5},
                {-3,-5,-5,-5,-5,-5,-5},
                {-5,-5,-5,-5,-5,-5,-5},
                {-5,-5,-5,-5,-5,-5,-5},
                {-5,-5,-5,-5,-5,-5,-5},
                {-5,-5,-5,-5,-5,-5,-5},
                {-5,-5,-5,-5,-5,-5,-5}}));
    }

}
