/**
 * Facebook
 * Given N points on a Cartesian plane, return the minimum time required to visit all points
 * in the order that they’re given.
 * You start at the first point and can move one unit vertically, horizontally or diagonally
 * in a single second.
 */
package Mathematical;

/**
 * @author gaurav kabra
 * @since 16 August 2021
 **/

public class TravelToPoints {
    public static int minTimeToVisitAllPoints(int[][] points) {
        /**
         * Logic:
         * Draw a catesian plane and there points from the testcases.
         * You will understand that we have to traverse minimum distance equal to maximum of the differences (y2-y1), (x2-x1).
         *
         * Time Complexity: O(N) to iterate over all N points
         * Space Complexity : O(1)
         */
        int startX = points[0][0], startY = points[0][1];
        int time = 0;

        for(int i=1; i<points.length; i++) {
            int endX = points[i][0], endY = points[i][1];
            int diffX = Math.abs(endX - startX);
            int diffY = Math.abs(endY - startY);
            time += (diffX > diffY ? diffX : diffY);
            startX = endX;
            startY = endY;
        }
        return time;
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASES
        System.out.println(minTimeToVisitAllPoints(new int[][] {{0,0}, {1,1}, {2,2}}));
        System.out.println(minTimeToVisitAllPoints(new int[][] {{0,1}, {2,3}, {4,0}}));
    }
}
