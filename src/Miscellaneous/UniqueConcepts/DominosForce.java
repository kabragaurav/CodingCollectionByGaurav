/**
 * There are n dominoes in a line, and we place each domino vertically upright.
 * In the beginning, we simultaneously push some of the dominoes either to the left or to the right.
 * After each second, each domino that is falling to the left pushes the adjacent domino on the left.
 * Similarly, the dominoes falling to the right push their adjacent dominoes standing on the right.
 *
 * When a vertical domino has dominoes falling on it from both sides,
 * it stays still due to the balance of the forces.
 *
 * For the purposes of this question, we will consider that a falling domino expends no additional
 * force to a falling or already fallen domino.
 *
 * You are given a string dominoes representing the initial state where:
         * dominoes[i] = 'L', if the ith domino has been pushed to the left,
         * dominoes[i] = 'R', if the ith domino has been pushed to the right, and
         * dominoes[i] = '.', if the ith domino has not been pushed.
 *
 * Return a string representing the final state.
 */
package Miscellaneous.UniqueConcepts;

/**
 * @author gaurav kabra
 * @since 11 Dec 2021
 **/

public class DominosForce {

    /**
     * Logic:
     * We take right direction as positive and left as negative.
     * Scanning from left to right, our force is always >=0. It is N for first R, then it decreases by 1 and on 'L' it becomes 0.
     * Opposite applies while scanning right to left.
     * For some domino force[i], if the forces are equal, then the answer is '.'.
     * Otherwise, the answer is implied by whichever force is stronger. (if positive, 'R'. Else 'L')
     *
     * TC : O(N) due to two traversals
     * SC : O(N) due to storing force at any domino
     */
    private static String pushDominoes(String dominoes) {
        int N = dominoes.length();
        int[] force = new int[N];
        int netForce = 0;
        for(int i=0; i<N; i++) {
            char ch = dominoes.charAt(i);
            if(ch == 'R') {
                netForce = N;
            } else if(ch == 'L') {
                netForce = 0;
            } else {    // '.'
                netForce = Math.max(0, netForce-1);
            }
            force[i] = netForce;
        }

        // reset netForce to 0
        netForce = 0;
        for(int i=N-1; i>=0; i--) {
            char ch = dominoes.charAt(i);
            if(ch == 'L') {
                netForce = N;
            } else if(ch == 'R') {
                netForce = 0;
            } else {    // '.'
                netForce = Math.max(0, netForce-1);
            }
            force[i] -= netForce;               // subtract it
        }

        // append operations are always faster on StringBuilder
        // not on String
        StringBuilder ans = new StringBuilder();
        for(int i=0; i<N; i++) {
            ans.append(
                    (force[i] > 0 ? 'R' : (force[i] == 0 ? '.' : 'L'))
            );
        }
        return ans.toString();
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASE
        System.out.println(pushDominoes("RR.L"));
    }
}
