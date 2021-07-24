/**
 * Amazon, Zoho, Microsoft, Samsung
 * 
 * Consider a 2D plane and a Robot which is located at (0,0) 
 * who can move only one unit step at a time in any direction i.e. if its initial position is (x,y), 
 * he can go to positions (x + 1, y), (x - 1, y), (x, y + 1) or (x, y - 1). 
 * Now Given three integers a,b (denoting the final position where the robot has to reach), and x. 
 * Find out if the Robot can reach the final position in exactly x steps.
 * 
 * Constraints:
 * 	 -10^9 <= a,b <= 10^9
 * 	 1 <= x <= 2*10^9
 *   Expected TC : O(1) and SC : O(1)
 */
package Mathematical;

/**
 * @author gaurav kabra
 * @since July 24, 2021
 */

public class FinalDestination {
	
	private static boolean canReach(Long a, Long b, Long x) {
		/**
		 * Logic:
		 * If robot chooses the shortest path from (0,0) to (a,b), it takes at least |a| + |b| steps.
		 * Now consider when the number of steps is not less than |a| + |b|:
		 * 	When Robot arrives at (a, b), he can take two more steps such as 
		 * (a, b) -> (a, b + 1) -> (a, b) to remain at the same position.
		 * So we know that for all x such that x ≥ |a| + |b| and (x - (|a| + |b|))%2 = 0, there exists a way for robot to get to (a, b) in exactly x steps.
		 */
		a = Math.abs(a);
		b = Math.abs(b);
		
		return (x >= (a+b)) && ((x - (a+b) & 1) == 0);
	}
	
	// driver - main method
	public static void main(String[] args) {
		// TESTCASES
		System.out.println(canReach(0L,0L,8L));
		System.out.println(canReach(10L,15L,25L));
		System.out.println(canReach(5L,5L,11L));
	}

}
