/**
 * Given an MxN matrix, return all elements of the matrix in clockwise spiral order.
 * -100 <= matrix[i][j] <= 100
 */
package Arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gaurav kabra
 * @since 4 Oct 2021
 *
 * Other very lucid solution @https://tinyurl.com/spiral-intuitive
 **/
public class SpiralTraversal {
    private static void getAdded(int[][] matrix, int i1, int i2, int j1, int j2, List<Integer> ls) {
        // We will set matrix' cells to -101 to indicate that we have visited the cell before
        // and hence won't include it again
        for(int y=j1; y<=j2; y++) {
            if(matrix[i1][y] != -101) {
                ls.add(matrix[i1][y]);
            }
            matrix[i1][y] = -101;
        }
        for(int x=i1+1; x<=i2; x++) {
            if(matrix[x][j2] != -101) {
                ls.add(matrix[x][j2]);
            }
            matrix[x][j2] = -101;
        }
        for(int y=j2-1; y>=j1; y--) {
            if(matrix[i2][y] != -101) {
                ls.add(matrix[i2][y]);
            }
            matrix[i2][y] = -101;
        }
        for(int x=i2-1; x>i1; x--) {
            if(matrix[x][j1] != -101) {
                ls.add(matrix[x][j1]);
            }
            matrix[x][j1] = -101;
        }
    }

    private static List<Integer> spiralOrder(int[][] matrix) {
        int M = matrix.length, N = matrix[0].length;
        int i1=0, i2 = M-1;
        int j1=0, j2=N-1;
        List<Integer> ls = new ArrayList<>();
        while(i1<=i2 && j1<=j2) {           // traverse layer by layer from outside to inside
            getAdded(matrix, i1, i2, j1, j2, ls);
            i1++; j1++;
            i2--; j2--;
        }
        return ls;
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASE
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        List<Integer> ans = spiralOrder(matrix);
        ans.stream().forEach(x -> System.out.print(x + " "));
    }
}
