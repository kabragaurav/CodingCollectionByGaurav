/**
 * Given two strings, find the number of times the second string occurs
 * in the first string.
 */
package Strings;

import org.apache.commons.lang3.StringUtils;

/**
 * Downloading Apache commons jar: https://tinyurl.com/download-apache-jar
 * Adding downloaded jar to IJ: https://tinyurl.com/add-jar-intellij
 *
 * @author gkabra
 * @since 15-01-2022 Sat
 **/

public class FrequencyOfASubstring {

    private static int freqOfASubstring(String sequence, String word) {
        return StringUtils.countMatches(sequence, word);
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASES
        System.out.println(freqOfASubstring("abcabcab", "abc"));
        System.out.println(freqOfASubstring("ccc", "c"));
        System.out.println(freqOfASubstring("ccc", "cc"));
        System.out.println(freqOfASubstring("banana", "nn"));
    }
}
