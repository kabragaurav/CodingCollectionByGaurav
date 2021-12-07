/**
 * Given two strings s and p, return an array of all the start indices of p's anagrams in s.
 * You may return the answer in any order.
 */
package Miscellaneous.UniqueConcepts.SlidingWindow;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

/**
 * @author gaurav kabra
 * @since 7 Dec 2021
 **/

public class AllAnagrams {

    /**
     * Logic:
     * If two strings are anagrams, on sorting, they will be equal.
     * So we will loop over s and extract substrings of length equal to that of p and compare them after sort.
     * If they are equal then store them.
     *
     * TC : O(NlogN) due to sort
     * SC : O(N) due to char[] and List
     */
    private static List<Integer> findAnagrams(String s, String p) {
        int lenP = p.length();
        char[] ch = p.toCharArray();
        Arrays.sort(ch);
        p = new String(ch);
        String _s;
        List<Integer> ls = new ArrayList<>();

        for(int i=0; i<s.length()-lenP+1; i++) {
            ch = s.substring(i, i+lenP).toCharArray();
            Arrays.sort(ch);
            _s = new String(ch);;
            if(_s.equals(p)) {
                ls.add(i);
            }
        }

        return ls;
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASE
        findAnagrams("aaaa", "aa").stream().forEach(s -> System.out.println(s));
    }
}
