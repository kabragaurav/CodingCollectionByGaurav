/**
 * Given an integer n, return a string array answer (1-indexed) where:
     * answer[i] == "FizzBuzz" if i is divisible by 3 and 5.
     * answer[i] == "Fizz" if i is divisible by 3.
     * answer[i] == "Buzz" if i is divisible by 5.
     * answer[i] == i (as a string) if none of the above conditions are true.
 */
package Strings;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * @author gaurav kabra
 * @since 8 Dec 2021
 **/

public class FizzBuzz {

    private static List<String> fizzBuzz(int n) {
        List<String> ls = new ArrayList<String>();

        IntStream.range(1, n+1).forEach(x -> {
            if(x%3 == 0 && x%5 == 0) {
                ls.add("FizzBuzz");
            } else if(x%3 == 0) {
                ls.add("Fizz");
            } else if(x%5 == 0) {
                ls.add("Buzz");
            } else {
                ls.add(Integer.toString(x));
            }
        });
        return ls;
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASE
        fizzBuzz(15).forEach(x -> System.out.println(x));
    }
}
