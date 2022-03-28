/*
Given the array prices where prices[i] is the price of the ith item in a shop.
There is a special discount for items in the shop, if you buy the ith item, then you will receive a discount
equivalent to prices[j] where j is the minimum index such that j > i and prices[j] <= prices[i],
otherwise, you will not receive any discount at all.

Return an array where the ith element is the final price you will pay for the ith item of the shop considering
the special discount.
 */
package StacksAndQueues.MonotonicStack;

import Arrays.Utils.ArrayUtils;

import java.util.Stack;

/**
 * @author gaurav kabra
 * @since 28/Mar/2022
 **/

public class FinalPricesAfterDiscount {

    // TC : O(N)
    // SC : O(N)
    private static int[] finalPrices(int[] prices) {
        Stack<Integer> stk = new Stack<>();

        for (int i=0; i<prices.length; i++) {
            while (!stk.isEmpty() && prices[stk.peek()] >= prices[i]) {
                prices[stk.pop()] -= prices[i];
            }
            stk.push(i);
        }

        return prices;
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASE
        ArrayUtils.printArray(finalPrices(new int[] {8,4,6,2,3}));
    }

}
