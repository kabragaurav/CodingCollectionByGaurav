/**
 * DE Shaw
 * Design a data structure that supports the following operations in Θ(1) time.
 * insert(x): Inserts an integer x to the data structure if not already present.
 * remove(x): Removes integer x from the data structure if present.
 * search(x): Searches an integer x in the data structure and return index if present, else -1.
 * getRandom(): Returns a random element from current set of elements (size > 0)
 * 
 */
package Interviews;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * @author gaurav kabra
 * @since July 10, 2021
 */

class DataStructure {
	private Map<Integer, Integer> mp;
	private List<Integer> arr;			// used in getRandom() method
	
	public DataStructure() {
		 this.mp = new HashMap<>();
		 this.arr = new ArrayList<>();
	}
	
	public Boolean insert(int num) {
		if(mp.get(num) != null)
			return false;
		mp.put(num, mp.size());
		return arr.add(num);
	}
	
	public Integer remove(int x) {
		if(mp.get(x) == null)
			return -1;
		arr.remove(new Integer(x));		// if we directly pass x, then it is treated as index, which may lead to ArrayIndexOutOfBounds exception
		return mp.remove(x);
	}
	
	public Integer search(int x) {
		return mp.get(x);
	}
	
	public Integer getRandom() {
		Random rm = new Random();
		int randomNum = rm.nextInt(arr.size());   // random number in range [0, arr.size())
		return arr.get(randomNum);
	}
	
}

public class DesignDataStructure {
	
	// driver - main method
	public static void main(String[] args) {
		DataStructure ds = new DataStructure();
		// TESTCASES
        ds.insert(10);
        ds.insert(20);
        ds.insert(30);
        ds.insert(40);
        System.out.println(ds.search(30));
        ds.remove(20);
        ds.insert(50);
        ds.insert(40);
        System.out.println(ds.search(50));
        System.out.println(ds.search(40));
        System.out.println(ds.search(100));
        System.out.println(ds.getRandom());
	}

}
