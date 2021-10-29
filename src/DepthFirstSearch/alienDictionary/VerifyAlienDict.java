/**
 * In an alien language, surprisingly, they also use English lowercase letters,
 * but possibly in a different order.
 * The order of the alphabet is some permutation of lowercase letters.
 * Given a sequence of words written in the alien language,
 * and the order of the alphabet, return true iff
 * the given words are sorted lexicographically in this alien language.
 */
package DepthFirstSearch.alienDictionary;

import java.util.HashMap;
import java.util.Map;

/**
 * @author gaurav kabra
 * @since 29 Oct 2021
 **/

public class VerifyAlienDict {

    private static boolean isCorrectOrder(Map<Character, Integer> charIndex, String prev, String curr) {
        int len = Math.min(prev.length(), curr.length());
        for(int i=0; i<len; i++) {
            if(prev.charAt(i) != curr.charAt(i)) {
                if(charIndex.get(prev.charAt(i)) > charIndex.get(curr.charAt(i))) {
                    return false;
                }
                return true;
            }
        }
        if(prev.length() > curr.length()) {
            return false;
        }
        return true;
    }

    private static boolean isAlienSorted(String[] words, String order) {
        Map<Character, Integer> charIndex = new HashMap<>();

        for(int i=0; i<order.length(); i++) {
            charIndex.put(order.charAt(i), i);
        }

        for(int i=1; i<words.length; i++) {
            if(!isCorrectOrder(charIndex, words[i-1], words[i])) {
                return false;
            }
        }
        return true;
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASE
        String[] words = new String[] {
                "apple",
                "app"
        };
        String order = "abcdefghijklmnopqrstuvwxyz";
        System.out.println(isAlienSorted(words, order));

    }
}
