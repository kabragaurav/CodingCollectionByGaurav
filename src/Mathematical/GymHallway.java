/**
 * Facebook, Microsoft, Infosys
 * In a gym hallway there are N lockers. You walk back and forth down the hallway opening and closing lockers.
 * On your first pass you open all the lockers. On your second pass, you close every second locker. 
 * On your third pass you open every third locker. 
 * After walking the hallway N times opening/closing lockers in the previously described manner, 
 * how many locker are left open?
 */
package Mathematical;

/**
 * @author gaurav kabra
 * @since August 08, 2021
 */

public class GymHallway {
	
	private static int numberOfOpenLockers(int N) {
		/**
		 * Logic:
		 * For any given door, say door 42, we will visit it for every divisor it has. 
		 * So 42 has 1 & 42, 2 & 21, 3 & 14, 6 & 7. So on pass 1 we will open the door, pass 2 we will close it,
		 * pass 3 open, pass 6 close, pass 7 open, pass 14 close, pass 21 open, pass 42 close. 
		 * For every pair of divisors the door will just end up back in its initial state. 
		 * So we might think that every door will end up closed? 
		 * Well what about door 9. 9 has the divisors 1 & 9, 3 & 3. But 3 is repeated because 9 is a perfect square, 
		 * so you will only visit door 9, on pass 1, 3, and 9. So leaving it open at the end. 
		 * 
		 * Crux : Only perfect square doors will be open at the end.
		 * 
		 * So the problem is to count number of perfect squares from [1,N]
		 * 
		 * Time Complexity : O(1)
		 * Space Complexity : O(1)
		 */
		return (int) Math.floor(Math.sqrt(N));
	}
	
	// driver - main method
	public static void main(String[] args) {
		// TESTCASES
		System.out.println(numberOfOpenLockers(1));
		System.out.println(numberOfOpenLockers(2));
		System.out.println(numberOfOpenLockers(100));
		System.out.println(numberOfOpenLockers(200));
		System.out.println(numberOfOpenLockers(10000));
	}

}
