/**
 * Given an integer array nums with possible duplicates, randomly output the index of
 * a given target number.
 * You can assume that the given target number must exist in the array.
 */
package Miscellaneous.UniqueConcepts;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

/**
 * @author gkabra
 * @since 19-02-2022 Sat
 **/

public class RandomPickIndex {

    private HashMap<Integer, List<Integer>> mp = new HashMap<>();

    public RandomPickIndex(int[] nums) {
        for(int i=0; i<nums.length; i++) {
            int num = nums[i];
            List<Integer> ls;
            if(mp.containsKey(num)) {
                ls = mp.get(num);
            } else {
                ls = new ArrayList<>();
            }
            ls.add(i);
            mp.put(num, ls);
        }
    }

    // TC : O(N) for storing all numbers + O(1) for random ~ O(N) overall
    // SC : O(N)
    public int pick(int target) {
        List<Integer> ls = mp.get(target);
        int index = new Random().nextInt(ls.size());
        return ls.get(index);
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASE
        RandomPickIndex randomPickIndex = new RandomPickIndex(new int[] {1,2,3,3,3});
        System.out.println(randomPickIndex.pick(3));
        System.out.println(randomPickIndex.pick(1));
        System.out.println(randomPickIndex.pick(3));
    }

}
