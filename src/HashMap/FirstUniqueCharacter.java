/**
 * Microsoft
 * Given a string, return the index of its first unique character. 
 * If a unique character does not exist, return -1.
 */
package HashMap;

import java.util.HashMap;
import java.util.Map;

/**
 * @author gaurav kabra
 * @since May 21, 2021
 */
public class FirstUniqueCharacter {
	
	private int indexFirstUniqueChar(String s) {
		/**
		 * Logic:
		 * We iterate the string, and for each character we see how many times it occurs (i.e. its frequency)
		 * Then we return the first character in string that has frequency = 1
		 */
		
		if(s == null)
			return -1;
		
		// map for storing frequency corresponding to each character
		Map<Character, Integer> mp = new HashMap<>();
		char[] arr = s.toCharArray();
		
		// We could also use getOrDefault() method below
		for(char ch : arr) {
			// if character already present, then increase its frequency by 1
			if(mp.containsKey(ch))
				mp.put(ch, mp.get(ch) + 1);
			// else it occurred first time, so put frequency as 1
			else
				mp.put(ch, 1);
		}
		
		
		for(int i=0; i<arr.length; i++) {
			// return first character having frequency as 1
			if(mp.get(arr[i]) == 1) 
				return i;
		}
		
		// if we reach here, that means all characters appear more than once, so return -1 as per question
		return -1;
	}
	
	
	
	// driver - main method
	public static void main(String[] args) {
			FirstUniqueCharacter fuc = new FirstUniqueCharacter();
			
			// TESTCASES
			System.out.println(fuc.indexFirstUniqueChar("abcabd"));
			System.out.println(fuc.indexFirstUniqueChar("thedailybyte"));
			System.out.println(fuc.indexFirstUniqueChar("developer"));
			
	}

}

/**
 * Time: O(N) since we iterate string twice linearly
 * Space: O(N) since we use hashmap and in worstcase all characters in string are different so end up storing frequency as 1 for all
 */
