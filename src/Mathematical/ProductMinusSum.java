/**
 * Given an integer number n,
 * return the difference between the product of its digits and the sum of its digits.
 */
package Mathematical;

/**
 * @author gkabra
 * @since 26-01-2022 Wed
 **/

public class ProductMinusSum {

    // TC : O(logn) since number of digits in n = log10(n)
    // SC : O(1)
    private static int subtractProductAndSum(int n) {
        int sum = 0;
        int prod = 1;

        while(n > 0) {
            sum += n%10;
            prod *= n%10;
            n /= 10;
        }

        return prod-sum;
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASE
        System.out.println(subtractProductAndSum(234));
    }

}
