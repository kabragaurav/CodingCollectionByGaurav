/**
 * Given an n x n matrix where each of the rows and columns is sorted in ascending order,
 * return the kth smallest element in the matrix.
 * Note that it is the kth smallest element in the sorted order, not the kth distinct element.
 */
package Heaps;

import java.util.PriorityQueue;
import java.util.Arrays;

/**
 * @author gkabra
 * @since 12-02-2022 Sat
 **/

public class KthSmallestInSortedMatrix {

    /**
     * TC :
     *  offer() is O(logN)
     *  poll() is O(logN)
     *  So, total is O(log(M*N)) + O(k*log(M*N)) = k*O(logMN)
     *
     * SC : O(M*N)
     */
    private static int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        /*
            add() comes from Collection.
            offer() comes from Queue.
            add() always returns true and throws an exception if it can't add the element
            offer() returns false if it can't add the element.

            For PriorityQueue, the two functions are synonymous.
         */
        Arrays.stream(matrix)
                .flatMapToInt(x -> Arrays.stream(x))
                .forEach(a -> pq.offer(a));


        for(int i=0; i<k-1; i++) {
            pq.poll();
        }
        return pq.poll();
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASE
        System.out.println(kthSmallest(new int[][] {
                {1,2},
                {1,3}
        }, 2));
    }

}
