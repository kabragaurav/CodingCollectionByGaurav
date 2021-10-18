/**
 * Given N non-negative integers a1, a2, ..., an , where each represents a very thin vertical wall at coordinate (i, ai), 0 <= i < N.
 * Find two walls, which, together with the x-axis forming a container, such that the container contains the most water.
 */
package GreedyAndTwoPointer;

/**
 * @author gaurav kabra
 * @since 16 Oct 2021
 **/

public class WaterContainer {

    /**
     * Logic:
     * We will use two-pointer approach, left and right.
     * left moves from left to right. And right moves from right to left.
     *
     * While left < right
     *
     * Calculate current area using min height of heights at left and right (else water will flow out)
     * and compare with previous area save the maximum area inside ans.
     *
     * if left is smaller or equal to right, increment left
     * else decrement right
     * NOTE: if left = right then it doesn't matter, if we increment left or decrement right.
     *
     * TC: O(N) due to two-pointer approach
     * SC: O(1) since extra space does not depend on size of height[]
     */
    private static int maxArea(int[] height) {
        int ans = 0;
        int left = 0;
        int right = height.length-1;
        int leftHeight, rightHeight, tempArea;

        while(left < right) {
            leftHeight = height[left];
            rightHeight = height[right];
            tempArea = Math.min(leftHeight, rightHeight) * (right-left);   // area = length x width
            ans = Math.max(ans, tempArea);

            if(leftHeight <= rightHeight) {
                left++;
            } else {
                right--;
            }

        }
        return ans;
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASES
        System.out.println(maxArea(new int[] {
                1,8,6,2,5,4,8,3,7
        }));
        System.out.println(maxArea(new int[] {
                1,8,9,7
        }));
        System.out.println(maxArea(new int[] {
                1,1
        }));
    }
}
