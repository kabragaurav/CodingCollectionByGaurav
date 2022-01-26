/**
 * Given a static-sized array of integers arr, move all zeroes in the array to the end of the array.
 * You should preserve the relative order of items in the array.
 * We should implement a solution that is more efficient than a naive brute force.
 */
package Company.Pramp;

import java.util.Arrays;

/**
 * @author gkabra
 * @since 26-01-2022 Wed
 **/

public class MoveZerosToEnd {

    private static int[] moveZerosToEnd(int[] arr) {
        int N = arr.length;
        int first = 0;
        int prevStateOfSecond = -1;
        while(first < N) {
            if(arr[first] == 0) {
                int second = prevStateOfSecond == -1 ? first+1 : prevStateOfSecond+1;
                while(second < N) {
                    if(arr[second] == 0) {
                        second++;
                    } else {
                        int temp = arr[first];
                        arr[first] = arr[second];
                        arr[second] = temp;
                        prevStateOfSecond = second;
                        break;
                    }
                }
            }
            first++;
        }
        return arr;
    }

    // TC : O(N)
    // SC : O(1)
    private static int[] moveZerosToEndOptimal(int[] arr) {
        int write = 0;
        for(int i=0; i<arr.length; i++) {
            if(arr[i] != 0) {
                int temp = arr[i];
                arr[i] = arr[write];
                arr[write] = temp;
                write++;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        // TESTCASES
        Arrays.stream(moveZerosToEnd(new int[] {0,1,2,3,0,0,1,1,6,4,1})).forEach(x -> System.out.print(x + " "));
        System.out.println();

        Arrays.stream(moveZerosToEnd(new int[] {0,0})).forEach(x -> System.out.print(x + " "));
        System.out.println();

        Arrays.stream(moveZerosToEnd(new int[] {0,0,3})).forEach(x -> System.out.print(x + " "));
        System.out.println();

        Arrays.stream(moveZerosToEnd(new int[] {0})).forEach(x -> System.out.print(x + " "));
        System.out.println();

        Arrays.stream(moveZerosToEnd(new int[] {})).forEach(x -> System.out.print(x + " "));
        System.out.println();

        Arrays.stream(moveZerosToEnd(new int[] {3,0,0})).forEach(x -> System.out.print(x + " "));
        System.out.println();



        Arrays.stream(moveZerosToEndOptimal(new int[] {0,1,2,3,0,0,1,1,6,4,1})).forEach(x -> System.out.print(x + " "));
        System.out.println();

        Arrays.stream(moveZerosToEndOptimal(new int[] {0,0})).forEach(x -> System.out.print(x + " "));
        System.out.println();

        Arrays.stream(moveZerosToEndOptimal(new int[] {0,0,3})).forEach(x -> System.out.print(x + " "));
        System.out.println();

        Arrays.stream(moveZerosToEndOptimal(new int[] {0})).forEach(x -> System.out.print(x + " "));
        System.out.println();

        Arrays.stream(moveZerosToEndOptimal(new int[] {})).forEach(x -> System.out.print(x + " "));
        System.out.println();

        Arrays.stream(moveZerosToEndOptimal(new int[] {3,0,0})).forEach(x -> System.out.print(x + " "));
        System.out.println();
    }

}
