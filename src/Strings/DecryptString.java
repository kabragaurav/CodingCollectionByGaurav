/*
You are given a string s formed by digits and '#'. We want to map s to English lowercase characters
as follows:

    Characters ('a' to 'i') are represented by ('1' to '9') respectively.
    Characters ('j' to 'z') are represented by ('10#' to '26#') respectively.

Return the string formed after mapping.

The test cases are generated so that a unique mapping will always exist.
 */
package Strings;

/**
 * @author gaurav kabra
 * @since 03/Apr/2022
 **/

public class DecryptString {

    // TC : O(N)
    // SC : O(1)
    private static String freqAlphabets(String s) {
        return s.replaceAll("10#", "j")
                .replaceAll("11#", "k")
                .replaceAll("12#", "l")
                .replaceAll("13#", "m")
                .replaceAll("14#", "n")
                .replaceAll("15#", "o")
                .replaceAll("16#", "p")
                .replaceAll("17#", "q")
                .replaceAll("18#", "r")
                .replaceAll("19#", "s")
                .replaceAll("20#", "t")
                .replaceAll("21#", "u")
                .replaceAll("22#", "v")
                .replaceAll("23#", "w")
                .replaceAll("24#", "x")
                .replaceAll("25#", "y")
                .replaceAll("26#", "z")
                .replaceAll("1", "a")
                .replaceAll("2", "b")
                .replaceAll("3", "c")
                .replaceAll("4", "d")
                .replaceAll("5", "e")
                .replaceAll("6", "f")
                .replaceAll("7", "g")
                .replaceAll("8", "h")
                .replaceAll("9", "i");

    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASE(S)
        System.out.println(freqAlphabets("1326#"));
        System.out.println(freqAlphabets("10#11#12"));
    }

}
