/**
 * Amazon
 * Given a string s and a list of words representing a dictionary, 
 * return whether or not the entirety of s can be segmented into dictionary words.
 * All characters in s and the dictionary are lowercase.
 */
package DP.Others;

import java.util.Arrays;
import java.util.List;

/**
 * @author gaurav kabra
 * @since July 24, 2021
 */

public class DictionaryWords {
	
	private static boolean wordBreak(String s, List<String> wordDict) {
		int len = s.length();
        boolean[] f = new boolean[len+1];
        f[0] = true;
        for (int i=1; i<len+1; i++) {
            for (int j=0; j<i; j++) {
                if (f[j] && wordDict.contains(s.substring(j,i))) {
                    f[i] = true;
                    break;
                }
            }
        }
        return f[len];
	}
	
	// driver - main method
	public static void main(String[] args) {
		// TESTCASES
		System.out.println(wordBreak("acaaaaabbbdbcccdcdaadcdccacbcccabbbbcdaaaaaadb",
				Arrays.asList(new String[] {
						"abbcbda","cbdaaa","b","dadaaad","dccbbbc","dccadd","ccbdbc","bbca","bacbcdd","a","bacb","cbc","adc","c","cbdbcad","cdbab","db","abbcdbd","bcb","bbdab","aa","bcadb","bacbcb","ca","dbdabdb","ccd","acbb","bdc","acbccd","d","cccdcda","dcbd","cbccacd","ac","cca","aaddc","dccac","ccdc","bbbbcda","ba","adbcadb","dca","abd","bdbb","ddadbad","badb","ab","aaaaa","acba","abbb"
				})));
		System.out.println(wordBreak("catsandog",
				Arrays.asList(new String[] {"cats", "and", "dog", "cat", "sand"})));
	}

}
