/**
 * Given a string s and a dictionary of strings wordDict,
 * return true if s can be segmented into a space-separated sequence of one
 * or more dictionary words.
 * The same word in the dictionary may be reused multiple times in
 * the segmentation.
 */
package Company.Amazon;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author gkabra
 * @since 26-01-2022 Wed
 **/

public class WorkBreak {

    private static HashSet<String> st = new HashSet<>();

    private static boolean feasible(String s, int curr, int N) {
        if(curr > N) {
            return false;
        }
        if(curr == N) {
            return true;
        }
        boolean possible = false;
        int temp = curr;
        while(temp <= N) {
            String substr = s.substring(curr, temp);
            if(st.contains(substr)) {
                possible = feasible(s, temp, N);
                if(possible) {
                    return true;
                }
            }
            temp++;
        }
        return false;
    }


    private static boolean wordBreak(String s, List<String> wordDict) {
        if(s.length() == 0) {
            return true;
        }
        if(s.length() == 1) {
            return wordDict.contains(Character.toString(s.toCharArray()[0]));
        }
        for(String word : wordDict) {
            st.add(word);
        }

        return feasible(s, 0, s.length());
    }

    // driver - main method
    public static void main(String[] args) {
        st = new HashSet<>();       // always reset static class level variable

        // TESTCASES
        System.out.println(wordBreak("leetcode", new ArrayList<>() {{
            add("leet");
            add("code");
        }}));

        System.out.println(wordBreak("a", new ArrayList<>() {{
            add("a");
        }}));

        System.out.println(wordBreak("a", new ArrayList<>() {{
            add("b");
        }}));

    }

}
