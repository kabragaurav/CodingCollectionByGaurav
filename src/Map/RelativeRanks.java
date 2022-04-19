/**
 * You are given an integer array score of size n, where score[i] is the score of the ith athlete in a competition.
 * All the scores are guaranteed to be unique.
 * The athletes are placed based on their scores, where the 1st place athlete has the highest score,
 * the 2nd place athlete has the 2nd highest score, and so on.
 * The placement of each athlete determines their rank:
         * The 1st place athlete's rank is "Gold Medal".
         * The 2nd place athlete's rank is "Silver Medal".
         * The 3rd place athlete's rank is "Bronze Medal".
 * For the 4th place to the nth place athlete, their rank is their placement number
 * (i.e., the xth place athlete's rank is "x").
 * Return an array answer of size n where answer[i] is the rank of the ith athlete.
 */
package Map;

import java.util.*;

/**
 * @author gaurav kabra
 * @since 23 Nov 2021
 **/

public class RelativeRanks {

    private static final Map<Integer, String> mp = new HashMap<>() {{
        put(1, "Gold Medal");
        put(2, "Silver Medal");
        put(3, "Bronze Medal");
    }};

    /**
     * Logic:
     * We create a copy of original array and sort it descending to know ranks.
     * For first 3, we find their index in original array and replace them with string : gold, silver or bronze.
     * For rest, we replace like 4,5,6....
     *
     * TC : O(N)
     * SC : O(N) due to list and copy of array
     */
    private static String[] findRelativeRanks(int[] score) {
        Integer[] temp = Arrays.stream(score).boxed().toArray( Integer[]::new);
        Arrays.sort(temp, Collections.reverseOrder());

        List<Integer> scoreList = new ArrayList<>();
        for(int t : score) {
            scoreList.add(t);
        }

        String[] ans = new String[score.length];
        for(int i=0; i<score.length && i<3; i++) {
            ans[scoreList.indexOf(temp[i])] = mp.get(i+1);
        }
        for(int i=3; i<score.length; i++) {
            ans[scoreList.indexOf(temp[i])] = "" + (i+1);
        }

        return ans;
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASES
        int[][] scores = {
                {5,4,3,2,1},
                {10,3,8,9,4},
                {1}
        };

        for(int[] score : scores) {
            System.out.println(Arrays.deepToString(findRelativeRanks(score)));
        }

    }
}
