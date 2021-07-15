/**
 * Amazon
 * Given a string s consisting of only letters and digits, 
 * where we are allowed to transform any letter to uppercase or lowercase, 
 * return a list containing all possible permutations of the string.
 */
package BitManipulation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author gaurav kabra
 * @since July 2, 2021
 * 
 * See this for BFS & DFS solutions: https://tinyurl.com/stringpermBFSDFS
 */

public class StringPermutations {
	
	public List<String> letterCasePermutation(String s) {
		/**
		 * Logic:
		 * For a string of length N there exists 2^N maximum combinations (with 1 empty) if each letter can be capital or small. 
		 * We can represent this as a bitwise operation : 1 << (N+1) (since 1<<(N+1) is equal to 2^N)
		 * 
		 * Time Complexity : O(N * 2^N) where N is length of string
		 * Space Complexity : O(N) for one character array
		 */
		s = s.toLowerCase();
        Set<String> st = new HashSet<>();
        
        int pow2ToN = 1 << (s.length()+1);
        // will hold characters of string
        char[] arr;
        
        for(int i=0; i<pow2ToN; i++) {
            arr = s.toCharArray();
            for(int j=0; j<s.length(); j++) {
            	// If j-th bit of i is set and it is a letter, we convert it to upper-case
                if(((i >> j) & 1) == 1 && !Character.isDigit(arr[j])) {
                    arr[j] = (char) (arr[j] - 32);
                }
            }
            st.add(new String(arr));
        }
        return new ArrayList<>(st);
    }
	
	// driver - main method
	public static void main(String[] args) {
		// TESTCASE
		System.out.println(new StringPermutations().letterCasePermutation("c7d15"));
	}
}
