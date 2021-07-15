/**
 * Find gcd and lcm of two numbers N > 0.
 */
package Miscellaneous.UniqueConcepts;

/**
 * @author gaurav kabra
 * @since June 27, 2021
 */

public class EuclideGCD {
	
	// gcd is same as hcf
	private static int euclidGCDUsingModulo(int a, int b) {
		if(b == 0)
			return a;
		return euclidGCDUsingModulo(b, a%b);
	}
	
	private static int lcm(int a, int b) {
		/**
		 * Logic: a x b = hcf x lcm
		 */
		return (a*b)/euclidGCDUsingModulo(a, b);
	}
	
	// driver - main method
	public static void main(String[] args) {
		// TESTCASES
		System.out.println(lcm(5, 10));
		System.out.println(euclidGCDUsingModulo(5, 10));
	}

}
