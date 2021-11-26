/**
 * Given an integer num (base-10) in string form, return a string of its base 7 representation.
 */
package BitManipulation;

/**
 * @author gaurav kabra
 * @since 26 Nov 2021
 **/

public class Base7 {

    private final static int SOURCE_BASE = 10;

    /**
     * Logic:
     * The question is very simple.
     * But there are some catches in the java.lang.Integer class.
     *
     * parseInt
     *      : returns primitive int
     *      : accepts only String, else throws NumberFormatException
     *      : second arg indicates num is in what base. It will always be converted to base 10.
     *
     * valueOf
     *      : return Integer
     *      : accepts Character, String, Integer, else throws NumberFormatException
     *      : = new Integer(Integer.parseInt(s, radix))
     *
     * Both can be used here in converting String to integer.
     */
    private static String convertToBase7(String num) {
        return Integer.toString(Integer.parseInt(num, SOURCE_BASE), 7);
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASES
        System.out.println(convertToBase7("10"));
        System.out.println(convertToBase7("-7"));
    }
}
