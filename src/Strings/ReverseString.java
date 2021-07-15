/**
 * Google
 * Given a string, reverse all of its characters and return the resulting string.
 */
package Strings;
/**
 * @author gaurav kabra
 * @since May 22, 2021
 */
public class ReverseString {
	
	/**
	 * @param string s to be reversed
	 * @return reversed String object using two-pointer approach
	 * Time: O(N) as we use two pointers to swap the characters
	 * Space: O(1) as don't use extra space
	 */
	private String getReversedStringManual(String s) {
		/**
		 * Logic:
		 * We convert String to character array and using two pointer method (i and j), we swap the characters in array.
		 * This makes the array reversed and we convert it to string and return.
		 */
		char[] arr = s.toCharArray();
		int i = 0, j = arr.length-1;
        char temp;
        while(i<j) {
            temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
        return new String(arr);
	}
	
	/**
	 * @param string s to be reversed
	 * @return reversed String object using built-in methods
	 * Time: O(N) as we use two pointers to swap the characters
	 * Space: O(1) as don't use extra space
	 */
	private String getReversedStringBuiltIn(String s) {
		/**
		 * Logic:
		 * Reversal is very easy with StringBuilder.
		 * So we create StringBuilder object using provided String object as argument. Reverse it and convert it back to String and return that.
		 */
		return new StringBuilder(s).reverse().toString();
	}
	
	// driver - main method
	public static void main(String[] args) {
		ReverseString rs = new ReverseString();
		
		// TESTCASES
		System.out.println(rs.getReversedStringBuiltIn("Cat"));
		System.out.println(rs.getReversedStringBuiltIn("The Daily Byte"));
		System.out.println(rs.getReversedStringBuiltIn("civic"));
		
		System.out.println(rs.getReversedStringManual("Cat"));
		System.out.println(rs.getReversedStringManual("The Daily Byte"));
		System.out.println(rs.getReversedStringManual("civic"));
	}

}
