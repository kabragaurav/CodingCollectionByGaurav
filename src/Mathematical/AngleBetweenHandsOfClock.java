/**
 * Goldman Sachs Internship MNIT, 2019
 *
 * Given two numbers, hour and minutes, return the smaller angle (in degrees) formed
 * between the hour and the minute hand.
 *
 * Notes:
 *  Answers within 10^-5 of the actual value will be accepted as correct.
 *  1 <= hour <= 12
 *  0 <= minutes <= 59
 */
package Mathematical;

import java.util.Arrays;

/**
 * @author gauravkabra
 * @since 19/Mar/2022
 **/

public class AngleBetweenHandsOfClock {

    // TC : O(1)
    // SC : O(1)
    private static double angleClock(int hour, int minutes) {
        hour = hour == 12 ? 0 : hour;
        double totalHours = hour + minutes/60.0;
        double angleByHour = 30 * totalHours;
        double angleByMinutes = 6 * minutes;

        double angle = Math.abs(angleByHour - angleByMinutes);
        return Math.min(angle, 360-angle);
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASE
        System.out.println(angleClock(12, 30));
        System.out.println(angleClock(1, 0));
        System.out.println(angleClock(12, 0));
        System.out.println(angleClock(3, 15));

    }

}
