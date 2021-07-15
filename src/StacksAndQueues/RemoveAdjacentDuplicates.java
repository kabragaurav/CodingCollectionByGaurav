/**
 * Facebook
 * Given a string s containing only lowercase letters, 
 * continuously remove adjacent characters that are the same and return the result.
 */
package StacksAndQueues;

import java.util.Stack;

/**
 * @author gaurav kabra
 * @since June 2, 2021
 */
public class RemoveAdjacentDuplicates {
	
	private String getAdjacentDuplicatesRemoved(String s) {
		/**
		 * We will use a stack to keep characters as we trace the string.
		 * But before pushing character in stack, we check if top of stack is same as character we want to push(using peek()).
		 * If so then we remove top element(using pop()) and discard the character as well (so removing adjacent characters)
		 * If not then we push the character
		 * 
		 * At last we keep poping from stack and build StringBuilder object from it.
		 * Reverse it and return its equivalent String object as answer.
		 * 
		 * Time Complexity : O(N) since we trace String once and then pop stack once (worst case is no duplicates)
		 * Space Complexity : O(N) in the form of stack (worst case is no duplicates)
		 */
		Stack<Character> stk = new Stack<>();
		
		for(char ch : s.toCharArray()) {
			if(!stk.isEmpty() && stk.peek() == ch) {
				stk.pop();
			}
			else {
				stk.push(ch);
			}
		}
		
		StringBuilder sb = new StringBuilder();
		
		while(!stk.isEmpty()) {
			sb.append(stk.pop());
		}
		
		sb.reverse();
		return new String(sb);    // return sb.toString(); will also work
	}

	
	// driver - main method
	public static void main(String[] args) {
		RemoveAdjacentDuplicates rad = new RemoveAdjacentDuplicates();
		
		// TESTCASES
		System.out.println(rad.getAdjacentDuplicatesRemoved("abccba"));
		System.out.println(rad.getAdjacentDuplicatesRemoved("foobar"));
		System.out.println(rad.getAdjacentDuplicatesRemoved("abccbefggfe"));
	}

}
