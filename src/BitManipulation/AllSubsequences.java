/**
 * Print all subsequences of a given string.
 */
package BitManipulation;

/**
 * @author gaurav kabra
 * @since July 3, 2021
 */

import java.util.HashSet;
import java.util.Set;

public class AllSubsequences {
	
	private Set<String> getAllSubsequences(String s) {
		/**
		 * Logic:
		 * Same as StringPermutations.java file
		 * Subsequence is a generalization of substring
		 */
		
		int waysToChoose = 1 << (s.length()+1);
		Set<String> st = new HashSet<>();
		for(int i=0; i<waysToChoose; i++) {
			String temp = "";
			
			for(int j=0; j<s.length(); j++) {
				if(((i >> j) & 1) == 1) {
					temp += s.charAt(j);
				}
			}
			st.add(temp);
		}
		return st;
	}

	// driver - main method
	public static void main(String[] args) {
		// TESTCASE
		System.out.println(new AllSubsequences().getAllSubsequences("abc"));
	}

}
