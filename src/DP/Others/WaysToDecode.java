/**
 * Microsoft
 * Given a message that is encoded using the following encryption method…
 * A -> 1
 * B -> 2
 * C -> 3
 * ...
 * Z -> 26
 * Return the total number of ways it can be decoded.
 * ‘0’ has no mapping and a character following a ‘0’ also has no mapping (i.e. “03” has no mapping).
 */
package DP.Others;

import java.util.HashMap;
import java.util.Map;

public class WaysToDecode {
	
	// mp will store mappings {"1"='A', "2"='B', ...}
	Map<String, Character> mp;
    
    public WaysToDecode() {
    	// initialize mp
        mp = new HashMap<>();
        for(int i=1; i<=26; i++) {
            mp.put(""+i, (char) ('A'+i-1));
        }
    }
    
    private int getDecodeCount(String s, int start, int[] cache) {
    	/**
    	 * Logic:
    	 * If we can reach the end of string, that means we found one way to decode. So return 1 in that case.
    	 * Else two cases are there:
    	 * 		If string at start index is in mp, then we continue from start+1 index
    	 * 		If string formed by start and start+1 index is in mp, then we continue from start+2 index
    	 */
        if(start == s.length()) {
            return 1;
        }
        if(cache[start] != 0)
            return cache[start];
        // one means take one char string
        // two means take two char string
        int one = 0, two = 0;
        if(mp.get(""+s.charAt(start)) != null) {
            one = getDecodeCount(s, start+1, cache);
        }
        if(start <= s.length()-2 && mp.get(""+s.charAt(start)+s.charAt(start+1)) != null) {
            two = getDecodeCount(s, start+2, cache);
        }
        return cache[start] = one + two;
    }
    
    public int numDecodings(String s) {
        int[] cache = new int[s.length()];
        return getDecodeCount(s, 0, cache);
    }
    
    // driver - main method
	public static void main(String[] args) {
		WaysToDecode wtd = new WaysToDecode();

		// TESTCASES
		System.out.println(wtd.numDecodings("06"));
		System.out.println(wtd.numDecodings("226"));
		System.out.println(wtd.numDecodings("111111111111111111111111111111111111111111111"));
	}

}
