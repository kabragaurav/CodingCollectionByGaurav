/**
 * Google
 * Given two non-null strings s and t, return the minimum number of operations needed to convert s into t 
 * where a single operation consists of inserting a character, deleting a character, or replacing a character.
 */
package DP.Others;

import java.util.Arrays;

/**
 * @author gaurav kabra
 * @since July 21, 2021
 * 
 * Edit distance finds many useful application:
 * 1. Check plagarism
 * 2. Speech recognition
 * 3. DNA matching
 * Here is a great read: https://tinyurl.com/min-edit-dist-pdf
 */

public class EditDistance {
	
	private static int getMinEditDist(String word1, int start1, int end1, String word2, int start2, int end2, int[][] cache) {
		/**
		 * Logic:
		 * First we check out of bounds for strings
		 * case 1: rose, rose and start1 and start2 both point after 'e'
		 * case 2: rose, ros and start1 points at 'e' and start2 points after 's'
		 * case 3: ros, rose and start1 points after 's' and start2 points at 'e'
		 * 
		 * After these checks, we check if chars at start1 and start2 match. If so, then we move them both by +1 to right.
		 * Otherwise, we return min(replace, min(delete, insert))
		 * 
		 * In replacement in word1, we move both pointers by +1 to right. E.g. cat, bat
		 * In deletion in word1, we move only start1 by +1 to right. E.g. bta, ba
		 * In insertion in word1, we move only start2 by +1 to right. E.g. ba, bta
		 * 
		 * Time Complexity: Without cache[][], it is O(3^min(s1.length(),s2.length())) since we have 3 ways(replace, delete, insert) for each char in word1.
		 * 					With cache[][], it is O(s1.length() * s2.length())
		 * Space Complexity: O(s1.length() * s2.length()) in the form of cache[][]
		 * 
		 * The solutions like below are called top-down approach solutions.
		 * 
		 * Note that word1 and word2 are interchangeable. Answer will be the same since insertion in word1 means deletion in word2 and vice-versa.
		 */
		if(start1 > end1 && start2 > end2) {
			return 0;
		}
		if(start2 > end2) {
			return end1 - start1 + 1;
		}
		if(start1 > end1) {
			return end2 - start2 + 1;
		}
		if(cache[start1][start2] != 0) {
			return cache[start1][start2];
		}
		if(word1.charAt(start1) == word2.charAt(start2)) {
			return cache[start1][start2] = getMinEditDist(word1, start1+1, end1, word2, start2+1, end2, cache);
		}
		return cache[start1][start2] = 1 + Math.min(
					getMinEditDist(word1, start1+1, end1, word2, start2+1, end2, cache),   // replace 
					Math.min(
								getMinEditDist(word1, start1+1, end1, word2, start2, end2, cache),	// delete 
								getMinEditDist(word1, start1, end1, word2, start2+1, end2, cache)	// insert
							)
				);
	}
	
	private static int minDistance(String word1, String word2) {
        if(word1.equals(word2)) {
            return 0;
        }
        int[][] cache = new int[word1.length()][word2.length()];
        return getMinEditDist(word1, 0, word1.length()-1, word2, 0, word2.length()-1, cache);
    }
	
	// driver - main method
	public static void main(String[] args) {
		// TESTCASES
		String[][] words = new String[][] {
			{"", ""},
			{"beach", "batch"},
			{"cat", "bat"},
			{"horse", "ros"},
			{"intention", "execution"},
			{"dinitrophenylhydrazine", "acetylphenylhydrazine"}
		};
		Arrays.stream(words).forEach(word -> System.out.println(minDistance(word[0], word[1])));
	}

}
