/**
 * Microsoft
 * Given an array of strings arr.
 * The strings in arr can be combined when resultant string, s, has all characters unique.
 * Return the maximum possible length of s.
 */
package Backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author gaurav kabra
 * @since 18 Sept 2021
 **/

public class MaxLenOfConcatStrWithUniqChar {
    /**
     * If we don't want to make ans a global variable but want it to be updated in recursive call,
     * then make it like this and pass to recursive calls:
     *
     * int[] ans = new int[1];      // size is 1 and final answer will be ans[0] now
     */
    private static int ans;

    // utility method to return true if all chars in s are unique
    private static boolean isAllUnique(String s) {
        Map<Character, Integer> count = new HashMap<>();
        for(char ch : s.toCharArray()) {
            if(count.get(ch) != null) {
                return false;
            }
            count.put(ch, 1);
        }
        return true;
    }

    private static void maxLengthHelper(List<String> arr, int index, String strSoFar) {
        // when we complete arr see if strSoFar has all chars unique
        // if so, then update ans if ans is less that length of strSoFar
        if(index == arr.size()) {
            if(isAllUnique(strSoFar) && strSoFar.length() > ans) {
                ans = strSoFar.length();
            }
            return;
        }
        maxLengthHelper(arr, index+1, strSoFar);        // don't take string
        maxLengthHelper(arr, index+1, strSoFar + arr.get(index));       // take string

    }

    private static int maxLength(List<String> arr) {
        /**
         * Logic:
         * We will build strings in two ways at current index:
         *      We will take string at the current index
         *      We won't take string at current index
         *
         * We return max length string obtainable in this way.
         */
        ans = 0;            // clear the previous value
        maxLengthHelper(arr, 0, "");
        return ans;
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASES
        System.out.println(maxLength(new ArrayList<>() {{
            add("un");
            add("iq");
            add("ue");
        }}));

        System.out.println(maxLength(new ArrayList<>() {{
            add("cha");
            add("r");
            add("act");
            add("ers");
        }}));

        System.out.println(maxLength(new ArrayList<>() {{
            add("abcdefghijklmnopqrstuvwxyz");
        }}));
    }
}
