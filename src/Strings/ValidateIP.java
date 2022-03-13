/**
 * Given a string queryIP, return "IPv4" if IP is a valid IPv4 address, "IPv6" if IP
 * is a valid IPv6 address or "Neither" if IP is not a correct IP of any type.
 *
 * A valid IPv4 address is an IP in the form "x1.x2.x3.x4" where 0 <= xi <= 255 and xi
 * cannot contain leading zeros. For example, "192.168.1.1" and "192.168.1.0" are valid
 * IPv4 addresses but "192.168.01.1", while "192.168.1.00" and "192.168@1.1" are invalid
 * IPv4 addresses.
 *
 * A valid IPv6 address is an IP in the form "x1:x2:x3:x4:x5:x6:x7:x8" where:
 *
 *     1 <= xi.length <= 4
 *     xi is a hexadecimal string which may contain digits, lower-case English letter
 *     ('a' to 'f') and upper-case English letters ('A' to 'F').
 *     Leading zeros are allowed in xi.
 *
 * For example, "2001:0db8:85a3:0000:0000:8a2e:0370:7334" and "2001:db8:85a3:0:0:8A2E:0370:7334"
 * are valid IPv6 addresses, while "2001:0db8:85a3::8A2E:037j:7334" and
 * "02001:0db8:85a3:0000:0000:8a2e:0370:7334" are invalid IPv6 addresses.
 */
package Strings;

/**
 * @author gkabra
 * @since 13-03-2022 Sun
 **/

public class ValidateIP {

    private static String[] individuals;

    // TC : O(N)
    // SC : O(1)
    // Trick is split() does not return empty strings. E.g. "x.y.".split(".") will give ["x", "y"] not ["x", "y", ""]
    private static String validIPAddress(String ip) {
        if(isValidIpv4(ip)) {
            return "IPv4";
        } else if(isValidIpv6(ip)) {
            return "IPv6";
        }
        return "Neither";
    }

    private static boolean isValidIpv4(String ip) {
        if(!isBasicValidationPassed(ip, ".", "\\.", 4)) {
            return false;
        }

        for(String individual : individuals) {
            try {
                int parsed = Integer.parseInt(individual);
                if(parsed < 0 || parsed > 255 || Integer.toString(parsed).length() < individual.length()) {
                    return false;
                }
            } catch (NumberFormatException nfe) {
                return false;
            }
        }

        return true;
    }

    private static boolean isValidIpv6(String ip) {
        if(!isBasicValidationPassed(ip, ":", "\\:", 8)) {
            return false;
        }

        for(String individual : individuals) {
            if(individual.length() < 1 || individual.length() > 4) {
                return false;
            }
            try {
                Integer.parseInt(individual, 16);
            } catch (NumberFormatException nfe) {
                return false;
            }
        }

        return true;
    }

    private static boolean isBasicValidationPassed(String ip, String notValidAtEnds,
                                                   String splitRegex, int desiredLength) {
        if(ip.startsWith(notValidAtEnds) || ip.endsWith(notValidAtEnds)) {
            return false;
        }

        individuals = ip.split(splitRegex);
        int N = individuals.length;

        if(N != desiredLength) {
            return false;
        }

        return true;
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASES
        System.out.println(validIPAddress("1.2.3.4"));
        System.out.println(validIPAddress("1.2.3.04"));
        System.out.println(validIPAddress("1.2.3.4."));
    }

}
