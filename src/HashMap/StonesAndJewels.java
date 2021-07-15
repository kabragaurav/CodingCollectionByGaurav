/**
 * Amazon
 * Given a string representing your stones and another string representing a list of jewels, 
 * return the number of stones that you have that are also jewels.
 */
package HashMap;

import java.util.HashMap;
import java.util.Map;

/**
 * @author gaurav kabra
 * @since May 21, 2021
 *
 */
public class StonesAndJewels {
	
	/**
	 * 
	 * @param first string, stones
	 * @param second string, jewels
	 * @return number of stones that are also jewels
	 */
	private int stonesThatAreJewels(String stones, String jewels) {
		/**
		 * Logic:
		 * We store frequency of each character in first arg string, i.e. stones, in a map
		 * Then we iterate second arg string, i.e. jewels and add the frequencies if the character in jewels string is found in map
		 */
		if(stones == null || jewels == null)
			return 0;
		
		Map<Character, Integer> mp = new HashMap<>();
		// initially answer is 0
		int ans = 0;
		
		char[] arr1 = stones.toCharArray();
		char[] arr2 = jewels.toCharArray();
		
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
			if(mp.containsKey(ch))
				ans += mp.get(ch);
		}
		
		return ans;
	}
	
	// driver - main method
	public static void main(String[] args) {
		
		StonesAndJewels saj = new StonesAndJewels();
		
		// TESTCASES
		System.out.println(saj.stonesThatAreJewels("abc", "ac"));
		System.out.println(saj.stonesThatAreJewels("Af", "AaaddfFf"));
		System.out.println(saj.stonesThatAreJewels("AYOPD", "ayopd"));
		
	}

}


/**
 * Time: O(N) since we iterate strings linearly
 * Space: O(N) since we use hashmap and in worstcase all characters in string are different so end up storing frequency as 1 for all
 */
