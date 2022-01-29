/**
 * There are a total of N courses you have to take, labeled from 0 to numCourses - 1.
 * You are given an array courses where courses[i] = [ai, bi] indicates that you
 * must take course bi first if you want to take course ai.
 * For example, the pair [0, 1], indicates that to take course 0 you have to first
 * take course 1.
 * Return true if you can finish all courses. Otherwise, return false.
 */
package BreadthFirstSearch;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @author gkabra
 * @since 29-01-2022 Sat
 **/

public class CourseSchedule {

    private static void createGraph(int[][] courses, List<List<Integer>> graph, int[] inDegree, int N) {
        for(int i=0; i<N; i++) {
            graph.add(new ArrayList<>());
        }
        for(int[] course : courses) {
            graph.get(course[1]).add(course[0]);
            inDegree[course[0]]++;
        }
    }

    private static boolean bfs(List<List<Integer>> graph, int[] inDegree, int N) {
        Queue<Integer> queue = new ArrayDeque<>();

        for(int i=0; i<N; i++) {
            if(inDegree[i] == 0) {          // add all courses that have indegree as 0, i.e., can be taken right now
                queue.offer(i);             // use offer that does not throws IllegalStateException when queue is full
            }
        }

        int count = 0;
        while(!queue.isEmpty()) {
            int front = queue.poll();
            count++;
            for(int adj : graph.get(front)) {
                if(--inDegree[adj] == 0) {
                    queue.offer(adj);
                }
            }
        }

        return count == N;
    }

    /**
     * Logic:
     *
     * Create graph List<List<Integer>>
     * Create inDegree array to count for each node how many incoming edges in graph
     * Apply bfs. Add to queue when inDegree becomes zero, i.e, it can be taken by student
     *
     * TC : O(N)
     * SC : O(N)
     */
    private static boolean canFinish(int N, int[][] courses) {
        List<List<Integer>> graph = new ArrayList<>();
        int[] inDegree = new int[N];
        createGraph(courses, graph, inDegree, N);
        return bfs(graph, inDegree, N);
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASE
        System.out.println(canFinish(2, new int[][] {{0,1}}));
    }

}
