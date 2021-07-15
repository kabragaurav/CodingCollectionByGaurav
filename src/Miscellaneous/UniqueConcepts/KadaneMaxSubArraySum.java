/**
 * Given an integer array, find the contiguous subarray which has the largest sum and return its sum.
 * For more, see here: https://tinyurl.com/kadane
 */

package Miscellaneous.UniqueConcepts;

/**
 * @author gaurav kabra
 * @since June 19, 2021
 *
 */

public class KadaneMaxSubArraySum {
	
	private int greedyKadane(int[] arr) {
		/**
		 * Logic:
		 * global = our final answer (i.e. sum of maximum subarray)
		 * At each step of loop, we check which is bigger:
		 * current element + previous subarray OR current element as subarray
		 * Time Complexity: O(N) since we loop through the array once
		 * Space Complexity: O(1) since no extra space is needed
		 */
		if(arr.length == 0)
			return 0;
		int global = arr[0];
		int local = arr[0];
		
		for(int i=0; i<arr.length; i++) {
			local = Math.max(local + arr[i], arr[i]);
			global = Math.max(global, local);
		}
		return global;
	}
	
	private int dynamicKadane(int[] arr) {
		/**
		 * global = our final answer (i.e. sum of maximum subarray)
		 * local = sum of current subarray
		 * 
		 * Time Complexity: O(N) since we loop through the array once
		 * Space Complexity: O(1) since no extra space is needed
		 */
		if(arr.length == 0)
			return 0;
		int global = Integer.MIN_VALUE;
		int local = 0;
		
		for(int i=0; i<arr.length; i++) {
			local += arr[i];
			global = Math.max(global, local);
			
			if(local < 0) {
				local = 0;
			}
		}
		return global;
	}
	
	// driver - main method
	public static void main(String[] args) {
		
		KadaneMaxSubArraySum kmsas = new KadaneMaxSubArraySum();
		
		// TESTCASE
		int[] arr = new int[] {-6,3,-9,12,-14};
		System.out.println(kmsas.greedyKadane(arr));
		System.out.println(kmsas.dynamicKadane(arr));
	
	}

}
