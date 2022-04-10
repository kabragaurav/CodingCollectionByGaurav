/*
You are given an array of words where each word consists of lowercase English letters.

wordA is a predecessor of wordB if and only if we can insert exactly one letter anywhere in wordA without
 changing the order of the other characters to make it equal to wordB.

    For example, "abc" is a predecessor of "abac", while "cba" is not a predecessor of "bcad".

A word chain is a sequence of words [word1, word2, ..., wordk] with k >= 1, where word1 is a predecessor
of word2, word2 is a predecessor of word3, and so on.

A single word is trivially a word chain with k == 1.

Return the length of the longest possible word chain with words chosen from the given list of words.
 */
package DP.Others;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author gaurav kabra
 * @since 08/Apr/2022
 **/

public class LongestChain {

    /*
    TC :
        O(NlogN) for sorting, O(NS) for looping the strings and for each substring checking in map. S = max string length
        So, overall O(N*(S+logN))

     SC : O(N)
     */
    private static int longestStrChain(String[] words) {
        int N = words.length;
        int max = 0;
        HashMap<String, Integer> mp = new HashMap<>();

        Arrays.sort(words, (word1, word2) -> word1.length()-word2.length());

        for (int i=0; i<N; i++) {
            String word = words[i];
            int count = 0;
            for (int j=0; j<word.length(); j++) {
                String subWord = word.substring(0, j) + word.substring(j+1);
                count = Math.max(count, mp.getOrDefault(subWord, 0) + 1);   // As problem says : A single word is trivially a word chain with k == 1.
                max = Math.max(max, count);
            }
            mp.put(word, count);
        }
        return max;
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASE(S)
        System.out.println(longestStrChain(new String[] {"a","b","ba","bca","bda","bdca"}));
        System.out.println(longestStrChain(new String[] {"abcd","dbqca"}));
        System.out.println(longestStrChain(new String[] {"xbc","pcxbcf","xb","cxbc","pcxbc"}));
    }

}
