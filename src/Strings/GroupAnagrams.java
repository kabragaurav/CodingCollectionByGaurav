/**
 * Given an array of strings, return a list of strings containing all anagrams grouped together.
 */
package Strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Arrays;

/**
 * @author gaurav kabra
 * @since 9 Oct 2021
 **/

public class GroupAnagrams {

    private static String getSorted(String s) {
        char[] chArr = s.toCharArray();
        Arrays.sort(chArr);
        return new String(chArr);
    }

    /**
     * Logic:
     *
     * TC : O(NMlogM) where N is length of strs, M is maximum length of any string in strs. So sorting N strings.
     * SC: O(N+N) ~ O(N) for storing all strings in mp and then in ans.
     */
    private static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> mp = new HashMap<>();
        List<String> ls;
        for(String str : strs) {
            String s = getSorted(str);
            if(mp.containsKey(s)) {
                ls = mp.get(s);
            } else {
                ls = new ArrayList<>();
            }
            ls.add(str);
            mp.put(s, ls);
        }

        List<List<String>> ans = new ArrayList<>();
        for(Map.Entry<String, List<String>> entry : mp.entrySet()) {
            ans.add(entry.getValue());
        }
        return ans;
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASES
        groupAnagrams(new String[] {
                "eat","tea","tan","ate","nat","bat"
        }).stream().forEach(ls -> ls.stream().forEach(s -> System.out.println(s)));

        groupAnagrams(new String[] {
                ""
        }).stream().forEach(ls -> ls.stream().forEach(s -> System.out.println(s)));

        groupAnagrams(new String[] {
                "a"
        }).stream().forEach(ls -> ls.stream().forEach(s -> System.out.println(s)));
    }
}
