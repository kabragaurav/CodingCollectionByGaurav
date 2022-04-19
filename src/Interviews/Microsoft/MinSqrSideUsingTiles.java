/*
Given M one-by-one tiles and N two-by-two tiles, what's the
largest side-length of a square that you can make if the square must be completely filled in the middle?
 */
package Interviews.Microsoft;

/**
 * @author gaurav kabra
 * @since 19/Apr/2022
 **/

public class MinSqrSideUsingTiles {

    private static int solution(int M, int N) {
        long maxLen = (long) Math.sqrt(4*N+M);   // max possible side of sqr

        if ((maxLen & 1) == 0) {               // so divided in 2x2
            return (int) maxLen;
        }
        long maxNConsumed = (maxLen-1) * (maxLen-1) / 4;  // usable 2x2
        long newMaxLenSquare = 4 * Math.min(maxNConsumed, N) + M;

        if (maxLen * maxLen <= newMaxLenSquare) {
            return (int) maxLen;
        }
        return (int) maxLen-1;

    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASE(S)
        System.out.println(solution(8,0));
        System.out.println(solution(0, 18));
        System.out.println(solution(11, 13));
    }

}
