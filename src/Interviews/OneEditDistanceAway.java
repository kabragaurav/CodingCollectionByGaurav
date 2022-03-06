/**
 * Amazon, Microsoft
 *
 * An edit between two strings is one of the following changes.
 *     Add a character
 *     Delete a character
 *     Change a character
 *
 * Given two non-null strings s1 and s2, find if s1 can be converted to s2
 * with exactly one edit.
 */
package Interviews;

/**
 * @author gkabra
 * @since 06-03-2022 Sun
 **/

public class OneEditDistanceAway {

    // TC : O(M+N)
    // SC : O(1)
    private static boolean isOneEditAway(String s1, String s2) {
        int l1 = s1.length();
        int l2 = s2.length();
        if(s1.equals(s2) || l1 - l2 >= 2 || l2 - l1 >= 2) {
            return false;
        }

        int i = 0, j = 0, countEdits = 0;

        while(i < l1 && j < l2) {
            if(s1.charAt(i) == s2.charAt(j)) {
                i++;
                j++;
            } else {
                if(countEdits == 1) {
                    return false;
                }
                if(l1 > l2) {  // delete in s1
                    i++;
                } else if(l2 > l1) {  // delete in s2
                    j++;
                } else {  // change
                    i++;
                    j++;
                }
                countEdits++;
            }
        }

        if(i != l1 || j != l2) {  // one add is required
            countEdits++;
        }

        return countEdits == 1;

    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASES
        System.out.println(isOneEditAway("pale", "ple"));
        System.out.println(isOneEditAway("pales", "pale"));
        System.out.println(isOneEditAway("pale", "bale"));
        System.out.println(isOneEditAway("pale", "bake"));
        System.out.println(isOneEditAway("pale", "paless"));
    }

}
