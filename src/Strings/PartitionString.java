/**
 * Given a string s. We want to partition the string into as many parts as possible
 * so that each letter appears in at most one part.
 * Return a list of integers representing the size of these parts.
 */
package Strings;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gaurav kabra
 * @since 2 Oct 2021
 **/

public class PartitionString {
    private static List<Integer> partitionString(String s) {
        int start = 0, end = 0;             // used to determine lengths of parts
        List<Integer> ans = new ArrayList<>();

        while(start <= end && start < s.length()) {         // traverse entire string
            char ch = s.charAt(start);
            end = s.lastIndexOf(ch);
            String temp = s.substring(start, end+1);        // take out candidate part from s
            // now for each character in part, see if remaining string has that. If so include part up to that, i.e. try expanding the part
            while(true) {
                boolean b = false;
                for(char c : temp.toCharArray()) {
                    int index = s.lastIndexOf(c);
                    if(index > end) {
                        end = index;
                        b = true;
                    }
                }
                if(!b) {                                    // if part could not be expanded, it is one answer
                    break;
                }
                temp = s.substring(start, end+1);           // else expand the part and try expanding again
            }

            int len = end-start+1;
            ans.add(len);
            start = end+1;
            end = start;
        }
        return ans;
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASE
        System.out.println(partitionString("qiejxqfnqceocmy"));
    }
}
