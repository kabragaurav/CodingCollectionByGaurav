/*
You have two types of tiles: a 2 x 1 domino shape and a tromino shape. You may rotate these shapes.
Given an integer n, return the number of ways to tile an 2 x n board. Since the answer may be very large, return
it modulo 10^9 + 7.

In a tiling, every square must be covered by a tile. Two tilings are different if and only if there are two
4-directionally adjacent cells on the board such that exactly one of the tilings has both squares occupied by a tile.
 */
package Company.Google.Tiling;

/**
 * @author gaurav kabra
 * @since 21/Apr/2022
 **/

public class DominoAndTromino {

    private static final int MOD = 1000000007;

    // TC : O(n)
    // SC : O(1)
    private static int numTilings(int n) {
        int a = 1;
        int b = 2;
        int c = 5;

        if (n == 1) {
            return a;
        }
        if (n == 2) {
            return b;
        }
        if (n == 3) {
            return c;
        }

        int ans = 0;
        for (int i=4; i<=n; i++) {
            ans = ((2 * c) % MOD + a % MOD) % MOD;
            a = b;
            b = c;
            c = ans;
        }

        return ans;
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASE(S)
        System.out.println(numTilings(3));
        System.out.println(numTilings(4));
        System.out.println(numTilings(1));
    }

}
