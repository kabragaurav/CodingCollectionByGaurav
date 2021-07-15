/**
 * Salesforce
 * Given that integers are being read from a data stream, say a file. 
 * Find the median of all the elements read so far at each read.
 */
package Miscellaneous.UniqueConcepts;

/**
 * @author gaurav kabra
 * @since June 18, 2021
 */

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianInStream {
	
	private PriorityQueue<Integer> minHeap, maxHeap;
	
	public MedianInStream() {
		// By default, the priority queue in Java is min heap. 
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    }
    
    public void addNum(int num) {
    	/**
    	 * Adds the number, num to one of heap
    	 * 
    	 * Logic:
    	 * We start with maxHeap. If it is empty or num is less than top then we insert num in maxHeap
    	 * Else we insert num to minHeap.
    	 * Once insertion is done, we want that the difference in size of maxHeap and minHeap should be <=1
    	 * So we check if anyone is bigger than other by >1
    	 * If so, we just remove top element from bigger heap and insert into smaller heap
    	 * 
    	 * Time Complexity : O(1) for a number
    	 * Space Complexity : O(N) since we store all numbers so far in heaps
    	 */
        if(maxHeap.isEmpty() || maxHeap.peek() > num) {
            maxHeap.offer(num);
        }
        else {
            minHeap.offer(num);
        }
        if(maxHeap.size() - minHeap.size() > 1) {
            minHeap.offer(maxHeap.poll());
        }
        else if(minHeap.size() - maxHeap.size() > 1) {
            maxHeap.offer(minHeap.poll());
        }
    }
    
    public double findMedian() {
    	/**
    	 * Logic:
    	 * If size of both heaps is same, then we return average of their top elements.
    	 * Else return top element of bigger heap without removing it.
    	 * 
    	 * Time Complexity : O(1)
    	 * Space Complexity : O(N) since we store all numbers so far in heaps
    	 */
        int minSz = minHeap.size();
        int maxSz = maxHeap.size();
        
        if(minSz == maxSz) {
            return (minHeap.peek() + maxHeap.peek())/2.0;
        }
        else if(maxSz > minSz) {
            return maxHeap.peek();
        }
        return minHeap.peek();
    }
    
    // driver - main method
	public static void main(String[] args) {
		MedianInStream mis = new MedianInStream();
		
		// TESTCASE
		mis.addNum(1);
		mis.addNum(2);
		System.out.println(mis.findMedian());
		mis.addNum(3);
		System.out.println(mis.findMedian());
	}

}
