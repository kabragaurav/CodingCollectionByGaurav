package Company.Amazon;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gkabra
 * @since 27-01-2022 Thu
 **/

public class GenerateAllBalancedParenthesis {

    private static List<String> ls;

    // TC : Exponential
    private static void helper(int N, String s, int leftCount, int rightCount) {
        if(s.length() == N) {
            ls.add(s);
            return;
        }
        if(leftCount <  (N/2)) {
            helper(N, s+'(', leftCount+1, rightCount);
        }
        if(leftCount > rightCount) {
            helper(N, s+')', leftCount, rightCount+1);
        }
    }

    private static List<String> generateParenthesis(int N) {
        helper(2*N, "", 0, 0);
        return ls;
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASE
        ls = new ArrayList<>();
        System.out.println(generateParenthesis(3));
    }

}
