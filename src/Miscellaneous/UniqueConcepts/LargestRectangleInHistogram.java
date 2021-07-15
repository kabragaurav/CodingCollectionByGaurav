/**
 * Given an array of integers representing the heights of bars in histogram from left to right.
 * The width of each bar is 1. Find the area of the largest rectangle in the histogram.
 */
package Miscellaneous.UniqueConcepts;

import java.util.Stack;

/**
 * @author gaurav kabra
 * @since June 19, 2021
 *
 */

public class LargestRectangleInHistogram {
	
	private int largestRectangleArea(int[] heights) {
		/**
		 * Logic:
		 * We will store indices, not actual heights, in the stack.
		 * Then we can quickly lookup heights using heights[removed index]
		 * 
		 * Time Complexity: O(N) since looping once through heights array
		 * Space Complexity: O(N) since we use a stack in the algorithm
		 */
        
        Stack<Integer> stk = new Stack<>();
        
        int removedTop = 0;			// stores index that is just removed from stack
        int tempArea = 0;			// stores area on temporary basis
        int ansArea = 0;			// our final answer
        int i = 0;					// variable for loop
        
        while(i<heights.length) {
            if(stk.isEmpty() || heights[i] >= heights[stk.peek()]) {
                stk.push(i++);
            }
            else {
                removedTop = stk.pop();
                tempArea = heights[removedTop] * (stk.isEmpty() ? i : (i-stk.peek()-1));
                if(tempArea > ansArea)
                    ansArea = tempArea;
           }
        }
        
        while(!stk.isEmpty()) {
        	removedTop = stk.pop();
            tempArea = heights[removedTop] * (stk.isEmpty() ? i : (i-stk.peek()-1));
            if(tempArea > ansArea)
                ansArea = tempArea;
        }
        
        return ansArea;
    }
	
	// driver - main method
	public static void main(String[] args) {
		LargestRectangleInHistogram lrih = new LargestRectangleInHistogram();
		
		// TESTCASE
		System.out.println(lrih.largestRectangleArea(new int[] {6, 2, 5, 4, 5, 1, 6}));
	}

}
