/*

Suppose you are at a party with n people (labeled from 0 to n - 1)
and among them, there may exist one celebrity. The definition of a celebrity is that all the other n - 1
people know him/her but he/she does not know any of them.

Now you want to find out who the celebrity is or verify that there is not one. The only thing you are allowed
to do is to ask questions like: "Hi, A. Do you know B?" to get information of whether A knows B.
You need to find out the celebrity (or verify there is not one) by asking as few questions as possible
(in the asymptotic sense).

You are given a helper function bool knows(a, b) which tells you whether A knows B. Implement a function
int findCelebrity(n), your function should minimize the number of calls to knows.

There will be exactly one celebrity if he/she is in the party. Return the celebrity's label if there is a
celebrity in the party. If there is no celebrity, return -1.
 */
package StacksAndQueues;

import java.util.Stack;
import java.util.stream.IntStream;

/**
 * @author gaurav kabra
 * @since 10/May/2022
 **/

public class FindCelebrity {

    private static int[][] arr = {
            {0, 0, 1, 0},
            {0, 0, 1, 0},
            {0, 0, 0, 0},
            {0, 0, 1, 0}
    };

    // https://tinyurl.com/find-celebrity
    // TC : O(N)
    // SC : O(N)
    private static int findCelebrity(int n) {

        Stack<Integer> stk = new Stack<>();
        IntStream.range(0, n)
                .forEach(i -> stk.push(i));

        while (stk.size() > 1) {
            int first = stk.pop();
            int second = stk.pop();

            if (knows(first, second)) {
                stk.push(second);
            } else {
                stk.push(first);
            }
        }

        int candidate = stk.pop();

        for (int i=0; i<n; i++) {
            if (i != candidate && !knows(i, candidate)) {
                return -1;
            }
        }

        for (int i=0; i<n; i++) {
            if (i != candidate && knows(candidate, i)) {
                return -1;
            }
        }

        return candidate;
    }

    private static boolean knows(int a, int b) {
        return arr[a][b] == 1;
    }
    // driver - main method
    public static void main(String[] args) {
        // TESTCASE(S)
        System.out.println(findCelebrity(4));
    }

}
