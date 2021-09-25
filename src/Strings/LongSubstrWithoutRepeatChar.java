/**
 * Given a string s,
 * return the length of the longest substring that contains only unique characters.
 */
package Strings;

import java.util.HashMap;
import java.util.Map;

/**
 * @author gaurav kabra
 * @since 25 Sept 2021
 **/

public class LongSubstrWithoutRepeatChar {

    /**
     * Logic:
     * We store the latest index of characters in map.
     * We traverse the string.
     * If current character already in map, so we hit duplicate
     *      We try to update maxLength
     *      We try to move pointer forward
     * We update the index of character in map
     *
     * After complete iteration, we return max of maxLength and length of string - pointer.
     *
     * TC: O(N) since we traverse the whole string once.
     * SC : O(N) since in worst case all characters in string are different and we end up storing all of them in the map.
     */
    private static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> mp = new HashMap<>();
        int maxLength = 0;
        int pointer = 0;

        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            if(mp.get(ch) != null) {
                int len = i-pointer;
                maxLength = Math.max(maxLength, len);
                pointer = Math.max(pointer, mp.get(ch) + 1);    // for "abba" . Pointer should never go back.
            }
            mp.put(ch, i);
        }
        return Math.max(maxLength, s.length() - pointer);        // for "au"
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASES
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("bbbbb"));
        System.out.println(lengthOfLongestSubstring(""));
        System.out.println(lengthOfLongestSubstring(" "));
        System.out.println(lengthOfLongestSubstring("au"));
        System.out.println(lengthOfLongestSubstring("aab"));
        System.out.println(lengthOfLongestSubstring("abba"));
    }
}
