/**
 * Amazon
 * Given a string representing the sequence of moves a robot vacuum makes, return whether or not it will 
 * return to its original position. 
 * The string will only contain L, R, U, and D characters, representing left, right, up, and down respectively.
 */
package Strings;
/**
 * @author gaurav kabra
 * @since May 21, 2021
 */
public class VaccumCleaner {
	
	/**
	 * @param string of moves, s
	 * @return is vaccum cleaner returns to original position
	 * Time: O(N) as iterate the string linearly
	 * Space: O(1) as don't use any additional space
	 */
	private boolean doesReturnToOriginal(String s) {
		/**
		 * Logic:
		 * We return to same position if:
		 * 		# of left moves = # of right moves
		 * 		AND
		 * 		# of up moves = # of down moves
		 */
		long l = s.chars().filter(ch -> ch == 'L').count(),
		r = s.chars().filter(ch -> ch == 'R').count(),
		u = s.chars().filter(ch -> ch == 'U').count(),
		d = s.chars().filter(ch -> ch == 'D').count();
		
		return (l == r) && (u == d);     // same as l == r && u == d; but has more clarity
	}
	
	
	// driver - main method
	public static void main(String[] args) {
		
		VaccumCleaner vc = new VaccumCleaner();
		
		// TESTCASES
		System.out.println(vc.doesReturnToOriginal("LR"));
		System.out.println(vc.doesReturnToOriginal("URURD"));
		System.out.println(vc.doesReturnToOriginal("RUULLDRD"));
	}

}
