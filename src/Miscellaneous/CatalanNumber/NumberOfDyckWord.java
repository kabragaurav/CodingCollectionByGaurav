/**
 * Given an integer N, the task is to count Dyck words possible of length N, N is even. 
 * A Dyck word is a word containing choosing only from characters 'A' and 'B'
 * such that in every prefix of the word frequency('A') ≥ frequency('B').
 * In each word, number of 'A' should be equal to number of 'B'.
 */
package Miscellaneous.CatalanNumber;

import Miscellaneous.CatalanNumber.CatalanUtil.NThCatalanNumber;

public class NumberOfDyckWord {

	// driver - main method
	public static void main(String[] args) {
		
		int N = 6;
		
		// TESTCASE
		System.out.println(NThCatalanNumber.catalanNumber(N/2));
	}

}
