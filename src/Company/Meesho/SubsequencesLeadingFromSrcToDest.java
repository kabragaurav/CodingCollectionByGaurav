/*
Swiggy, Meesho, Square Point Capital
Jamie is walking along a number line that starts at point 0 and ends at point n.
She can move either one step to the left or one step to the right of her current location ,
with the exception that she cannot move left from point 0 or right from point n. In other words,
if Jamie is standing at point i,she can move to either i-1 or i+1 as long as her destination exists
in the inclusive range [0,n]. She has a string ,s , of movement instruction consisting of the
letters l and r , where l is an instruction to move one step left and r is an instruction to move
one step right.
Jamie followed the instructions in s one by one and in order.
For Example if s=‘rrlr’,she performs the following sequence of moves :
one step right ->one step right ->one step left -> one step right.
Jamie wants to move from point x to point y following some subsequence of string s instruction and
wonders how many distinct possible subsequence of string s will get her from point x to point y.
 */
package Company.Meesho;

import java.util.HashSet;

/**
 * @author gaurav kabra
 * @since 18/May/2022
 **/

public class SubsequencesLeadingFromSrcToDest {
    private static HashSet<String> w;

    private static int ways(String s, int N, int src, int dest) {
        w = new HashSet<>();
        helper(s, 0, src, dest, N, "");
        return w.size();
    }

    private static void helper(String s, int i, int curr, int dest, int N, String path) {

        if (curr == dest) {
            w.add(path);
        }

        if (i == N) {
            return;
        }

        helper(s, i+1, curr, dest, N, path);

        char ch = s.charAt(i);
        if (ch == 'l') {
            if (curr > 0)
                helper(s, i+1, curr-1, dest, N, path + "l");
        } else {
            if (curr < N-1)
                helper(s, i+1, curr+1, dest, N, path + "r");
        }
    }


    // driver - main method
    public static void main(String[] args) {
        // TESTCASE(S)
        System.out.println(ways("rrlrlr", 6, 1, 2));
    }

}
