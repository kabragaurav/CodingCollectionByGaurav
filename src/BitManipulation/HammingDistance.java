/**
 * Facebook
 * Given two integers x and y, return the hamming distance between the two numbers.
 * The hamming distance between two numbers is the number of bit positions in which the bits differ.
 */
package BitManipulation;

/**
 * @author gaurav kabra
 * @since 15 August 2021
 **/
public class HammingDistance {

    private static int hammingDistance(int x, int y) {
        /**
         * Logic:
         * The basic concept is to do xor of x and y and count 1's in the xor result.
         * Why?
         * xor has the property that when bits are different (i.e. one bit is 0 and other is 1), the result is 1.
         * Now in problem we need to count bit positions that differ. So do xor and where 1 is there in xor, the bits differ.
         * Since we need only count of bit differences, we return number of 1's in xor.
         */
        int xor = x ^ y;
        return Integer.bitCount(xor);
        /**
         * Not that we could have also done this. But since it involves String, it is a bit slower.

            String bin = Integer.toBinaryString(xor);
            return (int) bin.chars().filter(ch -> ch == '1').count();
         */
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASES
        System.out.println(hammingDistance(1,4));
        System.out.println(hammingDistance(3,1));
        System.out.println(hammingDistance(4,2));
    }
}
