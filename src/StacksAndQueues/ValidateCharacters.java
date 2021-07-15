/**
 * Google
 * Given a string only containing the following characters (, ), {, }, [, and ] 
 * return whether or not the opening and closing characters are in a valid order.
 */
package StacksAndQueues;

import java.util.Stack;
/**
 * @author gaurav kabra
 * @since June 2, 2021
 */
public class ValidateCharacters {
	
	/**
	 * @param string s
	 * @return true if valid arrangement of parentheses. false otherwise.
	 * Time Complexity: O(N) since we trace string linearly.
	 * Space Complexity: O(N) since we use auxiliary space in form of stack to store characters of string.
	 */
	private boolean validateCharacters(String s) {
		/**
		 * We use stack to store characters.
		 * If it is (, { or [ then we simply store it
		 * Else if it is ), } or ] then we check:
		 * 		 if stack is empty
		 * 		or if corresponding parentheses if not at top (e.g. for ), ( is corresponding parentheses)
		 * If any condition is true, then we return false immediately.
		 * At last we check if stack if empty (say when s = "({["). If so, we return true, else false.
		 */
		Stack<Character> stk = new Stack<>();
		
		for(char ch : s.toCharArray()) {
			if(ch == '(' || ch == '{' || ch == '[') {
				stk.push(ch);
			}
			else {
				if(stk.isEmpty()
					|| (ch == ']' && stk.peek() != '[')
					|| (ch == '}' && stk.peek() != '{')
					|| (ch == ')' && stk.peek() != '(')
					) {
					return false;
				}
				else {
					stk.pop();
				}
			}
		}
		return stk.isEmpty();
	}

	public static void main(String[] args) {
		ValidateCharacters vc = new ValidateCharacters();
		
		System.out.println(vc.validateCharacters("(){}[]"));
		System.out.println(vc.validateCharacters("(({[]}))"));
		System.out.println(vc.validateCharacters("{(})"));
	}

}
