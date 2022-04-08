package Company.Microsoft;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author gaurav kabra
 * @since 08/Apr/2022
 **/

public class MinMeetingRooms {

    private static class Pair {
        int f;
        int l;

        Pair(int f, int l) {
            this.f = f;
            this.l = l;
        }
    }

    /*
        TC : O(NlogN) where N = A.length (sorting)
        SC : O(N)

        Excellent concise article : https://tinyurl.com/min-meeting-rooms
     */
    private static int meetingRooms(ArrayList<ArrayList<Integer>> A) {
        List<Pair> ls = new ArrayList<>();
        Pair t;
        for (ArrayList<Integer> arr : A) {
            t = new Pair(arr.get(0), 0);
            ls.add(t);
            new ArrayList<Pair>();
            t = new Pair(arr.get(1), 1);
            ls.add(t);
        }

        Collections.sort(ls, (x, y) -> x.f-y.f);

        int runningCount = 0;
        int max = Integer.MIN_VALUE;                    // It should not be initialized with 0

        for (int i=0; i<ls.size(); i++) {
            Pair curr = ls.get(i);
            if (curr.l == 1) {
                runningCount--;
            } else {
                runningCount++;
            }
            max = Math.max(max, runningCount);          // note it is updated outside if and else block. It is imp
        }

        return max;
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASE(S)
        // [0,5,10,15,20,30]
        ArrayList<ArrayList<Integer>> ls  = new ArrayList<>() {{
            add(new ArrayList<>() {{
                add(0);
                add(5);
            }});
            add(new ArrayList<>() {{
                add(10);
                add(15);
            }});
            add(new ArrayList<>() {{
                add(20);
                add(30);
            }});
        }};
        System.out.println(meetingRooms(ls));
    }

}
