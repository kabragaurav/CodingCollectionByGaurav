/**
 * Facebook, Amazon, Google, Microsoft
 * Given a string, check if it can be modified such that no two adjacent characters are the same.
 * If it is possible, return any string that satisfies this condition and if it is not possible
 * return an empty string.
 */
package Strings;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author gaurav kabra
 * @since 25 Aug 2021
 **/

public class NoSameNeighbors {

    private static String reorganizeString(String s) {
        /**
         * Logic:
         * We start building answer by picking characters which are most frequent to which are list frequent.
         * For frequency, we first need to build map, named frequency.
         * For picking characters most frequent to least frequent, make a priority queue (max heap), named pq.
         *
         * Here is excellent explanation: https://tinyurl.com/no-same-neighbors
         */
        // know frequency
        Map<Character, Integer> frequency = new HashMap<>();
        for(char ch : s.toCharArray()) {
            frequency.put(ch, frequency.getOrDefault(ch,0)+1);
        }

        // arrange from increasing frequency to decreasing, choice is max heap
        PriorityQueue<Character> pq = new PriorityQueue<>((a,b) -> frequency.get(b)-frequency.get(a));
        pq.addAll(frequency.keySet());

        // populate final answer
        StringBuilder sb = new StringBuilder();
        while(pq.size() > 1) {
            char firstMax = pq.poll();
            char secondMax = pq.poll();
            sb.append(firstMax);
            sb.append(secondMax);
            frequency.put(firstMax, frequency.get(firstMax)-1);
            frequency.put(secondMax, frequency.get(secondMax)-1);
            if(frequency.get(firstMax) > 0) {
                pq.add(firstMax);
            }
            if(frequency.get(secondMax) > 0) {
                pq.add(secondMax);
            }
        }
        if(!pq.isEmpty()) {
            char last = pq.poll();
            if(frequency.get(last) > 1) {
                return "";
            }
            sb.append(last);
        }
        return sb.toString();
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASES
        System.out.println(reorganizeString("aab"));
        System.out.println(reorganizeString("aaab"));
    }
}
