/**
 * Apple, LinkedIn
 * There are a row of N houses, each house can be painted with one of the three colors: Orange, White or Green.
 * The cost of painting each house with a certain color may be different because houses may differ in sizes. 
 * You have to paint all the houses such that no two adjacent houses have the same color.
 * The cost of painting each house with a certain color is represented by a N x 3 cost matrix A.
 * For example, A[0][0] is the cost of painting house 0 with color Orange;
 * A[1][2] is the cost of painting house 1 with color Green, and so on.
 * Find the minimum total cost to paint all houses.
 */

package DP.Others;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author gaurav kabra
 * @since July 25, 2021
 */

public class PaintHouse {

    private static int paintHouse(List<List<Integer>> A, int N) {
    	/**
    	 * Time Complexity : O(N) since we iterate once over A.
    	 * Space Complexity : O(N) for we use cache of size N*3.
    	 */
    	
    	int[][] cache = new int[N][3];
    	cache[0][0] = A.get(0).get(0);
    	cache[0][1] = A.get(0).get(1);
    	cache[0][2] = A.get(0).get(2);
    	
    	for(int i=1; i<N; i++) {
    		cache[i][0] = A.get(i).get(0) + Math.min(cache[i-1][1], cache[i-1][2]);
    		cache[i][1] = A.get(i).get(1) + Math.min(cache[i-1][0], cache[i-1][2]);
    		cache[i][2] = A.get(i).get(2) + Math.min(cache[i-1][0], cache[i-1][1]);
    	}
    	
    	return Math.min(cache[N-1][0],
    			Math.min(cache[N-1][1], cache[N-1][2]));
    }
    
    // driver - main method
	public static void main(String[] args) {
		
		// TESTCASES
		List<List<Integer>> ls = new ArrayList<>();
		Integer[] a = new Integer[] {11, 12, 13};
		Integer[] b = new Integer[] {14, 15, 16};
		ls.add(Arrays.asList(a));
		ls.add(Arrays.asList(b));
		System.out.println(paintHouse(ls, 2));
		
		ls = new ArrayList<>();
		a = new Integer[] {1, 2, 3};
		b = new Integer[] {10, 11, 12};
		ls.add(Arrays.asList(a));
		ls.add(Arrays.asList(b));
		System.out.println(paintHouse(ls, 2));
		
		ls = new ArrayList<>();
		a = new Integer[] {14, 2, 11};
		b = new Integer[] {11, 14, 5};
		Integer[] c = new Integer[] {14, 3, 10};
		ls.add(Arrays.asList(a));
		ls.add(Arrays.asList(b));
		ls.add(Arrays.asList(c));
		System.out.println(paintHouse(ls, 3));
		
		ls = new ArrayList<>();
		a = new Integer[] {1, 2, 3};
		b = new Integer[] {1, 4, 6};
		ls.add(Arrays.asList(a));
		ls.add(Arrays.asList(b));
		System.out.println(paintHouse(ls, 2));
	}

}
