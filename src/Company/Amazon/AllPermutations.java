/**
 * Given an array nums of distinct integers,
 * return all the possible permutations. You can return the answer in any order.
 */
package Company.Amazon;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gkabra
 * @since 31-01-2022 Mon
 **/

public class AllPermutations {

    private static void helper(int[] nums, boolean[] isUsed, List<Integer> permutation,
                               List<List<Integer>> ans) {
        if(permutation.size() == nums.length) {
            ans.add(new ArrayList<>(permutation));
            return;
        }
        for(int i=0; i<nums.length; i++) {
            if(isUsed[i]) {
                continue;
            }
            permutation.add(nums[i]);
            isUsed[i] = true;

            helper(nums, isUsed, permutation, ans);
            // backtrack
            permutation.remove(permutation.size()-1);
            isUsed[i] = false;
        }
    }

    // TC : O(N!) since N! permutations (as all are distinct)
    private static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> permutation = new ArrayList<>();
        boolean[] isUsed = new boolean[nums.length];
        helper(nums, isUsed, permutation, ans);
        return ans;
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASE
        System.out.println(permute(new int[] {1,2,3}));
    }

}
