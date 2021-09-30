package Strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author gaurav kabra
 * @since 30 Sept 2021
 **/

public class ShortestDistToChar {

    private static int getMinDist(int i, int[] arr) {
        int min = Integer.MAX_VALUE, diff;
        for(int x : arr) {
            diff = Math.abs(i-x);
            min = Math.min(min, diff);
        }
        return min;
    }

    /**
     * Logic:
     * We first store all indices of c in a list, indexOfC.
     * Then we iterate s and for each index we find minimum difference between current index and indices in indexOfC.
     *
     * TC : O(N) since we iterate s twice.
     * AS : O(N) since we use auxiliary space in storing indices and in worst case s contains only character c.
     */
    private static int[] shortestDistToChar(String s, char c) {
        int N = s.length();
        List<Integer> indexOfC = new ArrayList<>();
        for(int i=0; i<N; i++) {
            char ch = s.charAt(i);
            if(ch == c) {
                indexOfC.add(i);
            }
        }
        int[] arr = indexOfC.stream()
                .mapToInt(Integer::intValue)
                .toArray();
        int[] ans = new int[N];
        for(int i=0; i<N; i++) {
            ans[i] = getMinDist(i, arr);
        }
        return ans;
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASES
        int[] ans = shortestDistToChar("Gaurav Kabra", ' ');
        System.out.println(Arrays.toString(ans));
        ans = shortestDistToChar("Gaurav Kabra", 'a');
        System.out.println(Arrays.toString(ans));
        ans = shortestDistToChar("aaaaa", 'a');
        System.out.println(Arrays.toString(ans));
    }
}
