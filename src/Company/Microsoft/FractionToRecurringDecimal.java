/*
Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.

If the fractional part is repeating, enclose the repeating part in parentheses.
 */
package Company.Microsoft;

import java.util.HashMap;

/**
 * @author gaurav kabra
 * @since 08/Apr/2022
 **/

public class FractionToRecurringDecimal {

    /*
        TC : log(num) base denom
        SC : O(num/denom) with floating division

        Excellent video : https://tinyurl.com/recurring-decimal
     */
    private static String fractionToDecimal(int num, int denom) {
        // first check if final answer should be negative or not
        boolean isNegative = false;
        if (num < 0 || denom < 0) {
            if (! (num < 0 && denom < 0)) {         // one should be negative, not both
                isNegative = true;
            }
        }

        long d = Math.abs((long) denom);            // cast to long, what if denom = Integer.MIN_VALUE. Then Math.abs(denom) = denom. That's why
        long n = Math.abs((long) num);
        long q = Math.abs(n / d);
        long r = Math.abs(n % d);
        String ans = String.valueOf(q);             // quotient is always added to ans
        if (r == 0) {
            if (Long.parseLong(ans) == 0) {         // -0 does not make sense, so if 0, then return 0
                return ans;
            }
            return isNegative ? "-" + ans : ans;
        }
        ans += ".";
        HashMap<Long, String> rToPos = new HashMap<>();     // remainder to ans map. If remainder repeats, ue it to know where to put (
        while (r != 0) {
            if (rToPos.containsKey(r)) {
                int index = ans.indexOf(rToPos.get(r)) + rToPos.get(r).length();
                ans = ans.substring(0, index)
                        + "("
                        + ans.substring(index)
                        + ")";
                break;
            }
            rToPos.put(r, ans);         // first put entry
            r *= 10;
            q = r / d;
            ans += q;
            r %= d;
        }

        return isNegative ? "-" + ans : ans;
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASE(S)
        System.out.println(fractionToDecimal(-50, 8));
        System.out.println(fractionToDecimal(0, -8));                   // corner case 1
        System.out.println(fractionToDecimal(-1, -2147483648));         // corner case 2
        System.out.println(fractionToDecimal(-2147483648, 1));          // corner case 3
        System.out.println(fractionToDecimal(4, 333));
    }

}
