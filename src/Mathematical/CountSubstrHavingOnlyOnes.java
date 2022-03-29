/*
Given a binary string s,
return the number of substrings with all characters 1's. Since the answer may be too large, return it modulo 109 + 7.
 */
package Mathematical;

/**
 * @author gaurav kabra
 * @since 29/Mar/2022
 **/

public class CountSubstrHavingOnlyOnes {

    private static final int MOD = (int) 1e9 + 7;

    // TC : O(N)
    // SC : O(1)
    private static int numSub(String s) {
        int count = 0;
        long ones = 0;

        for (int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '0') {
                count += (ones * (ones + 1) / 2) % MOD;
                ones = 0;
            } else {
                ones++;
            }
        }

        count += (ones * (ones + 1) / 2) % MOD;
        return (int) count % (int) MOD;

    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASE
        System.out.println(numSub("0110111"));
    }

}
