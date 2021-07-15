/**
 * Given N non-negative integers representing an elevation map where
 * the width of each bar is 1, calculate maximum volume of water it can trap during raining.
 */
package Miscellaneous.UniqueConcepts;

/**
 * @author gaurav kabra
 * @since June 18, 2021
 */

public class TrappingRainWater {
	
	private int volumeOfTrappedWater(int[] heightOfBars) {
		/**
		 * Logic:
		 * Water above any bar will be :
		 * minimum of (maximum length of bar to left, maximum length of bar to right) - length of current bar
		 * 
		 * Time complexity: O(N) since we store the maximum heights upto a point using 2 iterations of O(N) each.
		 * Space complexity: O(N) extra space in form of arrays that store max to left and max to right.
		 */
		
		int sum = 0;											// final answer
		int totalNumberOfBars = heightOfBars.length;
		int max = Integer.MIN_VALUE;							// variable to find maximum length bars to left and right for current bar
		
		int[] maxToLeft = new int[totalNumberOfBars];
		for(int i=0; i < totalNumberOfBars; i++) {
			if(max < heightOfBars[i]) {
				max = heightOfBars[i];
			}
			maxToLeft[i] = max;
		}
		
		int[] maxToRight = new int[totalNumberOfBars];
		max = Integer.MIN_VALUE;
		for(int i=totalNumberOfBars-1; i >=0 ; i--) {
			if(max < heightOfBars[i]) {
				max = heightOfBars[i];
			}
			maxToRight[i] = max;
		}
		
		for(int i=0; i<totalNumberOfBars; i++) {
			sum += Math.min(maxToLeft[i], maxToRight[i]) - heightOfBars[i];
		}
		
		return sum;
	}
	
	// driver - main method
	public static void main(String[] args) {
		
		TrappingRainWater trw = new TrappingRainWater();
		
		// TESTCASES
		System.out.println(trw.volumeOfTrappedWater(new int[] {4,2,0,3,2,5}));
		System.out.println(trw.volumeOfTrappedWater(new int[] {2,1,2}));
		System.out.println(trw.volumeOfTrappedWater(new int[] {}));
		System.out.println(trw.volumeOfTrappedWater(new int[] {1,2,3,4}));
		System.out.println(trw.volumeOfTrappedWater(new int[] {4,3,2,1}));
		System.out.println(trw.volumeOfTrappedWater(new int[] {1,2,1}));
	}

}
