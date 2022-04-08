/*
    Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.

Implement the LRUCache class:

    LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
    int get(int key) Return the value of the key if the key exists, otherwise return -1.
    void put(int key, int value) Update the value of the key if the key exists. Otherwise, add the key-value pair
    to the cache. If the number of keys exceeds the capacity from this operation, evict the least recently used key.

The functions get and put must each run in O(1) average time complexity.
 */
package Company.Microsoft;

import java.util.LinkedHashMap;

/**
 * @author gaurav kabra
 * @since 08/Apr/2022
 **/

public class LRU {

    // TC : O(1) for one operation; overall O(N) for N queries
    // SC : O(N) for map, serving as cache

    private final int CAPACITY;
    private LinkedHashMap<Integer, Integer> mp;

    public LRU(int capacity) {
        CAPACITY = capacity;
        mp = new LinkedHashMap<>(CAPACITY);
    }

    public int get(int key) {
        if (mp.containsKey(key)) {
            int val = mp.remove(key);
            mp.put(key, val);
            return val;
        }
        return -1;
    }

    public void set(int key, int value) {
        if (mp.containsKey(key)) {
            int val = mp.remove(key);
        } else if (mp.size() == CAPACITY) {
            mp.remove(mp.keySet().iterator().next());
        }
        mp.put(key, value);
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASE(S)
        LRU lru = new LRU(2);
        lru.set(2, 1);
        lru.set(2,2);
        System.out.println(lru.get(2));
        lru.set(1,1);
        lru.set(4,1);
        System.out.println(lru.get(2));
    }

}
