/**
 * DEShaw
 * Given two integer arrays V and W of size N each which represent values and weights associated 
 * with N items respectively.
 * Also given an integer C which represents knapsack capacity.
 * Find out the maximum value subset of V such that sum of the weights of this subset is smaller than or equal to C, 
 * picking each item either completely or not (0-1 property). Also you can pick each item only once.
 * 
 * For more, see: https://tinyurl.com/01KnapsackPPT 
 * 				  and 
 *                https://tinyurl.com/01Knapsack
 */
package DP.Others;

/**
 * @author gaurav kabra
 * @since June 27, 2021
 */

public class Knapsack01 {
	
	private static int knapsackHelper(int[] V, int[] W, int C, int current, int[][] cache) {
		/**
		 * Logic:
		 * If Capacity of knapsack is <=0 or we run out of available items, return value 0.
		 * Else we check with (only if capacity allows us to include item) as well without item at current index.
		 * And return max of the two values.
		 * 
		 * Time Complexity : O(N*C)
		 * Space Complexity : O(N*W) (due to the use of 2D array for storing overlapping subproblems answer
		 */
        if(C <= 0 || current >= V.length)
            return 0;
            
        if(cache[current][C] != 0)
            return cache[current][C];
        int withItem = 0, withoutItem = 0;
        if(W[current] <= C) {
            withItem = V[current] + knapsackHelper(V, W, C-W[current], current+1, cache);
        }
        withoutItem = knapsackHelper(V, W, C, current+1, cache);
        return cache[current][C] = Math.max(withItem, withoutItem);
    }
    
    static int knapSack(int C, int W[], int V[]) 
    { 
        return knapsackHelper(V, W, C, 0, new int[V.length+1][C+1]);
    } 
    
    // driver - main method
	public static void main(String[] args) {
		
		// TESTCASE
		System.out.println(knapSack(41, new int[] {
				83,84,85,76,13,87,2,23,33,82,79,100,88,85,91,78,83,44,4,50,11,68,90,88,73,83,46,16,7,35,76,31,40,49,65,2,18,47,55,38,75,58,86,77,96,94,82,92,10,86,54,49,65,44,77,22,81,52
		}, new int[] {
				57,95,13,29,1,99,34,77,61,23,24,70,73,88,33,61,43,5,41,63,8,67,20,72,98,59,46,58,64,94,97,70,46,81,42,7,1,52,20,54,81,3,73,78,81,11,41,45,18,94,24,82,9,19,59,48,2,72
		}));

	}

}
