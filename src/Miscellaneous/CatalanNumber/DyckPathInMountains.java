/**
 * Count number of Dyck paths of length 2N, which are sequences of equally-spaced north-east 
 * and south-east walks starting at the origin, ending on the X-axis, and never going below the X-axis.
 * You must return to ground at last (means # of ups = # of downs)
 */
package Miscellaneous.CatalanNumber;

/**
 * @author gaurav kabra
 * @since June 18, 2021
 */

import Miscellaneous.CatalanNumber.CatalanUtil.NThCatalanNumber;

public class DyckPathInMountains {

	// driver - main method
	public static void main(String[] args) {
		
		int N = 3;
		
		// TESTCASE
		System.out.println(NThCatalanNumber.catalanNumber(N));
	}

}
