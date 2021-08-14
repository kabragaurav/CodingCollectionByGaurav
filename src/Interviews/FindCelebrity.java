/**
 * DE Shaw
 * A celebrity is a person who is known to all but does not know anyone at a party.
 * Find if there is a celebrity in the party or not.
 * A square NxN matrix M[][] is used to represent people at the party such that if an element of
 * row i and column j  is set to 1 it means ith person knows jth person. Here M[i][i] will always be 1 since a person always knows herself.
 * Follow 0 based indexing while answering.
 * Expected time complexity is O(N).
 */
package Interviews;

/**
 * @author gaurav kabra
 * @since 14 August 2021
 */

public class FindCelebrity {
    private static int celebrity(int M[][]) {
        /**
         * Logic:
         * We use a 2-pointer approach. Assume the persons are standing in a line.
         * i=start index and j=last index
         * We first find candidate for celebrity and then verify it
         *
         * Time Complexity: O(N)
         * Space Complexity: O(1) No extra space is required.
         */
        int N = M.length, i = 0, j = N-1;
        while(i < j) {
            if(M[j][i] == 1) {      // j knows i, so decrease j so next iteration will check for [j-1][i]
                j--;
            } else {                // increase i since i cannot be celebrity (since j does not know i). Next iteration will check for [j][i+1]
                i++;
            }
        }

        int candidate = i;
        for(i=0; i<N; i++) {
            // i must now be candidate and everyone must know i but i must know nobody.
            if(i != candidate && (M[i][candidate] == 0 || M[candidate][i] == 1)) {
                return -1;
            }
        }
        return candidate;
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASES
        System.out.println(celebrity(new int[][] {
                {1,1,0},
                {0,1,0},
                {0,1,1}
        }));
        System.out.println(celebrity(new int[][] {
                {1,1,1},
                {1,1,1},
                {1,1,1}
        }));
    }
}
