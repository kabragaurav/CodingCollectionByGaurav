/**
 * You are given a list of values and a list of labels. The ith element in labels represents the label of the ith element.
 * Similarly, the ith element in values represents the value associated with the ith element
 * (i.e. together, an “item” could be thought of as a label and a price).
 * Given a list of values, a list of labels, a limit, and wanted, return the sum of the most expensive items
 * you can group such that the total number of items used is less than wanted and the number of any given label
 * that is used is less than limit.
 */
package GreedyAndTwoPointer;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author gaurav kabra
 * @since 23 Oct 2021
 **/

public class LargestSumFromLabels {

    private static  int largestValsFromLabels(int[] values, int[] labels, int numWanted, int useLimit) {
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);        // max priority queue
        Map<Integer, Integer> mp = new HashMap<>();                          // to keep track on number of occurrences of labels
        int N = values.length;
        for(int i=0;i<N;i++) {
            pq.offer(new int[]{values[i], labels[i]});                       // sort as per highest values
        }
        int times = 0;
        int sum = 0;
        while(!pq.isEmpty() && times < numWanted) {
            int[] pair = pq.poll();                                          // get the highest value in pq
            int count  = mp.getOrDefault(pair[1], 0);
            if(count < useLimit){                                            // check if the count of this specific label is within the limit
                times++;                                                     // increment the times which we considered the label to be added
                sum = sum + pair[0];
            }
            mp.put(pair[1], count+1);                                        // increment the counter
        }
        return sum;
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASES
        System.out.println(largestValsFromLabels(new int[] {4,6,3,9,2}, new int[] {2,0,0,0,2}, 5, 2));
        System.out.println(largestValsFromLabels(new int[] {9,9,4,0,2,4}, new int[] {0,2,0,0,0,2}, 5, 2));
        System.out.println(largestValsFromLabels(new int[] {2,6,3,6,5}, new int[] {1,1,2,1,1}, 3, 1));
    }
}
