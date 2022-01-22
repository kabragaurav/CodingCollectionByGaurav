/**
 * We're building a new social network where users are friends with one another.
 * In order to make better friend recommendations, we want to develop a "friend distance" algorithm.
 *
 * Write a function that returns the minimum distance between two users
 * (similar to the "degree" of connection on LinkedIn).
 *
 * Ref: https://tinyurl.com/degree-of-friendship
 */
package Trees;

/**
 * @author gkabra
 * @since 22-01-2022 Sat
 **/

import Trees.TreeUtils.Node;

import java.util.ArrayDeque;
import java.util.Queue;

public class DegreeOfFriendship {

    /**
     * Logic:
     * BFS
     *
     * TC: O(N) as each edge is visited at max once in worst case
     * SC: O(N) due to queue
     */
    private static int findMinDistance(Node node1, Node node2) {
        if(node1 == node2) {
            return 0;
        }
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(node1);
        node1.isVisited = true;
        int minDist = 0;
        int sz = 1;
        while(!queue.isEmpty()) {
            sz = queue.size();
            minDist++;
            for (int i = 0; i < sz; i++) {
                Node poped = queue.poll();
                for (Node child : poped.children) {
                    if (child == node2) {
                        return minDist;
                    }
                    if (!child.isVisited) {
                        queue.add(child);
                        child.isVisited = true;
                    }
                }
            }
        }
        // if two nodes are disjoint, minDist will still be 1
        // so cross check
        if(minDist == 1) {
            for(Node child : node1.children) {
                if(child == node2) {
                    return minDist;
                }
            }
            return Integer.MAX_VALUE;       // INF
        }
        return minDist;
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASE
        Node[] nodes = Node.getGraph1();
        System.out.println(findMinDistance(nodes[1], nodes[5]));
        System.out.println(findMinDistance(nodes[1], nodes[1]));
        System.out.println(findMinDistance(nodes[1], nodes[7]));
    }

}
