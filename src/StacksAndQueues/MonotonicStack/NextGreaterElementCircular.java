/*
Given a circular integer array nums (i.e., the next element of nums[nums.length - 1] is nums[0]),
return the next greater number for every element in nums.

The next greater number of a number x is the first greater number to its traversing-order next in the array,
which means you could search circularly to find its next greater number.
If it doesn't exist, return -1 for this number.
 */
package StacksAndQueues.MonotonicStack;

import Arrays.Utils.ArrayUtils;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author gaurav kabra
 * @since 28/Mar/2022
 **/

public class NextGreaterElementCircular {
    /*
        Loop once, we can get the Next Greater Number of a normal array.
        Loop twice, we can get the Next Greater Number of a circular array

        TC : O(N)
        SC : O(N)
     */

    private static int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stk = new Stack<>();
        int N = nums.length;
        int[] ans = new int[N];
        Arrays.fill(ans, -1);

        for (int i=0; i<2*N; i++) {
            while (!stk.isEmpty() && nums[stk.peek()] < nums[i%N]) {
                ans[stk.pop()] = nums[i%N];
            }
            stk.push(i%N);
        }

        return ans;
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASE
        ArrayUtils.printArray(nextGreaterElements(new int[] {1,2,1}));
    }

}
