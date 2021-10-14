/**
 * Facebook
 * Given a string s that contains parentheses and letters,
 * remove the minimum number of invalid parentheses to make the input string valid.
 * Return list of all possible results.
 * The list may have the valid strings in any order.
 */
package Miscellaneous.UniqueConcepts;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author gaurav kabra
 * @since 14 Oct 2021
 **/

public class RemoveInvalidParentheses {

    // set so that even if in multiple ways we get a string, we have it only once in our final answer
    private static Set<String> st = new HashSet<>();
    private static int minCount = Integer.MAX_VALUE;

    private static void dfs(String s, int lc, int rc, StringBuilder sb, int removalCount, int index) {
        // reached end
        if(index == s.length()) {
            // decide if want to include sb in final result
            if(removalCount == minCount && lc == rc) {      // that means a valid string, also all previously added strings are valid
                st.add(new String(sb));
            } else if(removalCount < minCount && lc == rc) { // that means a valid string, but all previously added strings are invalid
                    minCount = removalCount;
                    st.clear();                             // invalidate previous results
                    st.add(new String(sb));
            }
            return;
        }

        // grab current char
        char currChar = s.charAt(index);
        // if it is a letter. E.g. 'a'
        if(currChar != '(' && currChar != ')') {
            // then just add it as it is and do dfs
            dfs(s, lc, rc, sb.append(currChar), removalCount, index+1);
        } else {    // it is either '(' or ')'
            dfs(s, lc, rc, sb, removalCount+1, index+1);        // once don't pick it
            sb.append(currChar);                                                // once pick it

            if(currChar == '(') {                                               // it added char is '('
                dfs(s, lc+1, rc, sb, removalCount, index+1);            // lc++
            } else if(lc > rc) {                                               // else it is ')'. Add right parenthesis only when lc>rc
                dfs(s, lc, rc+1, sb, removalCount, index+1);           // rc++
            }
        }
        sb.deleteCharAt(sb.length()-1);
    }

    // Perform dfs, populate set and return arraylist made from it
    private static List<String> removeInvalidParentheses(String s) {
        dfs(s,0,0,new StringBuilder(),0,0);
        return new ArrayList<>(st);
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASE
        removeInvalidParentheses("()())()").stream().forEach(x -> System.out.println(x));
        st.clear();
        minCount = Integer.MAX_VALUE;
        removeInvalidParentheses("(a)())()").stream().forEach(x -> System.out.println(x));

    }
}
