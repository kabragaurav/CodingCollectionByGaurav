/**
 * An image is represented by an m x n integer grid image where image[i][j]
 * represents the pixel value of the image.
 * You are also given three integers sr, sc, and newColor.
 * You should perform a flood fill on the image starting from the pixel image[sr][sc].
 * To perform a flood fill, consider the starting pixel, plus any pixels connected
 * 4-directionally to the starting pixel of the same color as the starting pixel,
 * plus any pixels connected 4-directionally to those pixels (also with the same color),
 * and so on. Replace the color of all of the aforementioned pixels with newColor.
 * Return the modified image after performing the flood fill.
 */
package DepthFirstSearch;

import java.util.Arrays;

/**
 * @author gaurav kabra
 * @since 23 Nov 2021
 **/

public class FloodFill {

    private static int[][] dirs = {
            {-1,0},
            {0,-1},
            {1,0},
            {0,1}
    };

    private static boolean isSafe(int M, int N, int X, int Y) {
        return X>=0
                && Y>=0
                && X<M
                && Y<N;
    }

    private static void floodFillHelper(int[][] image, int val, int M, int N, int x, int y, int newColor) {
        for(int[] dir : dirs) {
            if(isSafe(M, N, x+dir[0], y+dir[1]) && image[x+dir[0]][y+dir[1]] == val) {
                image[x+dir[0]][y+dir[1]] = newColor;
                floodFillHelper(image, val, M, N, x+dir[0], y+dir[1], newColor);
            }
        }
    }

    // Simple DFS
    private static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        // If new color is same as original, just return image
        if(image[sr][sc] == newColor) {
            return image;
        }
        floodFillHelper(image, image[sr][sc], image.length, image[0].length, sr, sc, newColor);
        image[sr][sc] = newColor;
        return image;
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASES
        System.out.println(Arrays.deepToString(floodFill(
                new int[][]{
                        {1, 1, 1},
                        {1,1,0},
                        {1,0,1}
                }, 1, 1, 2
        )));

        System.out.println(Arrays.deepToString(floodFill(
                new int[][]{
                        {0,0,0},
                        {0,1,1}
                }, 1, 1, 1
        )));
    }
}
