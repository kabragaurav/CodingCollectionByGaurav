/**
 * Google
 * Given a positive integer N, return the number of prime numbers less than N.
 */
package Mathematical;

/**
 * @author gaurav kabra
 * @since August 08, 2021
 */

import java.util.Arrays;

public class CountPrimes {
	private static int countPrimes(int N) {
		/**
		 * Logic:
		 * This is called sieve of Erastosthenes.
		 * 
		 * Algorithm can be found here: https://tinyurl.com/sieve-of-erastosthenes
		 * 
		 * Time Complexity : O(NloglogN)
		 * Space Complexity : O(N) for isPrime array
		 */
        if(N <= 1)
            return 0;
        int[] isPrime = new int[N];
		Arrays.fill(isPrime, 1);
        isPrime[0] = isPrime[1] = 0;
		for(int i=2; i*i <N; i++) {
			if(isPrime[i] == 1) {
				for(int j=i*i; j<N; j += i) {
					isPrime[j] = 0;
				}
			}
		}
		return Arrays.stream(isPrime).reduce(0,
				(subtotal, element) -> subtotal + element);
		
    }

	public static void main(String[] args) {
		System.out.println(countPrimes(0));
		System.out.println(countPrimes(1));
		System.out.println(countPrimes(2));
		System.out.println(countPrimes(10));
	}

}
