/**
 * You are given an array coordinates, coordinates[i] = [x, y], where [x, y]
 * represents the coordinate of a point.
 * Check if these points make a straight line in the XY plane.
 */
package Mathematical;

/**
 * @author gaurav kabra
 * @since 01 Jan 2022
 **/

public class StraightLineOrNot {

    /**
     * TC : O(N) due to check for all points
     * SC : O(1)
     */
    private static boolean checkStraightLine(int[][] coordinates) {
        int N = coordinates.length;

        // two points are always in straight line
        if(N<=2) {
            return true;
        }

        // slope (m)
        // m = (y2-y1) / (x2-x1)
        double m = (1.0 * coordinates[1][1] - coordinates[0][1])/
                (coordinates[1][0] - coordinates[0][0]);

        // if line is vertical, m = Infinite
        // then just check if all x are same
        if(Double.isInfinite(m)) {
            for(int i=2; i<N; i++) {
                if(coordinates[i][0] != coordinates[0][0]) {
                    return false;
                }
            }
            return true;
        } else {
            // y = mx + c should be satisfied by all points to be in straight line
            double c = (coordinates[0][1] - m * coordinates[0][0]);
            for(int i=2; i<N; i++) {
                double y = m * coordinates[i][0] + c;

                if(y != coordinates[i][1]) {
                    return false;
                }
            }
            return true;
        }
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASE
        System.out.println(checkStraightLine(new int[][] {{0,0},{0,1},{0,-1}}));
    }
}
