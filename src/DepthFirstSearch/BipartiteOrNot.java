/**
 * Facebook
 * There is an undirected graph with N nodes, where each node is numbered between 0 and N-1.
 * Given a 2D array, graph, where graph[u] is an array of nodes that node u is adjacent to.
 * There are no self-edges (graph[u] does not contain u, i.e., there are no self loops).
 * There are no parallel edges (graph[u] does not contain duplicate values, i.e., there are no parallel edges).
 * The graph may not be connected (meaning there may be two nodes u and v such that there is no path between them).
 *
 * A graph is bipartite if the nodes can be partitioned into two independent sets A and B such that every edge
 * in the graph connects a node in set A and a node in set B.
 *
 * Return true if graph is bipartite.
 */
package DepthFirstSearch;

import java.util.Arrays;

/**
 * @author gaurav kabra
 * @since 18 Sept 2021
 **/

public class BipartiteOrNot {

    private static boolean dfs(int[][] graph, int[] color, int V) {
        /**
         * Logic:
         * The neighbors, as per bipartite definition, should have different color:
         *      If current node has color 1, each of its adjacent should have color 0
         *      If current node has color 0, each of its adjacent should have color 1
         *
         * For more, read here: https://tinyurl.com/bipartite-graph
         */
        for(int node : graph[V]) {
            if(color[node] == color[V]) {
                return false;
            }
            else if(color[node] == -1) {
                color[node] = 1-color[V];       // 1 to 0, 0 to 1
                if(!dfs(graph, color, node)) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isBipartite(int[][] graph) {
        /**
         * Logic:
         * We will solve this using DFS.
         * When we try to partition graph in two parts, let us denote it like coloring:
         *      One part has all nodes with color 1
         *      Other part has all nodes with color 0
         * Initially each node in graph has color -1.
         * Then we iterate over each node:
         *      If node's color is -1:
         *          Set its color to 1 and perform dfs from this node
         */

        int N = graph.length;
        int[] color = new int[N];
        Arrays.fill(color, -1);

        for(int i=0; i<N; i++) {
            if(color[i] == -1) {
                color[i] = 1;
                if(!dfs(graph, color, i)) {
                    return false;
                }
            }
        }
        return true;
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASES
        int[][] arr1 = {{1,2,3},{0,2},{0,1,3},{0,2}};
        System.out.println(isBipartite(arr1));

        // We can partition the nodes into two sets: {0, 2} and {1, 3}.
        int[][] arr2 = {{1,3},{0,2},{1,3},{0,2}};
        System.out.println(isBipartite(arr2));
    }
}
