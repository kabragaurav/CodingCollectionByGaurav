/**
 * Given an array arr[] of positive integers of size N.
 * Reverse every sub-array group of size K.
 */
package Company.Amazon;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gkabra
 * @since 30-01-2022 Sun
 **/

public class ReverseArrayInGroup {

    // TC : O(N)
    // SC : O(1)
    private static void reverseInGroups(List<Integer> arr, int n, int k) {
        int first = 0, last = Math.min(k-1, n-1);

        while(first < n) {
            int i=first, j = last;
            while(i <= j) {
                int t = arr.get(i);
                arr.set(i++, arr.get(j));
                arr.set(j--, t);
            }
            first = last+1;
            last = Math.min(last+k, n-1);
        }
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASE
        List<Integer> arr = new ArrayList<>() {{
            add(1); add(2);
            add(3); add(4);
        }};
        reverseInGroups(arr, 4, 3);
        arr.stream().forEach(x -> System.out.println(x));
    }

}
