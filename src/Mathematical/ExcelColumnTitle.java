/**
 * Given an integer columnNumber,
 * return its corresponding column title as it appears in an Excel sheet.
 * E.g. If n = 1, return "A". If n = 28, return "AB".
 */
package Mathematical;

/**
 * @author gaurav kabra
 * @since 24 Oct 2021
 **/

public class ExcelColumnTitle {

    private static String convertToTitle(int n) {
        String ans = "";
        while(n > 0) {                      // while n is not 0
            n--;
            ans += (char) ('A' + n%26);     // if we don't typecast to char, then 'A' will be promoted to int
            n /= 26;
        }

        return new StringBuilder(ans).reverse().toString();
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASES
        System.out.println(convertToTitle(1));
        System.out.println(convertToTitle(701));
        System.out.println(convertToTitle(666));
    }
}
