/**
 * Arcesium
 * Given an array of non-negative integers arr, a frog is initially positioned at index 0.
 * Each element in the array represents maximum jump length from that position to right.
 * Your goal is to find the the minimum number of jumps for frog to reach last index of array.
 * If the frog cannot reach end, return -1.
 */
package DP.Others;

/**
 * @author gaurav kabra
 * @since June 26, 2021
 */

public class MinJumpsToReachEnd {
	
	private int jump(int[] arr) {
		/**
		 * Logic:
		 * min_jumps[i] represents minimum jumps required to reach i from 0
		 * We want to jump from position j to i (j < i).
		 * We can jump iff arr[j] >= (i-j).
		 * Moreover before jump, we assume we cannot reach i from j. So we set arr[i] = Integer.MAX_VALUE
		 * Our final answer is min_jumps[N-1]
		 * 
		 * Time Complexity: O(N^2) since we have two nested loops
		 * Space Complexity: O(N) since we need extra array min_jumps
		 */
        int N = arr.length;
        int[] min_jumps = new int[N];
        
        for(int i=1; i<N; i++) {
            min_jumps[i] = Integer.MAX_VALUE;
            for(int j=0; j<i; j++) {
                if(arr[j] >= (i-j)) {
                    min_jumps[i] = Math.min(min_jumps[i],
                                           min_jumps[j]+1);
                    break;
                }
            }
        }
        return (min_jumps[N-1] == Integer.MAX_VALUE 
        		|| min_jumps[N-1] < 0) ? -1
        				               : min_jumps[N-1];
    }
	
	// driver - main method
	public static void main(String[] args) {
		// TESTCASE
		System.out.println(new MinJumpsToReachEnd().jump(new int[] {2,3,1,1,4}));
		System.out.println(new MinJumpsToReachEnd().jump(new int[] {0, 2, 3}));
	}

}
