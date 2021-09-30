/**
 * Images in Digital Image Processing are grid of pixel intensities.
 * You are given an NxN 2D matrix representing an image, rotate the image, in-place, by 90 degrees (clockwise).*/
package Arrays;

import java.util.Arrays;

/**
 * @author gaurav kabra
 * @since 30 Sept 2021
 **/

public class RotateImage {
    private static void rotate(int[][] matrix) {

        int N = matrix.length;

        // Transpose -- diagonal as axis
        for(int i=0; i<N; i++) {
            for(int j=i; j<N; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // Reverse each row.
        // E.g. {1,2,3,4,5} -> {5,4,3,2,1} and {1,2,3,4} -> {4,3,2,1}
        for(int i=0; i<N; i++) {
            int[] arr = matrix[i];
            int start=0, end=arr.length-1;
            while(start < end) {
                int temp = arr[start];
                arr[start++] = arr[end];
                arr[end--] = temp;
            }
            matrix[i] = arr;
        }
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASE
        int[][] matrix = {
            {1,2,3,4},
            {5,6,7,8},
            {9,10,11,12},
            {13,14,15,16}
        };
        rotate(matrix);
        System.out.println(Arrays.deepToString(matrix));

    }
}
