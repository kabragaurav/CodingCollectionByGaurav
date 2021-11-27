/**
 * Given a string s containing only three types of characters:
 * '(', ')' and '*', return true if s is valid.
 *
 * The following rules define a valid string:
     * Any left parenthesis '(' must have a corresponding right parenthesis ')'.
     * Any right parenthesis ')' must have a corresponding left parenthesis '('.
     * Left parenthesis '(' must go before the corresponding right parenthesis ')'.
     * '*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string "".
 */
package Miscellaneous.UniqueConcepts;

/**
 * @author gaurav kabra
 * @since 27 Nov 2021
 **/

public class ValidParenthesisWithAsterisk {

    /*
        Logic:
        There are 3 valid cases:
        1 - There are as many '(' than ')' so all parenthesis are balanced, we can ignore the extra '*'
        2- There are more open parenthesis but we have enough '*' so we can balance the parenthesis with ')'
        3- There are more close parenthesis but we have enough '*' so we can balance the parenthesis with '('

        So, parse the String twice, once from left to right by replacing all '*' by '(' and once from right to left by replacing all '*' by ')'

     */
    private static boolean checkValidString(String s) {
        int leftBalance = 0, rightBalance = 0;
        int N = s.length();

        // parse : left -> right
        for(int i=0; i<N; i++) {
            char ch = s.charAt(i);
            leftBalance += ch == '(' || ch == '*' ? 1 : -1;
            // if at any index, we find leftBalance < 0 that means it is like (*))))
            if(leftBalance < 0) {
                return false;
            }
        }

        // ( and * can balance out )
        if(leftBalance == 0) {
            return true;
        }

        // parse : right -> left
        // We are not doing left -> right due to "(*)"
        for(int i=N-1; i>=0; i--) {
            char ch = s.charAt(i);
            rightBalance += ch == ')' || ch == '*' ? 1 : -1;
            // if at any index, we find rightBalance < 0 that means it is like (((*)
            if(rightBalance < 0) {
                return false;
            }
        }
        return true;
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASES
        System.out.println(checkValidString("()"));
        System.out.println(checkValidString("(*)"));
        System.out.println(checkValidString("(**)"));
        System.out.println(checkValidString("(*))"));
    }
}
