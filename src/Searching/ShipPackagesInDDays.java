/**
 * A conveyor belt has packages that must be shipped
 * from one port to another within D days.
 * The i-th package on the conveyor belt has a weight of weights[i].
 * Each day, we load the ship with packages on the conveyor belt
 * in the order given by weights[]. We may not load more weight than
 * the maximum weight capacity of the ship.
 *
 * Return the least weight capacity of the ship that will result in all the packages
 * on the conveyor belt being shipped within D days.
 */
package Searching;

import java.util.Arrays;

/**
 * @author gkabra
 * @since 19-01-2022 Wed
 **/

public class ShipPackagesInDDays {

    private static boolean transferredInExactDdays(int[] weights, int mid, int days) {
        int idx = 0;
        int totalWeight = 0;
        int daysDone = 1;       // it's always day 1 :)

        while(idx < weights.length) {
            totalWeight += weights[idx];
            if(totalWeight > mid) {
                totalWeight = weights[idx];     // reset
                daysDone++;                     // and move to next day
                if(daysDone > days) {
                    return false;
                }
            }
            idx++;
        }

        return true;
    }


    /**
     * Solution is same as SplitArrayLargestSum.java
     *
     * Logic:
     * We are looking for the minimal one among all feasible capacities.
     * If we can successfully ship all packages within D days with capacity m,
     * then we can definitely ship them all with any capacity larger than m.
     * Now we can design a condition function, let's call it transferredInExactDdays().
     * Given an input capacity (mid), it returns whether it's possible to ship all packages within D days.
     * If there's still room for the current package, we put a package onto the conveyor belt, otherwise we wait
     * for the next day to place this package.
     * If the total days needed exceeds D, we return False, otherwise we return True.
     *
     * Next, we need to initialize our boundary correctly. Obviously capacity at left should be at least max(weights),
     * otherwise the conveyor belt couldn't ship the heaviest package.
     * On the other hand, capacity at right need not be more than sum(weights), because then we can ship all packages
     * in just one day.
     */
    private static int shipWithinDays(int[] weights, int days) {
        int left = Arrays.stream(weights).max().getAsInt();
        int right = Arrays.stream(weights).sum();

        while(left < right) {
            int mid = left + (right-left)/2;
            if(transferredInExactDdays(weights, mid, days)) {
                right = mid;
            } else {
                left = mid+1;
            }
        }

        return left;
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASE
        /**
         * 1st day: 1, 2, 3, 4, 5
         * 2nd day: 6, 7
         * 3rd day: 8
         * 4th day: 9
         * 5th day: 10
         */
        System.out.println(shipWithinDays(new int[] {1,2,3,4,5,6,7,8,9,10}, 5));
    }

}
