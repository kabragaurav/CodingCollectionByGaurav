/**
 * Find the maximum nesting depth of parentheses expression
 */
package Miscellaneous.UniqueConcepts;

/**
 * @author gaurav kabra
 * @since 18 Dec 2021
 **/

public class MaxDepthOfParenthesis {

    /**
     * TC : O(N)
     * SC : O(1)
     */
    private static int maxDepth(String s) {
        int max = 0;
        int curr = 0;
        for(char ch : s.toCharArray()) {
            if(ch == '(') {
                curr++;
            } else if(ch == ')') {
                curr--;
            }
            max = Math.max(max, curr);
        }
        return max;
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASES
        System.out.println(maxDepth("8*((1*(5+6))*(8/6))"));
        System.out.println(maxDepth("(1+(2*3)+((8)/4))+1"));
    }
}
