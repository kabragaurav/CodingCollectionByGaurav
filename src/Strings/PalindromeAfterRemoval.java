/**
 * Facebook
 * Given a string and the ability to delete at most one character, 
 * return whether or not it can form a palindrome.
 */
package Strings;

/**
 * @author gaurav kabra
 * @since May 21, 2021
 */

public class PalindromeAfterRemoval {
	
	/**
	 * Helper method for canPalindrome
	 * @param string, s
	 * @param index to start, start
	 * @param index where to end (inclusive), end
	 * @return boolean, if s is palindrome from index [start, end]
	 */
	private boolean isPalindrome(String s, int start, int end) {
        while(++start <= --end) {
            if(s.charAt(start) != s.charAt(end))
                return false;
        }
        return true;
    }
    
	/**
	 * @param string, s
	 * @param index to start, start
	 * @param index where to end (inclusive), end
	 * @return boolean, if s can be a palindrome, removing at most one char\
	 * 
	 * Time: O(N) since we use two pointers and trace string
	 * Space: O(1) as we don't use any extra space
	 */
    private boolean canPalindrome(String s, int start, int end) {
    	/**
    	 * Logic:
    	 * We use two-pointer and recursion.
    	 * We keep one pointer to left most and other pointer to right-most end of string.
    	 * If the characters at pointers are same, we move both pointers inwards (by increasing left and decresing right pointer)
    	 * Else, we remove one character and check if removing makes the string a palindrome
    	 */
		while(++start <= --end) {
            if(s.charAt(start) != s.charAt(end))
                return isPalindrome(s, start-1, end) || isPalindrome(s, start, end+1);
        }
		// If we are here, that means we never needed to remove any character. Return true as s is already palindrome (no need to remove char)
        return true;
	}

	// driver - main method
	public static void main(String[] args) {
		
		PalindromeAfterRemoval par = new PalindromeAfterRemoval();
		
		// TESTCASES
		String s = "abcba";
		System.out.println(par.canPalindrome(s, -1, s.length()));
		s = "foobof";
		System.out.println(par.canPalindrome(s, -1, s.length()));
		s = "abccab";
		System.out.println(par.canPalindrome(s, -1, s.length()));
		
	}

}
