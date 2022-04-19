/**
 * Google
 * Given an array of integers, return whether or not two numbers sum to a given target, k.
 * Note: you may not sum a number with itself.
 */
package Map;

import java.util.HashSet;
import java.util.Set;

/**
 * @author gaurav kabra
 * @since May 21, 2021
 */
public class TwoSum {
	
	/**
	 * @param arr, the array of integers
	 * @param k, the sum
	 * @return boolean, if two numbers, at separate indices, add up to k
	 */
	private boolean canSumToK(int[] arr, int k) {
		/**
		 * Logic:
		 * We find diff that is difference between k and current element
		 * If this diff is there in set, that we maintain, then we found the pair and return true
		 * Else we just add the current element to set
		 */
		if(arr == null || arr.length < 2)
			return false;
		
		Set<Integer> st = new HashSet<>();
		
		for(int i=0; i<arr.length; i++) {
			int diff = k-arr[i];
			if(st.contains(diff))
				return true;   // pair is < arr[i], diff >
			else
				st.add(arr[i]);
		}
		
		// if we reach here, that means we found no pair. Return false
		return false;
	}
	
	// driver - main method
	public static void main(String[] args) {
		
		TwoSum ts = new TwoSum();
		
		// TESTCASES
		int[] arr = {1, 3, 8, 2};
		System.out.println(ts.canSumToK(arr, 10));
		
		arr = new int[]{3, 9, 13, 7};
		System.out.println(ts.canSumToK(arr, 8));
		
		arr = new int[]{4, 2, 6, 5, 2};
		System.out.println(ts.canSumToK(arr, 4));
		
	}

}

/**
 * Time: O(N) since we iterate array once linearly
 * Space: O(N) since we use hashset and in worstcase all integers in array are different and don't add to the sum, k
 */
