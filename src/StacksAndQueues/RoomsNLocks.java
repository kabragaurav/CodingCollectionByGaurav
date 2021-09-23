/**
 * Amazon
 * Given N distinct rooms, 0 to N-1, that are locked we want to know if you can unlock and visit every room.
 * Each room has a list of keys (two rooms may have same keys) in it
 * that allows you to unlock and visit the rooms.
 * We start with room 0 being unlocked. Return whether we can visit every room.
 */
package StacksAndQueues;

import java.util.*;

/**
 * @author gaurav kabra
 * @since 23 Sept 2021
 **/

public class RoomsNLocks {

    private static boolean canVisitAllRooms(List<List<Integer>> rooms) {
        /**
         * Logic:
         * Logic is very simple - BFS.
         * Consider room 0 as node of a graph. From there we are having keys to some other rooms.
         * That means we are connected to some other rooms (nodes).
         * So just perform BFS and see if all rooms (nodes) are visited or not.
         *
         * It is just knowing if graph is connected or not.
         *
         * Complexity
         * Since graph is in form of adjacency list:
         * Time: O(V+E)
         * Space: O(V+E)
         * V = number of rooms, E = Number of connections among rooms
         */
        Deque<Integer> queue = new ArrayDeque<>();
        for(int keys : rooms.get(0)) {
            queue.addLast(keys);
        }
        int N = rooms.size();
        int[] isVisited = new int[N];
        isVisited[0] = 1;
        N--;

        while(!queue.isEmpty()) {
            int sz = queue.size();
            for(int i=0; i<sz; i++) {
                int room = queue.pollFirst();
                if(isVisited[room] == 0) {
                    N--;
                    isVisited[room] = 1;
                    for(int key : rooms.get(room)) {
                        queue.addLast(key);
                    }
                }
            }
        }
        return N == 0;
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASE 1
        //[[1,3],[3,0,1],[2],[0]]
        List<List<Integer>> all = new ArrayList<>();
        List<Integer> ls = new ArrayList<>() {{
            add(1);
            add(3);
        }};
        all.add(ls);
        ls = new ArrayList<>() {{
            add(3);
            add(0);
            add(1);
        }};
        all.add(ls);

        ls = new ArrayList<>() {{
            add(2);
        }};
        all.add(ls);

        ls = new ArrayList<>() {{
            add(0);
        }};
        all.add(ls);

        System.out.println(canVisitAllRooms(all));

        // TESTCASE 2
        // [[4],[3],[],[2,5,7],[1],[],[8,9],[],[],[6]]
        all.clear();

        ls = new ArrayList<>() {{
            add(4);
        }};
        all.add(ls);
        ls = new ArrayList<>() {{
            add(3);
        }};
        all.add(ls);

        ls = new ArrayList<>();
        all.add(ls);

        ls = new ArrayList<>() {{
            add(2);
            add(5);
            add(7);
        }};
        all.add(ls);

        ls = new ArrayList<>() {{
            add(1);
        }};
        all.add(ls);

        ls = new ArrayList<>();
        all.add(ls);

        ls = new ArrayList<>() {{
            add(8);
            add(9);
        }};
        all.add(ls);

        ls = new ArrayList<>();
        all.add(ls);

        ls = new ArrayList<>();
        all.add(ls);

        ls = new ArrayList<>() {{
            add(6);
        }};
        all.add(ls);

        System.out.println(canVisitAllRooms(all));
    }
}
