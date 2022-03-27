/*
You’re testing a new driverless car that is located at the Southwest (bottom-left) corner of an n×n grid.
The car is supposed to get to the opposite, Northeast (top-right), corner of the grid. Given n,
the size of the grid’s axes,
write a function numOfPathsToDest that returns the number of the possible paths the driverless car can take.

For convenience, let’s represent every square in the grid as a pair (i,j).
The first coordinate in the pair denotes the east-to-west axis, and the second coordinate denotes the south-to-north
axis. The initial state of the car is (0,0), and the destination is (n-1,n-1).

The car must abide by the following two rules: it cannot cross the diagonal border.
In other words, in every step the position (i,j) needs to maintain i >= j
 */
package Company.Pramp;

import java.util.Arrays;

/**
 * @author gaurav kabra
 * @since 27/Mar/2022
 **/

public class NumberOfPaths {

    private static int helper(int n, int currX, int currY, int ways, int[][] cache) {
        if (currX == n-1 && currY == n-1) {
            ways += 1;
            return ways;
        }

        if (currX > n || currX < currY) {
            return 0;
        }

        if (cache[currX][currY] != -1) {
            return cache[currX][currY];
        }

        return cache[currX][currY] = helper(n, currX+1, currY, ways, cache)
                + helper(n, currX, currY+1, ways, cache);
    }

    // TC : O(N^2)
    // SC : O(N)
    private static int numOfPathsToDest(int n) {
        int[][] cache = new int[n+1][n+1];
        Arrays.stream(cache)
                .forEach(x -> Arrays.fill(x, -1));
        return helper(n, 0, 0, 0, cache);
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASE
        System.out.println(numOfPathsToDest(5));
        System.out.println(numOfPathsToDest(2));
        System.out.println(numOfPathsToDest(1));
        System.out.println(numOfPathsToDest(1000));
    }

}
