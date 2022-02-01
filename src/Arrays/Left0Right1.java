/**
 * Given a string s of zeros and ones, return
 * the maximum score after splitting the string into two non-empty substrings
 * (i.e. left substring and right substring).
 *
 * The score after splitting a string is the number of zeros in the left substring plus
 * the number of ones in the right substring.
 */
package Arrays;

/**
 * @author gkabra
 * @since 01-02-2022 Tue
 **/

public class Left0Right1 {

    // TC : O(N)
    // SC : O(N)
    private static int maxScore(String s) {
        int max = -1;
        int len = s.length();
        int[] zero = new int[s.length()];
        int[] one = new int[s.length()];

        zero[0] = s.charAt(0) == '0' ? 1 : 0;
        one[len-1] = s.charAt(len-1) == '1' ? 1 : 0;

        for(int i=1; i<len; i++) {
            zero[i] = zero[i-1] + (s.charAt(i) == '0' ? 1 : 0);
            one[len-i-1] = one[len-i] + (s.charAt(len-i-1) == '1' ? 1 : 0);
        }

        for(int i=0; i<s.length()-1; i++) {
            max = Math.max(max, zero[i]+one[i+1]);
        }

        return max;

    }

    /**
     * Logic:
     *  Max score = max(left 0s + right 1s)
     *            = max(left 0s + total 1s - left 1s)
     *            = max(left 0s - left 1s) + total 1s
     *
     *  TC : O(N)
     *  SC : O(1)
     */
    private static int maxScoreTrick(String s) {
        var ones = 0;
        var maxScore = Integer.MIN_VALUE;

        for (int i = 0, zeros = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0')
                zeros++;
            else
                ones++;
            if (i < s.length() - 1) // since we want non-empty partitions
                maxScore = Math.max(maxScore, zeros - ones);
        }

        return maxScore + ones;   // totalOnes
    }

    public static void main(String[] args) {
        String[] s = new String[] {
                "00",
                "1111",
                "1011101"
        };

        for(String str : s) {
            System.out.println(maxScore(str));
            System.out.println(maxScoreTrick(str));
        }
    }

}
