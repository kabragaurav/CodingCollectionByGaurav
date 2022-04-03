/*
Given two strings of uppercase letters source and target, list (in string form) a sequence of edits to convert
from source to target that uses the least edits possible.

For example, with strings source = "ABCDEFG", and target = "ABDFFGH" we might return:
["A", "B", "-C", "D", "-E", "F", "+F", "G", "+H"]

More formally, for each character C in source, we will either write the token C, which does not count as an edit;
or write the token -C, which counts as an edit.

Additionally, between any token that we write, we may write +D where D is any letter, which counts as an edit.

At the end, when reading the tokens from left to right, and not including tokens prefixed with a minus-sign,
the letters should spell out target (when ignoring plus-signs.)

In the example, the answer of A B -C D -E F +F G +H has total number of edits 4 (the minimum possible),
and ignoring subtraction-tokens, spells out A, B, D, F, +F, G, +H which represents the string target.

If there are multiple answers, use the answer that favors removing from the source first.

Constraints
 2 <= src.length, target.length <= 12
 */
package Company.Pramp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author gaurav kabra
 * @since 03/Apr/2022
 **/

public class DiffBetweenStrings {

    private static List<String> l = new ArrayList<>();
    private static int len = Integer.MAX_VALUE;

    private static void helper(String src, String target, ArrayList<String> ls, int i, int j, int l1, int l2, int edits) {

        if (i == l1 && j == l2) {           // if both are at end
            if (edits < len) {
                len = edits;
                l = new ArrayList<>(ls);
            }
            return;
        }

        if (i >= l1) {                      // if only i is at end
            while (j < l2) {
                ls.add("+" + target.charAt(j));
                edits++;
                j++;
            }
            if (edits < len) {
                len = edits;
                l = new ArrayList<>(ls);
            }
            return;
        }

        if (j >= l2) {                      // if only j is at end
            while (i < l1) {
                ls.add("-" + src.charAt(i));
                edits++;
                i++;
            }
            if (edits < len) {
                len = edits;
                l = new ArrayList<>(ls);
            }
            return;
        }

        if (src.charAt(i) == target.charAt(j)) {            // if chars are equal
            ls.add("" + src.charAt(i));
            helper(src, target, new ArrayList<>(ls), i+1, j+1, l1, l2, edits);
            ls.remove("" + src.charAt(i));
        } else {                                            // otherwise
            // If there are multiple answers, use the answer that favors removing from the source first.
            ls.add("-" + src.charAt(i));
            helper(src, target, new ArrayList<>(ls), i + 1, j, l1, l2, edits + 1);
            ls.remove(ls.size() - 1);
            ls.add("+" + target.charAt(j));
            helper(src, target, new ArrayList<>(ls), i, j + 1, l1, l2, edits + 1);
            ls.remove(ls.size() - 1);
        }
    }

    // TC : O(l1 * l2)
    // SC : O(l1 * l2)
    private static String[] diffBetweenTwoStrings(String src, String target) {
        // reset globals
        l.clear();
        len = Integer.MAX_VALUE;

        ArrayList<String> ls = new ArrayList<>();
        helper(src, target, ls, 0, 0, src.length(), target.length(), 0);

        String[] ans = new String[l.size()];
        for (int i=0; i<l.size(); i++) {
            ans[i] = l.get(i);
        }
        return ans;
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASE(S)
        System.out.println(Arrays.toString(diffBetweenTwoStrings("ABCDEFG", "ABDFFGH")));
        System.out.println(Arrays.toString(diffBetweenTwoStrings("CCBC", "CCBC")));
        System.out.println(Arrays.toString(diffBetweenTwoStrings("GHMXGHUGXL", "PPGGXHHULL")));
    }

}
