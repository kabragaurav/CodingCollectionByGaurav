/**
 * You are transporting bricks on a construction site and want to work as efficiently as possible. 
 * The weight of each brick is given by bricks[i].
 * Given a wheelbarrow that can carry up to (not including) capacity pounds (say 5000),
 * return then maximum number of bricks you can place in your wheelbarrow to transport.
 */
package GreedyAndTwoPointer;

import java.util.Arrays;

/**
 * @author gaurav kabra
 * @since July 13, 2021
 */

public class TransportBricks {
	
	private int maxNumberOfBricks(int[] weights, int capacity) {
		/**
		 * Logic:
		 * We can maximize # of bricks if we pick lighter bricks
		 * So we sort the weights array
		 * We pick up bricks till total weight of picked bricks is < capacity
		 * 
		 * Time Complexity : O(NlogN) for sorting
		 * Space Complexity : O(1)
		 */
		Arrays.sort(weights);
		int totalWeightSoFar = 0;
		int countSoFar = 0;
		for(int weight : weights) {
			totalWeightSoFar += weight;
			countSoFar++;
			if(totalWeightSoFar >= capacity) {
				break;
			}
		}
		return totalWeightSoFar >= capacity ? countSoFar-1 : countSoFar;
	}
	
	// driver - main method
	public static void main(String[] args) {
		TransportBricks tb = new TransportBricks();
		// TESTCASES
		System.out.println(tb.maxNumberOfBricks(new int[] {1, 12, 5, 111, 200, 1000, 10, 9, 12, 15}, 50));
		System.out.println(tb.maxNumberOfBricks(new int[] {1, 12, 5, 111, 200, 1000, 10}, 50));
		System.out.println(tb.maxNumberOfBricks(new int[] {1000, 1000, 1000, 2000}, 5000));
		System.out.println(tb.maxNumberOfBricks(new int[] {1000, 200, 150, 200}, 5000));
		
	}

}
