/*
Given a directed acyclic graph, with n vertices numbered from 0 to n-1, and an array edges
where edges[i] = [fromi, toi] represents a directed edge from node fromi to node toi.
Find the smallest set of vertices from which all nodes in the graph are reachable.
It's guaranteed that a unique solution exists.
You can return the vertices in any order.
 */
package Graph;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gaurav kabra
 * @since 07/May/2022
 **/

public class MinVerticesToCoverWholeGraph {

    // TC : O(n)
    // SC : O(n) when every node is disjoint
    // This does not require any specific technique related to graph like traversals.
    // What the interviewer expects is just nodes that don't have any incoming edges.
    private static List<Integer> findSmallestSetOfVertices(int n, int[][] edges) {
        int[] indeg = new int[n];

        for (int[] edge : edges) {
            indeg[edge[1]]++;
        }

        List<Integer> ans = new ArrayList<>();

        for (int i=0; i<n; i++) {
            if (indeg[i] == 0) {
                ans.add(i);
            }
        }

        return ans;
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASE(S)
        System.out.println(findSmallestSetOfVertices(6, new int[][] {
                {0,1},{0,2},{2,5},{3,4},{4,2}
        }));
    }

}
