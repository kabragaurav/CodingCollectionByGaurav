/*
You are given a two-dimensional matrix that represents the grades of a class of students.
Each grade is represented as an array where the first index is the student’s ID and the second student
is a grade (0 - 100) that the student has received. Given these grades, calculate the average of each
student’s top five scores and return the result.
Note: Each student is guaranteed to have at least 5 scores. Student IDs start from zero and increase
by one. Your return variable should be sorted according to student ID.
 */
package HashMap;

import Arrays.Utils.ArrayUtils;

import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * @author gaurav kabra
 * @since 06/Apr/2022
 **/

public class Top5OfEachStudent {

    private static final int SUBJECTS_COUNT = 5;

    /*
        SC : O(N), N = grades.length

        TC :
            O(N) for populating mp
            O(M * log(S)) for poll, M = number of students, S = max number of subjects for any student
     */
    private static double[] getAverages(int[][] grades) {
        HashMap<Integer, PriorityQueue<Integer>> mp = new HashMap<>();

        for (int[] grade : grades) {
            int rollNumber = grade[0];
            int marks = grade[1];

            mp.putIfAbsent(rollNumber, new PriorityQueue<>(Collections.reverseOrder()));
            mp.get(rollNumber).add(marks);
        }

        double[] ans = new double[mp.size()];

        for (int i=0; i<mp.size(); i++) {
            double sum = 0;
            PriorityQueue<Integer> pq = mp.get(i);
            for (int j=0; j<SUBJECTS_COUNT; j++) {
                sum += pq.poll();
            }
            ans[i] = sum / SUBJECTS_COUNT;
        }

        return ans;

    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASE(S)
        ArrayUtils.printArray(getAverages(new int[][] {
                {0,90}, {0,95}, {0,96}, {0,97}, {0,93}, {0,89}, {0,76}, {0,99},
                {1,90}, {1,95}, {1,96}, {1,97}, {1,93}
        }));
    }

}
