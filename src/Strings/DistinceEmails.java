/**
 * Google
 * Email addresses are made up of local and domain names.
 * For example in anand@india.com, anand is the local name and india.com is the domain name.
 * Email addresses may also contain '+' or '.' characters besides lowercase letters.
 * If there is a '.' in the local name of the email address it is ignored.
 * Everything after a '+' in the local name is also ignored. For example an.and+raj@india.com
 * is equivalent to anand@india.com.
 * Given a list of email addresses, find the number of unique addresses.
 */
package Strings;

import java.util.HashSet;
import java.util.Set;

/**
 * @author gaurav kabra
 * @since 28 Sept 2021
 **/

public class DistinceEmails {
    private static String reduceEmail(String email) {
        String[] broken = email.split("@");             // separate local and domain names
        broken[0] = broken[0]
                .split("\\+")[0]                        // discard string in local name after first +
                .replaceAll("\\.", "")        // remove all .
                .replaceAll("\\+", "");       // remove all +
        return String.join("@", broken);             // join to form standardized email address
    }

    /**
     * Logic:
     * We use set to keep track of 'distinct' addresses.
     * What we do before adding email to set is to reduce it to standard form using rules in the problem statements.
     */
    private static int cntDistinctEmails(String[] emails) {
        Set<String> st = new HashSet<>();
        for(String email : emails) {
            st.add(reduceEmail(email));
        }
        return st.size();
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASES
        System.out.println(cntDistinctEmails(new String[] {
                "a@leetcode.com",
                "b@leetcode.com",
                "c@leetcode.com"
        }));
        System.out.println(cntDistinctEmails(new String[] {
                "test.email+alex@leetcode.com",
                "test.e.mail+bob.cathy@leetcode.com",
                "testemail+david@lee.tcode.com"
        }));
    }
}
