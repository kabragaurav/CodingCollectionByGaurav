/**
 * Google
 * Given a linked list and a value, 
 * remove all nodes containing the provided value, and return the resulting list.
 */
package LinkedList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
/**
 * @author gaurav kabra
 * @since June 2, 2021
 */
public class RemoveValue {
	
	private LinkedList<Integer> getListAfterRemoval(LinkedList<Integer> ls, int valueToRemove) {
		/*
		 * We use removeAll method that takes as argument a Collection of values to be removed
		 * 
		 * Time Complexity : O(N) since this method internally traverses the LinkedList linearly and whenever finds the element to be removed, it removed that element.
		 * Space Complexity : O(1) since additional space required is constant.
		 */
		ls.removeAll(new ArrayList<Integer>(Arrays.asList(valueToRemove)));
		return ls;
	}
	
	// driver - main method
	public static void main(String[] args) {
		RemoveValue rv = new RemoveValue();
		
		// TESTCASES
		LinkedList<Integer> ls = new LinkedList<>(new ArrayList<>(List.of(1,2,3)));
		System.out.println(rv.getListAfterRemoval(ls,3));
		ls = new LinkedList<>(new ArrayList<>(List.of(8,1,1,4,12)));
		System.out.println(rv.getListAfterRemoval(ls,1));
		ls = new LinkedList<>(new ArrayList<>(List.of(7,12,2,9)));
		System.out.println(rv.getListAfterRemoval(ls,7));
	}

}
