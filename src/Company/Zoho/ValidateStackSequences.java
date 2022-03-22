/*
    Zoho SDE-1
    Given two integer arrays pushed and popped each with distinct values, return true if this could
    have been the result of a sequence of push and pop operations on an initially empty stack,
    or false otherwise.
 */
package Company.Zoho;

import java.util.Stack;

/**
 * @author gauravkabra
 * @since 22/Mar/2022
 **/

public class ValidateStackSequences {

    // TC : O(N)
    // SC : O(N)
    // This works because values are distinct
    private static boolean validateStackSequences(int[] pushed, int[] popped) {

        Stack<Integer> stk = new Stack<>();
        int pointer = 0;
        int N = pushed.length;

        if (N != popped.length) {
            return false;
        }

        for (int i=0; i<N; i++) {
            stk.push(pushed[i]);
            while (!stk.isEmpty() && popped[pointer] == stk.peek()) {
                stk.pop();
                pointer++;
                if (pointer == N) {
                    break;
                }
            }
        }

        return stk.isEmpty() && pointer == N;
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASES
        System.out.println(validateStackSequences(new int[] {1,2,3,4,5}, new int[] {4,5,3,2,1}));
        System.out.println(validateStackSequences(new int[] {1,0}, new int[] {1,0}));
    }

}
