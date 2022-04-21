/*
There is a fence with n posts, each post can be painted with one of the k colors.
You have to paint all the posts such that no more than two adjacent fence posts have the same color.
Return the total number of ways you can paint the fence.
n and k are non-negative integers.
 */
package Company.Google;

/**
 * @author gaurav kabra
 * @since 21/Apr/2022
 **/

public class PaintFence {

    private static int numWays(int n, int k) {

        if (n <= 0) {
            return 0;
        }

        int[] same = new int[n];
        int[] different = new int[n];
        int[] total = new int[n];

        same[0] = 0;
        different[0] = k;
        total[0] = same[0] + different[0];

        for (int i=1; i<n; i++) {
            same[i] = different[i-1];
            different[i] = (k-1) * total[i-1];
            total[i] = same[i] + different[i];
        }

        return total[n-1];

    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASE(S)
        System.out.println(numWays(3,2));
        System.out.println(numWays(2,2));
    }

}
