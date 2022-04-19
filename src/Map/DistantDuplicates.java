/**
 * Google
 * Given an integer array nums and an integer k, return true if there are
 * two distinct indices i and j in the array such that nums[i] == nums[j] and abs(i - j) <= k.
 */
package Map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author gaurav kabra
 * @since 4 Sept 2021
 **/

class DistantDuplicates {
    private static boolean containsNearbyDuplicate(int[] nums, int k) {
        /**
         * Logic:
         * We maintain a map, mp, of numbers in nums and their indices where they have appeared.
         * We iterate over nums
         *      if we already have that number in mp
         *          if so we find distance if <= k. If so return true
         *       else
         *          we add fresh list having that index to mp
         * return false since we could not find such a pair.
         *
         * Time Complexity : O(N) since we iterate over nums and O(1) for map operations
         * Space Complexity : O(1) since we use a map and in worst case all numbers are distinct
         */
        Map<Integer, List<Integer>> mp = new HashMap<>();
        for(int i=0; i<nums.length; i++) {
            if(mp.get(nums[i]) != null) {
                List<Integer> ls = mp.get(nums[i]);
                for(int x : ls) {
                    if(i-x <= k) {
                        return true;
                    }
                }
                ls.add(i);
                mp.put(nums[i], ls);

            } else {
                List<Integer> ls = new ArrayList<>();
                ls.add(i);
                mp.put(nums[i], ls);
            }
        }
        return false;
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASE
        System.out.println(containsNearbyDuplicate(new int[] {1,0,1,1},1));
    }
}
