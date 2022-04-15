/*
An integer has sequential digits if and only if each digit in the number is one more than
the previous digit.
Return a sorted list of all the integers in the range [low, high] inclusive that have sequential
digits.

Note : 10 <= low <= high <= 10^9
 */
package Miscellaneous.TrickySimple;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gaurav kabra
 * @since 15/Apr/2022
 **/

public class SequentialDigits {

    //Read the constraints. Since we have limited numbers that satisfy the condition
    // within given constraints, we can pre-calculate and store it.
    // TC : O(1) since pre-calculates and iteration is over fixed length
    // SC : O(1) since max space is definitely <= cache.length
    private static List<Integer> sequentialDigits(int low, int high) {
        List<Integer> ls = new ArrayList<>();

        int[] cache = new int[] {
                12,23,34,45,56,67,78,89,123,234,345,456,567,678,789,1234,
                2345,3456,4567,5678,6789,12345,23456,34567,45678,56789,123456,234567,
                345678,456789,1234567,2345678,3456789,12345678,23456789,123456789
        };

        for (int candidate : cache) {
            if (low <= candidate && candidate <= high) {
                ls.add(candidate);
            }
        }

        return ls;
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASE(S)
        System.out.println(sequentialDigits(10, 1000000000));
    }

}
