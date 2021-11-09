/**
 * Saurav and Diya want to choose a restaurant for dinner,
 * and they both have a list of favorite restaurants represented by strings (There may be duplicates. In that case consider each).
 * Find out their common interest with the least list index sum.
 * If there is a choice tie between answers, output all of them with no order requirement.
 * You could assume there always exists an answer.
 */

package HashMap;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Arrays;

/**
 * @author gaurav kabra
 * @since 9 Nov 2021
 **/

public class MinIndexSum {

    /**
     * TC : O(N) as we traverse both lists
     * SC : O(N) in form of map and set
     */
    private static String[] findRestaurant(String[] list1, String[] list2) {
        // track min sum of indices in lists
        int min = Integer.MAX_VALUE;
        // key : restaurant name
        // value : [index, 0 or 1]
        // 0 if occurs only in first list or 1 if occurs in both lists
        Map<String, int[]> mp = new HashMap<>();
        String s;
        for(int i=0; i<list1.length; i++) {
            s = list1[i];
            mp.put(s, new int[] {i,0});
        }
        for(int i=0; i<list2.length; i++) {
            s = list2[i];
            if(mp.containsKey(s)) {
                mp.put(s, new int[] {mp.get(s)[0] + i, 1});
                if(min > mp.get(s)[0]) {
                    min = mp.get(s)[0];
                }
            }
        }
        Set<String> ans = new HashSet<>();
        for(Map.Entry<String, int[]> entry : mp.entrySet()) {
            // consider only those entries
            // for which value is min and occur in both lists
            if(entry.getValue()[0] == min && entry.getValue()[1] == 1) {
                ans.add(entry.getKey());
            }
        }
        // set to String[]
        return ans.toArray(new String[ans.size()]);
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASES
        System.out.println(Arrays.deepToString(findRestaurant(new String[] {"jayaka", "milan"},
                                            new String[] {"milan", "jayaka", "milan"})));
        System.out.println(Arrays.deepToString(findRestaurant(new String[] {"jayaka", "milan"},
                new String[] {"milan", "jayaka", "rawat"})));
    }
}
