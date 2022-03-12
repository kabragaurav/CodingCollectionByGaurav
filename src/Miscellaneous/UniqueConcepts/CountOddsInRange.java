/**
 * Given two numbers, find number of odd numbers between them (both inclusive).
 */
package Miscellaneous.UniqueConcepts;

/**
 * @author gkabra
 * @since 12-03-2022 Sat
 **/

public class CountOddsInRange {

    // TC : O(1)
    // SC : O(1)
    private static int countOdds(int low, int high) {
        return (high+1)/2 + low/2;
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASES
        System.out.println(countOdds(1, 3));
        System.out.println(countOdds(1, 4));
        System.out.println(countOdds(2, 3));
        System.out.println(countOdds(2, 4));
    }

}
