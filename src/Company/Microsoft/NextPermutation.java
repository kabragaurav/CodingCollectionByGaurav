/*
    Given an array of integers nums, find the next permutation of nums.
    The replacement must be in place and use only constant extra memory.
 */
package Company.Microsoft;

/**
 * @author gaurav kabra
 * @since 08/Apr/2022
 **/

public class NextPermutation {

    /*
        This is pure trick based question.
        If you have solved it, that's the only key.

        See Solution tab's animation here https://tinyurl.com/next-perm
     */
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;

        // first decreasing element
        for (; i>=0; i--) {
            if (nums[i] < nums[i+1]) {
                break;
            }
        }

        // first number from end, which is greater than nums[i]
        if (i >= 0) {
            int j = nums.length - 1;

            for (; j>i; j--) {
                if (nums[j] > nums[i]) {
                    break;
                }
            }
            // swap these two
            swap(nums, i, j);
        }

        // reverse from i+1 to end
        int left = i+1;
        int right = nums.length-1;
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }

    }

    private static void swap(int[] nums, int l, int r) {
        int t = nums[l];
        nums[l] = nums[r];
        nums[r] = t;
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASE(S)
    }

}
