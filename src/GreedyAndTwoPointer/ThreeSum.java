/**
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]]
 * such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 * The solution must not contain duplicate triplets.
 */
package GreedyAndTwoPointer;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

/**
 * @author gaurav kabra
 * @since 18 Oct 2021
 **/

public class ThreeSum {
    /**
     * Logic:
     * The problem is an extension of two sum problem.
     * To avoid duplicate triplets, we first sort the input array.
     * Now we fix i and keep two pointers j and k that traverse right part of i,
     * in such a way to get sum 0. Also we move them such that duplicates are skipped.
     *
     * TC: O(NlogN) for sort + O(N^2) due to nested loops ~ O(N^2)
     * SC: O(1)
     *
     * Beautiful explanation: https://tinyurl.com/sum-three
     */
    private static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ls = new ArrayList<>();
        int N = nums.length;
        Arrays.sort(nums);
        List<Integer> subLs;

        for(int i=0; i<N; i++) {
            if(i>0 && nums[i] == nums[i-1]) {
                continue;
            }
            int j = i+1;
            int k = N-1;
            int sum;
            while(j < k) {
                sum = nums[i] + nums[j] + nums[k];
                if(sum == 0) {
                    subLs = new ArrayList<>();
                    subLs.add(nums[i]);
                    subLs.add(nums[j]);
                    subLs.add(nums[k]);
                    ls.add(subLs);
                    j++;
                    while(j<k && nums[j] == nums[j-1]) {
                        j++;
                    }
                } else if(sum < 0) {
                    j++;
                } else {
                    k--;
                }
            }
        }

        return ls;
    }
    
    // driver - main method
    public static void main(String[] args) {
        // TESTCASES
        int[][] arr = {
                {-1, 0, 1, 2, -1, -4},
                {},
                {0},
                {-2, 0, 0, 2, 2},
                {0, 0, 0}
        };
        for(int[] a : arr) {
            threeSum(a).stream().forEach(x -> System.out.print(x + "\n"));
        }
    }
}
