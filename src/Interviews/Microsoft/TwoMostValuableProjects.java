/*
A company is planning N projects, numbered from 0 to N-1. Completing the K-th project will bring value V[K] to the company. For some projects there may be additional requirements - the L-th requirement states that before starting project B[L], project A[L] should be completed. There are M such requirements.

The company has enough resources for at most two projects to be completed. If two projects are chosen, they will be completed one by one (in sequential order) and the total value they bring to the company is the sum of their individual values. What is the highest value that a valid choice of projects can bring to the company?

Write a function:
class Solution { public int solution(int[] V, int[] A, int[] B); }

that, given array V of N integers and two arrays A and B of M integers each, returns the maximum value that the company may gain by completing at most two possible projects.

Examples:

    Given V = [-3, 5, 7, 2, 3], A = [3, 1] and B = [2, 4], the function should return 9. This can be achieved by completing project 3 (with value 2) first and then project 2 (with value 7).
    Given V = [1, 1, 5], A = [0, 1] and B = [2, 2], the function should return 2.
    Given V = [5, 6, 6, 7, -10] and A = [0, 0, 0, 1, 2, 3] and B = [1, 2, 3, 3, 1, 2], the function should return 5. The project that are possible to be completed are 0 and 4. As project 4 would bring negative value to the company, it is optimal to do only project 0. The structure of dependencies of projects 1, 2 and 3 form a cycle, so none of them can be completed in a valid choice of projects.

Write an efficient algorithm for the following assumptions:

    N is an integer within the range [1..100,000];
    M is an integer within the range [0..100,000];
    each element of array V is an integer within the range [-1,000,000,000..1,000,000,000];
    each element of arrays A and B is an integer within the range [0..N-1];
    a project may not require itself to be completed (A[K] != B[K]);
    projects’ requirements do not repeat.

 */
package Interviews.Microsoft;

import java.util.*;

/**
 * @author gaurav kabra
 * @since 19/Apr/2022
 **/

public class TwoMostValuableProjects {

    private static int solution(int[] V, int[] A, int[] B) {
        int M = A.length;

        int[][] prerequisite = new int[M][M];

        for (int i=0; i<M; i++) {
            prerequisite[i][0] = A[i];
            prerequisite[i][1] = B[i];
        }

        int N = V.length;
        int[] indeg = new int[N];       // in-degrees

        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        for (int i=0; i<M; i++) {
            indeg[prerequisite[i][1]]++;
            graph.putIfAbsent(prerequisite[i][0], new ArrayList<>());
            graph.get(prerequisite[i][0]).add(prerequisite[i][1]);
        }

        Queue<Integer> queue = new ArrayDeque<>();
        HashSet<Integer> nonZeroIndeg = new HashSet<>();
        for (int i=0; i<N; i++) {
            if (indeg[i] == 0) {
                queue.add(i);
            } else {
                nonZeroIndeg.add(i);
            }
        }

        int sz = queue.size();
        int max = 0;
        ArrayList<Integer> zeroIndeg = new ArrayList<>();
        for (int i=0; i<sz; i++) {
            int pop = queue.poll();
            zeroIndeg.add(pop);
            queue.add(pop);
        }

        for (int i=0; i<sz; i++) {
            for (int j=i+1; j<sz; j++) {
                int t1 = V[zeroIndeg.get(i)];
                int t2 = V[zeroIndeg.get(j)];
                int t = 0;
                if (t1 >= 0) {
                    t += t1;
                }
                if (t2 >= 0) {
                    t += t2;
                }
                max = Math.max(max, t);
            }
        }

        if (queue.size() == 0) {
            return 0;           // all cyclic
        }

        int sum = 0;
        while (!queue.isEmpty()) {
            int pop = queue.poll();
            if (nonZeroIndeg.contains(pop)) {           // needed by 1st test
                break;
            }
            if (V[pop] < 0) {
                continue;
            }
            sum = V[pop];

            for (int neigh : graph.getOrDefault(pop, Collections.emptyList())) {
                if (indeg[neigh] == 1) {            // needed by 2nd test
                    queue.add(neigh);
                }
            }

            zeroIndeg.clear();
            sz = queue.size();
            for (int i=0; i<sz; i++) {
                pop = queue.poll();
                zeroIndeg.add(pop);
                queue.add(pop);
            }

            for (int i=0; i<sz; i++) {
                int t = V[zeroIndeg.get(i)];
                int s = sum;
                if (t >= 0) {
                    s += t;
                }
                max = Math.max(max, s);
            }
        }

        return max;
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASE(S)
        System.out.println(solution(new int[] {-3,5,7,2,4}, new int[] {3,1}, new int[] {2,4}));
        System.out.println(solution(new int[] {1,1,5}, new int[] {0,1}, new int[] {2,2}));
        System.out.println(solution(new int[] {5, 6, 6, 7, -10}, new int[] {0, 0, 0, 1, 2, 3}, new int[] {1, 2, 3, 3, 1, 2}));
    }

}
