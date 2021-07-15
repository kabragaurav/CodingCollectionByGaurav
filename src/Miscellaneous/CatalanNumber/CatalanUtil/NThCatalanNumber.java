package Miscellaneous.CatalanNumber.CatalanUtil;

/**
 * @author gaurav kabra
 * @since June 18, 2021
 * 
 * See more here: https://brilliant.org/wiki/catalan-numbers/
 */

public class NThCatalanNumber {
	
	public static int catalanNumber(int n) {
	/**
	 * Nth Catalan number Cn is defined as:
	 * Cn = C0*Cn-1 + C1*Cn-2 + ...
	 * Which boils down to (2n)! / ((n + 1)! n!)
	 * 
	 * Time Complexity : O(N2)
	 * Space Complexity : O(N) for array G
	 */
        int [] G = new int[n+1];
        G[0] = G[1] = 1;

        for(int i=2; i<=n; ++i) {
          for(int j=1; j<=i; ++j) {
            G[i] += G[j-1] * G[i-j];
          }
        }
        return G[n];
  }
	
}
