/**
 * Given a positive integer N, return whether or not it has alternating bit values.
 */
package BitManipulation;

/**
 * @author gaurav kabra
 * @since 25 Aug 2021
 **/
public class FlipFlops {
    private static boolean hasAlternatingBits(int N) {
        /**
         * Logic:
         * Convert to binary string and see bits.
         */
        String s = Integer.toBinaryString(N);
        for(int i=1; i<s.length(); i++) {
            if(s.charAt(i) == s.charAt(i-1)) {
                return false;
            }
        }
        return true;
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASES
        System.out.println(hasAlternatingBits(5));
        System.out.println(hasAlternatingBits(8));
        System.out.println(hasAlternatingBits(0));
        System.out.println(hasAlternatingBits(10));
    }
}
