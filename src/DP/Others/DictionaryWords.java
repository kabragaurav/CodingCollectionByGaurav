/**
 * Amazon
 * Given a string s and a list of words representing a dictionary of words wordDict, return whether or not 
 * the entirety of s can be segmented into dictionary words.
 * All characters in s and wordDict are lowercase.
 */
package DP.Others;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gaurav kabra
 * @since July 23, 2021
 */

public class DictionaryWords {
	
	private static boolean wordBreak(String s, List<String> wordDict) {
		int len = s.length();
        boolean[] f = new boolean[len+1];
        f[0] = true;
        for (int i=1; i<len+1; i++)
            for (int j=0; j<i; j++)
                if (f[j] && wordDict.contains(s.substring(j,i)))
                {
                    f[i] = true;
                    break;
                }
        return f[len];
    }
	
	// driver - main method
	public static void main(String[] args) {
		// TESTCASES
		System.out.println(wordBreak("aam", new ArrayList<String>() {{
			add("a");
			add("aam");
		}}));
		System.out.println(wordBreak("thee", new ArrayList<String>() {{
			add("he");
			add("th");
		}}));
		System.out.println(wordBreak("ccaccc", new ArrayList<String>() {{
			add("cc");
			add("ac");
		}}));
	}

}
