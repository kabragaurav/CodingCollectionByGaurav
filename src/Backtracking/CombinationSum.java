/**
 * Apple
 * Given a list of positive numbers without duplicates and a target number, 
 * find all unique combinations of the numbers that sum to the target.
 * You may use the same number more than once.
 */
package Backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gaurav kabra
 * @since July 10, 2021
 */

public class CombinationSum {
    private static List<List<Integer>> ls = new ArrayList<>();
    
    private boolean isSafe(int target, int currentElement) {
        return target >= currentElement;
    }
    
    private void canFindSum(int[] candidates, int target, int currentIndex, List<Integer> t, int N) {
    	/**
    	 * Logic:
    	 * We check at each element in candidates array, if it can be used to reach near to target
    	 * If so, we include it and see if target can be reached
    	 */
        if(target == 0) {
            ls.add(new ArrayList<>(t));
            return;
        }
        for(int i=currentIndex; i<N; i++) {
            if(isSafe(target, candidates[i])) {
                t.add(candidates[i]);
                canFindSum(candidates, target-candidates[i], i, t, N);  // since we can take an element more than once, so we again pass i, not i+1
                t.remove(t.size()-1);   //  backtrack. Due to this, just before we do i++ in for loop, our t will again be empty and hence no need to create new empty list.
            }
        }
        
    }
    
    private List<List<Integer>> combinationSum(int[] candidates, int target) {
        canFindSum(candidates, target, 0, new ArrayList<>(), candidates.length);
        return ls;
    }
    
    // driver - main method
	public static void main(String[] args) {
		CombinationSum cs = new CombinationSum();
		// TESTCASES
		System.out.println(cs.combinationSum(new int[] {1}, 1));
		ls.clear();
		System.out.println(cs.combinationSum(new int[] {1}, 2));
		ls.clear();
		System.out.println(cs.combinationSum(new int[] {1,2,3}, 5));
	}

}
