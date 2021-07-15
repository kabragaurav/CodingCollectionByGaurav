/**
 * DE Shaw
 * Given a list of N-1 integers and these integers are in sorted, in the range of 1 to N. 
 * There are no duplicates in list. 
 * One of the integers is missing in the list. Write an efficient code to find the missing integer. 
 */
package Interviews;

/**
 * @author gaurav kabra
 * @since July 10, 2021
 */

public class MissingNumberInSortedArr {
	
	private int binarySearch(int[] arr, int start, int end) {
		/**
		 * Logic:
		 * Since array is sorted, the first thing to find something, binary search comes to mind
		 * 
		 * Time Complexity: O(logN)
		 * Space Complexity: O(NlogN) due to recurive call. 
		 * In each next call we pass N-2 elements, where N is number of elements passed in current function.
		 * And this continue for logN levels, leading to worst case O(NlogN)
		 */
		
		// if in the sub-array, no element is missing
		if(start >= end)
			return -1;
		if(arr[start+1] != arr[start]+1)
			return arr[start]+1;
		if(arr[end-1] != arr[end]-1)
			return arr[end]-1;
		int mid = start + (end-start)/2;
		/**
		 *  before partition at mid, we will check at mid
		 * E.g.  1 2 3 4  P  6 7 8
		 * Here P denotes partition. So before solving sub-arrays, check at mid for missing element
		 */
		if(arr[mid-1] != arr[mid]-1)
			return arr[mid]-1;
		if(arr[mid+1] != arr[mid]+1)
			return arr[mid]+1;
		
		int temp = binarySearch(arr, start+1, mid);
		return temp > 0 ? temp : binarySearch(arr, mid+1, end-1);
	}
	
	// driver - main method
	public static void main(String[] args) {
		MissingNumberInSortedArr mnisa = new MissingNumberInSortedArr();
		// TESTCASE
		System.out.println(mnisa.binarySearch(new int[] {1, 2, 3, 4, 6, 7, 8}, 0, 6));
		System.out.println(mnisa.binarySearch(new int[] {1, 2, 3, 4, 5, 6, 8, 9}, 0, 7));
		System.out.println(mnisa.binarySearch(new int[] {1}, 0, 0));
	}

}
