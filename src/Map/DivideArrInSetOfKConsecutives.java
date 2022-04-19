/*

Variation #1
Given an array of integers nums and a positive integer k, check whether it is possible to divide this array
into sets of k consecutive numbers.
Return true if it is possible. Otherwise, return false.

Variation #2
Alice has some number of cards and she wants to rearrange the cards into groups so that each group is of
size groupSize, and consists of groupSize consecutive cards.
Given an integer array hand where hand[i] is the value written on the ith card and an integer groupSize,
return true if she can rearrange the cards, or false otherwise.

 */
package Map;

import java.util.TreeMap;

/**
 * @author gaurav kabra
 * @since 19/Apr/2022
 **/

public class DivideArrInSetOfKConsecutives {

    // TC : O(NlogN + N*k)
    // SC : O(N)
    private static boolean isPossibleDivide(int[] nums, int k) {

        int N = nums.length;
        if (N % k != 0) {
            return false;
        }

        TreeMap<Integer, Integer> mp = new TreeMap<>();

        for (int num : nums) {
            mp.put(num, mp.getOrDefault(num, 0) + 1);
        }

        for (int key : mp.keySet()) {
            int value = mp.get(key);

            if (value > 0) {
                for (int i=0; i<k; i++) {
                    if (mp.getOrDefault(key+i, 0) < value) {
                        return false;
                    }
                    mp.put(key+i, mp.get(key+i)-value);
                }
            }
        }

        return true;
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASE(S)
        System.out.println(isPossibleDivide(new int[] {3,3,2,2,1,1}, 3));
    }

}
