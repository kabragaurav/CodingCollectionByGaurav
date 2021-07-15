/**
 * Euler's Polygon Division Problem:
 * In how many ways can a regular N-gon be divided into N-2 triangles 
 * by drawing N-3 non-crossing lines between vertices of the polygon
 * if different orientations are counted separately?
 */
package Miscellaneous.CatalanNumber;

/**
 * @author gaurav kabra
 * @since June 18, 2021
 */

import Miscellaneous.CatalanNumber.CatalanUtil.NThCatalanNumber;

public class PolygonTriangulation {

	// driver - main method
	public static void main(String[] args) {
		
		int N = 6;
		
		// TESTCASE
		System.out.println(NThCatalanNumber.catalanNumber(N-2));
	}

}
