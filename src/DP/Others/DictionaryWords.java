/**
 * Amazon
 * Given a string s and a dictionary of strings wordDict, 
 * add spaces in s to construct a sentence where each word is a valid dictionary word. 
 * Return all such possible sentences in any order.
 * The same word in the dictionary may be reused multiple times in the segmentation.
 */

package DP.Others;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author gaurav kabra
 * @since July 23, 2021
 */

public class DictionaryWords {
	private static Map<String, List<String>> mp;
	
	private static List<String> wordBreak(String rightSoFar, List<String> wordDict) {
		
		/**
		 * Logic:
		 * We keep splitting the original string in two parts, leftString and rightSoFar.
		 * rightSoFar's size keeps reducing and leftString's size keeps increasing.
		 * 
		 * One possibility is whole string is in wordDict. If so, we add it to our result.
		 * Else we get a leftString from rightSoFar and check if leftString is in wordDict. If so, we recurse for remaining part.
		 */
		
		if(mp.containsKey(rightSoFar)) {
			return mp.get(rightSoFar);
		}
		List<String> ls = new ArrayList<>();
		if(wordDict.contains(rightSoFar)) {
			ls.add(rightSoFar);
		}
		for(int i=1; i<=rightSoFar.length(); i++) {
			String leftString = rightSoFar.substring(0, i);
			if(wordDict.contains(leftString)) {
				List<String> subList = wordBreak(rightSoFar.substring(i), wordDict);
				subList.forEach(subSentence -> {
					ls.add(leftString + " " + subSentence);
				});
			}
		}
		
		mp.put(rightSoFar, ls);
		return ls;
    }
	
	// driver - main method
	public static void main(String[] args) {
		// TESTCASES
		mp = new HashMap<>();
		System.out.println(wordBreak("aam", new ArrayList<String>() {{
			add("a");
			add("aam");
		}}));
		mp = new HashMap<>();
		System.out.println(wordBreak("thee", new ArrayList<String>() {{
			add("he");
			add("th");
		}}));
		mp = new HashMap<>();
		System.out.println(wordBreak("ccaccc", new ArrayList<String>() {{
			add("cc");
			add("ac");
		}}));
		mp = new HashMap<>();
		System.out.println(wordBreak("catsanddog", new ArrayList<String>() {{
			add("cat");
			add("cats");
			add("and");
			add("sand");
			add("dog");
		}}));
		mp = new HashMap<>();
		System.out.println(wordBreak("aaaaaaaaaaaaaaaaaaaa", new ArrayList<String>() {{
			add("a");
			add("aa");
			add("aaa");
			add("aaaa");
			add("aaaaa");
		}}));
	}

}
