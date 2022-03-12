
/**
 * A dictionary is a type of data structure that is supported natively in all major interpreted
 * languages such as JavaScript, Python, Ruby and PHP, where it’s known as an Object, Dictionary,
 * Hash and Array, respectively. In simple terms, a dictionary is a collection of unique keys and
 * their values. The values can typically be of any primitive type (i.e an integer, boolean, double,
 * string etc) or other dictionaries (dictionaries can be nested). However, for this exercise assume
 * that values are either an integer, a string or another dictionary.
 *
 * Given a dictionary dict, write a function flattenDictionary that returns a flattened version of it .
 *
 * If you’re using a compiled language such Java, C++, C#, Swift and Go, you may want to use a
 * Map/Dictionary/Hash Table that maps strings (keys) to a generic type (e.g. Object in Java,
 * AnyObject in Swift etc.) to allow nested dictionaries.
 *
 * If a certain key is empty, it should be excluded from the output (see e in the example below).
 */

package Company.Pramp;

import java.util.HashMap;
import java.util.Map;

/**
 * @author gkabra
 * @since 06-03-2022 Sun
 **/

public class FlattenDictionary {

    // TC : O(N) with N overall keys
    // SC : O(N) for ans
    private static void helper(String currKey, Object value, HashMap<String, String> ans) {
        // below is rough way to know if value is of type String
        /*
        try {
            String val = (String) value;
            ans.put(currKey, val);
            return;
        } catch(Exception ex) { }
         */
        if(value instanceof String) {   // class or subclass (String is final, so no subclass)
            // or try with value.getClass().equals(String.class)  for exact class
            ans.put(currKey, (String) value);
            return;
        }

        HashMap<String, Object> obj = (HashMap) value;

        for(Map.Entry<String, Object> entry : obj.entrySet()) {
            String key = entry.getKey();
            Object val = entry.getValue();
            if(currKey.equals("")) {        // because what if initial key is ""
                helper(key, val, ans);
            } else if("".equals(key)) {
                helper(currKey, val, ans);
            } else {
                helper(currKey+"."+key, val, ans);
            }
        }
    }

    private static HashMap<String, String> flattenDictionary(HashMap<String, Object> mp) {
        HashMap<String, String> ans = new HashMap<>();

        for(Map.Entry<String, Object> entry : mp.entrySet()) {
            String key = entry.getKey();
            Object val = entry.getValue();
            helper(key, val, ans);
        }

        return ans;

    }

    // driver - main method
    public static void main(String[] args) {
        /**
             dict = {
                "Key1" : "1",
                "Key2" : {
                     "a" : "2",
                     "b" : "3",
                     "c" : {
                     "d" : "3",
                     "e" : {
                         "" : "1"
                     }
                 }
                }
             }
         */
        HashMap<String, Object> e = new HashMap<>();
        e.put("", "1");
        HashMap<String, Object> c = new HashMap<>();
        c.put("d", "3");
        c.put("e", e);
        HashMap<String, Object> key2 = new HashMap<>();
        key2.put("a", "2");
        key2.put("b", "3");
        key2.put("c", c);
        HashMap<String, Object> dict = new HashMap<>();
        dict.put("Key1", "1");
        dict.put("key2", key2);

        // TESTCASE
        HashMap<String, String> mp = flattenDictionary(dict);


        for(Map.Entry<String, String> entry : mp.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }


}
