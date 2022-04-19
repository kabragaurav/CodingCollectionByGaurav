/*
Design a Map without using any built-in hash table libraries.

Implement the MyHashMap class:

    MyHashMap() initializes the object with an empty map.
    void put(int key, int value) inserts a (key, value) pair into the Map.
    If the key already exists in the map, update the corresponding value.
    int get(int key) returns the value to which the specified key is mapped, or -1
    if this map contains no mapping for the key.
    void remove(key) removes the key and its corresponding value if the map contains the mapping for the key.

 */
package Company.Google;

import java.util.LinkedList;

/**
 * @author gaurav kabra
 * @since 18/Apr/2022
 *
 * Note : Similar is for Design HashSet
 **/

public class DesignHashMap {

    private static LinkedList<Pair>[] mp;
    private static final int SZ = 769;

    private static void put(int key, int value) {
        int hash = key % SZ;
        LinkedList<Pair> ll = mp[hash];

        if (ll == null) {
            mp[hash] = new LinkedList<Pair>();
            mp[hash].add(new Pair(key, value));
            return;
        }
        for (Pair p : ll) {
            if (p.key == key) {
                p.value = value;
                return;
            }
        }
        ll.add(new Pair(key, value));
    }

    private static int get(int key) {
        int hash = key % SZ;
        LinkedList<Pair> ll = mp[hash];
        if (ll == null) {
            return -1;
        }
        for (Pair p : ll) {
            if (p.key == key) {
                return p.value;
            }
        }
        return -1;
    }

    private static void remove(int key) {
        int hash = key % SZ;
        LinkedList<Pair> ll = mp[hash];

        if (ll == null) {
            return;
        }

        for (Pair p : ll) {
            if (p.key == key) {
                ll.remove(p);
                return;
            }
        }
    }

    private static class Pair {
        int key;
        int value;

        Pair(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASE(S)
        mp = new LinkedList[SZ];
        put(1, 2);
        System.out.println(get(1));
        System.out.println(get(2));
        remove(1);
        System.out.println(get(1));
        System.out.println(get(2));
    }

}
