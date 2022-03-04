/**
 * Your friend is typing his name into a keyboard. Sometimes, when typing a character c,
 * the key might get long pressed, and the character will be typed 1 or more times.
 * You examine the typed characters of the keyboard. Return True if it is possible
 * that it was your friends name, with some characters (possibly none) being long pressed.
 */
package GreedyAndTwoPointer;

/**
 * @author gkabra
 * @since 04-03-2022 Fri
 **/

public class LongPressedKey {

    // TC : O(max(M, N))
    // SC : O(1)
    private static boolean isLongPressedName(String name, String typed) {
        int first = 0;
        int second = 0;
        int l1 = name.length();
        int l2 = typed.length();
        if(l1 == l2) {
            return name.equals(typed);
        }
        if(l1 > l2) {
            return false;
        }
        // l1 < l2

        while(first < l1 && second < l2) {
            char ch = name.charAt(first);
            if(ch != typed.charAt(second)) {
                return false;
            }
            while(first < l1 && second < l2 && ch == name.charAt(first) && name.charAt(first) == typed.charAt(second)) {
                first++;
                second++;
            }
            while(second < l2 && ch == typed.charAt(second)) {
                second++;
            }
            // if anyone reaches end
            if((first == l1 && second != l2) ||
                    (second == l2 && first != l1)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isLongPressedName("pyplrz", "ppyypllr"));
        System.out.println(isLongPressedName("alex", "aaleexa"));
    }

}
