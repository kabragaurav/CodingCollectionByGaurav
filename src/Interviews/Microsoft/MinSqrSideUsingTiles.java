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

    /*
        CodeForces : https://tinyurl.com/sqr-and-tiles
        We can not build a square having length greater than sqrt(4*n+m).

        Let x=sqrt(4*n+m).

        if x is even then the whole x by x grid can be divide into 2 by 2 squares.
        So we will use the maximum possible 2 by 2 squares and since 4*n+m>=x*x so simply x is the answer.

        if x is odd then the maximum possible 2 by 2 squares that can be used is ((x-1)*(x-1))/4; Let val1=((x-1)*(x-1))/4.

        So 2 by 2 squares used will be min(val1,n); now if 4*min(val1,n)+m>=x*x then x is answer otherwise x-1 is the answer.
     */
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
