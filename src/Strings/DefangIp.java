/**
 * Amazon
 * Given a valid IP address, defang it.
 * Note: To defang an IP address, replace every ".", with "[.]".
 *
 * Read more here: https://tinyurl.com/defang-ip
 *              and https://tinyurl.com/defang-ip-ibm
 */
package Strings;

/**
 * @author gaurav kabra
 * @since 14 August 2021
 */

public class DefangIp {
    private static String getDefangedIp(String ip) {
        /**
         * Logic:
         * We use a regex for representing '.'
         * Since '.' in regex means specially a single character, we use \\. to represent a dot(.)
         */
        return ip.replaceAll("\\.","[.]");
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASE
        System.out.println(getDefangedIp("1.1.1.1"));
    }
}
