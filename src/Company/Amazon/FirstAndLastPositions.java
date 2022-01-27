package Company.Amazon;

import java.util.Arrays;

/**
 * @author gkabra
 * @since 27-01-2022 Thu
 **/

public class FirstAndLastPositions {

    private static int findFirstIndex(int[] nums, int target) {
        int index = -1;
        int start = 0, end = nums.length-1, mid;
        while(start <= end) {
            mid = start + (end-start)/2;
            if(nums[mid] == target) {
                index = mid;
            }
            if(nums[mid] < target) {
                start = mid+1;
            } else {
                end = mid-1;
            }
        }
        return index;
    }

    private static int findLastIndex(int[] nums, int target) {
        int index = -1;
        int start = 0, end = nums.length-1, mid;
        while(start <= end) {
            mid = start + (end-start)/2;
            if(nums[mid] == target) {
                index = mid;
            }
            if(nums[mid] <= target) {         // only difference from above method
                start = mid+1;
            } else {
                end = mid-1;
            }
        }
        return index;
    }

    private static int[] searchRange(int[] nums, int target) {
        int[] ans = new int[2];
        ans[0] = findFirstIndex(nums, target);
        ans[1] = findLastIndex(nums, target);
        return ans;
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASE
        Arrays.stream(searchRange(new int[] {1,2,2,2,2,4,5}, 2))
                .forEach(x -> System.out.println(x));
        Arrays.stream(searchRange(new int[] {1,2,3,4,6}, 5))
                .forEach(x -> System.out.println(x));
    }

}
