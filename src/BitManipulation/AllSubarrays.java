/**
 * Print all subarrays of a given integer array.
 */
package BitManipulation;

/**
 * @author gaurav kabra
 * @since July 3, 2021
 */

import java.util.HashSet;
import java.util.Set;

public class AllSubarrays {
	
	private Set<String> getAllSubarrays(int[] arr) {
		/**
		 * Logic:
		 * Same as StringPermutations.java file
		 */
		
		int waysToChoose = 1 << (arr.length+1);
		Set<String> st = new HashSet<>();
		for(int i=0; i<waysToChoose; i++) {
			String temp = "{";
			
			for(int j=0; j<arr.length; j++) {
				if(((i >> j) & 1) == 1) {
					temp += arr[j];
				}
			}
			st.add(temp + "}");
		}
		return st;
	}

	// driver - main method
	public static void main(String[] args) {
		// TESTCASE
		System.out.println(new AllSubarrays().getAllSubarrays(new int[] {1,2,3}));
	}

}
