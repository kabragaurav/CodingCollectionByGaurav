/*
Given 2 strings s and t, determine if you can convert s into t. The rules are:

    You can change 1 letter at a time.
    Once you changed a letter you have to change all occurrences of that letter.

Both strings contain only lowercase English letters.
 */
package Strings;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author gaurav kabra
 * @since 29/Mar/2022
 **/

public class ConvertSToT {


    /*
        Rough coded, may not be correct (Premium on LeetCode)
        Theory : https://tinyurl.com/can-transform

        TC : O(N)
        SC : O(1)
     */
    private static boolean canTransform(String s, String t) {
        int l = s.length();

        if (l != t.length()) {
            return false;
        }

        final String aToZ = "abcdefghijklmnopqrstuvwxyz";
        char[] charsS = s.toCharArray();
        Arrays.sort(charsS);
        char[] charsT = t.toCharArray();
        Arrays.sort(charsT);
        if (new String(charsS).equals(aToZ) && new String(charsT).equals(aToZ)) {
            return false;
        }

        if (new String(charsS).equals(new String(charsT))) {
            return true;
        }

        HashMap<Character, Character> mp = new HashMap<>();

        for (int i=0; i<l; i++) {
            char chS = s.charAt(i);
            char chT = t.charAt(i);

            if (mp.containsKey(chS) && mp.get(chS) != chT) {
                return false;
            }

            mp.put(chS, chT);
        }

        return true;
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASE
        System.out.println(canTransform("abca", "dced"));
        System.out.println(canTransform("ab", "ba"));
        System.out.println(canTransform("abcdefghijklmnopqrstuvwxyz", "bcdefghijklmnopqrstuvwxyza"));
        System.out.println(canTransform("aa", "cd"));
        System.out.println(canTransform("ab", "aa"));
        System.out.println(canTransform("abcdefghijklmnopqrstuvwxyz", "bbcdefghijklmnopqrstuvwxyz"));
        System.out.println(canTransform("aac", "bbc"));
        System.out.println(canTransform("bbd", "cde"));
    }

}
