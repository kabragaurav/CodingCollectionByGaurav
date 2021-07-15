/**
 * Google
 * Given a string s, return all possible partitions of s such that each substring is a palindrome.
 * Order of characters matters.
 */
package Backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gaurav kabra
 * @since July 10, 2021
 */

public class PalindromeParitioning {
	
	private boolean isPalindrome(StringBuilder s, int start, int end) {
        StringBuilder temp = new StringBuilder(s.substring(start, end+1));
        return temp.toString().equals(temp.reverse().toString());
    }
    
    private void getAllPartitions(List<List<String>> ans, List<String> current, StringBuilder s, int start, int end) {
    	/**
    	 * Logic:
    	 * We start and see at each index if it can be used to form a palindrome
    	 * If so, we include it in current.
    	 */
        if(start >= end) {
            ans.add(new ArrayList<>(current));
            return;
        }
        for(int i=start; i<end; i++) {
            if(isPalindrome(s, start, i)) {
                String temp = new String(s.substring(start, i+1));
                current.add(temp);
                getAllPartitions(ans, current, s, i+1, end);
                current.remove(current.size()-1);
            }
        }
    }
    
    private List<List<String>> partition(String s) {
    	// our final answer
        List<List<String>> ans = new ArrayList<>();
        // holds a part of final answer
        List<String> current = new ArrayList<>();
        getAllPartitions(ans, current, new StringBuilder(s), 0, s.length());
        return ans;
    }

    // driver - main method
	public static void main(String[] args) {
		// TESTCASES
		System.out.println(new PalindromeParitioning().partition("cbbbcc"));
		System.out.println(new PalindromeParitioning().partition("xyz"));
	}

}
