/**
 * Given a string array, words,
 * return a list containing all the characters that are common to all the words.
 * If a character appears multiple times in all the words it should also
 * appear multiple times in your return list.
 */
package Strings;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gaurav kabra
 * @since 02 Jan 2022
 **/

public class CommonCharacter {

    /**
     * Logic:
     * For each character in each word, see if that is in all words.
     * If yes, add it to the answer list (ans) and remove its first occurrence in every word.
     * Removal is needed as we need to consider duplicates as well. So if we don't remove, it may be counted more than once.
     *
     * TC : O(N^2 * l), N = words.length and l = longest length of word in words
     * SC : O(l) as ans will store character.
     */
    private static List<String> commonChars(String[] words) {
        List<String> ans = new ArrayList<>();
        int N = words.length;

        for(int i=0; i<N; i++) {
            String word = words[i];


            for(char ch : word.toCharArray()) {
                boolean containedInAll = true;
                for(int j=0; j<N; j++) {
                    if(!words[j].contains(Character.toString(ch))) {
                        containedInAll = false;
                        break;
                    }
                }
                if(containedInAll) {
                    ans.add(Character.toString(ch));
                    for(int k=0; k<N; k++) {
                        words[k] = words[k].replaceFirst(Character.toString(ch), "");
                    }
                }
            }
        }

        return ans;
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASES
        commonChars(new String[] {"bella","label","roler"}).forEach(str -> System.out.println(str));
        commonChars(new String[] {"bella","label","roller"}).forEach(str -> System.out.println(str));
    }
}
