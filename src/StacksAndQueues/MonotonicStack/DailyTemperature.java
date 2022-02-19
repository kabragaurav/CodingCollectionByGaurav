/**
 * Given an array of integers temperatures represents the daily temperatures,
 * return an array answer such that answer[i] is the number of days you have to
 * wait after the ith day to get a warmer temperature.
 * If there is no future day for which this is possible, keep answer[i] == 0 instead.
 */
package StacksAndQueues.MonotonicStack;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author gkabra
 * @since 19-02-2022 Sat
 **/

public class DailyTemperature {

    // TC : O(N)
    // SC : O(N)
    private static int[] dailyTemperatures(int[] temperatures) {
        Stack<int[]> stk = new Stack<>();
        int index = 0;
        int[] ret = new int[temperatures.length];

        for(int temperature : temperatures) {
            int[] element = new int[] {index++, temperature};
            if(stk.isEmpty()) {
                stk.push(element);
            } else if (stk.peek()[1] <= temperature) {
                while(!stk.isEmpty() && stk.peek()[1] < temperature) {
                    int prevIndex = stk.pop()[0];
                    ret[prevIndex] = element[0] - prevIndex;
                }
                stk.push(element);
            } else {
                stk.push(element);
            }
        }
        return ret;
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASE
        int[] ans = dailyTemperatures(new int[] {73,74,75,71,69,72,76,73});
        Arrays.stream(ans)
                .forEach(x -> System.out.println(x));
    }

}
