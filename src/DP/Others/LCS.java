/**
 * Google
 * Given two non-null strings, s and t, return the length of their longest subsequence.
 * A subsequence of a string is a new string generated from the original string with some characters 
 * (can be none) deleted without changing the relative order of the remaining characters.
 */
package DP.Others;

/**
 * @author gaurav kabra
 * @since July 20, 2021
 */

public class LCS {
	
	private static int getLCS(String text1, int start1, int end1, String text2, int start2, int end2, int[][] cache) {
		/**
		 * Logic:
		 * We first check bounds using "start1 > end1 || start2 > end2". E.g. in "a" and "ab", we want lcs = 1.
		 * 
		 * If front chars match, then we increment length of lcs by one and search in remaining strings.
		 * Else, we remove front chars from strings, one at a time, and get max length of lcs from resulting strings.
		 */
		if(start1 > end1 || start2 > end2) {
			return 0;
		}
		if(cache[start1][start2] != 0) {
			return cache[start1][start2];
		}
		if(text1.charAt(start1) == text2.charAt(start2)) {
			return cache[start1][start2] = 1 + getLCS(text1, start1+1, end1, text2, start2+1, end2, cache);
		}
		return cache[start1][start2] = Math.max(
				getLCS(text1, start1+1, end1, text2, start2, end2, cache),
				getLCS(text1, start1, end1, text2, start2+1, end2, cache)
			);
				
	}
	
	private static int longestCommonSubsequence(String text1, String text2) {
		/**
		 * If any string is empty, lcs = 0 (even if other string is empty)
		 */
		if(text1.equals("") || text2.equals("")) {
			return 0;
		}
		int[][] cache = new int[text1.length()][text2.length()];
        return getLCS(text1, 0, text1.length()-1, text2, 0, text2.length()-1, cache);
    }

	// driver - main method
	public static void main(String[] args) {
		String[][] samples = new String[][] {
			{"xyz", "xyz"},
			{"abca", "acea"},
			{"abc", "def"},
			{"mhunuzqrkzsnidwbun", "szulspmhwpazoxijwbq"}
		};
		
		// TESTCASES
		for(String[] sample : samples) {
			System.out.println(longestCommonSubsequence(sample[0], sample[1]));
		}
	}

}
