/**
 * Given a string s, find the length of
 * the longest substring t that contains at most 2 distinct characters.
 */

package Miscellaneous.UniqueConcepts;

/**
 * @author gaurav kabra
 * @since 18 Sept 2021
 **/

import java.util.HashMap;
import java.util.Map;

/**
 * e c e b a
 *     ^
 *       ^
 *   {e : 2, b : 1}
 */
public class LongestSubstrWithAtMostTwoDistinctChars {
    private static Map<Character, Integer> count;
    private static int maxLen;
    private static void lengthOfLongestSubstringTwoDistinct(String s) {
        if(s.length() == 1) {
            maxLen = 1;
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
                        pointer1++;
                        if (pointer1 == s.length()) {
                            return;
                        }
                    }
                    pointer1++;
                }
            }
            count.put(s.charAt(j), count.getOrDefault(s.charAt(j), 0) +1);
            maxLen++;
        }
    }

    public static void main(String[] args) {
        lengthOfLongestSubstringTwoDistinct("eceba");
        System.out.println(maxLen);
        lengthOfLongestSubstringTwoDistinct("ccaabbb");
        System.out.println(maxLen);

    }
}
