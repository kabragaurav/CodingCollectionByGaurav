/*
Goldman Sachs
We are given an array asteroids of integers representing asteroids in a row.

For each asteroid, the absolute value represents its size, and the sign represents its direction
(positive meaning right, negative meaning left). Each asteroid moves at the same speed.

Find out the state of the asteroids after all collisions. If two asteroids meet, the smaller one
will explode. If both are the same size, both will explode. Two asteroids moving in the same direction
will never meet.
 */
package StacksAndQueues;

import Arrays.Utils.ArrayUtils;

import java.util.Stack;

/**
 * @author gaurav kabra
 * @since 01/Apr/2022
 **/

public class AstroidCollision {

    // TC : O(N)
    // SC : O(N)
    private static int[] asteroidCollision(int[] ast) {

        Stack<Integer> stk = new Stack<>();
        int N = ast.length;

        for (int i=0; i<N; i++) {
            int a = ast[i];

            if (stk.isEmpty()) {
                stk.push(a);
                continue;
            }

            if (a < 0) {
                while (!stk.isEmpty() && stk.peek() > 0 && stk.peek() < Math.abs(a)) {
                    stk.pop();
                }
                if (!stk.isEmpty() && stk.peek() > 0 && stk.peek() == Math.abs(a)) {
                    stk.pop();
                    continue;
                }
                if (stk.isEmpty() || stk.peek() < 0) {
                    stk.push(a);
                }
            } else {
                stk.push(a);
            }
        }

        int sz = stk.size();
        int[] ans = new int[sz];
        for (int i=sz-1; i>=0; i--) {
            ans[i] = stk.pop();
        }
        return ans;
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASES
        ArrayUtils.printArray(asteroidCollision(new int[] {-2,-2,1,-1}));
        ArrayUtils.printArray(asteroidCollision(new int[] {-2,1,-1,-2}));
        ArrayUtils.printArray(asteroidCollision(new int[] {-2,-2,1,-2}));
    }

}
