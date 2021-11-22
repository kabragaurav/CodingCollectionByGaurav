/**
 * Given an integer array nums of size n, return the minimum number of moves required to make all array elements equal
 * In one move, you can increment n - 1 elements of the array by 1.
 */
package Mathematical;

import java.util.stream.Collectors;
import java.util.Arrays;

/**
 * @author gaurav kabra
 * @since 22 Nov 2021
 **/

public class MinMovesToEqualArray {

    // Logic - https://tinyurl.com/min-moves-equal-arr
    private static int minMoves(int[] nums) {

        // find sum of all numbers in nums
        int sum = Arrays.stream(nums)
                        .boxed()
                        .collect(Collectors.toList())
                        .stream()
                        .reduce(0, (x, y) -> x+y);
        Arrays.sort(nums);      // No need for Collections.reverseOrder()

        // FORMULA
        // minMoves = sum - len x min
        return sum - nums.length * nums[0];
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASE
        System.out.println(minMoves(new int[]{1,2,3}));
    }
}
