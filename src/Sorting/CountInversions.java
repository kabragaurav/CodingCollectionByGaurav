/**
 * For an array, inversion count indicates how far (or close) the array is from being sorted. 
 * If array is already sorted then the inversion count is 0. 
 * If an array is sorted in the reverse order then the inversion count is the maximum.
 * Formally, two elements a[i] and a[j] form an inversion if a[i] > a[j] and i < j.
 * Given an array of integers. Find the Inversion Count in the array. 
 */

package Sorting;

/**
 * @author gaurav kabra
 * @since July 18, 2021
 */

public class CountInversions {
	
	private static long inversions = 0;
    
	private static void merge(long[] arr, int start, int mid, int end) {
        int n1 = mid-start+1;
        int n2 = end-mid;
        long[] left = new long[n1];
        for(int i=0; i<n1; i++) {
            left[i] = arr[start+i];
        }
        long[] right = new long[n2];
        for(int i=0; i<n2; i++) {
            right[i] = arr[mid+i+1];
        }
        int leftIndex = 0;
        int rightIndex = 0;
        int k = start;
        
        while(leftIndex < n1 && rightIndex < n2) {
            if(left[leftIndex] <= right[rightIndex]) {
                arr[k++] = left[leftIndex++];
            }
            else {
                arr[k++] = right[rightIndex++];
                inversions += (n1-leftIndex);
            }
        }
        
        while(leftIndex < n1) {
            arr[k++] = left[leftIndex++];
        }
        while(rightIndex < n2) {
            arr[k++] = right[rightIndex++];
        }
    }
    
    private static void mergeSort(long[] arr, int start, int end) {
        if(start < end) {
            int mid = start + (end-start)/2;
            mergeSort(arr, start, mid);
            mergeSort(arr, mid+1, end);
            merge(arr, start, mid, end);
        }
    }
    
    private static long inversionCount(long[] arr, long N) {
    	/**
    	 * The whole idea is to use merge sort.
    	 * During merge process, keep counting inversions.
    	 * 
    	 * Time Complexity: O(NlogN), The algorithm used is merge sort that uses divide and conquer.
    	 * Space Complexity: O(N), due to auxiliary array.
    	 */
        inversions = 0;
        mergeSort(arr, 0, (int)N-1);
        return inversions;
    }

	public static void main(String[] args) {
		System.out.println(inversionCount(new long[] {
				468,335,1,170,225,479,359,463,465,206,146,282,328,462,492,496,443,328,437,392,105,403,154,293,383,422,217,219,396,448,227,272,39,370,413,168,300,36,395,204,312,323
		}, 42));
		System.out.println(inversionCount(new long[] {
				468,335,1,170,225,479,359,463,465,206,146,282,328,462,492,496,443,328,437,392,105,403,154,293,383,422,217,219,396,448,227,272,39,370,413,168,300,36,395,204,312,323
		}, 34));
	}

}
