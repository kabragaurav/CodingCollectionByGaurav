/**
 * Count ways to divide circle using N non-intersecting chords.
 * 
 * In other words, You are given 2*N points on circle, 
 * in how many ways can you connect them without intersecting any two lines? One point may only be on one chord.
 * You must use all points. 
 */
package Miscellaneous.CatalanNumber;

/**
 * @author gaurav kabra
 * @since June 18, 2021
 */

import Miscellaneous.CatalanNumber.CatalanUtil.NThCatalanNumber;

public class DivideCircleInNonIntersectingChords {

	// driver - main method
	public static void main(String[] args) {
		
		int twoN = 18;
		
		// TESTCASE
		System.out.println(NThCatalanNumber.catalanNumber(twoN/2));
	}

}
