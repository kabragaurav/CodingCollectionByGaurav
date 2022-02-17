/**
 * You are given an array of integers nums represents the numbers written on a chalkboard.
 * Alice and Bob take turns erasing exactly one number from the chalkboard,
 * with Alice starting first. If erasing a number causes the bitwise XOR of
 * all the elements of the chalkboard to become 0, then that player loses.
 * The bitwise XOR of one element is that element itself, and the bitwise XOR of no elements
 * is 0.
 * Also, if any player starts their turn with the bitwise XOR of all the elements of the
 * chalkboard equal to 0, then that player wins.
 * Return true if and only if Alice wins the game, assuming both players play optimally.
 */
package GameTheory;

/**
 * @author gkabra
 * @since 17-02-2022 Thu
 **/

public class XorGame {

    private static boolean xorGame(int[] nums) {
        if(nums.length % 2 == 0) {
            return true;
        }
        int xor = 0;
        for(int num : nums) {
            xor ^= num;
        }
        return xor == 0;
    }

    public static void main(String[] args) {
        System.out.println(xorGame(new int[] {1,1,2}));
    }

}
