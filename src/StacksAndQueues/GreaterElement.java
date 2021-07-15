/**
 * Amazon
 * Given two arrays of numbers, where the first array is a subset of the second array, 
 * return an array containing all the next greater elements for each element in the first array, 
 * in the second array. If there is no greater element for any element, output -1 for that number.
 */
package StacksAndQueues;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author gaurav kabra
 * @since June 5, 2021
 */
public class GreaterElement {
	
	private int[] getNextGreaterElemet(int[] arr1, int[] arr2) {
		/**
		 * Logic:
		 * First to know if an element in arr2 appears in arr1, we create a map object (mp) and store elements of arr1 with their indices.
		 * Then we start traversing arr2 from right to left using variable ptr.
		 * We maintain a stack to keep elements of arr2 temporarily.
		 * 
		 * While ptr does not traverse arr2 (i.e. while ptr >=0), we check if current element pointed by ptr is in arr1.
		 * If so then we need to find out next greater element for this element in arr2. If not then simply store element in stack and decrease ptr.
		 * So we keep removing element from stack till we get a greater element.
		 * If in the process we get empty stack, then we store -1 for the element and push the element to stack always.
		 * 
		 * Time Complexity : O(N) since we push and pop each element at most once.
		 * Space Complexity : O(N) since we use stack as auxiliary storage.
		 */
		Map<Integer, Integer> mp = new HashMap<>();
		int[] ans = new int[arr1.length];		// our final result to return
		int ans_i;								// will be used to contain index of an element in arr1, obtained from mp
		
		for(int i=0; i<arr1.length; i++) {
			mp.put(arr1[i], i);
		}
		
		int ptr = arr2.length-1;
		Stack<Integer> stk = new Stack<>();
		
		while(ptr >=0) {
			if(mp.containsKey(arr2[ptr])) {
                ans_i = mp.get(arr2[ptr]);
				while(!stk.isEmpty() && stk.peek() <= arr2[ptr]) {
					stk.pop();
				}
				if(stk.isEmpty()) {
					stk.push(arr2[ptr--]);
					ans[ans_i] = -1;	
				}
				else {
					ans[ans_i] = stk.peek();	
					stk.push(arr2[ptr--]);
				}
			}
			else {
				stk.push(arr2[ptr--]);
			}
		}
		return ans;
	}
	
	// helper method to main
	// prints array elements
	private void printArray(int[] arr) {
		for(int i : arr) {
			System.out.print(i+" ");
		}
		System.out.println();
	}

	// driver - main method
	public static void main(String[] args) {
		GreaterElement ge = new GreaterElement();
		
		// TESTCASES
		ge.printArray(ge.getNextGreaterElemet(new int[] {4,1,2}, new int[] {1,3,4,2}));
		ge.printArray(ge.getNextGreaterElemet(new int[] {2,4}, new int[] {1,2,3,4}));
	}

}
