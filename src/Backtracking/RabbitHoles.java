/**
 * Given an NxN (N<=5) grid containing only values 0 and 1, where 0 represents hole and
 * 1 represents rabbit, find a hole such that its distance to the nearest rabbit is maximized,
 * and return the distance. If no rabbit or hole exists in the grid, return -1.
 * The distance used in this problem is the Manhattan distance:
 * the distance between two cells (x0, y0) and (x1, y1) is |x0 - x1| + |y0 - y1|.
 */
package Backtracking;

public class RabbitHoles {
    private static final int[][] directions = {
            {-1, 0},
            {0, -1},
            {1, 0},
            {0, 1}
    };
    private static final int VERY_LARGE_INT = 1000000;

    private static boolean isSafe(int x, int y, int N) {
        return x < N &&
                y < N &&
                x >= 0 &&
                y >= 0;
    }

    private static int getMaxDistanceHelper(int[][] grid, int i, int j, int dist, int N) {
        // If value at (i.j) is -1 that means it is a loop. So return immediately.
        if(!isSafe(i, j, N) || grid[i][j] == -1) {
            return VERY_LARGE_INT;
        }
        // if we find a rabbit, return distance from hole
        if(grid[i][j] == 1) {
            return dist;
        }

        int minDist = Integer.MAX_VALUE;
        for(int[] direction : directions) {
            // We use backtracking, using value -1 in-between to detect loop and hence break out of them
            int temp = grid[i][j];
            grid[i][j] = -1;
            minDist = Math.min(minDist, getMaxDistanceHelper(grid, i+direction[0], j+direction[1], dist+1, N));
            grid[i][j] = temp;
        }
        return minDist;
    }

    private static int maxDistance(int[][] grid) {
        int maxDist = -1;
        int N = grid.length;
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(grid[i][j] == 0) {
                    maxDist = Math.max(maxDist, getMaxDistanceHelper(grid, i, j, 0, N));
                }
            }
        }
        return maxDist == VERY_LARGE_INT ? -1 : maxDist;
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASES
        System.out.println(maxDistance(new int[][] {
                {1,0},
                {0,0}
        }));
        System.out.println(maxDistance(new int[][] {
                {1,0,1},
                {0,0,0},
                {1,0,1}
        }));
        System.out.println(maxDistance(new int[][] {
                {1,0,0},
                {0,0,0},
                {0,0,0}
        }));
        System.out.println(maxDistance(new int[][] {
                {0,0,0},
                {0,0,0},
                {0,0,0}
        }));
    }
}
