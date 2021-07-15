/**
 * Count the number of prime numbers LESS THAN a non-negative number N.
 */
package Miscellaneous.UniqueConcepts;

/**
 * @author gaurav kabra
 * @since June 27, 2021
 */

import java.util.Arrays;

public class SieveOfErastosthenes {
	
	private static int sieve(int N) {
		/**
		 * Logic: 
		 * 0 and 1 are non-prime numbers.
		 * So we start from 2. We keep an array and assume each number is prime and hence initialize it with 1.
		 * Then we run outer loop from [2,sqrt(N)).
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
		
		// count and return number of 1's remaining in the array. This will be number of primes < N.
		return Arrays.stream(isPrime).reduce(0,
				(subtotal, element) -> subtotal + element);
		
	}
	
	// driver - main method
	public static void main(String[] args) {
		
		// TESTCASES
		System.out.println(sieve(10));
		System.out.println(sieve(2));
		System.out.println(sieve(0));
	}

}
