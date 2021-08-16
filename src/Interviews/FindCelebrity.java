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

import java.util.Stack;

/**
 * @author gaurav kabra
 * @since 14 August 2021
 */

public class FindCelebrity {
    private static int celebrity(int[][] M) {
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
            // i must not be candidate and everyone must know i but i must know nobody.
            if(i != candidate && (M[i][candidate] == 0 || M[candidate][i] == 1)) {
                return -1;
            }
        }
        return candidate;
    }

    private static int celebrityUsingStack(int[][] M) {
        /**
         * Logic:
         * We put each person in stack (i.e. 0 to N-1)
         * While size of stack > 1
         *      pop top two persons and based on condition of being celebrity put back one of them if she satisfies the condition.
         * Now size of stack is can be 1 or 0 (i.e. empty).
         * In case size is 1, the top of stack is the candidate.
         * Verify using for loop, if candidate is really the celebrity.
         *
         * Time Complexity : O(N) due to comparisons after popping
         * Space Complexity : O(N) due to stack.
         */
        Stack<Integer> stk = new Stack<>();
        int N = M.length;
        for(int i=0; i<N; i++) {
            stk.push(i);
        }
        while(stk.size() > 1) {
            int top = stk.pop();
            int secondTop = stk.pop();
            // find which one can be celebrity
            if(M[top][secondTop] == 1 && M[secondTop][top] == 0) {
                stk.push(secondTop);
            } else if(M[secondTop][top] == 1 && M[top][secondTop] == 0) {
                stk.push(top);
            }
        }
        int top = -1;
        if(stk.size() == 1) {
            top = stk.pop();
            for(int i=0; i<N; i++) {
                if(i != top && (M[i][top] == 0 || M[top][i] == 1)) {
                    return -1;
                }
            }
        }
        return top;
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

        System.out.println(celebrityUsingStack(new int[][] {
                {1,1,0},
                {0,1,0},
                {0,1,1}
        }));
        System.out.println(celebrityUsingStack(new int[][] {
                {1,1,1},
                {1,1,1},
                {1,1,1}
        }));
        System.out.println(celebrityUsingStack(new int[][] {
                {0,1,1,0},
                {0,0,0,1},
                {1,1,0,1},
                {1,1,1,0}
        }));
    }
}
