/**
 * Amazon
 * Given two strings s1 and s2, return true if s2 contains a permutation of s1,
 * or false otherwise.
 */
package Interviews;

import java.util.Arrays;

/**
 * @author gkabra
 * @since 05-03-2022 Sat
 **/

public class ContainsPermutation {

    // TC : O(N^2logN) since we take N substrings and sort them
    // SC : O(M) for chars
    private static boolean checkInclusion(String s1, String s2) {
        int l1 = s1.length();
        int l2 = s2.length();

        if(l2 < l1) {
            return false;
        }

        if(s1.equals(l2)) {
            return true;
        }

        char[] chars = s1.toCharArray();
        Arrays.sort(chars);
        s1 = new String(chars);

        for(int i=0; i<l2; i++) {
            int ch = s2.charAt(i);
            if(i+l1 <= l2 && s1.contains(Character.toString(ch))) {
                char[] substr = s2.substring(i, i+l1).toCharArray();
                Arrays.sort(substr);
                if(s1.equals(new String(substr))) {
                    return true;
                }
            }
        }
        return false;
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASES
        System.out.println(checkInclusion("hello", "ooolleoooleh"));
        System.out.println(checkInclusion("adc", "dcda"));
    }

}
