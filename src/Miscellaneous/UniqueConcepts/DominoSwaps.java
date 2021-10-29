/**
 * Google
 * A domino is a tile with two numbers from 1 to 6 - one on each half of the tile.
 * In a row of dominoes, tops[i] and bottoms[i] represent the top and bottom halves of the ith domino.
 * We may rotate the ith domino, so that tops[i] and bottoms[i] swap values.
 * Return the minimum number of rotations so that all the values in tops are the same,
 * or all the values in bottoms are the same.
 * If it cannot be done, return -1.
 */
package Miscellaneous.UniqueConcepts;

/**
 * @author gaurav kabra
 * @since 29 Oct 2021
 **/

public class DominoSwaps {

    private static int minSwaps(int target, int[] A, int[] B) {
        int swaps = 0;
        for(int i=0; i<A.length; i++) {
            if(A[i] != target) {
                if(B[i] != target) {
                    return Integer.MAX_VALUE;
                }
                swaps++;
            }
        }
        return swaps;
    }

    /**
     * Logic:
     * First pick an index, say 0.
     * Then there are only 4 possibilities
     *      - All tops[] values become tops[0]
     *      - All tops[] values become bottoms[0]
     *      - All bottoms[] values become tops[0]
     *      - All bottoms[] values become bottoms[0]
     *
     * TC: O(N) since for  combinations, we run O(N) loop each time, so O(4*N) ~ O(N).
     * SC: O(1).
     *
     * Excellent video : https://tinyurl.com/dominos-swaps
     */
    private static int minDominoRotations(int[] tops, int[] bottoms) {
        // converting tops
        int ans = Math.min(
                minSwaps(tops[0], tops, bottoms),
                minSwaps(bottoms[0], tops, bottoms)
        );
        // converting bottoms
        ans = Math.min(
                ans,
                minSwaps(tops[0], bottoms, tops)
        );
        ans = Math.min(
                ans,
                minSwaps(bottoms[0], bottoms, tops)
        );

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASES
        System.out.println(minDominoRotations(
                new int[] {2,1,2,4,2,2},
                new int[] {5,2,6,2,3,2}
        ));
        System.out.println(minDominoRotations(
                new int[] {3,5,1,2,3},
                new int[] {3,6,3,3,4}
        ));
    }
}
