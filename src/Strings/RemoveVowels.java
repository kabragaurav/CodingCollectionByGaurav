/**
 * Amazon
 * Given a string, remove the vowels from the string and print the string without vowels.
 */
package Strings;

import java.util.stream.Stream;

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

    private static String removeVowels(String s) {
        /**
         * Logic:
         * Convert s to char stream and filter remove vowels.
         */
        StringBuilder sb = new StringBuilder();
        Stream<Character> charStream = s.chars()            // gives IntStream
                                        .mapToObj(i->(char)i);      // convert int to char
        // instead you could try print here only
        // using forEach(System.out::print);
        charStream.filter( x -> isNotVowel(x)).forEach(x -> sb.append(x));
        return sb.toString();
    }

    // driver - main method
    public static void main(String []args){
        // TESTCASES
        System.out.println(removeVowels("aeiou"));
        System.out.println(removeVowels("xyz"));
        System.out.println(removeVowels("hi"));
        System.out.println(removeVowels("what is your name ?"));
    }
}
