/**
 * Given a pattern, s and a string, str, find if str follows the pattern displayed by s.
 * Here "follow" means a full match, such that there is a bijection (one-to-one and onto) between
 * a letter in s and a word in str.
 */
package Strings;

import java.util.HashMap;
import java.util.Map;

/**
 * @author gaurav kabra
 * @since 5 Oct 2021
 **/

public class WordPattern {

    /**
     * Logic:
     * Since relation has to be one-to-one, we first check from s to str. Then str to s.
     * If any point something is not conformed, we return false.
     * Else at last we return true.
     *
     * TC: O(N) due to two iterations
     * SC: O(N) due to two maps
     */
    private static boolean wordPattern(String s, String str) {
        char[] pattern = s.toCharArray();
        String[] toMatch = str.split(" ");
        if(pattern.length != toMatch.length) {
            return false;
        }
        Map<Character, String> mp = new HashMap<>();
        for(int i=0; i<pattern.length; i++) {
            String temp = mp.get(pattern[i]);
            if(temp == null) {
                mp.put(pattern[i], toMatch[i]);
            } else {
                if(!temp.equals(toMatch[i])) {
                    return false;
                }
            }
        }

        Map<String, Character> strChrMap = new HashMap<>();
        for(int i=0; i<toMatch.length; i++) {
            Character temp = strChrMap.get(toMatch[i]);
            if(temp == null) {
                strChrMap.put(toMatch[i], pattern[i]);
            } else {
                if(temp != pattern[i]) {
                    return false;
                }
            }
        }
        return true;
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASES
        System.out.println(wordPattern("abba", "dog cat cat dog"));
        System.out.println(wordPattern("abba", "cat cat cat cat"));
        System.out.println(wordPattern("aaaa", "cat dog dog cat"));
    }
}
