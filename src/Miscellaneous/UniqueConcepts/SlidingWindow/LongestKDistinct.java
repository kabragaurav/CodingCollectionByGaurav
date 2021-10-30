/**
 * Given a string you need to print the size of the longest possible substring that has exactly K unique characters.
 * If there is no possible substring then print -1.
 */
package Miscellaneous.UniqueConcepts.SlidingWindow;

import java.util.HashMap;

/**
 * @author gaurav kabra
 * @since 30 Oct 2021
 **/

public class LongestKDistinct {
    /**
     * Logic:
     * We can use two pointers to traverse the string.
     * We maintain map to have freuency of chars and use its size for knowing number of distinct chars.
     *
     * TC : O(|S|), |S| being length of string s.
     * SC : O(|S|) in form of map, worst case if s has all distinct chars and k = |S|
     *
     * Excellent video : https://tinyurl.com/longest-subtr-k-distinct-chars
     */
    private static int longestKSubstr(String s, int k) {
        int i=0, j=0, N = s.length();
        HashMap<Character, Integer> mp = new HashMap<>();
        int len = -1;
        while(j < N) {
            char ch = s.charAt(j);
            if(mp.size() == k) {
                len = Math.max(len, j-i);
            } else if(mp.size() > k) {
                while(mp.size() > k) {
                    char temp = s.charAt(i);
                    mp.put(temp, mp.get(temp)-1);
                    if(mp.get(temp) == 0) {
                        mp.remove(temp);
                    }
                    i++;
                }
            }
            mp.put(ch, mp.getOrDefault(ch, 0)+1);
            j++;
        }
        if(mp.size() == k) {
            len = Math.max(len, j-i);
        }
        return len;
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASES
        System.out.println(longestKSubstr("aabacbebebe", 3));
        System.out.println(longestKSubstr("aaaa", 2));
        System.out.println(longestKSubstr("qwerty", 6));
    }
}
