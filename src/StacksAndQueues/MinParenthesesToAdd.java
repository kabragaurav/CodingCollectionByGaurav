/*
A parentheses string is valid if and only if:

    It is the empty string,
    It can be written as AB (A concatenated with B), where A and B are valid strings, or
    It can be written as (A), where A is a valid string.

You are given a parentheses string s. In one move, you can insert a parenthesis at any position
of the string.

    For example, if s = "()))", you can insert an opening parenthesis to be "(()))" or a closing
    parenthesis to be "())))".

Return the minimum number of moves required to make s valid.
 */
package StacksAndQueues;

import java.util.Stack;

/**
 * @author gaurav kabra
 * @since 10/Apr/2022
 **/

public class MinParenthesesToAdd {

    // TC : O(N)
    // SC : O(N)
    private static int minAddToMakeValid(String s) {
        Stack<Character> stk = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (stk.isEmpty() || stk.peek() == ')') {
                stk.push(ch);
            } else {
                if (stk.peek() == '(' && ch == ')') {
                    stk.pop();
                } else {
                    stk.push(ch);
                }
            }
        }
        return stk.size();
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASE(S)
        System.out.println(minAddToMakeValid("()))"));
    }

}
