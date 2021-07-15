/**
 * Facebook
 * Given a linked list, containing unique values, reverse it, and return the result.
 */
package LinkedList;
import java.util.*;


/**
 * @author gaurav kabra
 * @since June 2, 2021
 */
public class ReverseList {
	
	private LinkedList<Integer> reverseList(LinkedList<Integer> ls) {
		/**
		 * descendingIterator method of LinkedList class return an iterator over the elements in this LinkedList in reverse sequential order(i.e. tail to head)
		 * A good read : https://tinyurl.com/oracle-doc-descendingIter
		 * Time Complexity : For descendingIterator(), it is O(N) since LinkedList is to be traversed linearly
		 * Space Complexity : O(N) since we create new LinkedList having same values in original list but in reverse order.
		 */
		Iterator itr = ls.descendingIterator();
		LinkedList<Integer> ret = new LinkedList<>();
		
		while(itr.hasNext()) {
			ret.add((Integer) itr.next());
		}
		return ret;
	}
	
	
	// helper method for main. Prints LinkedList
	private void printList(LinkedList<Integer> ls) {
		for(Integer i : ls) {
			System.out.print(i+" ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		LinkedList<Integer> ls = new LinkedList<>(new ArrayList<>() {{
			add(7);
			add(15);
			add(9);
			add(2);
		}});
		
		ReverseList rl = new ReverseList();
		
		rl.printList(rl.reverseList(ls));
	} 

}
