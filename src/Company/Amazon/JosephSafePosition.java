/**
 * There are n people standing in a circle (numbered clockwise 1 to n) waiting to be executed.
 * The counting begins at point 1 in the circle and proceeds around the circle in a fixed
 * direction (clockwise).
 * In each step, a certain number of people are skipped and the next person is executed.
 * The elimination proceeds around the circle (which is becoming smaller and smaller as
 * the executed people are removed), until only the last person remains, who is given freedom.
 * Given the total number of persons n and a number k which indicates that k-1 persons
 * are skipped and kth person is killed in circle. The task is to choose the place in the
 * initial circle so that you are the last one remaining and so survive.
 */
package Company.Amazon;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author gkabra
 * @since 30-01-2022 Sun
 **/

public class JosephSafePosition {

    private static int helper(List<Integer> ls, int k, int curr) {
        if(ls.size() == 1) {
            return ls.get(0);
        }
        int killed = (curr+k) % ls.size();          // mod since people are in circle
        ls.remove(killed);
        return helper(ls, k, killed);
    }

    // TC : O(N)
    // SC : O(N)
    private static int safePos(int n, int k) {
        List<Integer> ls = IntStream.rangeClosed(1, n)
                                    .boxed()
                                    .collect(Collectors.toList());
        k--;        // 0-based index
        return helper(ls, k, 0);
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASES
        System.out.println(safePos(2, 1));
        System.out.println(safePos(4, 2));
        System.out.println(safePos(14, 2));
    }

}
