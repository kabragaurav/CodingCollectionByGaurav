/*
There are n gas stations along a circular route, where the amount of gas at the ith station is gas[i].

You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from the ith station to
its next (i + 1)th station. You begin the journey with an empty tank at one of the gas stations.

Given two integer arrays gas and cost, return the starting gas station's index if you can travel around the
circuit once in the clockwise direction, otherwise return -1. If there exists a solution, it is guaranteed to
be unique
 */
package GreedyAndTwoPointer;

/**
 * @author gaurav kabra
 * @since 19/Apr/2022
 **/

public class GasStation {

    // TC : O(N)
    // SC : O(1)
    private static int canCompleteCircuit(int[] gas, int[] cost) {
        int ans = 0;
        int sum = 0;
        int total = 0;
        int N = gas.length;

        for (int i=0; i<N; i++) {
            sum += (gas[i] - cost[i]);

            if (sum < 0) {
                total += sum;
                sum = 0;
                ans = i+1;
            }
        }

        total += sum;

        return total >= 0 ? ans : -1;

    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASE(S)
    }

}
