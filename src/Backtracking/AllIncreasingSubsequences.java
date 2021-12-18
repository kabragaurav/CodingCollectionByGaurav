/**
 * Given an integer array nums, return
 * all the different possible increasing subsequences of the given array with at least two elements.
 * You may return the answer in any order.
 *
 * The given array may contain duplicates, and two equal integers should also be considered a
 * special case of increasing sequence.
 */
package Backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author gaurav kabra
 * @since 18 Dec 2021
 **/

public class AllIncreasingSubsequences {

    private static Set<List<Integer>> setOfLists;

    private static void backtrack(List<Integer> oneList, int[] nums, int curr) {
        // if size is >=2 include it in final result
        if(oneList.size() >= 2) {
            setOfLists.add(new ArrayList<>(oneList));   // creating new list makes sure modifying existing does not impact final result
        }
        for(int i=curr; i<nums.length; i++) {
            // if list is empty, directly add number
            // else if last number <= current number, then also add the number
            if(oneList.size() == 0 || oneList.get(oneList.size()-1) <= nums[i]) {
                oneList.add(nums[i]);                           // add
                backtrack(oneList, nums, i+1);
                oneList.remove(oneList.size()-1);         // remove - backtrack
            }
        }
    }

    /**
     * Logic:
     * Use backtracking. Why? Because once we want to consider, once we don't want to.
     * E.g. [4,6,7] then once [4,6,7] and once [4,7]
     */
    private static List<List<Integer>> findSubsequences(int[] nums) {
        setOfLists = new HashSet<>();       // so as no duplicates such as [4,7] and [4,7]
        backtrack(new ArrayList<>(), nums, 0);
        return new ArrayList<>(setOfLists);
    }

    public static void main(String[] args) {

    }
}
