/**
 * Given a string s consisting of characters, either 'X' or 'O'.
 * A move is defined as selecting three consecutive characters of s and converting them to 'O'.
 * If a move is applied to the character 'O', it will stay the same.
 * Return the minimum number of moves required so that all the characters of s are converted to 'O'.
 */
package Strings;

/**
 * @author gaurav kabra
 * @since 14 Oct 2021
 **/

public class MinMovesToConvertStr {

    /**
     * Logic:
     * Whenever we encounter 'X', we can convert next three characters (including this 'X') to 'OOO'
     * So in that case we increment count.
     * Now since we want minimum moves, we jump to three next indices after encountering 'X'.
     * If we don't encounter 'X', just jump one index ahead.
     *
     * TC: O(N), traverse s once
     * SC: O(1)
     */
    private static int minimumMoves(String s) {
        int ans = 0;
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) == 'X') {
                ans++;
                i += 2;
            }
        }
        return ans;
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASES
        System.out.println(minimumMoves("XXX"));
        System.out.println(minimumMoves("OOOO"));
        System.out.println(minimumMoves("XXOX"));
        System.out.println(minimumMoves("OXOX"));
    }
}
