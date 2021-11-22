/**
 * You are given a license key represented as a string s that consists of only
 * alphanumeric characters and dashes. The string is separated into n + 1 groups by n dashes.
 * You are also given an integer k.
 * We want to reformat the string s such that each group contains exactly k characters,
 * except for the first group, which could be shorter than k but still must contain at
 * least one character. Furthermore, there must be a dash inserted between two groups,
 * and you should convert all lowercase letters to uppercase.
 * Return the reformatted license key.
 */
package Strings;

/**
 * @author gaurav kabra
 * @since 22 Nov 2021
 **/

public class FormatLicense {

    private static String licenseKeyFormatting(String s, int k) {
        // first see if any other char is in s except '-'
        // by removing '-' from s
        if(s.replace("-", "").length() == 0) {
            return "";
        }
        String ans = "";
        int j = 0;
        for(int i=s.length()-1; i>=0; i--) {
            if(s.charAt(i) == '-') {
                continue;
            }
            if(j%k == 0) {
                ans += "-";
                j = 0;
            }
            j++;
            ans += Character.toUpperCase(s.charAt(i));
        }
        return new StringBuilder(ans).reverse().substring(0, ans.length()-1);
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASES
        System.out.println(licenseKeyFormatting("---", 3));
        System.out.println(licenseKeyFormatting("2-5g-3-J", 2));
    }
}
