/**
 * Facebook
 * Given a linked list and a value n,
 * remove the nth to last node and return the resulting list.
 */
package LinkedList;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author gaurav kabra
 * @since June 2, 2021
 */
public class RemoveNthToLastNode {
	
	private LinkedList<Integer> removeNthValueFromLastNode(LinkedList<Integer> ls, int N) {
		/**
		 * We start iterating linkedlist from backwards using descendingIterator method and keep incrementing i for each element covered.
		 * When we see that we reached Nth node from last (i.e. when i equals N), we delete that element and return list immediately.
		 * 
		 * Time Complexity : O(N) since we traverse LinkedList once and linearly
		 * Space Complexity: O(1) since additional space required is constant.
		 */
		
		Iterator<Integer> itr = ls.descendingIterator();
		itr.next();
		int i = 1;
		while(i != N) {
			itr.next();
			i++;
		}
		itr.remove();
		return ls;
		
		/**
		 * You can also use this solution. Just that it does not use iterator.
		 * It finds out index of element to be removed and removes it.
		 * Time Complexity : O(1) since we directly get index of element to be removed, remove it and return list.
		 * Space Complexity : O(1) since additional space required is constant.
		 * 
		 * int lengthOfList = ls.size();
		 * int indexOfElementToRemove = lengthOfList-N;
		 * ls.remove(indexOfElementToRemove);
		 * return ls;
		 * 
		 */
	}
	
	// driver - main method
	public static void main(String[] args) {
		RemoveNthToLastNode rntln = new RemoveNthToLastNode();
		
		// TESTCASES
		LinkedList<Integer> ls = new LinkedList<>(new ArrayList<>(List.of(1,2,3)));
		System.out.println(rntln.removeNthValueFromLastNode(ls,1));
		ls = new LinkedList<>(new ArrayList<>(List.of(1,2,3)));
		System.out.println(rntln.removeNthValueFromLastNode(ls,2));
		ls = new LinkedList<>(new ArrayList<>(List.of(1,2,3)));
		System.out.println(rntln.removeNthValueFromLastNode(ls,3));
	}

}