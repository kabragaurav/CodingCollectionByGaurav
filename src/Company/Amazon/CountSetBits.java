/**
 * Write a function that takes an UNSIGNED integer (Java does not have that concept of unsigned)
 * and returns the number of '1' bits it has (also known as the Hamming weight).
 */
package Company.Amazon;

/**
 * @author gkabra
 * @since 28-01-2022 Fri
 **/

public class CountSetBits {

    /**
     * Logic:
     *
     * The binary representation of Integer.MAX_VALUE is 0111 1111 1111 1111 1111 1111 1111 1111, and
     * the binary representation of Integer.MAX_VALUE + 1 is 1000 0000 0000 0000 0000 0000 0000 0000 (spaces added).
     * Note that the leftmost bit here denotes the sign of the number, but recall that we're told to treat input as unsigned.
     * As mentioned above, Integer.MAX_VALUE is 2147483647, and Integer.MAX_VALUE + 1 is -2147483648.
     * Intuitively, we would agree that -2147483648 has 1 one.
     * However, if our test is n > 0, -2147483648 fails that test, so we don't count any 1s, and instead incorrectly return 0.
     *
     * Filling in zeros from the left is done using unsigned >>>
     *
     * So a few shifts of Integer.MAX_VALUE + 1 should look like this:
     * 0100 0000 0000 0000 0000 0000 0000 0000
     * 0010 0000 0000 0000 0000 0000 0000 0000
     * 0001 0000 0000 0000 0000 0000 0000 0000
     *
     * The operation that describes that kind of shift is the unsigned shift (also "logical shift") operator, denoted by >>>.
     *
     * The operation denoted by >> is indeed also a shift (the "signed" or "arithmetic" shift), but not the shift we're looking for (since it fills in whatever the sign bit is, either 0 or 1)
     *
     * A few shifts of Integer.MAX_VALUE + 1 using the >> operator would look like this:
     * 1100 0000 0000 0000 0000 0000 0000 0000
     * 1110 0000 0000 0000 0000 0000 0000 0000
     * 1111 0000 0000 0000 0000 0000 0000 0000
     * 1111 1000 0000 0000 0000 0000 0000 0000
     * ...
     * 1111 1111 1111 1111 1111 1111 1111 1111, to infinity, which would never exit our n != 0 condition.
     *
     * TC : O(1) since either 32-bit or 64-bit
     * SC : O(1)
     */
    private static int hammingWeight(int n) {
        int count = 0;
        while(n != 0) {             // DO NOT USE n>0 CONDITION
            count += (n&1);
            n = n>>>1;              // USE >>> NOT >>
        }
        return count;
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASES
        System.out.println(hammingWeight(0));
        System.out.println(hammingWeight(Integer.MAX_VALUE));
        System.out.println(hammingWeight(Integer.MAX_VALUE+1));
    }

}
