/**
 A scenic location is represented by its name and attractiveness score, where name is a unique string
 among all locations and score is an integer. Locations can be ranked from the best to the worst.
 The higher the score, the better the location. If the scores of two locations are equal,
 then the location with the lexicographically smaller name is better.

 You are building a system that tracks the ranking of locations with the system initially starting with
 no locations. It supports:

 Adding scenic locations, one at a time.
 Querying the ith best location of all locations already added, where i is the number of times the system
 has been queried (including the current query).
 For example, when the system is queried for the 4th time, it returns the 4th best location of all locations
 already added.

 Note that the test data are generated so that at any time, the number of queries does not exceed the number
 of locations added to the system.

 Implement the SORTracker class:

 SORTracker() Initializes the tracker system.
 void add(string name, int score) Adds a scenic location with name and score to the system.
 string get() Queries and returns the ith best location, where i is the number of times this method has been
 invoked (including this invocation).

 */
package Company.Amazon.Hard;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author gauravkabra
 * @since 21/Mar/2022
 **/

public class SequentiallyOrdinalRankTracker {

    TreeMap<Integer, List<String>> mp;
    int query;

    public SequentiallyOrdinalRankTracker() {
        mp = new TreeMap<>((a, b) -> b-a);
        query = 0;
    }

    // TC : O(logN) if all names have same price then map has one entry and doing binary search will be O(logN)
    public void add(String name, int score) {
        mp.putIfAbsent(score, new ArrayList<>());
        List<String> ls = mp.get(score);
        ls.add(getInsertionIndex(ls, name), name);
    }

    private int getInsertionIndex(List<String> ls, String name) {
        int left = 0;
        int right = ls.size()-1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (ls.get(mid).compareTo(name) < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    // TC : O(N) where N is count of names in map
    // SC : O(N) for map
    public String get() {
        List<String> ls;
        int queryCopy = query;
        String ans = null;
        for (Map.Entry<Integer, List<String>> entry : mp.entrySet()) {
            ls = entry.getValue();
            if (query < ls.size()) {
                ans = ls.get(query);
                break;
            }
            query -= ls.size();
        }
        query = queryCopy;
        query++;
        return ans;
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASE
        SequentiallyOrdinalRankTracker sequentiallyOrdinalRankTracker = new SequentiallyOrdinalRankTracker();
        sequentiallyOrdinalRankTracker.add("happy", 100000);
        sequentiallyOrdinalRankTracker.add("thanks", 100000);
        sequentiallyOrdinalRankTracker.add("giving", 99999);
        sequentiallyOrdinalRankTracker.add("everyone", 11111);
        System.out.println(sequentiallyOrdinalRankTracker.get());
        System.out.println(sequentiallyOrdinalRankTracker.get());
        System.out.println(sequentiallyOrdinalRankTracker.get());
        System.out.println(sequentiallyOrdinalRankTracker.get());
    }

}
