/**
 * Facebook
 * Given an array of unsorted, strictly positive (i.e. >0) integers, 
 * return the length of its longest strictly increasing subsequence (LIS).
 */
package DP.Others;

import java.util.Arrays;
import java.util.Collections;

/**
 * @author gaurav kabra
 * @since July 23, 2021
 */

public class LIS {
	
	private static int lengthOfLIS(int[] nums) {
		/**
		 * Time Complexity : O(N^2) since nested for loops with linear increase.
		 * Space Complexity : O(N) due to auxiliary countArray
		 */
		Integer[] lis = new Integer[nums.length];
		Arrays.fill(lis, 1);
		for(int i=0; i<nums.length; i++) {
			for(int j=0; j<i; j++) {
				if(nums[i] > nums[j] && lis[i] < lis[j]+1) {
					lis[i] = lis[j]+1;
				}
			}
		}
		return Collections.max(Arrays.asList(lis));
    }
	
	// driver - main method
	public static void main(String[] args) {
		// TESTCASES
		System.out.println(lengthOfLIS(new int[] {1, 9, 7, 4, 7, 13}));
		System.out.println(lengthOfLIS(new int[] {1, 1, 1, 1}));
	}
}
