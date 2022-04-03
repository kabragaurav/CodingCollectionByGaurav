/*
An integer x is a good if after rotating each digit individually by 180 degrees,
we get a valid number that is different from x. Each digit must be rotated - we cannot choose to leave
it alone.

A number is valid if each digit remains a digit after rotation. For example:

    0, 1, and 8 rotate to themselves,
    2 and 5 rotate to each other (in this case they are rotated in a different direction,
    in other words, 2 or 5 gets mirrored),
    6 and 9 rotate to each other, and
    the rest of the numbers do not rotate to any other number and become invalid.

Given an integer n, return the number of good integers in the range [1, n].
 */
package Mathematical;

import java.util.HashMap;

/**
 * @author gaurav kabra
 * @since 03/Apr/2022
 **/

public class RotatedDigits {

    private static HashMap<Integer, Integer> rotate;

    static {
        rotate = new HashMap<>();
        rotate.put(0, 0);
        rotate.put(1, 1);
        rotate.put(2, 5);
        rotate.put(5, 2);
        rotate.put(8, 8);
        rotate.put(6, 9);
        rotate.put(9, 6);
    }

    private static int rotatedDigits(int num) {

        int count = 0;

        for (int n=1; n<=num; n++) {
            boolean isValid = true;
            StringBuilder sb = new StringBuilder();
            int t = n;
            while (t > 0) {
                isValid = isValid && checkValid(t % 10);
                if (!isValid) {
                    break;
                } else {
                    sb.append(rotate.get(t % 10));
                }
                t /= 10;
            }
            if (isValid) {
                if (Integer.parseInt(sb.reverse().toString()) != n) {
                    count++;
                }
            }
        }

        return count;

    }

    private static boolean checkValid(int digit) {
        if (rotate.containsKey(digit)) {
            return true;
        }
        return false;
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASE(S)
        System.out.println(rotatedDigits(10));
        System.out.println(rotatedDigits(1));
        System.out.println(rotatedDigits(2));
    }

}
