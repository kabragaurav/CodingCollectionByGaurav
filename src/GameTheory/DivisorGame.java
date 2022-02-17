/**
 * Alice and Bob take turns playing a game, with Alice starting first.
 * Initially, there is a number n on the chalkboard. On each player's turn, that player makes
 * a move consisting of:
 *
 *     Choosing any x with 0 < x < n and n % x == 0.
 *     Replacing the number n on the chalkboard with n - x.
 *
 * Also, if a player cannot make a move, they lose the game.
 * Return true if and only if Alice wins the game, assuming both players play optimally.
 */
package GameTheory;

/**
 * @author gkabra
 * @since 17-02-2022 Thu
 **/

public class DivisorGame {
    /**
     * Logic:
     * Induction: a player who starts with even always wins and a player who starts with odd always lose.
     *
     * If N is an even number, Alice can always choose 1, so n-x = N-1 will be odd (since both are playing optimally)
     * giving Bob an odd number. Odd numbers are only divisible by odd numbers.
     * Hence Bob will subtract an odd number from this odd number resulting in even number.
     * Alice will thus get a smaller even number after each round and Bob will get a smaller
     * odd number after each round. And at last round Bob will
     * have to choose the number 1 and will lose the game since he will be left with no other
     * option.
     *
     * TC : O(1)
     * SC : O(1)
     */
    private static boolean divisorGame(int n) {
        return n%2 == 0;
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASES
        System.out.println(divisorGame(2));
        System.out.println(divisorGame(3));
    }

}
