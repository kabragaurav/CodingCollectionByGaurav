/**
 * Given a list of words,
 * return the top k frequently occurring words.
 * If two words occur with the same frequency,
 * then the alphabetically smaller word should come first.
 */
package Sorting;

import java.util.*;

/**
 * @author gaurav kabra
 * @since 30 Sept 2021
 **/

public class TopFrequentWords {

    private static class Pair {
        String word;
        Integer count;

        Pair(String word, Integer count) {
            this.word = word;
            this.count = count;
        }
    }

    private static List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> mp = new HashMap<>();
        for(String word : words) {
            mp.put(word, mp.getOrDefault(word, 0) + 1);
        }

        PriorityQueue<Pair> maxHeap = new PriorityQueue<>((p1, p2) -> {
            if(p1.count == p2.count) {
                return p1.word.compareTo(p2.word);
            }
            return p2.count - p1.count;
        });

        for(Map.Entry<String, Integer> entry : mp.entrySet()) {
            maxHeap.add(new Pair(entry.getKey(), entry.getValue()));
        }


        List<String> ans = new ArrayList<>();
        for(int i=0; i<k; i++) {
            Pair p = maxHeap.poll();
            ans.add(p.word);
        }
        return ans;
    }

    public static void main(String[] args) {
        List<String> ls = topKFrequent(new String[] {
                "the","day","is","sunny","the","the","the","sunny","is","is"
        }, 4);

        ls.stream().forEach(s -> System.out.println(s));
    }
}
