/**
 * Amazon
 * Given two strings s and t, which represents a sequence of keystrokes, 
 * where # denotes a backspace, return whether or not the sequences produce the same result.
 */
package StacksAndQueues;

import java.util.Stack;

/**
 * @author gaurav kabra
 * @since June 2, 2021
 */
public class CompareKeyStrokes {
	/**
	 * @param string s
	 * @param string t
	 * @return true if after simulating #'s behavior, strings are equal. false otherwise.
	 * Time Complexity : O(N) since we trace strings linearly and put in stack and pop as required
	 * Space Complexity : O(N) since for storing each character in stack we need space. So a total of N.
	 */
	private boolean compareKeyStrokes(String s, String t) {
		// make separate stacks for each string to store characters
		Stack<Character> stk1 = new Stack<>();
		Stack<Character> stk2 = new Stack<>();
		
		// convert strings to character array (since stack is declared to contain character)
		char[] arr1 = s.toCharArray();
		char[] arr2 = t.toCharArray();
		
		// put character in stack if it is not #
		// If it is # then remove top element if stack is not empty. If stack is empty, do nothing (as there is no character, so pressing backspace does nothing)
		for(char ch : arr1) {
			if(ch == '#') {
				if(stk1.size() > 0) {
					stk1.pop();
				}
			}
			else {
				stk1.push(ch);
			}
		}
		
		for(char ch : arr2) {
			if(ch == '#') {
				if(stk2.size() > 0) {
					stk2.pop();
				}
			}
			else {
				stk2.push(ch);
			}
		}
		
		s = t = "";
		
		// again form strings with remaining characters in stack after backstroke
		while(stk1.size() > 0) {
			s += stk1.pop();
		}
		while(stk2.size() > 0) {
			t += stk2.pop();
		}
		
		return s.equals(t); 
	}

	public static void main(String[] args) {
		CompareKeyStrokes cks = new CompareKeyStrokes();
		
		System.out.println(cks.compareKeyStrokes("ABC#", "CD##AB"));
		System.out.println(cks.compareKeyStrokes("como#pur#ter", "computer"));
		System.out.println(cks.compareKeyStrokes("cof#dim#ng", "code"));
	}

}
