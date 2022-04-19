/**
 * Amazon
 * Given two strings representing sentences, return the words that are not common to both strings AND appear exactly once.
 * (i.e. the words that only appear in one of the sentences). 
 * You may assume that each sentence is a sequence of words (without punctuation) correctly separated
 * using space characters.
 */
package Map;

import java.util.HashMap;
import java.util.Map;
/**
 * @author gaurav kabra
 * @since May 23, 2021
 */
public class UncommonWords {
	
	private String[] getUncommonWordsIntuitive(String s1, String s2) {
		/**
		 * Logic:
		 * We store words in strings in map along with their frequency.
		 * If they repeat then their frequency will be > 1.
		 * We return words that have frequency = 1.
		 * Time: O(N) since we trace strings linearly and the time complexity for map operations is O(1)
		 * Space: O(N) N = total number of words in strings (since we store words in map and in worst case, all words are different)
		 */
		 String[] arr1 = s1.split(" ");
		 String[] arr2 = s2.split(" ");
			
		 Map<String, Integer> mp = new HashMap<>();
			
		for(String str : arr1)
			mp.put(str, mp.getOrDefault(str, 0)+1);
		for(String str : arr2)
			mp.put(str, mp.getOrDefault(str, 0)+1);
		
		String ans = "";
		for(Map.Entry<String, Integer> e : mp.entrySet()) {
			if(e.getValue() == 1)
				ans += e.getKey()+" ";
		}
		String[] ret = ans.split(" ");
		if(ret[0]=="")
            return new String[0];
        return ret;
	}
	
	/**
	 * @param string s1
	 * @param string s2
	 * @return array of uncommon words (that appear only one and in only one of the strings)
	 */
	private String[] getUncommonWords(String s1, String s2) {
		/**
		 * Logic:
		 * We create two array of words in respective Strings.
		 * Then for first array, we put value=1 for each word.
		 * Then for second array:
		 * 		if word is already there in map, we set its value=-1 that indicates that the word is there in first string.
		 * 		Else we put value=1
		 * 
		 * At last we trace map and return only words that have value NOT equal to -1 (i.e. have value 1)
		 * Time: O(N) since we trace strings linearly and the time complexity for map operations is O(1)
		 * Space: O(N) N = total number of words in strings (since we store words in map and in worst case, all words are different)
		 */
		String[] arr1 = s1.split(" ");
		String[] arr2 = s2.split(" ");
		
		Map<String, Integer> mp = new HashMap<>();
		
		for(String str : arr1)
            if(mp.get(str) != null)
			    mp.put(str, -1);
            else 
                mp.put(str, 1);
		for(String str : arr2) {
			if(mp.get(str) != null)
				mp.put(str, -1);
			else 
				mp.put(str, 1);
		}
		String ans = "";
		for(Map.Entry<String, Integer> e : mp.entrySet()) {
			if(e.getValue() != -1)
				ans += e.getKey()+" ";
		}
		String[] ret = ans.split(" ");
        if(ret[0]=="")
            return new String[0];
        return ret;
	}
	
	// helper method to main
	// prints array in readable format
	private void displayArr(String[] arr) {
		for(String s : arr)
			System.out.print(s+" ");
		System.out.println();
	}
	
	// driver - main method
	public static void main(String[] args) {
			UncommonWords uw = new UncommonWords();
			
			// TESTCASES
			uw.displayArr(uw.getUncommonWords("the quick", "brown fox"));
			uw.displayArr(uw.getUncommonWords("the tortoise beat the haire", "the tortoise lost to the haire"));
			uw.displayArr(uw.getUncommonWords("copper coffee pot", "hot coffee pot"));
			uw.displayArr(uw.getUncommonWords("apple apple", "banana"));
			
			uw.displayArr(uw.getUncommonWordsIntuitive("the quick", "brown fox"));
			uw.displayArr(uw.getUncommonWordsIntuitive("the tortoise beat the haire", "the tortoise lost to the haire"));
			uw.displayArr(uw.getUncommonWordsIntuitive("copper coffee pot", "hot coffee pot"));
			uw.displayArr(uw.getUncommonWordsIntuitive("apple apple", "banana"));
	}

}
