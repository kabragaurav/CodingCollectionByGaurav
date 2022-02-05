/**
 * Given an array of integers nums and a positive integer k,
 * check whether it is possible to divide this array into sets of k consecutive numbers.
 */
package HashMap;

import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * @author gkabra
 * @since 05-02-2022 Sat
 **/

public class DivideArrayInSetsOfKConsecutiveNums {

    /**
     * Logic:
     * We need to find k groups of consecutive numbers.
     *
     * So to find min in each group, use PriorityQueue.
     * And to find if consecutive numbers are present, we use HashMap.
     *
     * TC :
     *      insertion in pq -> O(logN)
     *      insertion in mp -> O(1) assuming hashcode is distributing keys uniformly
     *      size of pq -> O(1)
     *      peek for pq -> O(1)
     *      containsKey for mp -> O(1)
     *      put in mp -> O(1)
     *      remove in mp -> O(1)
     *      remove in pq -> O(logN)
     *
     *      And this is done till empty -> overall O(NlogN)
     *
     * SC : O(N) for pq and mp
     */
    private static boolean isPossibleDivide(int[] nums, int k) {
        if(nums.length % k != 0) {
            return false;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        HashMap<Integer, Integer> mp = new HashMap<>();

        for(int num : nums) {
            pq.add(num);
            mp.put(num, mp.getOrDefault(num, 0) + 1);
        }

        while(!pq.isEmpty()) {
            int min = pq.peek();

            for(int i=0; i<k; i++) {
                int consecutive = min+i;
                if(!mp.containsKey(consecutive)) {
                    return false;
                }
                mp.put(consecutive, mp.get(consecutive)-1);
                pq.remove(consecutive);
                if(mp.get(consecutive) == 0) {
                    mp.remove(consecutive);
                }
            }
        }
        return true;
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASES
        System.out.println(isPossibleDivide(new int[] {1,2,3,3,2,1}, 3));
        System.out.println(isPossibleDivide(new int[] {1,2,3,4}, 3));
        System.out.println(isPossibleDivide(new int[] {1,2,3,3,4,4,5,6}, 4));
    }

}
