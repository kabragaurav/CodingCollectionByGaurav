package Miscellaneous.UniqueConcepts;

/**
 * @author gaurav kabra
 * @since 28/Mar/2022
 **/

public class LongestSubarrOf1AfterDeleting {

    /*
    Just calculate the max sum of counts of prev Ones and after Ones for each non-ones;
    prev: counts of prev Ones
    next: counts of Ones after.
    Corner cases:
        - If all ones, must remove one.

        TC : O(N)
        SC : O(1)
    */
    private static int longestSubarray(int[] nums) {
        int ans = 0;
        int prev = 0;
        int next = 0;
        int N = nums.length;

        for (int i=0; i<N; i++) {
            if (nums[i] == 0) {
                ans = Math.max(ans, prev + next);
                prev = next;
                next = 0;
            } else {
                next++;
            }
        }

        ans = Math.max(ans, prev + next);
        return ans == N ? ans-1 : ans;
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASE
        System.out.println(longestSubarray(new int[] {1,1,0,1}));
    }

}
