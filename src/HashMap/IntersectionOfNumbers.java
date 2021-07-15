/**
 * Google
 * Given two integer arrays, return their intersection.
 * Note: the intersection is the set of elements that are common to both arrays.
 */
package HashMap;

import java.util.HashSet;
import java.util.Set;

/**
 * @author gaurav kabra
 * @since May 22, 2021
 */
public class IntersectionOfNumbers {
	
	/**
	 * @param arr1
	 * @param arr2
	 * @return intersection of arr1 & arr2 with distinct elements
	 * Time: O(N) since we traverse arr1 and arr2 once
	 * Space: O(N) since we store elements in sets and in worst case all elements are distinct
	 */
	private int[] getIntersectionBuiltInMethod(int[] arr1, int[] arr2) {
		/**
		 * Logic:
		 * We just have to check element in first array that is also present in second array and return distinct elements.
		 * This is nothing but interssection of sets.
		 * In Java, retailAll method is used to do intersection.
		 */
		Set<Integer> st1 = new HashSet<>(),
		st2 = new HashSet<>();
		
		int[] ans;
		
		for(int x : arr1)
			st1.add(x);
		for(int x : arr2)
			st2.add(x);
		/**
		 * addAll() does Union
		 * retailAll() does Intersection
		 * containsAll() checks for subset
		 * removeAll() takes set difference
		 * (see: https://docs.oracle.com/javase/tutorial/collections/interfaces/set.html)
		 */
		st1.retainAll(st2);  // st1 now contains only elements in both sets (Retains only the elements in this set that are contained in arg set)
		ans = new int[st1.size()];
		
		int i=0;
		for(int x : st1) {
			ans[i++] = x;
		}
		return ans;
	}
	
	/**
	 * @param arr1
	 * @param arr2
	 * @return intersection of arr1 & arr2 with distinct elements
	 * Time: O(N) since we traverse arr1 and arr2 once
	 * Space: O(N) since we store elements in sets and in worst case all elements are distinct
	 */
	private int[] getIntersection(int[] arr1, int[] arr2) {
		Set<Integer> st = new HashSet<>();
		Set<Integer> ans = new HashSet<>();
		
		for(int x : arr1)
			st.add(x);
		for(int x : arr2) {
			if(st.contains(x))
				ans.add(x);
		}
		Integer[] temp = ans.stream().toArray(Integer[]::new);
		int[] ret = new int[temp.length];
		
		for(int i=0; i<temp.length; i++) {
			ret[i] = temp[i];
		}
		return ret;
	}
	
	// Helper method for main method
	// prints array contents
	private void displayAns(int[] ans) {
		for(int x : ans)
			System.out.print(x+" ");
		System.out.println();
	}
	
	// driver - main method
	public static void main(String[] args) {
		IntersectionOfNumbers ion = new IntersectionOfNumbers();
		int[] ans;
		
		// TESTCASES
		ans = ion.getIntersection(new int[]{2, 4, 4, 2}, new int[]{2, 4});
		ion.displayAns(ans);
		ans = ion.getIntersection(new int[]{1, 2, 3, 3}, new int[]{3, 3});
		ion.displayAns(ans);
		ans = ion.getIntersection(new int[]{2, 4, 6, 8}, new int[]{1, 3, 5, 7});
		ion.displayAns(ans);
		
		ans = ion.getIntersectionBuiltInMethod(new int[]{2, 4, 4, 2}, new int[]{2, 4});
		ion.displayAns(ans);
		ans = ion.getIntersectionBuiltInMethod(new int[]{1, 2, 3, 3}, new int[]{3, 3});
		ion.displayAns(ans);
		ans = ion.getIntersectionBuiltInMethod(new int[]{2, 4, 6, 8}, new int[]{1, 3, 5, 7});
		ion.displayAns(ans);
	}

}
