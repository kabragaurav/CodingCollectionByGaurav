/**
 * Design an algorithm that collects daily price quotes for some stock and returns the span of that
 * stock's price for the current day.
 *
 * The span of the stock's price today is defined as the maximum number of consecutive days
 * (starting from today and going backward) for which the stock price was less than or equal
 * to today's price.
 */
package StacksAndQueues.MonotonicStack;

import java.util.Stack;

/**
 * @author gkabra
 * @since 19-02-2022 Sat
 **/

public class OnlineStockSpan {

    private static Stack<int[]> stk;
    private static int index;

    // TC : O(N)
    // SC : O(N)
    private static int next(int price) {
        int[] element = new int[] {index++, price};
        int ans;
        if(stk.isEmpty()) {
            ans = element[0] + 1;
        } else if (price < stk.peek()[1]) {
            ans = 1;
        } else {
            while(!stk.isEmpty() && price >= stk.peek()[1]) {
                stk.pop();
            }
            if(stk.isEmpty()) {
                ans = element[0] + 1;
            } else {
                ans = element[0] - stk.peek()[0];
            }
        }
        stk.push(element);
        return ans;
    }

    // driver - main method
    public static void main(String[] args) {
        index = 0;
        stk = new Stack<>();

        // TESTCASE
        System.out.println(next(90));
        System.out.println(next(21));
        System.out.println(next(21));
    }

}
