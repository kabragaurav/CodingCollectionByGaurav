package Company.Amazon;

/**
 * @author gkabra
 * @since 27-01-2022 Thu
 **/

public class SearchInSortedRotatedArray {

    private static int search(int[] nums, int target) {
        int N = nums.length;
        int left = 0;
        int right = N-1;
        while(left <= right) {
            int mid = left + (right-left)/2;
            if(nums[mid] == target) {
                return mid;
            }
            if(nums[left] <= nums[mid]) {        // left part sorted
                if(nums[left] <= target && target <= nums[mid]) {
                    right = mid-1;
                } else {
                    left = mid+1;
                }
            } else {
                if(nums[mid] <= target && target <= nums[right]) {
                    left = mid+1;
                } else {
                    right = mid-1;
                }
            }
        }
        return -1;
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASES
        System.out.println(search(new int[] {4,5,6,0,1,2,3}, 2));
        System.out.println(search(new int[] {4,5,6,0,1,3}, 2));
    }

}
