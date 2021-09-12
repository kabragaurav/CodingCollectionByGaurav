/**
 * Given an array of points where points[i] = [xi, yi] represents a point on the XY plane
 * and an integer K, return the K closest points to the origin (0, 0) according to the Eclidean distance.
 * Answer can have points in any order.
 */
package Miscellaneous.UniqueConcepts;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author gaurav kabra
 * @since 12 Sept 2021
 **/

public class KClosestPoints {

    private class Pair {
        int x, y;
        double dist;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
            this.dist = getDistFromOrigin();
        }

        int[] get2DRepr() {
            return new int[] {this.x, this.y};
        }

        double getDistFromOrigin() {
            return Math.sqrt(Math.pow(this.x, 2) + Math.pow(this.y, 2));
        }
    }

    private class Comp implements Comparator<Pair> {
        public int compare(Pair p1, Pair p2) {
            if(p1.dist < p2.dist) {
                return -1;
            }
            return 1;
        }
    }

    private int[][] kClosest(int[][] points, int K) {
        /**
         * Logic:
         * Since we want K closest points, we will first need to find distance of each point from origin as per Euclidean distance.
         * And then we will pickup K minimum distances, which can be achieved by min heap (Priority Queue in Java by default is min heap).
         */
        PriorityQueue<Pair> minPq = new PriorityQueue<>(points.length, new Comp());

        for(int[] point : points) {
            Pair p = new Pair(point[0], point[1]);
            minPq.add(p);
        }

        int[][] ans = new int[K][];
        for(int i=0; i<K; i++) {
            int[] a = minPq.poll().get2DRepr();
            ans[i] = a;
        }

        return ans;
    }

    // driver - main method
    public static void main(String[] args) {
        KClosestPoints kcp = new KClosestPoints();

        // TESTCASE
        System.out.println(Arrays.deepToString(kcp.kClosest(new int[][] {
                {1,3},{-2,2}
        }, 1)));
    }
}
