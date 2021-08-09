/**
 * Facebook
 * Given an array of characters chars, compress it using the following algorithm:
 * Begin with an empty string s. For each group of consecutive repeating characters in chars:
 * If the group's length is 1, append the character to s.
 * Otherwise, append the character followed by the group's length.
 * The compressed string s should not be returned separately, but instead be stored in the input character array chars. 
 * Note that group lengths that are 10 or longer will be split into multiple characters in chars.
 * After you are done modifying the input array, return the new length of the array.
 */
package Strings;

/**
 * @author gaurav kabra
 * @since August 09, 2021
 */

public class SpecialCompress {
	
	private static int compress(char[] chars) {
		/**
		 * Logic is obvious.
		 * Only thing is to take care of corner cases (as indicated in comments)
		 * 
		 * Time Complexity : O(N) since we traverse string once
		 * Space Complexity : O(M), M<=N since we use a string to represent compressed form.
		 */
        String s = "";
        int N = chars.length;
        if(N == 1) {							// E.g. ['a']
            return 1;
        }
        for(int i=0; i<N-1; i++) {
            char temp = chars[i];
            int j = 1;
            while(chars[i+1] == chars[i]) {
                j++;
                i++;
                if(i == N-1) {					// E.g. ['a','b','b']
                    break;
                }
            }
            if(j == 1) {
                s = s + temp;
            } else {
                s = s + temp + j;   
            }
        }
        if(chars[N-1] != chars[N-2]) {			// E.g. ['a','b','c']
            s = s + chars[N-1];
        }
        for(int i=0; i<s.length(); i++) {
            chars[i] = s.charAt(i);
        }
        return s.length();
    }
	
	// driver - main method
	public static void main(String[] args) {
		char[][] chars = new char[][] {
			{'a','b','b','c','c','c'},
			{'a'},
			{'a','b','b','b','b','b','b','b','b','b','b','b','b'},
			{'a','b','c'}
		};
		
		// TESTCASES
		for(char[] chr : chars) {
			int len = compress(chr);
			System.out.println(len);
			System.out.println(new String(chr).substring(0, len));
		}
	}

}
