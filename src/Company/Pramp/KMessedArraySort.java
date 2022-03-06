/**
 * Given an array of integers arr where each element is at most k places away from
 * its sorted position, code an efficient function sortKMessedArray that sorts arr.
 * For instance, for an input array of size 10 and k = 2, an element belonging to
 * index 6 in the sorted array will be located at either index 4, 5, 6, 7 or 8 in the input array.
 */
package Company.Pramp;

import java.util.PriorityQueue;
import java.util.Arrays;

/**
 * @author gkabra
 * @since 06-03-2022 Sun
 **/

import java.util.PriorityQueue;

public class KMessedArraySort {

    // TC : O(Nlogk)
    // SC : O(k)
    static int[] sortKMessedArray(int[] arr, int k) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int N = arr.length;

        for(int i=0; i<=k; i++) {
            pq.add(arr[i]);
        }

        for(int i=k+1; i<N; i++) {
            arr[i-k-1] = pq.poll();
            pq.add(arr[i]);
        }

        for(int i=0; i<=k; i++) {
            arr[N-k-1+i] = pq.poll();
        }

        return arr;
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASES
        System.out.println(Arrays.toString(sortKMessedArray(new int[] {1, 4, 5, 2, 3, 7, 8, 6, 10, 9}, 2)));
    }

}
