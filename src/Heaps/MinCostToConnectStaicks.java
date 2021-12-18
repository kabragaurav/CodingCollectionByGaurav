/**
 * All sticks have positive integer lengths.
 * At a time pick two sticks to convert them to a new stick of length as sum of these two.
 * The cost will be the length of new stick.
 * repeat this till you have only one stick.
 *
 * Return minimum total cost of doing so.
 */
package Heaps;

import java.util.PriorityQueue;

/**
 * @author gaurav kabra
 * @since 18 Dec 2021
 **/

public class MinCostToConnectStaicks {

    // insert : O(logN)
    // delete : O(logN)
    // min : O(1)
    private static int connectSticks(int[] sticks) {

        /**
         * Logic:
         * For the overall cost to be minimum, every time we combine two sticks, they should be smallest two among all available sticks.
         * For this we use min heap.
         *
         * TC : O(logN) for one insertion. For N insertions, O(NlogN)
         * SC : O(N) as min heap max size is N
         */
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int stick : sticks) {
            minHeap.add(stick);
        }
        int cost = 0;
        int newLen = 0;

        while(minHeap.size() > 1) {
            newLen = minHeap.poll() + minHeap.poll();
            cost += newLen;
            minHeap.add(newLen);
        }
        return cost;
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASES
        System.out.println(connectSticks(new int[] {2,4,3}));
        System.out.println(connectSticks(new int[] {1,8,3,5}));
    }
}
