/**
 * Given an input string s, reverse the order of the words.
 * A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.
 * Return a string of the words in reverse order concatenated by a single space.
 * Note that s may contain leading or trailing spaces or multiple spaces between two words.
 * The returned string should only have a single space separating the words. Do not include any extra spaces.
 */
package Strings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author gaurav kabra
 * @since 2 Sept 2021
 **/

public class ReverseWords {
    private static String reverseWords(String s) {
        String[] arr = s.replaceAll("\\s{2,}", " ")  // Replace more than one consecutive whitespaces with single whitespace
                        .trim()                                     // Remove leading and trailing whitespaces, if any
                        .split(" ");                           // Split on every whitespace
        List<String> ls = new ArrayList<>(List.of(arr));            // List.of() gives unmodifiable list. So convert to ArrayList.
        Collections.reverse(ls);                                    // Reverse using Collections
        return String.join(" ", ls);                        // Join each word in reversed list using a whitespace
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASE
        System.out.println(reverseWords("the sky        is blue"));
    }
}
