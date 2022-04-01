/*
Let the function f(s) be the frequency of the lexicographically smallest character in a non-empty
string s. For example, if s = "dcce" then f(s) = 2 because the lexicographically smallest character
is 'c', which has a frequency of 2.
You are given an array of strings words and another array of query strings queries. For each query
queries[i], count the number of words in words such that f(queries[i]) < f(W) for each W in words.
Return an integer array answer, where each answer[i] is the answer to the ith query.
 */

package Strings;

import Arrays.Utils.ArrayUtils;

import java.util.TreeMap;

/**
 * @author gaurav kabra
 * @since 01/Apr/2022
 **/

public class CompareStringsByFreqOfSmallestChar {

    private static int f(String s) {
        TreeMap<Character, Integer> mp = new TreeMap<>();

        for (char ch : s.toCharArray()) {
            mp.putIfAbsent(ch, 0);
            int f = mp.get(ch);
            mp.put(ch, f+1);
        }

        return mp.get(mp.firstKey());
    }



    // TC : O(M*N)
    // SC : O(L) where L = max length of any string in queries or words
    private static int[] numSmallerByFrequency(String[] queries, String[] words) {
        int q = queries.length;
        int w = words.length;

        int[] freqQ = new int[q];
        int[] freqW = new int[w];

        for (int i=0; i<q; i++) {
            freqQ[i] = f(queries[i]);
        }

        for (int i=0; i<w; i++) {
            freqW[i] = f(words[i]);
        }

        int[] ans = new int[q];

        for (int i=0; i<q; i++) {
            int fQ = freqQ[i];
            int count = 0;
            for (int j=0; j<w; j++) {
                if (fQ < freqW[j]) {
                    count++;
                }
            }
            ans[i] = count;
        }

        return ans;
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASE(S)
        ArrayUtils.printArray(numSmallerByFrequency(new String[] {"bbb","cc"}, new String[] {"a","aa","aaa","aaaa"}));
    }

}
