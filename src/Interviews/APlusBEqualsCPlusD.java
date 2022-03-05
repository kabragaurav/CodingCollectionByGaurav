/**
 * Amazon
 * Given an array A[ ] of N of  integers, find the index of values that satisfy
 * A + B = C + D where A,B,C & D are integers values in the array.
 * Note: Return A, B , C and D all as -1 if there are no pairs satisfying the equation.
 *
 * About the multiple quadruples present in the array , please make sure
 * you return the lexicographical smallest quadruple.
 *
 * Formally:-
 *
 * S1 : a1 b1 c1 d1 (these are values of indices in the array)
 * S2 : a2 b2 c2 d2
 *
 * S1 is lexicographically smaller than S2 iff
 * a1 < a2 OR
 * a1 = a2 AND b1 < b2 OR
 * a1 = a2 AND b1 = b2 AND c1 < c2 OR
 * a1 = a2 AND b1 = b2 AND c1 = c2 AND d1 < d2
 */
package Interviews;

import Arrays.Utils.ArrayUtils;

import java.util.HashMap;
import java.util.Arrays;

/**
 * @author gkabra
 * @since 05-03-2022 Sat
 **/

public class APlusBEqualsCPlusD {

    private static int[] getLexicographicallySmaller(int[] A, int[] B) {
        if(A[0] < B[0] ||
                (A[0] == B[0] && A[1] < B[1]) ||
                (A[0] == B[0] && A[1] == B[1] && A[2] < B[2]) ||
                (A[0] == B[0] && A[1] == B[1] && A[2] == B[2] && A[3] < B[3])) {
            return A;
        }
        return B;
    }

    // TC : O(N)
    // SC : O(N)
    private static int[] satisfyEqn(int[] A, int N) {
        int[] candidate = new int[4];
        Arrays.fill(candidate, Integer.MAX_VALUE);
        HashMap<Integer, int[]> mp = new HashMap<>();

        for(int i=0; i<N; i++) {
            for(int j=i+1; j<N; j++) {
                int sum = A[i] + A[j];
                if(mp.containsKey(sum)) {
                    int[] val = mp.get(sum);
                    if(val[0] == i || val[0] == j || val[1] == i || val[1] == j) {
                        continue;
                    }
                    int[] potentialCandidate = new int[] {val[0], val[1], i, j};
                    candidate = getLexicographicallySmaller(candidate, potentialCandidate);
                } else {
                    mp.put(sum, new int[] {i, j});
                }
            }
        }
        return candidate[0] != Integer.MAX_VALUE ? candidate : new int[] {-1, -1, -1, -1};

    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASE
        ArrayUtils.printArray(satisfyEqn(new int[] {3, 4, 7, 1, 2, 9, 8}, 7));
    }

}
