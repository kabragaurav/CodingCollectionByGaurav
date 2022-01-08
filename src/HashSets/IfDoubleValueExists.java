/**
 * Given an array arr of integers, check if there exists two integers N
 * and M such that N is the double of M ( i.e. N = 2 * M).
 */
package HashSets;

import java.util.HashSet;

/**
 * @author gaurav kabra
 * @since 08 Jan 2022
 **/

public class IfDoubleValueExists {

    /**
     * Logic:
     * For each number, check if its half or double exists. If yes, then return true.
     * Else at end return false.
     *
     * TC : O(N) for input {1,4,5,2}
     * SC : O(N) for using set
     */
    private static boolean checkIfExist(int[] arr) {
        HashSet<Integer> st = new HashSet<>();
        for(int num : arr) {
            int half = num/2;      // 3/2 = 1 but 1*2 != 3
            int twoTimes = num*2;

            if((st.contains(half) && half*2 == num) || st.contains(twoTimes)) {
                return true;
            }
            st.add(num);
        }
        return false;
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASES
        System.out.println(checkIfExist(new int[] {2,3,4,1}));
        System.out.println(checkIfExist(new int[] {1,3}));
    }
}
