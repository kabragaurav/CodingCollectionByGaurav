/**
 * You are given an n x n binary matrix grid where 1 represents land and 0 represents water.
 * An island is a 4-directionally connected group of 1's not connected to any other 1's.
 * There are exactly two islands in grid.
 * You may change 0's to 1's to connect the two islands to form one island.
 * Return the smallest number of 0's you must flip to connect the two islands.
 */
package BreadthFirstSearch;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @author gkabra
 * @since 15-03-2022 Tue
 **/

public class ShortestBridgeIslands {

    private static int[][] dirs = new int[][] {
            {-1,0},
            {0,1},
            {1,0},
            {0,-1}
    };

    private static int shortestBridge(int[][] grid) {
        int M = grid.length;
        int N = grid[0].length;

        boolean[][] isVisited = new boolean[M][N];

        List<int[]> oneIslandAllCoords = new ArrayList<>();
        Queue<int[]> queue = new ArrayDeque<>();

        // first collect all coords of any one island
        for (int i=0; i<M; i++) {
            boolean isSomeIslandColored = false;
            for (int j=0; j<N; j++) {
                if(grid[i][j] == 1 && !isVisited[i][j]) {
                    queue.add(new int[] {i, j});
                    isVisited[i][j] = true;
                    List<int[]> ls = new ArrayList<>();
                    oneIslandAllCoords.add(new int[] {i, j});
                }
                while(!queue.isEmpty()) {
                    int[] front = queue.poll();
                    for(int[] dir : dirs) {
                        int ii = front[0] + dir[0];
                        int jj = front[1] + dir[1];
                        if (isSafe(isVisited, ii, jj, M, N)) {
                            if(grid[ii][jj] != 1) {
                                continue;
                            }
                            queue.add(new int[] {ii, jj});
                            isVisited[ii][jj] = true;
                            oneIslandAllCoords.add(new int[] {ii, jj});
                        }
                    }
                }
                if(oneIslandAllCoords.size() > 0) {
                    isSomeIslandColored = true;
                    break;
                }
            }
            if (isSomeIslandColored) {
                break;
            }
        }


        // Now we will try to reach other island using above island
        // So first enqueue the coords of current island
        for(int[] arr : oneIslandAllCoords) {
            queue.add(arr);
        }

        int steps = 0;

        while(!queue.isEmpty()) {
            int sz = queue.size();
            // Increase the boundary of current island by 1 unit in each possible direction by 1 unit
            // For Visualization : https://tinyurl.com/shortest-bridge
            for(int i=0; i<sz; i++) {
                int[] island = queue.poll();
                for(int[] dir : dirs) {
                    int ii = island[0] + dir[0];
                    int jj = island[1] + dir[1];
                    if(isSafe(isVisited, ii, jj, M, N)) {
                        if(grid[ii][jj] == 1) {
                            return steps;
                        }
                        isVisited[ii][jj] = true;
                        queue.add(new int[] {ii, jj});
                    }
                }
            }
            steps++;
        }

        return steps;
    }

    private static boolean isSafe(boolean[][] isVisited, int i, int j, int M, int N) {
        return i >= 0 &&
                j >= 0 &&
                i < M &&
                j < N &&
                !isVisited[i][j];
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASE
        System.out.println(shortestBridge(new int[][] {{1,1,1,1,1},{1,0,0,0,1},{1,0,1,0,1},{1,0,0,0,1},{1,1,1,1,1}}));
    }

}
