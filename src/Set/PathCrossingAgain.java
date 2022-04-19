/**
 * Given a string path, where path[i] = 'N', 'S', 'E' or 'W',
 * each representing moving one unit north, south, east, or west, respectively.
 * You start at the origin (0, 0) on a 2D plane and walk on the path specified by path.
 *
 * Return true if the path crosses itself at any point, that is, if at any time you are on a
 * location you have previously visited. Return false otherwise.
 */
package Set;

import java.util.HashSet;

/**
 * @author gkabra
 * @since 13-03-2022 Sun
 **/

public class PathCrossingAgain {

    private static class Pair {
        int x, y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        /**
         * These methods are used by HashSet to determine if two objects are the same.
         * When you don't override them, the equals method
         * tests equality of the objects' references rather that equality of their field values.
         */

        @Override
        public boolean equals(Object obj) {
            Pair p = (Pair) obj;
            return p.x == x && p.y == y;
        }

        @Override
        public int hashCode() {
            return x + y;
        }
    }

    // TC : O(N)
    // SC : O(N) for hashset
    private static boolean isPathCrossing(String path) {
        int x = 0, y = 0;
        HashSet<Pair> st = new HashSet<>();
        st.add(new Pair(0,0));

        for(char ch : path.toCharArray()) {
            if(ch == 'N') {
                y++;
            } else if (ch == 'S') {
                y--;
            } else if (ch == 'E') {
                x++;
            } else {
                x--;
            }
            Pair p = new Pair(x, y);
            if(st.contains(p)) {
                return true;
            }
            st.add(p);
        }

        return false;
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASES
        System.out.println(isPathCrossing("NESWW"));
        System.out.println(isPathCrossing("NES"));
        System.out.println(isPathCrossing("NNSWWEWSSESSWENNW"));
    }

}
