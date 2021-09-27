/**
 * We have two kinds of bots, A and B.
 * A always moves left and B always moves right.
 * An empty space are represented by a #.
 * Bots never cross each other since they move along 1-D.
 * There can be many bots of same type.
 * Given initial and final state, tell if the transformation is possible.
 *
 * Video - https://tinyurl.com/ola-samples
 */
package CompanyWise.Ola;

/**
 * @author gaurav kabra
 * @since 28 Sept 2021
 **/
public class BotsMovement {
    private static boolean moveBots(String s1, String s2) {
        /**
         * Logic:
         * If we remove spaces, the two strings should be equal, since bots move on spaces only (i.e. never cross each other)
         * If yes, then we check validity.
         * A moves left so we start from end,
         * B moves right, so we start from left.
         */
        if(!(s1.replaceAll("#", "").equals(s2.replaceAll("#", "")))) {
            return false;
        }
        // #A#, ##A
        int N = s1.length();
        int aSoFar = 0;
        for(int i=N-1; i>=0; i--) {
            if(s1.charAt(i) == 'A') {
                aSoFar++;
            }
            if(s2.charAt(i) == 'A') {
                aSoFar--;
            }
            if(aSoFar < 0) {
                return false;
            }
        }
        int bSoFar = 0;
        for(int i=0; i<N; i++) {
            if(s1.charAt(i) == 'B') {
                bSoFar++;
            }
            if(s2.charAt(i) == 'B') {
                bSoFar--;
            }
            if(bSoFar < 0) {
                return false;
            }
        }

        return true;
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASE
        System.out.println(moveBots("#ABB#AB", "A#B#BAB"));
    }
}
