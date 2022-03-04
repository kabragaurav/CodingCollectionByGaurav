/**
 * Given an integer array sorted in non-decreasing order, there is exactly one
 * integer in the array that occurs more than 25% of the time, return that integer.
 */
package Arrays;

/**
 * @author gkabra
 * @since 04-03-2022 Fri
 **/

public class OccurMoreThanOneFourth {

    // TC : O(N) if we find number at last
    // SC : O(1)
    private static int findSpecialInteger(int[] arr) {
        int oneFourth = arr.length/4;
        for(int i=0; i<arr.length-oneFourth; i++) {
            if(arr[i] == arr[i+oneFourth]) {
                return arr[i];
            }
        }
        return -1;
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASE
        System.out.println(findSpecialInteger(new int[] {1,2,2,6,6,6,6,7,10}));
    }

}
