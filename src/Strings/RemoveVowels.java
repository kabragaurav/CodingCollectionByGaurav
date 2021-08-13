/**
 * Amazon
 * Given a string, remove the vowels from the string and print the string without vowels.
 */
package Strings;

import java.util.stream.*;

/**
 * @author gaurav kabra
 * @since 13 August 2021
 */

public class RemoveVowels {

    private static boolean isNotVowel(char x) {
        x = Character.toLowerCase(x);
        return x != 'a' &&
                x != 'e' &&
                x != 'i' &&
                x != 'o' &&
                x != 'u';
    }

    private static void removeVowels(String s) {
        /**
         * Logic:
         * Convert s to char stream and filter remove vowels.
         */
        Stream<Character> charStream = s.chars().mapToObj(i->(char)i);
        charStream.filter( x -> isNotVowel(x)).forEach(System.out::print);
        System.out.println();
    }

    // driver - main method
    public static void main(String []args){
        // TESTCASES
        removeVowels("aeiou");
        removeVowels("xyz");
        removeVowels("hi");
        removeVowels("what is your name ?");
    }
}
