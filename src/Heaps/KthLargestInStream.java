/**
 * Design a class to find the kth largest element in a stream.
 * Note that it is the kth largest element in the sorted order, not the kth distinct element.
 */
package Heaps;

import Sorting.KthLargest;

import java.util.PriorityQueue;

/**
 * @author gkabra
 * @since 19-02-2022 Sat
 **/

public class KthLargestInStream {

    PriorityQueue<Integer> min = new PriorityQueue<>();
    int k;

    // TC : O(logN) for offering once, O(N) for removing once and O(1) for size ~ almost O(NlogN) but less than O(N^^2)
    // SC : O(N)
    public KthLargestInStream(int k, int[] nums) {
        this.k = k;
        for(int num : nums) {
            min.add(num);
            if(min.size() > k) {
                min.remove();
            }
        }
    }

    public int add(int val) {
        min.add(val);
        if(min.size() > k) {
            min.remove();
        }
        return min.peek();
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASE
        KthLargestInStream kthLargestInStream = new KthLargestInStream(3, new int[] {4,5,8,2});
        System.out.println(kthLargestInStream.add(3));
        System.out.println(kthLargestInStream.add(5));
        System.out.println(kthLargestInStream.add(10));
        System.out.println(kthLargestInStream.add(9));
        System.out.println(kthLargestInStream.add(4));

    }

}
