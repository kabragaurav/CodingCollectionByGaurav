/**
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
 *
                     * Symbol       Value
                     * I             1
                     * V             5
                     * X             10
                     * L             50
                     * C             100
                     * D             500
                     * M             1000
 * For example, 2 is written as II in Roman numeral, just two one's added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.
 * Roman numerals are usually written largest to smallest from left to right.
 * However, the numeral for four is not IIII. Instead, the number four is written as IV.
 * Because the one is before the five we subtract it making four.
 * The same principle applies to the number nine, which is written as IX.
 * There are six instances where subtraction is used:
         * I can be placed before V (5) and X (10) to make 4 and 9.
         * X can be placed before L (50) and C (100) to make 40 and 90.
         * C can be placed before D (500) and M (1000) to make 400 and 900.
 * Given a roman numeral, convert it to an integer.
 */
package HashMap;

import java.util.HashMap;
import java.util.Map;

/**
 * @author gaurav kabra
 * @since 23 Nov 2021
 **/

public class RomanToInt {

    final static Map<String, Integer> mp = new HashMap<>() {{
        put("I", 1);
        put("V", 5);
        put("X", 10);
        put("L", 50);
        put("C", 100);
        put("D", 500);
        put("M", 1000);
    }};

    // TC: O(N) since we traverse s once
    // SC: O(N) since we use temp, which in worst case can be of length equal to that of s
    private static int romanToInt(String s) {
        int ans = 0;
        String temp = "";
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            temp += c;
            if(mp.containsKey(temp)) {
                ans += mp.get(temp);
                if(i > 0) {
                    int prev = s.charAt(i-1);
                    // The logic here is that, if a current character value is greater than that of the previous,
                    // we have to subtract it.
                    // We subtract twice the prev value, because previously iteration had blindly added it.
                    if(prev == 'I' && (c == 'V' || c == 'X')) {
                        ans -= 2;
                    } else if(prev == 'X' && (c == 'L' || c == 'C')) {
                        ans -= 20;
                    } else if(prev == 'C' && (c == 'D' || c == 'M')) {
                        ans -= 200;
                    }
                }
                temp = "";
            }
        }
        return ans;
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASE
        System.out.println(romanToInt("MCMXCIV"));
    }
}
