/**
 * You are given row x col grid representing a map where grid[i][j] = 1
 * represents land and grid[i][j] = 0 represents water.
 * Grid cells are connected horizontally/vertically (not diagonally).
 * The grid is completely surrounded by water, and there is exactly one island
 * (i.e., one or more connected land cells).
 * The island doesn't have "lakes", meaning the water inside isn't connected to
 * the water around the island. One cell is a square with side length 1.
 * The grid is rectangular,
 * width and height don't exceed 100. Determine the perimeter of the island.
 */
package DepthFirstSearch;

/**
 * @author gaurav kabra
 * @since 01 Jan 2022
 **/

public class IslandPerimeter {

    private static int perimeter;

    // go in vertical and horizontal direction ny one unit
    private static int[][] dirs = {
            {-1,0},
            {0,1},
            {1,0},
            {0,-1}
    };

    // checks if cell coordinates lie inside rectangle
    private static boolean isSafe(int i, int j, int M, int N) {
        return i>=0 &&
                j>=0 &&
                i<M &&
                j<N;
    }

    private static int countWater(int[][] grid, int i, int j, int M, int N) {
        int water = 0;
        for(int[] dir : dirs) {
            // either at boundary OR inside AND has value 0
            if(!isSafe(i+dir[0], j+dir[1], M, N) || (isSafe(i+dir[0], j+dir[1], M, N) && grid[i+dir[0]][j+dir[1]] == 0)) {
                water++;
            }
        }
        return water;
    }


    private static void dfs(int[][] grid, int i, int j, int M, int N) {
        if(isSafe(i, j, M, N)) {
            if(grid[i][j] == 1) {
                grid[i][j] = -1;        // to avoid INF loop
                perimeter += countWater(grid, i, j, M, N);  // count zeroes adjacent to it
                for(int[] dir : dirs) {
                    dfs(grid, i+dir[0], j+dir[1], M, N);
                }
            }
        }
    }

    private static int islandPerimeter(int[][] grid) {
        perimeter = 0;      // reset since static
        int M = grid.length;
        int N = grid[0].length;
        // dfs on all cells
        for(int i=0; i<M; i++) {
            for(int j=0; j<N; j++) {
                dfs(grid, i, j, M, N);
            }
        }
        return perimeter;
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASES
        System.out.println(islandPerimeter(new int[][] {{0,1,0,0},{1,1,1,0},{0,1,0,0},{1,1,0,0}}));
        System.out.println(islandPerimeter(new int[][] {{1}}));
        System.out.println(islandPerimeter(new int[][] {{1,0}}));

    }
}
