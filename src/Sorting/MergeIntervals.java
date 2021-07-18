/**
 * Given an array of intervals where intervals[i] = [start_i, end_i], 
 * merge all overlapping intervals, and return an array of the non-overlapping intervals 
 * that cover all the intervals in the input.
 */
package Sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;


/**
 * @author gaurav kabra
 * @since July 18, 2021
 */

public class MergeIntervals {
	
	public static int[][] merge(int[][] intervals) {
		/**
		 * Logic:
		 * If there is single interval, we return that.
		 * Else we first sort on basic of start_i time
		 * Since at beginning, we don't know how many intervals will be there in our final answer, instead of using int[][], we use List and at last convert it back to int[][] using toArray() method.
		 */
		if (intervals.length <= 1)
			return intervals;
		
		/**
		 *  The below line can also be written using Comparator:
		 *  
			 Arrays.sort(intervals, new Comparator<int[]>() {
				@Override
				public int compare(int[] i1, int[] i2) {
	                return Integer.compare(i1[0], i2[0]);
	            }
			});
			
		 */
		
		/**
		 * Or you can also use:
		 * 
		  	Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));
		 
		 */
		
		Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));

		List<int[]> result = new ArrayList<>();
		int[] temp = intervals[0];
		result.add(temp);
		for (int[] interval : intervals) {
			if (interval[0] <= temp[1]) 
				temp[1] = Math.max(temp[1], interval[1]);
			else {                             
				temp = interval;
				result.add(temp);
			}
		}

		return result.toArray(new int[result.size()][]);
	}

	public static void main(String[] args) {
		// TESTCASES
		int[][] arr1 = new int[][] {
			{1,4}, {0, 4}
		};
		
		int[][] arr2 = new int[][] {
			{1,4}, {2, 3}
		};
		
		int[][] arr3 = new int[][] {
			{1,4}, {0, 2}, {3, 5}
		};
		
		/**
		 * Below way to print is same as:
		 * for(int[] x: someIntTwoDArray)
            System.out.println(Arrays.toString(x));
		 */
		System.out.println(Arrays.deepToString(merge(arr1)));
		System.out.println(Arrays.deepToString(merge(arr2)));
		System.out.println(Arrays.deepToString(merge(arr3)));
	}

}
