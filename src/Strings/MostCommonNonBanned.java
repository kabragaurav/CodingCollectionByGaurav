/**
 * Given a string paragraph and a string array of the banned words banned,
 * return the most frequent word that is not banned.
 * It is guaranteed there is at least one word that is not banned,
 * and that the answer is unique.
 * The words in paragraph are case-insensitive and the answer should be returned in lowercase.
 */
package Strings;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Arrays;

/**
 * @author gaurav kabra
 * @since 23 Nov 2021
 **/

public class MostCommonNonBanned {

    // convert para to lower case and remove special chars
    // Also replace multiple whitespaces between words to single whitespace
    private static String formatPara(String para) {
        para = para.toLowerCase();
        para = para.replaceAll("!", " ");
        para = para.replaceAll("\\?", " ");
        para = para.replaceAll("'", " ");
        para = para.replaceAll(",", " ");
        para = para.replaceAll(";", " ");
        para = para.replaceAll("\\.", " ");
        para = para.replaceAll("\"", " ");
        para = para.replaceAll("\\s+", " ");
        return para;
    }

    // TC: O(N) as we traverse para linearly contant number of times
    // SC: O(N) due to map
    private static String mostCommonWord(String para, String[] banned) {
        para = formatPara(para);
        for(int i=0; i<banned.length; i++) {
            banned[i] = banned[i].toLowerCase();
        }
        List<String> ban = Arrays.asList(banned);
        Map<String, Integer> mp = new HashMap<>();
        // keep track of max frequency of non-banned word so far
        int max = 0;
        // According to max variable, update the most frequent non-banned word
        String ans = "";
        for(String word : para.split(" ")) {
            if(!ban.contains(word)) {
                mp.put(word, mp.getOrDefault(word, 0) + 1);
                if(mp.get(word) > max) {
                    max = mp.get(word);
                    ans = word;
                }
            }
        }
        return ans;
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASE
        System.out.println(mostCommonWord("a, a, a, a, b,b,b,c, c", new String[] {"a"}));
    }
}
