/**
 * Amazon, Microsoft
 *
 * Given a sorted array arr of distinct integers, write a function indexEqualsValueSearch
 * that returns the lowest index i for which arr[i] == i. Return -1 if there is no such index.
 */
package Company.Pramp;
/**
* @author gkabra
* @since 20-02-2022 Sun
**/

public class LowestIndexEqualsValue {

    // TC : O(logN)
    // SC : O(1)
    private static int indexEqualsValueSearch(int[] arr) {
        int start = 0;
        int end = arr.length-1;
        int ans = -1;

        while(start <= end) {
            int mid = start + (end - start) / 2;
            if(arr[mid] == mid) {
                ans = mid;
                end = mid-1;
            } else if (arr[mid] >= mid) {
                end--;
            } else {
                start++;
            }
        }
        return ans;
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASES
        System.out.println(indexEqualsValueSearch(new int[] {0}));
        System.out.println(indexEqualsValueSearch(new int[] {0, 3}));
        System.out.println(indexEqualsValueSearch(new int[] {-5,0,2,3,10,29}));
    }

}
