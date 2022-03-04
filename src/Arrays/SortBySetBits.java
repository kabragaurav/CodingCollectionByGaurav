/**
 * You are given an integer array arr.
 * Sort the integers in the array in ascending order by the number of 1's in their binary
 * representation and in case of two or more integers have the same number of 1's you
 * have to sort them in ascending order.
 * Return the array after sorting it.
 */
package Arrays;

/**
 * @author gkabra
 * @since 04-03-2022 Fri
 **/

import Arrays.Utils.ArrayUtils;

import java.util.Arrays;

public class SortBySetBits {

    private static int[] sortByBits(int[] nums) {
        Integer[] arr = Arrays.stream(nums).boxed().toArray( Integer[]::new);
        Arrays.sort(arr, (Integer num1, Integer num2) -> {
            int c1 = Integer.bitCount(num1);
            int c2 = Integer.bitCount(num2);
            if(c1 == c2) {
                return num1 - num2;
            }
            return c1 - c2;
        });
        int i = 0;
        for(int a : arr) {
            nums[i++] = a;
        }
        return nums;

    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASES
        ArrayUtils.printArray(sortByBits(new int[] {0,1,2,3,4,5,6,7,8}));
    }

}
