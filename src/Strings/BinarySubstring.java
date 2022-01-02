/**
 * Given a binary string s, return the number of contiguous substrings that contains the
 * same number of zeroes and ones.
 * Each substring’s zeroes and ones must be grouped together.
 * E.g. 0011 can be one substring but 0110 cannot be as 0s and 1s are not contiguous in this substring.
 */
package Strings;

/**
 * @author gaurav kabra
 * @since 02 Jan 2022
 **/

public class BinarySubstring {

    /**
     * Logic:
     * Use two pointer approach.
     *
     * TC : Less than O(N^2)
     * SC : O(1)
     */
    private static int countBinarySubstrings(String s) {
        char[] charr = s.toCharArray();
        int ans = 0;

        for(int i=0; i<charr.length-1; i++) {
            int j = i;
            int zeros = 0;
            int ones = 0;
            if(charr[i] == '0') {
                while( j < charr.length && charr[j] == '0') {
                    zeros++;
                    j++;
                }
                while( j < charr.length && charr[j] == '1') {
                    ones++;
                    if(ones == zeros) {
                        ans++;
                        break;
                    }
                    j++;
                }
            } else {
                while( j < charr.length && charr[j] == '1') {
                    ones++;
                    j++;
                }
                while( j < charr.length && charr[j] == '0') {
                    zeros++;
                    if(ones == zeros) {
                        ans++;
                        break;
                    }
                    j++;
                }
            }
        }

        return ans;
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASE
        System.out.println(countBinarySubstrings("00110011"));
    }
}
