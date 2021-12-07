/**
 * Given an m x n matrix of distinct numbers, return all numbers that are the minimum element in their row and
 * maximum in their column.
 */
package Arrays;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author gaurav kabra
 * @since 7 Dec 2021
 **/

public class MinInRowMaxInCol {

    /**
     * Logic:
     * We know that elements are distinct.
     * We will leverage this point by looping over matrix and find for each row the minimum and for each column the maximum.
     * Now we will check their intersection and return the result, since it will have number that are both min in row and max in col.
     *
     * TC: O(N^2) due to nested for loops
     * SC: O(N) as we will store total of 2N numbers (N for rows having min values, N for cols having max values)
     */
    private static List<Integer> getMinMax(int[][] matrix) {
        Set<Integer> rowMins = new HashSet<>();
        Set<Integer> colMaxs = new HashSet<>();
        int m = matrix.length;
        int n = matrix[0].length;

        for(int i=0; i<m; i++) {
            int min = Integer.MAX_VALUE;
            for(int j=0; j<n; j++) {
                if(matrix[i][j] < min) {
                    min = matrix[i][j];
                }
            }
            rowMins.add(min);
        }

        for(int j=0; j<n; j++) {
            int max = Integer.MIN_VALUE;
            for(int i=0; i<m; i++) {
                if(matrix[i][j] > max) {
                    max = matrix[i][j];
                }
            }
            colMaxs.add(max);
        }

        rowMins.retainAll(colMaxs);
        return rowMins.stream().collect(Collectors.toList());
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASE
        getMinMax(new int[][]{
                {1,10,4,2},
                {9,3,8,7},
                {15,16,17,12}
        }).stream().forEach(x -> System.out.println(x));
    }
}
