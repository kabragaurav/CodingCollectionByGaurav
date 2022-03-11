/**
 * You are given an m x n binary matrix mat of 1's (representing soldiers) and 0's
 * (representing civilians). The soldiers are positioned in front of the civilians.
 * That is, all the 1's will appear to the left of all the 0's in each row.
 *
 * A row i is weaker than a row j if one of the following is true:
 *
 *     The number of soldiers in row i is less than the number of soldiers in row j.
 *     Both rows have the same number of soldiers and i < j.
 *
 * Return the indices of the k weakest rows in the matrix ordered from weakest to strongest.
 */
package Sorting;

import Arrays.Utils.ArrayUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

/**
 * @author gkabra
 * @since 11-03-2022 Fri
 **/

public class KWeakestRows {

    private static class Pair {
        int index;
        int sum;

        Pair(int index, int sum) {
            this.index = index;
            this.sum = sum;
        }
    }

    /*
        TC : Sum for each row O(M*N)
             Sort as per sum : O(MlogM), since M sums are there

             Overall, O(M*(N+logM))
        SC : O(k) for final answer
             O(M) for storing sums

             Overall, O(M+k)
     */
    private static int[] kWeakestRows(int[][] mat, int k) {
        List<Pair> ls = new ArrayList<>();

        for(int i=0; i<mat.length; i++) {
            int sum = IntStream.of(mat[i]).sum();
            Pair ele = new Pair(i, sum);
            ls.add(ele);
        }

        Collections.sort(ls, (a, b) -> a.sum == b.sum ? a.index-b.index : a.sum-b.sum);

        List<Integer> ans = new ArrayList<>();

        ls.stream()
                .limit(k)
                .forEach(x -> {
                    ans.add(x.index);
                });

        return ans.stream()
                .mapToInt(i->i)
                .toArray();

    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASE
        ArrayUtils.printArray(kWeakestRows(new int[][] {{1,1,0,0,0},
                {1,1,1,1,0},
                {1,0,0,0,0},
                {1,1,0,0,0},
                {1,1,1,1,1}}, 3));
    }

}
