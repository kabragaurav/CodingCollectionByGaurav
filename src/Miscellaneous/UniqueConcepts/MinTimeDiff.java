/*
Given a list of 24-hour clock time points in "HH:MM" format,
return the minimum minutes difference between any two time-points in the list.
 */
package Miscellaneous.UniqueConcepts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author gaurav kabra
 * @since 17/Apr/2022
 **/

public class MinTimeDiff {

    // TC : O(N)
    // SC : O(1) since at max ls.size() = 24 * 60 = 1440
    private static int findMinDifference(List<String> times) {
        List<Integer> ls = new ArrayList<>();

        for (String time : times) {
            String[] split = time.split("\\:");
            int hr = Integer.parseInt(split[0]);
            int min = Integer.parseInt(split[1]);
            ls.add(hr * 60 + min);
        }

        Collections.sort(ls);

        int N = ls.size();
        int min = Integer.MAX_VALUE;

        for (int i=0; i<N; i++) {
            int diff = Math.abs(ls.get((i+1)%N) - ls.get(i));  // circular difference, so using % N
            diff = Math.min(diff, 1440-diff);                  // take min of clockwise diff and anticlockwise diff
            min = Math.min(min, diff);
        }

        return min;
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASE(S)
        System.out.println(findMinDifference(new ArrayList<>() {{
            add("12:12");
            add("00:13");
        }}));
        System.out.println(findMinDifference(new ArrayList<>() {{
            add("12:01");
            add("00:10");
        }}));
        System.out.println(findMinDifference(new ArrayList<>() {{
            add("00:00");
            add("23:59");
            add("00:00");
        }}));
        System.out.println(findMinDifference(new ArrayList<>() {{
            add("01:39");
            add("10:26");
            add("21:43");
        }}));

    }

}
