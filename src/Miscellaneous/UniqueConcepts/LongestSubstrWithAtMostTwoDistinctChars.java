/**
 * Given a string s, length >=0, find the length of
 * the longest substring t that contains at most 2 distinct characters.
 */

package Miscellaneous.UniqueConcepts;

/**
 * @author gaurav kabra
 * @since 18 Sept 2021
 **/

import java.util.HashMap;
import java.util.Map;

public class LongestSubstrWithAtMostTwoDistinctChars {

    private static Map<Character, Integer> count;
    private static int maxLen;

    private static void lengthOfLongestSubstringTwoDistinct(String s) {
        /**
         * Logic:
         * If length of s is 0 or 1, then our answer will be length of s.
         * Else
         *      We make a map, count, for tracking at most 2 distinct chars.
         *      We keep two pointers, pointer1 and pointer 2
         *      Initially
         *                  e c e b a
         *                  ^
         *                    ^
         *      Then in for loop, variable j moves forward till end of s and we find the maxLen.
         *
         *
         *  Here is an excellent video:
         *  https://tinyurl.com/long-substr-2-dist-chars-most
         *  (Watch till 4.09 min from start, then come back to this code!)
         */
        if(s.isEmpty() || s.length() == 1) {
            maxLen = s.length();
            return;
        }
        count = new HashMap<>();
        maxLen = 0;
        int pointer1 = 0, pointer2 = 1;
        count.put(s.charAt(pointer1), 1);
        count.put(s.charAt(pointer2), count.getOrDefault(s.charAt(pointer2), 0) + 1);
        maxLen = 2;

        for(int j=pointer2+1; j<s.length(); j++) {
            if(null == count.get(s.charAt(j))) {
                count.put(s.charAt(j), 1);
                while(count.size() > 2) {
                    count.put(s.charAt(pointer1), count.get(s.charAt(pointer1)) - 1);
                    if (count.get(s.charAt(pointer1)) == 0) {
                        count.remove(s.charAt(pointer1));
                    }
                    pointer1++;
                    if (pointer1 == s.length()) {
                        return;
                    }
                }
            } else {
                count.put(s.charAt(j), count.getOrDefault(s.charAt(j), 0) + 1);
                maxLen = Math.max(maxLen, j-pointer1+1);
            }
        }
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASES
        lengthOfLongestSubstringTwoDistinct("eceba");
        System.out.println(maxLen);

        lengthOfLongestSubstringTwoDistinct("ccaabbb");
        System.out.println(maxLen);

        lengthOfLongestSubstringTwoDistinct("aaa");
        System.out.println(maxLen);

        lengthOfLongestSubstringTwoDistinct("");
        System.out.println(maxLen);
    }
}
