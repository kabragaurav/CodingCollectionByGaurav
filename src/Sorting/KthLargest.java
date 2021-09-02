package Sorting;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @author gaurav kabra
 * @since 2 Spet 2021
 **/

public class KthLargest {

    private static int findKthLargest(int[] nums, int k) {
        return Arrays.stream(nums)                  // IntStream
                .sorted()                           // Ascending IntStream
                .boxed()                            // Stream<Integer> -- each element boxed into Integer
                .collect(Collectors.toList())       // Convert to List
                .get(nums.length-k);                // Kth largest will be length-K from beginning
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASE
        System.out.println(findKthLargest(new int[] {3,2,1,5,6,4}, 2));
    }
}
