/**
 * Given three integer arrays nums1, nums2, and nums3,
 * return an array containing all the values that are present in at least two out of the three arrays.
 * Array may contain the values in any order.
 */
package Arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.Arrays;

/**
 * @author gaurav kabra
 * @since 14 Oct 2021
 **/

public class LeastTwoOfThree {

    /**
     * Logic:
     * Since one array may have duplicates, we first remove that using set.
     * This will ensure, we count frequency of a number in different arrays corectly.
     * Then we maintain a map to keep a numbers frequency, traversing all the three arrays.
     * We return list of numbers having frequency >= 2.
     *
     * TC: O(N)
     * SC: O(N)
     *
     * Main thing to note is :
     * How to convert an array to set and back to array.
     */
    private static List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        Map<Integer, Integer> mp = new HashMap<>();

        nums1 = Arrays.stream(nums1).boxed().collect(Collectors.toSet())
                .stream().mapToInt(Number::intValue).toArray();
        nums2 = Arrays.stream(nums2).boxed().collect(Collectors.toSet())
                .stream().mapToInt(Number::intValue).toArray();
        nums3 = Arrays.stream(nums3).boxed().collect(Collectors.toSet())
                .stream().mapToInt(Number::intValue).toArray();

        for(int num : nums1) {
            mp.put(num, mp.getOrDefault(num, 1));
        }

        for(int num : nums2) {
            mp.put(num, mp.getOrDefault(num, 0) + 1);
        }

        for(int num : nums3) {
            mp.put(num, mp.getOrDefault(num, 0) + 1);
        }

        List<Integer> ls = new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry : mp.entrySet()) {
            if(entry.getValue() >= 2) {
                ls.add(entry.getKey());
            }
        }
        return ls;
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASE
        twoOutOfThree(new int[]{1, 2, 2},
                        new int[]{4,3,3},
                        new int[]{5}).stream().forEach(x -> System.out.print(x+" "));
    }
}
