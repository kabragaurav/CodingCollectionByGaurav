/**
 * Apple
 * Given two binary strings (strings containing only 1s and 0s) return their sum (also as a binary string).
 * Note: neither binary string will contain leading 0s unless the string itself is 0
 */
package Strings;
/**
 * @author gaurav kabra
 * @since May 21, 2021
 */
public class AddBinary {
	/**
	 * Adds two binary strings to another binary string. Works fine with very long strings (say length=10k)
	 * @param first binary string, bin1
	 * @param second binary string, bin2
	 * @return sum of the two binary strings as binary string
	 * 
	 * Time: O(N) as we traverse both strings from back to front linearly
	 * Space: O(1) as we don't use any additional space
	 */
	private String addBinaryStringsManual(String bin1, String bin2) {
		/**
		 * Logic:
		 * We add the strings from right to left (as we do using pen-and-paper).
		 * We follow these rules:
		 * 
		 * 
		 * Left		Right		Current Carry		Result 		Next Carry
		 * 0		0			0					0			0
		 * 0		0			1					1			0
		 * 0		1			0					1			0
		 * 0		1			1					0			1
		 * 1		0			0					1			0
		 * 1		0			1					0			1
		 * 1		1			0					0			1
		 * 1		1			1					1			1
		 */
        int len1 = bin1.length();
        int len2 = bin2.length();
        
        int i = len1-1, j = len2-1;
        int carry = 0;
        // we use StringBuilder instead of String as at last we will need to reverse ans, which is very easy with StringBuilder
        StringBuilder ans = new StringBuilder();
        // while one of string exhausts, we continue adding
        while(i>=0 && j>=0) {
            int ch1 = bin1.charAt(i)-'0';
            int ch2 = bin2.charAt(j)-'0';
            if(ch1 == 1 && ch2 == 1) {
                ans.append(carry == 0 ? 0: 1);
                carry = 1;
            }
            else if(ch1 == 0 && ch2 == 0) {
            	ans.append(carry == 0 ? 0: 1);
                carry = 0;
            }
            else {
            	ans.append(carry == 0 ? 1: 0);
            }
            i--;
            j--;
        }
        // if first string is not yet exhausted
        while(i>=0) {
            int ch = bin1.charAt(i)-'0';
            if(ch == 0) {
                if(carry == 1) {
                    ans.append(1);
                    carry = 0;
                }
                else {
                    ans.append(0);
                }
            }
            else {
                ans.append(carry == 1 ? 0: 1);
            }
            i--;
        }
        // if second string is not yet exhausted
        while(j>=0) {
            int ch = bin2.charAt(j)-'0';
            if(ch == 0) {
                if(carry == 1) {
                    ans.append(1);
                    carry = 0;
                }
                else {
                    ans.append(0);
                }
            }
            else {
                ans.append(carry == 1 ? 0: 1);
            }
            j--;
        }
        if(carry != 0)
            ans.append(carry);
        return ans.reverse().toString();
   }
	
	/**
	 * Adds two binary strings to another binary string. NOT SUITABLE FOR VERY LARGE STRINGS (SAY LENGTH 10k, THROWS NumberFormatException).
	 * @param first binary string, bin1
	 * @param second binary string, bin2
	 * @return sum of the two binary strings as binary string
	 * 
	 * Time: O(N) as O(N) for parseInt method and O(logN) for toBinaryString method
	 * Space: O(1) as we don't use any additional space
	 */
	private String addBinaryStringsUsingBuiltIn(String bin1, String bin2) {
		/**
		 * Logic:
		 * We convert binary to decimal. Add decimal and reconvert to binary.
		 */
		int decimal1 = Integer.parseInt(bin1, 2);
		int decimal2 = Integer.parseInt(bin2, 2);
		
		return Integer.toBinaryString(decimal1+decimal2);
	}

	public static void main(String[] args) {
		AddBinary ab = new AddBinary();
		
		// Using built-in methods
		System.out.println(ab.addBinaryStringsUsingBuiltIn("100", "1"));
		System.out.println(ab.addBinaryStringsUsingBuiltIn("11", "1"));
		System.out.println(ab.addBinaryStringsUsingBuiltIn("1", "0"));
		
		// Without built-in methods
		System.out.println(ab.addBinaryStringsManual("100", "1"));
		System.out.println(ab.addBinaryStringsManual("11", "1"));
		System.out.println(ab.addBinaryStringsManual("1", "0"));
		
	}

}
