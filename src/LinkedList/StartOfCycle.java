/**
 * Apple
 * Given a potentially cyclical linked list where each value is unique, 
 * return the node at which the cycle starts.
 * If the list does not contain a cycle, return null.
 */
package LinkedList;

/**
 * Not using java.util.* as it is generally a bad idea to use wildcard character
 * For more, see: https://tinyurl.com/wildimport
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author gaurav kabra
 * @since June 2, 2021
 */
// A good read : https://tinyurl.com/floyd-cycle-detection-explain
public class StartOfCycle {
	
	private Integer getStartOfCycleUsingSet(LinkedList<Integer> ls) {
		/**
		 * We use set to see if an element comes again. If so, then size of set before and after will remain the same.
		 * 
		 * Time Complexity : O(N) since we need to iterate list once
		 * Space Complexity : O(N) since in worst case all elements in list are different and we store that in set
		 */
		Set<Integer> st = new HashSet<>();
		for(Integer i : ls) {
			if(st.contains(i))
				return i;
			else
				st.add(i);
		}
		return null;
	}
	
	private Integer getStartOfCycleUsingMap(LinkedList<Integer> ls) {
		/**
		 * We use map to see if an element comes again. If so, then collision will happen and we return that element immediately.
		 * If no collision happens, that means the element came first time. So map it to some value (we map to 1 here)
		 * If no collision happens at all, then return null.
		 * 
		 * Time Complexity : O(N) since we need to iterate list once
		 * Space Complexity : O(N) since in worst case all elements in list are different and we store that in map
		 */
		Map<Integer, Integer> mp = new HashMap<>();
		for(Integer i : ls) {
			if(mp.containsKey(i))
				return i;
			else
				mp.put(i, 1);
		}
		return null;
	}
	
	// driver - main method
	public static void main(String[] args) {
		StartOfCycle soc = new StartOfCycle();
		
		// TESTCASES
		LinkedList<Integer> ls = new LinkedList<>(new ArrayList<>(List.of(1,2,3)));
		System.out.println(soc.getStartOfCycleUsingMap(ls));
		System.out.println(soc.getStartOfCycleUsingSet(ls));
		ls = new LinkedList<>(new ArrayList<>(List.of(-1,-7,7,-4,19,6,-9,-5,-2,-5)));
		System.out.println(soc.getStartOfCycleUsingMap(ls));
		System.out.println(soc.getStartOfCycleUsingSet(ls));
		ls = new LinkedList<>(new ArrayList<>(List.of(1,9,3,7,7)));
		System.out.println(soc.getStartOfCycleUsingMap(ls));
		System.out.println(soc.getStartOfCycleUsingSet(ls));
		
	}

}
