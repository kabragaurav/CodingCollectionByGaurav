/**
 * Design a data structure that works like a LRU Cache. 
 * get(key) : returns the value of the key if it already exists in the cache, otherwise -1.
 * set(key, value) : if the key is already present, update its value. If not present, adds the <key, value> pair to the cache. If the cache reaches its capacity it should invalidate the least recently used (LRU) item before inserting the new item.
 * In the constructor of the class the capacity of the cache should be intitialized.
 */
package Miscellaneous.UniqueConcepts;

/**
 * @author gaurav kabra
 * @since July 3, 2021
 */

import java.util.LinkedHashMap;

public class LRUCache {
	/**
	 * Logic:
	 * We will use LinkedHashMap because it maintains insertion order. 
	 * So it will be easy to know and remove most stale entry.
	 * If we use TreeMap, it will keep sorting on basis of keys and hence order of insertion is disrupted
	 * Same goes for HashMap which does not retail order and may change order based on each insertion
	 * 
	 * See this for more: https://tinyurl.com/map-implementations
	 * 
	 */
	private LinkedHashMap<Integer, Integer> map;
    private int capacity;
    
    LRUCache(int cap)
    {
        map = new LinkedHashMap<>();
        capacity = cap;
    }

    public int get(int key)
    {
    	/**
    	 * Logic:
    	 * We return -1 if key is not there
    	 * Else,
    	 *  we return the value associated with the key.
    	 *  Also we make it latest entry by moving it to last.
    	 *  
    	 *  Time Complexity : O(1) since get, put, containsKey and remove are all O(1)
    	 *  Space Complexity : O(1)
    	 */
        if(map.containsKey(key)) {
            int val = map.get(key);
            map.remove(key);
            map.put(key, val);
            return val;
        }
        return -1;
    }

    public void set(int key, int value)
    {
    	/**
    	 * Logic:
    	 * If map contains key, then there is no change in size as we will just update the value for the provided key and make it latest by moving it to last
    	 * Else,
    	 * 	We need to consider size of map. If it exceeds capacity, we remove first (i.e. most stale entry)
    	 * 	And then we put the entry in map.
    	 * 
    	 * Time Complexity : O(1) since get, put, containsKey and remove are all O(1)
    	 * Space Complexity : O(1)
    	 */
        if(map.containsKey(key)) { 
            map.remove(key);
            map.put(key, value);
            return;
        }
        if(map.size() == capacity) {
            map.remove(map.keySet().iterator().next());
        }
        map.put(key, value);
    }
    
    // driver - main method
	public static void main(String[] args) {
		LRUCache lruc = new LRUCache(3);
		
		// TESTCASES
		System.out.println(lruc.get(1));
		lruc.set(1, 1);
		lruc.set(2, 2);
		lruc.set(3, 3);
		System.out.println(lruc.get(1));
		lruc.set(1, 11);
		System.out.println(lruc.get(1));
		lruc.set(4, 4);
		System.out.println(lruc.get(1));
		System.out.println(lruc.get(2));
	}

}
