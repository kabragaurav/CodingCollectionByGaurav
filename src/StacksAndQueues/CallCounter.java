/**
 * Google
 * Create a class CallCounter that tracks the number of calls a client has made within the last 3 seconds.
 * Your class should contain one method, ping(int t) that receives the current timestamp (in milliseconds) of
 * a new call being made and returns the number of calls made within the last 3 seconds.
 * You may assume that the time associated with each subsequent call to ping is strictly increasing & positive.
 */
package StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author gaurav kabra
 * @since June 5, 2021
 */
public class CallCounter {
	
	// Maintain a doubly-ended queue(deque) to store incoming call timing (in msec)
	Deque<Integer> record;
	
	// Zero-parameter constructor to initialize the record object
	public CallCounter() {
		this.record = new ArrayDeque<Integer>();
	}
	
	private int ping(int t) {
		/**
		 * Logic:
		 * When a call is made and record deque is empty, that means no call made within 3000 msec (i.e. 3 sec) other than new call.
		 * So just add this call timing to record and return 1.
		 * Else if deque is not empty, then while the front element of record is older than new call by 3000 msec, keep removing front element.
		 * When removal is finished, add new call timing to record and return record size.
		 * Time Complexity : O(1) since t can range from 0 to 3000 only. So in the worst case we need only 3000 iterations to pop out all outdated elements
		 * Space Complexity : O(1) since t can range from 0 to 3000 only. So record of size 3000 is sufficient in worst case.
		 */
		if(record.isEmpty()) {
			record.addLast(t);
			return 1;
		}
		else {
			while(!record.isEmpty() && (t - record.getFirst()) > 3000) {
				record.removeFirst();
			}
			record.addLast(t);
			return record.size();
		}
	}
	
	// driver - main method
	public static void main(String[] args) {
		CallCounter cc = new CallCounter();
		
		// TESTCASES
		System.out.println(cc.ping(1));
		System.out.println(cc.ping(300));
		System.out.println(cc.ping(3000));
		System.out.println(cc.ping(3002));
		System.out.println(cc.ping(7000));
	}

}
