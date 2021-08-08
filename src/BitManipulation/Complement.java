/**
 * Given an integer N, N >= 1, return its complement.
 * The complement of an integer is the integer you get when you flip all the 0s to 1s and all the 1s to 0s
 * in its binary representation. You should not consider starting 0s.
 */
package BitManipulation;

/**
 * @author gaurav kabra
 * @since August 08, 2021
 */

public class Complement {
	
	private static int getComplement(int N) {
		/**
		 * Logic:
		 * First convert N to binary string without beginning 0s. E.g. 5 to "101".
		 * Then flip the characters from '0' to '1' and vice-versa.
		 * Then convert it bacck to decimal.
		 * 
		 * Utilities:
		 * convert to binary : Integer.toBinaryString(decimalNumber)
		 * convert to decimal : Integer.parseInt(binaryString, 2)
		 */
		String binaryStr = Integer.toBinaryString(N);  
		char[] binaryRepr = binaryStr.toCharArray();
		for(int i=0; i<binaryRepr.length; i++) {
			binaryRepr[i] = binaryRepr[i] == '0' ? '1' : '0';
 		}
		return Integer.parseInt(new String(binaryRepr),2);
	}
	
	// driver - main method
	public static void main(String[] args) {
		// TESTCASES
		System.out.println(getComplement(5));
		System.out.println(getComplement(1));
	}

}
