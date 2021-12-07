/**
 * You are given an array of n pairs pairs where pairs[i] = [lefti, righti] and lefti < righti.
 * A pair p2 = [c, d] follows a pair p1 = [a, b] if b < c. A chain of pairs can be formed in this fashion.
 * Return the length longest chain which can be formed.
 * You do not need to use up all the given intervals. You can select pairs in any order.
 */
package Sorting;

/**
 * @author gaurav kabra
 * @since 7 Dec 2021
 **/

import java.util.Arrays;

public class MaxPairChain {

    /**
     * TC: O(NlogN) due to sorting
     * SC : O(1)
     */
    private static int findLongestChain(int[][] pairs) {
        // Choosing the next addition to be the one with the lowest second coordinate
        // is at least better than a choice with a larger second coordinate.
        // So, consider the pairs in increasing order of their second coordinate.
        Arrays.sort(pairs, (a, b) -> Integer.compare(a[1], b[1]));

        int secondCoord = Integer.MIN_VALUE;
        int ans = 0;

        for(int[] pair : pairs) {
            if(secondCoord < pair[0]) {
                ans++;
                secondCoord = pair[1];
            }
        }
        return ans;
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASES
        System.out.println(findLongestChain(new int[][]{
                {-10,-8},
                {8,9},
                {-5,0},
                {6,10},
                {-6,-4},
                {1,7},
                {9,10},
                {-4,7}
        }));
        System.out.println(findLongestChain(new int[][]{
                {3,4},
                {2,3},
                {1,2}
        }));
    }
}
