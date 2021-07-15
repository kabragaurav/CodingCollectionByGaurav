/**
 * Google
 * Given a string, return whether or not it uses capitalization correctly. 
 * A string correctly uses capitalization if all letters are capitalized, 
 * no letters are capitalized, or only the first letter is capitalized.
 */
package Strings;
/**
 * @author gaurav kabra
 * @since May 21, 2021
 */
public class CorrectCapitalization {
	
	/**
	 * Check for correct capitalization Using regex
	 * @param string s
	 * @return boolean, if correctly capitalized
	 * Time: Should be O(N). But the actual depends on Deterministic Finite Automaton (DFA) for regex
	 * Space: O(1) since we require constant space
	 */
	private boolean isCorrectlyCapitalizedUsingRegex(String s) {
		/**
		 * Logic:
		 * We are actually just doing patten matching - whether a given string matches a patten criterion
		 * So we can use regex. We have 3 cases:
		 * all small then [a-z]*
		 * all capital then [A-Z]*
		 * First letter capital and rest all small then [A-Z][a-z]*
		 * If any one of the above three criteria matches then we return true. 
		 */
		return s.matches("[a-z]*|[A-Z]*|[A-Z][a-z]*");  // Note that there is no space among conditions
	}
	
	/**
	 * Check for correct capitalization
	 * @param string s
	 * @return boolean, if correctly capitalized
	 * Time: O(N) as string comparison using equals method
	 * Space: O(1) as we don't use any extra space
	 */
	private boolean isCorrectlyCapitalized(String s) {
		/**
		 * Logic:
		 * First check first character's case.
		 * If it is capitalized, we have two cases:
		 * 			We need to check for correct capitalization either remaining chars should be all caps or all small
		 * Else:
		 * 			remaining chars should be all small
		 */
		if(s == null || s.isEmpty())
			return true;
		
		char firstChar = s.charAt(0);
		// check if first char is capital or small case
		boolean isCapital = (firstChar >= 'A' && firstChar <= 'Z');
		
		if(isCapital) {
			String secondOnwards = s.substring(1);
			String secondOnwardsUpperCase = secondOnwards.toUpperCase();
			String secondOnwardsLowerCase = secondOnwards.toLowerCase();
			
			return secondOnwards.equals(secondOnwardsUpperCase) || secondOnwards.equals(secondOnwardsLowerCase);		
		}
		// else all chars should be small case
		else {
			for(int i=1; i<s.length(); i++) {
				if(s.charAt(i) > 'z' || s.charAt(i) < 'a')
					return false;
			}
		}
		// if we reach here that means string is correctly capitalized
		return true;
		
	}
	
	// driver - main method
	public static void main(String[] args) {
		CorrectCapitalization cc = new CorrectCapitalization();
		
		// TESTCASES
		System.out.println(cc.isCorrectlyCapitalized("USA"));
		System.out.println(cc.isCorrectlyCapitalized("Calvin"));
		System.out.println(cc.isCorrectlyCapitalized("compUter"));
		System.out.println(cc.isCorrectlyCapitalized("coding"));
		
		System.out.println(cc.isCorrectlyCapitalizedUsingRegex("USA"));
		System.out.println(cc.isCorrectlyCapitalizedUsingRegex("Calvin"));
		System.out.println(cc.isCorrectlyCapitalizedUsingRegex("compUter"));
		System.out.println(cc.isCorrectlyCapitalizedUsingRegex("coding"));
	}

}
