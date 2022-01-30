/**
 * You are given an array arr[] of size n.
 * Find the total count of sub-arrays having their sum equal to 0.
 */
package Company.Amazon;

import java.util.HashMap;

/**
 * @author gkabra
 * @since 30-01-2022 Sun
 **/

public class ZeroSumSubarray {

    /**
     * Logic:
     * If you see a sum again, then the array traversed after first one has total sum = 0.
     *
     * TC : O(N)
     * SC : O(N)
     */
    private static long findSubarray(long[] arr ,int n) {
        HashMap<Integer, Integer> mp = new HashMap<>();
        int sum = 0;
        long count = 0;
        for(int i=0; i<arr.length; i++) {
            sum += arr[i];
            if(mp.containsKey(sum)) {
                count += mp.get(sum);
                mp.put(sum, mp.get(sum)+1);
            } else {
                mp.put(sum, 1);
            }
        }
        return count+mp.getOrDefault(0, 0);     // include 0's as well
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASES
        System.out.println(findSubarray(new long[] {0,0,5,5,0,0}, 6));
        System.out.println(findSubarray(new long[] {6,-1,-3,4,-2,2,4,6,-12,-7}, 10));
    }

}
