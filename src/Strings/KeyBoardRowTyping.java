/**
 * Given a list of words, return all the words that require only a single row of a keyboard to type.
 */
package Strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

/**
 * @author gaurav kabra
 * @since 21 Aug 2021
 **/
public class KeyBoardRowTyping {

    final static String[] keyboardRows = new String[]{
            "qwertyuiop",
            "asdfghjkl",
            "zxcvbnm"
    };


    private static String[] findRowWords(String[] words) {
        List<String> ls = new ArrayList<>();        // final answer
        // for each character in each word, see in which row the character falls.
        // then at last check if any count equals word length
        // if so that means that row has whole word. So add word to our final answer
        // Time Complexity : O(N) (since rows has only 3 words so it is O(1))
        // Space Complexity : O(N), in worst case we end up storing every word in ls
        for(String word : words) {
            int[] whichRowHas = new int[3];
            for(char ch : word.toLowerCase().toCharArray()) {
                for(int i=0; i<3; i++) {
                    if(keyboardRows[i].indexOf(ch) != -1) {
                        whichRowHas[i] += 1;
                        break;
                    }
                }
            }
            for(int i=0; i<whichRowHas.length; i++) {
                if(whichRowHas[i] == word.length()) {
                    ls.add(word);
                    break;
                }
            }
        }
        return Arrays.copyOf(ls.toArray(), ls.size(), String[].class);
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASE
        System.out.println(Arrays.deepToString(findRowWords(new String[] {"tWo", "Dad", "caT"})));
        System.out.println(Arrays.deepToString(findRowWords((new String[] {"ufo", "xZy", "bit"}))));
    }
}
