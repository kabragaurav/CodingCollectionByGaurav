/*
Let's call an array arr a mountain if the following properties hold:

    arr.length >= 3
    There exists some i with 0 < i < arr.length - 1 such that:
        arr[0] < arr[1] < ... arr[i-1] < arr[i]
        arr[i] > arr[i+1] > ... > arr[arr.length - 1]

Given an integer array arr that is guaranteed to be a mountain,
return any i such that arr[0] < arr[1] < ... arr[i - 1] < arr[i] > arr[i + 1] > ... > arr[arr.length - 1].
 */
package Company.Google;

/**
 * @author gaurav kabra
 * @since 21/Apr/2022
 **/

public class PeakOfMountain {

    private static int peakIndexInMountainArray(int[] arr) {
        int N = arr.length;

        int left = 0;
        int right = N-1;

        while (left < right) {
            int mid = left + (right-left)/2;
            if (arr[mid-1] < arr[mid] && arr[mid] > arr[mid+1]) {
                return mid;
            } else if (arr[mid-1] < arr[mid] && arr[mid] < arr[mid+1]) {
                left = mid;
            } else {
                right = mid;
            }
        }

        return left;
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASE(S)
        System.out.println(peakIndexInMountainArray(new int[] {0,10,5,2,0}));
    }

}
