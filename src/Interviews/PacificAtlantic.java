/**
 * Google, Amazon
 * There is an m x n rectangular island that borders both the Pacific Ocean and Atlantic Ocean.
 * The Pacific Ocean touches the island's left and top edges, and the Atlantic Ocean touches the
 * island's right and bottom edges.
 *
 * The island is partitioned into a grid of square cells. You are given an m x n integer matrix
 * heights where heights[r][c] represents the height above sea level of the cell at coordinate (r, c).
 *
 * The island receives a lot of rain, and the rain water can flow to neighboring cells directly
 * north, south, east, and west if the neighboring cell's height is less than or equal to the
 * current cell's height. Water can flow from any cell adjacent to an ocean into the ocean.
 *
 * Return a 2D list of grid coordinates result where result[i] = [ri, ci] denotes that rain water
 * can flow from cell (ri, ci) to both the Pacific and Atlantic oceans.
 */
package Interviews;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

/**
 * @author gkabra
 * @since 05-03-2022 Sat
 **/

public class PacificAtlantic {

    private static int[][] dirs = new int[][] {
            {-1,0},
            {0,1},
            {1,0},
            {0,-1}
    };

    // driver - main method
    public static void main(String[] args) {
        // TESTCASE
        pacificAtlantic(new int[][] {{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}})
                .stream()
                .forEach(ls -> ls.stream()
                        .forEach(x -> System.out.print(x + " "))
                );
    }

    // Great explanation here: https://tinyurl.com/pacific-atlantic (Move from edges towards inside)
    // TC : O(N^2)
    // SC : O(N^2)
    private static List<List<Integer>> pacificAtlantic(int[][] heights) {

        List<List<Integer>> ans = new ArrayList<>();
        int M = heights.length;
        int N = heights[0].length;

        if(heights == null || M == 0 || N == 0) {
            return ans;
        }

        // track if the ocean can be visited from each (i,j)
        boolean[][] pacific = new boolean[M][N];
        boolean[][] atlantic = new boolean[M][N];

        for(int i=0; i<M; i++) {
            dfs(heights, i, 0, M, N, Integer.MIN_VALUE, pacific);
            dfs(heights, i, N-1, M, N, Integer.MIN_VALUE, atlantic);
        }

        for(int j=0; j<N; j++) {
            dfs(heights, 0, j, M, N, Integer.MIN_VALUE, pacific);
            dfs(heights, M-1, j, M, N, Integer.MIN_VALUE, atlantic);
        }

        for(int i=0; i<M; i++) {
            for(int j=0; j<N; j++) {
                if(pacific[i][j] && atlantic[i][j]) {
                    ans.add(Arrays.asList(i,j));
                }
            }
        }
        return ans;
    }


    private static void dfs(int[][] heights, int i, int j, int M, int N, int prev, boolean[][] visited) {
        if(i < 0 || j < 0 || i >= M || j >= N
                || heights[i][j] < prev || visited[i][j]) {
            return;
        }

        visited[i][j] = true;

        for(int[] dir : dirs) {
            dfs(heights, i+dir[0], j+dir[1], M, N, heights[i][j], visited);
        }
    }

}
