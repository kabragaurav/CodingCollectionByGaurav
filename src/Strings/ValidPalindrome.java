/**
 * Facebook
 * Given a string, return whether or not it forms a palindrome ignoring case and non-alphabetical characters.
 */
package Strings;
/**
 * @author gaurav kabra
 * @since May 21, 2021
 */
public class ValidPalindrome {
	/**
	 * Helper for isValidPalindrome method
	 * @param char ch
	 * @return boolean, true if ch is alphanumeric
	 */
	private boolean isAlphaNum(char ch) {
		// We can also use  Character.isJavaLetterOrDigit method
		return (ch >= 'a' && ch <= 'z') || (ch >= '0' && ch <= '9');
	}
	
	/**
	 * @param string s
	 * @param start index
	 * @param end index
	 * @return boolean, true if it is valid palindrome
	 * Time: O(N) as traverse string once
	 * Space: O(1) as don't use any additional space
	 */
	private boolean isValidPalindrome(String s, int start, int end) {
		/**
		 * Logic:
		 * We use two pointers and traverse string.
		 * Left pointer moves to right and right pointer moves to left.
		 * And during that we ignore characters that are non-alphanumeric and check equality for alphanumeric chars.
		 */
		if(s == null || s.isEmpty())
			return true;
		// since case does not matter, convert to lowercase (We can also convert to upper case and change isAlphaNum method accordingly)
		s = s.toLowerCase();
		// store chars at start and end indices as they change
		char left, right;
		// check if left and right are alphanumeric
		boolean isLeftAlphaNum, isRightAlphaNum;
		while(start <= end) {
			left = s.charAt(start);
			right = s.charAt(end);
			isLeftAlphaNum = isAlphaNum(left);
			isRightAlphaNum = isAlphaNum(right);
			// if both are alphanumeric, then they must be equal
			if(isLeftAlphaNum && isRightAlphaNum) {
				if(left != right)
					return false;
				start++;
				end--;
			}
			else if(!isLeftAlphaNum && !isRightAlphaNum) {
				start++;
				end--;
			}
			else if(!isLeftAlphaNum) {
				start++;
			}
			else if(!isRightAlphaNum) {
				end--;
			}
		}
		return true;
	}
	
	// driver - main method
	public static void main(String[] args) {
		
		ValidPalindrome vp = new ValidPalindrome();
		
		// TESTCASES
		String s = "level";
		System.out.println(vp.isValidPalindrome(s, 0, s.length()-1));
		s = "algorithm";
		System.out.println(vp.isValidPalindrome(s, 0, s.length()-1));
		s = "A man, a plan, a canal: Panama.";
		System.out.println(vp.isValidPalindrome(s, 0, s.length()-1));

	}

}
