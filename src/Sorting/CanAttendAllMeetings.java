/**
 * Given an array of meeting time intervals consisting of start and end times
 * [[s1,e1],[s2,e2],...] where si < ei, determine if a person can attend all meetings.
 */
package Sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author gkabra
 * @since 22-01-2022 Sat
 **/

class Interval {
     int start, end;
     Interval(int start, int end) {
         this.start = start;
         this.end = end;
     }
}

public class CanAttendAllMeetings {

    // TC : O(NlogN) for sorting + O(N) for one traversal ~ O(NlogN) overall
    // SC : O(1)
    private static boolean canAttendMeetings(List<Interval> intervals) {        // could have been List<int[]> as well
        Collections.sort(intervals, (a, b) -> a.start - b.start);

        for(int i=0; i<intervals.size()-1; i++) {
            int endTime = intervals.get(i).end;
            int startTime = intervals.get(i+1).start;
            if(endTime > startTime) {
                return false;
            }
        }
        return true;
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASE
        System.out.println(canAttendMeetings(new ArrayList<>() {{
            add(new Interval(10, 20));
            add(new Interval(10, 15));
            add(new Interval(20, 30));
        }}));
    }

}
