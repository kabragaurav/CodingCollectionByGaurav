/**
 * Design a data structure that is initialized with a list of different words. Provided
 * a string,
 * you should determine if you can change exactly one character in this string to match
 * any word in the data structure.
 *
 * Implement the MagicDictionaryFuzzyMatching class:
 *
 *     MagicDictionaryFuzzyMatching() Initializes the object.
 *
 *     void buildDict(String[] dictionary) Sets the data structure with an array
 *     of distinct strings dictionary.
 *
 *     bool search(String searchWord) Returns true if you can change exactly one
 *     character in searchWord to match any string in the data structure, otherwise
 *     returns false.
 */
package Map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author gkabra
 * @since 04-03-2022 Fri
 **/

public class MagicDictionaryFuzzyMatching {

    HashMap<String, List<Pair>> mp;

    public MagicDictionaryFuzzyMatching() {
        mp = new HashMap<>();
    }

    public void buildDict(String[] dictionary) {
        for(String s : dictionary) {
            for(int i=0; i<s.length(); i++) {
                // remove one character at a time and store in map
                String t = s.substring(0, i) + s.substring(i+1, s.length());
                List<Pair> ls;
                if(mp.containsKey(t)) {
                    ls = mp.get(t);
                } else {
                    ls = new ArrayList<>();
                }
                ls.add(new Pair(i, s.charAt(i)));
                mp.put(t, ls);
            }
        }
    }

    public boolean search(String s) {
        for(int i=0; i<s.length(); i++) {
            // remove one character at a time and see if map contains that substring. If yes, return true
            String t = s.substring(0, i) + s.substring(i+1, s.length());
            if(mp.containsKey(t)) {
                List<Pair> ls = mp.get(t);
                for(Pair p : ls) {
                    if(p.ch != s.charAt(i) && p.index == i) {
                        return true;
                    }
                }
            }
        }
        return false;
    }


    private class Pair {
        int index;
        char ch;

        Pair(int index, char ch) {
            this.index = index;
            this.ch = ch;
        }
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASES
        MagicDictionaryFuzzyMatching magic = new MagicDictionaryFuzzyMatching();
        magic.buildDict(new String[] {"hello", "hallo", "leetcode"});
        System.out.println(magic.search("hello"));
        System.out.println(magic.search("hell"));
        System.out.println(magic.search("leetcoded"));

    }

}
