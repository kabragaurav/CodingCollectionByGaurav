/**
 * You are given an n x n 2D matrix representing an image,
 * rotate the image by 90 degrees (clockwise) inplace.
 */
package Company.Amazon;

import java.util.Arrays;

/**
 * @author gkabra
 * @since 29-01-2022 Sat
 **/

public class RotateImage {

    private static void rotate(int[][] matrix) {
        int N = matrix.length;

        // Transpose -- left diagonal as axis
        for(int i=0; i<N; i++) {
            for(int j=i; j<N; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // Reverse each row
        for(int i=0; i<N; i++) {
            int[] arr = matrix[i];
            int start=0, end=arr.length-1;
            while(start <= end) {
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
        int[][] arr = new int[][] {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        rotate(arr);
        for(int[] x : arr) {
            for(int y : x) {
                System.out.print(y + " ");
            }
            System.out.println();
        }
    }

}
