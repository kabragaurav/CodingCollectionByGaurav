/**
 * Door Dash
 * Google Calendar, Outlook, iCal has been banned from your company! So an intrepid engineer has decided to roll their
 * own implementation.
 * Unfortunately one major missing feature is the ability to find out what time slots are free for a particular individual.
 *
 * OR
 *
 * Implement a function meetingPlanner that given the availability, slotsA and slotsB,
 * of two people and a meeting duration dur,
 * returns the earliest time slot that works for both of them and is of duration dur.
 * If there is no common time slot that satisfies the duration requirement, return an empty array.
 * Time is given in a Unix format called Epoch, which is a nonnegative integer holding the
 * number of seconds that have elapsed since 00:00:00 UTC, Thursday, 1 January 1970.
 * Each person’s availability is represented by an array of pairs. Each pair is an epoch array
 * of size two. The first epoch in a pair represents the start time of a slot. The second epoch
 * is the end time of that slot. The input variable dur is a positive integer that represents
 * the duration of a meeting in seconds. The output is also a pair represented by an epoch array
 * of size two.
 * In your implementation assume that the time slots in a person’s availability are disjointed,
 * i.e, time slots in a person’s availability don’t overlap. Further assume that the slots are
 * sorted by slots’ start time.
 */
package Company.Pramp;

import java.util.Arrays;

/**
 * @author gkabra
 * @since 19-02-2022 Sat
 **/

public class MeetingInterval {

    // TC : O(M+N)
    // SC : O(1)
    private static int[] meetingPlanner(int[][] slotsA, int[][] slotsB, int dur) {
        int pA = 0;
        int pB = 0;
        int lengthA = slotsA.length;
        int lengthB = slotsB.length;

        while (pA < lengthA && pB < lengthB) {
            int start = Math.max(slotsA[pA][0], slotsB[pB][0]);
            int end = Math.min(slotsA[pA][1], slotsB[pB][1]);

            if (start + dur <= end) {
                return new int[]{start, start + dur};
            } else if (slotsA[pA][1] < slotsB[pB][1]) {
                pA++;
            } else {
                pB++;
            }
        }

        return new int[] { };
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASES
        int[] ans = meetingPlanner(new int[][] {
                {7, 12}
        }, new int[][] {
                {2, 11}
        }, 5);
        Arrays.stream(ans).forEach(x -> System.out.println(x));

        ans = meetingPlanner(new int[][] {
                {10, 50}, {60, 120}, {140, 210}
        }, new int[][] {
                {0, 15}, {60, 70}
        }, 8);
        Arrays.stream(ans).forEach(x -> System.out.println(x));
    }

}
