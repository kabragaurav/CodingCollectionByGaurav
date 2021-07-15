/**
 * Google
 * Given a string containing digits from 2-9 inclusive, each number maps to set of characters just like on a dial pad.
 * Return all possible letter combinations that the number could represent if pressed in that order(any number can be pressed any non-zero number of times). 
 * Return the answer in any order.
 */
package Miscellaneous.UniqueConcepts;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author gaurav kabra
 * @since July 2, 2021
 */
public class DialPadPermutation {
	
	// mapping for dial-pad
	private final HashMap<Character,String> dialPad = new HashMap<>(){{
        put('2',"abc");
        put('3',"def");
        put('4',"ghi");
        put('5',"jkl");
        put('6',"mno");
        put('7',"pqrs");
        put('8',"tuv");
        put('9',"wxyz");
    }} ;
    
    // our final answer declaration
    List<String> ls;
    
    private void dfs(int currentIndex, String digits, StringBuilder sb) {
        if(currentIndex == digits.length()) {
            ls.add(sb.toString());
        }
        else {
            String dialPadChars = dialPad.getOrDefault(digits.charAt(currentIndex), "");
            
            // for each character, take one at a time and keep creating string
            for(int i=0; i<dialPadChars.length(); i++) {
                dfs(currentIndex+1, digits, new StringBuilder(sb).append(dialPadChars.charAt(i)));
            }
        }
    }
    public List<String> letterCombinations(String digits) {
        ls = new ArrayList<>();
        if(digits.length() == 0)
            return ls;					// if digits length is 0, return empty list
        dfs(0, digits, new StringBuilder());
        return ls;
    }
    
    // driver - main method
	public static void main(String[] args) {
		// TESTCASE
		System.out.println(new DialPadPermutation().letterCombinations("23"));
	}

}
