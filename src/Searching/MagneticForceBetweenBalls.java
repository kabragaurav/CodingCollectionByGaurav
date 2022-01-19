/**
 * In the universe Earth C-137, Rick discovered a special form of magnetic force between two balls
 * if they are put in his new invented basket. Rick has n empty baskets,
 * the ith basket is at position[i], Rick has m balls and needs to distribute the balls into
 * the baskets such that the minimum magnetic force between any two balls is maximum.
 * Rick stated that magnetic force between two different balls at positions x and y is |x - y|.
 * Given the integer array position and the integer m. Return the required force.
 *
 * constraints: position[] : [1...10^9]
 */
package Searching;

import java.util.Arrays;

/**
 * @author gkabra
 * @since 19-01-2022 Wed
 **/

public class MagneticForceBetweenBalls {

    // mid is like minDistance
    private static boolean canPlaceMBalls(int[] position, int mid, int m) {
        int idx = 0;                            // index for position[]
        int lastPos = position[idx++];          // start placing balls
        int ballsPlaced = 1;

        while(idx < position.length && ballsPlaced < m) {
            int currPos = position[idx];
            if(currPos-lastPos >= mid) {    // so we can place another ball
                lastPos = currPos;
                ballsPlaced++;
            }
            idx++;
        }

        return ballsPlaced == m;        // able to place all m balls?
    }

    private static int binarySearch(int[] position, int m) {
        // cover constraints
        int left = 1;
        int right = (int) Math.pow(10, 9);        // constraints

        while(left < right) {
            int mid = left + (right-left)/2;
            // we have to place all m balls. Check if we can do so
            if(!canPlaceMBalls(position, mid, m)) {
                right = mid;
            } else {
                left = mid+1;
            }
        }

        return left-1;
    }

    // TC : O(NlogN) due to sort
    // SC : O(1)
    private static int maxDistance(int[] position, int m) {
        // sort for applying binary search
        Arrays.sort(position);
        return binarySearch(position, m);
    }


    public static void main(String[] args) {
        System.out.println(maxDistance(new int[] {1,2,3,4,7}, 3));
        System.out.println(maxDistance(new int[] {5,4,3,2,1,1000000000}, 2));
    }

}
