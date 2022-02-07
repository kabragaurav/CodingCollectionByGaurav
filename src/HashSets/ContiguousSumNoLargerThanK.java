/**
 * Given an array of non-negative integers and a sum. We have to find sum
 * of the subarray having a maximum sum less than or equal to the given K in the array.
 */
package HashSets;

import java.util.TreeSet;

/**
 * @author gkabra
 * @since 07-02-2022 Mon
 **/

public class ContiguousSumNoLargerThanK {

    /**
     * Logic:
     * TreeSet:
     * TreeSet uses Red-Black tree underlying.
     * So the set could be thought as a dynamic search tree.
     * When you need a structure which is operated read/write frequently and also should keep order,
     * the TreeSet is a good choice.
     *
     * Sum of subarray [i, j] is given by (sumSoFar till j – sumSoFar till i).
     * Now the problem reduces to finding two indexes i and j such that i < j and cum[j] – cum[i] are as close to K
     * but lesser than it.
     * To solve this, iterate the array from left to right. Put the cumulative sum of i values that you
     * have encountered till now into a set. When you are processing sumSoFar[j] what you need to retrieve from the
     * set is the smallest number in the set which is bigger than sumSoFar[j] – K.
     * This can be done in O(logN) using ceiling() on the set.
     *
     * TC : O(NlogN)
     * SC : O(N)
     */
    private static int maxSubarraySum(int[] nums, int K) {
        int sumSoFar = 0;
        TreeSet<Integer> st = new TreeSet<>();
        int ans = Integer.MIN_VALUE;
        st.add(0);
        for(int i=0; i<nums.length; i++) {
            sumSoFar += nums[i];
            // sumSoFar - left <= K
            // so sumSoFar - K <= left
            Integer left = st.ceiling(sumSoFar-K);
            if(left != null) {
                ans = Math.max(ans, sumSoFar-left);
            }
            st.add(sumSoFar);
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(maxSubarraySum(
                new int[] {1, 2, 3, 4, 5}, 11
        ));
        System.out.println(maxSubarraySum(
                new int[] {2, 4, 6, 8, 10}, 7
        ));
    }

}
