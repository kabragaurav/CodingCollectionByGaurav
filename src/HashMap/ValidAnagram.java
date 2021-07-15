/**
 * Facebook
 * Given two strings s and t return whether or not s is an anagram of t.
 */
package HashMap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author gaurav kabra
 * @since May 21, 2021
 */

public class ValidAnagram {
	/**
	 * 
	 * @param first string, original
	 * @param second string, other
	 * @return boolean, if strings are anagram
	 * 
	 * Time: O(N) since we iterate string linearly
	 * Space: O(N) since we use hashmap and in worstcase all characters in string are different so end up storing frequency as 1 for all
	 */
	private boolean isAnagramUsingMap(String original, String other) {
		
		if(original == null || other == null)
			return false;
		
		// if length is not same then strings cannot be anagram
		if(original.length() != other.length())
			return false;
		
		// Map to store frequency of each character in first string (i.e. original)
		Map<Character, Integer> mp = new HashMap<>();
		
		char[] arr1 = original.toCharArray();
		char[] arr2 = other.toCharArray();
		
		// We could also use getOrDefault() method below
		for(char ch : arr1) {
			// if character already present, then increase its frequency by 1
			if(mp.containsKey(ch))
				mp.put(ch, mp.get(ch)+1);
			// else it occurred first time, so put frequency as 1
			else
				mp.put(ch, 1);
		}
		
		for(char ch : arr2) {
			// if character already present, then decrease its frequency by 1
			if(mp.containsKey(ch))
				mp.put(ch, mp.get(ch)-1);
			// else the character not present, so strings are not anagram
			else
				return false;
		}
		
		// Finally check that all frequencies are 0. If any one is not, then return false
		for (Map.Entry<Character, Integer> set : mp.entrySet()) {
		    if(set.getValue() != 0)
		    	return false;
		}
		
		// if we reached here, that means strings are anagram. Return true
		return true;
	}
	
	/**
	 * 
	 * @param first string, original
	 * @param second string, other
	 * @return boolean, if strings are anagram
	 * 
	 * Time: O(NlogN), NlogN for sorting and N for comparing strings for equality
	 * Space: O(N) for character arrays, O(1) for heapsort (if sort method uses heap sort)
	 */
	private boolean isAnagramUsingSorting(String original, String other) {
		/**
		 * Logic:
		 * We sort the two strings, and they are anagram is they are equal after sorting
		 */
		if(original == null || other == null)
			return false;
		
		// if length is not same then strings cannot be anagram
		if(original.length() != other.length())
			return false;
		
		// We cannot sort strings directly. We first convert to character array and then sort and then re-convert to string
		char[] arr1 = original.toCharArray();
		char[] arr2 = other.toCharArray();
		Arrays.sort(arr1);
		Arrays.sort(arr2);
		String s1 = new String(arr1);
		String s2 = new String(arr2);
		
		// or we could directly do Arrays.equals(arr1, arr2);
		return s1.equals(s2);
	}

	public static void main(String[] args) {
		ValidAnagram va = new ValidAnagram();
		
		// TESTCASES
		
		// Using sorting
		System.out.println(va.isAnagramUsingSorting("cat", "tac"));
		System.out.println(va.isAnagramUsingSorting("listen", "silent"));
		System.out.println(va.isAnagramUsingSorting("program", "function"));
		
		// Using Map
		System.out.println(va.isAnagramUsingMap("cat", "tac"));
		System.out.println(va.isAnagramUsingMap("listen", "silent"));
		System.out.println(va.isAnagramUsingMap("program", "function"));
	}

}
