/**
 * Given an array nums, return the third largest (distinct) value.
 * Note: If the third largest number does not exist, return the largest value.
 */
package Sorting;

import java.util.*;

/**
 * @author gaurav kabra
 * @since 13 Sept 2021
 **/

public class ThirdLargest {

    private static int thirdMax(int[] nums) {
        /**
         * Logic:
         * To get unique elements, use set.
         * Set can be sorted by converting to list and using Collections
         */
        Set<Integer> st = new HashSet<>();
        for(int num : nums) {
            st.add(num);
        }

        List<Integer> ls = new ArrayList<>(st);
        Collections.sort(ls, Collections.reverseOrder());
        // can also use below two lines to achieve same as above line
        //Collections.sort(ls);
        //Collections.reverse(ls);

        return ls.size() < 3 ?  ls.get(0) : ls.get(2);
    }
    public static void main(String[] args) {
        System.out.println(thirdMax(new int[] {1,3,2}));
        System.out.println(thirdMax(new int[] {4,10}));
    }
}
