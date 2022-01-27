/**
 * Given an integer array nums of unique elements, return all possible subsets (the power set).
 * The solution set must not contain duplicate subsets.
 * Return the solution in any order.
 */
package Company.Amazon;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author gkabra
 * @since 27-01-2022 Thu
 **/

public class PowerSet {

    private static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        HashSet<List<Integer>> st = new HashSet<>();
        int N = nums.length;

        int pow2ToN = 1 << (N+1);

        for(int i=0; i<pow2ToN; i++) {
            List<Integer> ls = new ArrayList<>();
            for(int j=0; j<N; j++) {
                if(((i>>j) & 1) == 1) {
                    ls.add(nums[j]);
                }
            }
            st.add(ls);
        }
        ans.addAll(st);

        return ans;
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASE
        System.out.println(subsets(new int[] {1,2,3}));
    }

}
