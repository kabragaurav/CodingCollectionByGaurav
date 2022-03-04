/**
 * There is a broken calculator that has the integer startValue
 * on its display initially. In one operation, you can:
 *
 *     multiply the number on display by 2, or
 *     subtract 1 from the number on display.
 *
 * Given two integers startValue and target, return the minimum number of operations
 * needed to display target on the calculator.
 */
package Mathematical;

/**
 * @author gkabra
 * @since 04-03-2022 Fri
 **/

public class BrokenCalculator {

    /**
     * Logic:
     * The best way to get to taregt was from target/2; and the best way to get to target/2 was from target/2/2 and so on.
     *
     * TC : O(log(target/startValue))
     * SC : O(1)
     */
    private static int brokenCalc(int startValue, int target) {
        int step = 0;

        while(target > startValue) {
            if(target % 2 == 1) {
                target++;
            } else {
                target /= 2;
            }
            step++;
        }

        return step + (startValue - target);
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASES
        System.out.println(brokenCalc(1024, 1));
        System.out.println(brokenCalc(5, 8));
    }

}
