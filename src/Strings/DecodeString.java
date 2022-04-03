/*
Given an encoded string, return its decoded string.

The encoding rule is: k[encoded_string], where the encoded_string inside the square
brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.

You may assume that the input string is always valid; there are no extra white spaces, square brackets
are well-formed, etc.

Furthermore, you may assume that the original data does not contain any digits and that digits are only
for those repeat numbers, k. For example, there will not be input like 3a or 2[4].
 */
package Strings;

import java.util.Stack;

/**
 * @author gaurav kabra
 * @since 03/Apr/2022
 **/

public class DecodeString {

    // TC : O(N)
    // SC : O(N)
    private static String decodeString(String input) {
        Stack<Character> stk = new Stack<>();

        for (char ch : input.toCharArray()) {
            if (ch == ']') {
                StringBuilder s = new StringBuilder();
                while (!stk.isEmpty() && !Character.isDigit(stk.peek())) {
                    if (stk.peek() == '[') {
                        stk.pop();
                        continue;
                    }
                    s.append(stk.pop());
                }

                StringBuilder repeat = new StringBuilder();
                while (!stk.isEmpty() && Character.isDigit(stk.peek())) {
                    repeat.append(stk.pop());
                }
                int r = Integer.parseInt(repeat.reverse().toString());
                String finalRepeat = "";
                String reversedS = s.reverse().toString();
                for (int i=0; i<r; i++) {
                    finalRepeat += reversedS;
                }

                for (char c : finalRepeat.toCharArray()) {
                    stk.push(c);
                }

            } else {
                stk.push(ch);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!stk.isEmpty()) {
            sb.append(stk.pop());
        }
        return sb.reverse().toString();

    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASE(S)
        System.out.println(decodeString("3[a2[c]]"));
    }

}
