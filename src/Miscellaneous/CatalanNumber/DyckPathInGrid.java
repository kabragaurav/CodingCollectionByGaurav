/**
 * Consider a N x N grid. Dyck path is a staircase walk from bottom left to top right that lies below or on the diagonal cells.
 * Count the number of Dyck Paths. Once you move forward, you never come backwards again.
 * 
 * Equivalent problem is: A man walks N blocks north and N blocks west of his residence. 
 * Every day he has 2N blocks to walk. 
 * How many routes are possible if he never crosses the diagonal line from home to office?
 */
package Miscellaneous.CatalanNumber;

import Miscellaneous.CatalanNumber.CatalanUtil.NThCatalanNumber;

public class DyckPathInGrid {

	// driver - main method
	public static void main(String[] args) {
		
		// TESTCASE
		System.out.println(NThCatalanNumber.catalanNumber(3));
	}

}
