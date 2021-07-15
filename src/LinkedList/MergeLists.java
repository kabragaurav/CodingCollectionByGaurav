/**
 * Apple
 * Given two sorted linked lists, 
 * merge them together in ascending order and return a reference to the merged list
 */
package LinkedList;
import java.util.LinkedList;
import java.util.List;
/**
 * @author gaurav kabra
 * @since June 2, 2021
 */
public class MergeLists {
	
	private LinkedList<Integer> getMergedLists(LinkedList<Integer> ls1, LinkedList<Integer> ls2) {
		/**
		 * We will keep two pointers, i and j. i points to ls1 and j points to ls2.
		 * We will compare elements where i and j point. 
		 * If element being pointed by i is less then we will add it to our final result (ls) and increment i (so i starts pointing to next element)
		 * Else we add element being pointed by j and increment j.
		 * 
		 * Time Complexity: O(N) since we trace both lists linearly
		 * Space Complexity: O(N) since we keep the LinkedList (ls) that we return as our final result.
		 */
		int l1 = ls1.size(),
			l2 = ls2.size();
		LinkedList<Integer> ls = new LinkedList<Integer>();    // final result
		
		int i=0, j=0, ele;
		
		while(i<l1 && j<l2) {
			ele = ls1.get(i) < ls2.get(j) ? ls1.get(i++) : ls2.get(j++);
			ls.add(ele);
		}
		
		// if one list runs out then we just need to add remaining elements from other list
		while(i<l1) {
			ls.add(ls1.get(i++));
		}
		while(j<l2) {
			ls.add(ls2.get(j++));
		}
		
		return ls;
	}
	
	// driver - main method
	public static void main(String[] args) {
		MergeLists ml = new MergeLists();
		LinkedList<Integer> ls1, ls2;
		
		// TESTCASES
		ls1 = new LinkedList<Integer>(List.of(1,2,3));
		ls2 = new LinkedList<Integer>(List.of(4,5,6));
		System.out.println(ml.getMergedLists(ls1, ls2));
		
		ls1 = new LinkedList<Integer>(List.of(1,3,5));
		ls2 = new LinkedList<Integer>(List.of(2,4,6));
		System.out.println(ml.getMergedLists(ls1, ls2));
		
		ls1 = new LinkedList<Integer>(List.of(4,4,7));
		ls2 = new LinkedList<Integer>(List.of(1,5,6));
		System.out.println(ml.getMergedLists(ls1, ls2));
	}

}
