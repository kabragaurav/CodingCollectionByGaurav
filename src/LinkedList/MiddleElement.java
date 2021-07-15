/**
 * Amazon
 * Given a non-empty linked list, return the middle node of the list. 
 * If the linked list contains an even number of elements, return the node closer to the end.
 */
package LinkedList;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author gaurav kabra
 * @since June 2, 2021
 */
public class MiddleElement {
	
	private Integer getMiddleElementOfList(LinkedList<Integer> ls) {
		/**
		 * We directly get middle index using formula : (length of list)/2 (this is because indexes begin from 0)
		 * Time Complexity : O(1) since we directly get index of element.
		 * Space Complexity : O(1) since additional space required is constant.
		 * 
		 */
		int sizeOfList = ls.size();
		int indexOfMiddleElement = sizeOfList/2;
		
		return ls.get(indexOfMiddleElement);
	}
	
	// driver - main method
	public static void main(String[] args) {
		MiddleElement me = new MiddleElement();
		
		// TESTCASES
		LinkedList<Integer> ls = new LinkedList<>(new ArrayList<>(List.of(1,2,3)));
		System.out.println(me.getMiddleElementOfList(ls));
		ls = new LinkedList<>(new ArrayList<>(List.of(1,2,3,4)));
		System.out.println(me.getMiddleElementOfList(ls));
		ls = new LinkedList<>(new ArrayList<>(List.of(1)));
		System.out.println(me.getMiddleElementOfList(ls));
		
		
	}

}
