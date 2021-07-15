/**
 * Facebook
 * Given an integer N, where N represents the number of pairs of parentheses.
 * Return a list containing all possible well-formed parentheses you can create.
 */
package Backtracking;

/**
 * @author gaurav kabra
 * @since July 04, 2021
 */

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
	
	List<String> ls = new ArrayList<>();
    
    private void helper(int N, String s, int leftCount, int rightCount) {
    	/**
    	 * Logic:
    	 * if length of string is equal to 2*N, we got a valid string
    	 * Else,
    	 * 	we will have a '(' if number of '(' is less than N/2
    	 *  also we would like to add a ')' only if number of '(' is greater than number of ')'
    	 *  
    	 *  Time Complexity: O(2^N) since for each character we have two options - '(' or ')'
    	 *  Space Complexity : O(2*N*k) ~ O(N*k) since we have k valid strings and each has length 2*N in list
    	 */
        if(s.length() == N) {
            ls.add(s);
            return;
        }
        /** Below code is same as
         *	if(leftCount <  (N/2)) {
         		s = s +'(';								// adding a new char
            	helper(N, s, leftCount+1, rightCount);
            	s = s.substring(0, s.length()-1);   	// removing the added char
        	}	
         *  Hence actually backtracking
         */
        if(leftCount <  (N/2)) {
            helper(N, s+'(', leftCount+1, rightCount);
        }
        
        if(leftCount > rightCount) {
            helper(N, s+')', leftCount, rightCount+1);
        }
    }
    
    private List<String> generateParenthesis(int N) {
        helper(2*N, "", 0, 0);
        return ls;
    }
    
    // driver - main method
	public static void main(String[] args) {
		// TESTCASE
		System.out.println(new GenerateParenthesis().generateParenthesis(8));
	}

}
