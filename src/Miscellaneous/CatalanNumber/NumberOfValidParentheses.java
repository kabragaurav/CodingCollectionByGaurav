/**
 * Find the number of valid parentheses expressions of length N, where N is even.
 */
package Miscellaneous.CatalanNumber;

/**
 * @author gaurav kabra
 * @since June 18, 2021
 */

import Miscellaneous.CatalanNumber.CatalanUtil.NThCatalanNumber;

public class NumberOfValidParentheses {

	// driver - main method
	public static void main(String[] args) {
		int lengthOfExpression = 6;
		
		// TESTCASE
		System.out.println(NThCatalanNumber.catalanNumber(lengthOfExpression/2));
	}

}
