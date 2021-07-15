/**
 * Microsoft
 * Given an array of strings, return the longest common prefix that is shared amongst all strings.
 * Note: you may assume all strings only contain lowercase alphabetical characters.
 */
package Strings;

import java.util.Arrays;

/**
 * @author gaurav kabra
 * @since May 21, 2021
 */

public class LongestCommonPrefix {
	
	
	private String longestCommonPrefix(String[] arr) {
		/**
		 * Logic:
		 * We sort the array alphabetically.
		 * Now we only match characters in first and last strings in array.
		 * If they match:
		 * 		that means characters in all strings in between also match (since array is sorted)
		 * 		and we break out of loop at first mismatch
		 * 
		 */
		Arrays.sort(arr);
		
		String first = arr[0];
		String last = arr[arr.length-1];
		// the length of longest common prefix won't be more than minLen
		int minLen = Math.min(first.length(), last.length());
		int i=0;
		for(; i<minLen; i++) {
			if(first.charAt(i) != last.charAt(i))
				break;
		}
		// return part of string that is common to all strings (common prefix)
		return first.substring(0, i);
	}

	// driver - main method
	public static void main(String[] args) {
		
		LongestCommonPrefix lcp = new LongestCommonPrefix();
		
		// TESTCASES
		System.out.println(lcp.longestCommonPrefix(new String[]{"colorado", "color", "cold"}));
		System.out.println(lcp.longestCommonPrefix(new String[]{"a", "b", "c"}));
		System.out.println(lcp.longestCommonPrefix(new String[]{"spot", "spotty", "spotted"}));
		
	}

}
