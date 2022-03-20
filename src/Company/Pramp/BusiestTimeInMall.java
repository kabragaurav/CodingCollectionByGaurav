/**
 * The Westfield Mall management is trying to figure out what the busiest moment at the mall was last year.
 * You’re given data extracted from the mall’s door detectors. Each data point is represented as an integer
 * array whose size is 3. The values at indices 0, 1 and 2 are the timestamp, the count of visitors, and
 * whether the visitors entered or exited the mall (0 for exit and 1 for entrance), respectively. Here’s an
 * example of a data point: [ 1440084737, 4, 0 ].
 *
 * Note that time is given in a Unix format called Epoch, which is a nonnegative integer holding the number of
 * seconds that have elapsed since 00:00:00 UTC, Thursday, 1 January 1970.
 *
 * Given an array, data, of data points, write a function findBusiestPeriod that returns the time at which
 * the mall reached its busiest moment last year. The return value is the timestamp, e.g. 1480640292. Note that
 * if there is more than one period with the same visitor peak, return the earliest one.
 *
 * Assume that the array data is sorted in an ascending order by the timestamp.
 */
package Company.Pramp;

/**
 * @author gauravkabra
 * @since 20/Mar/2022
 **/

public class BusiestTimeInMall {

    // TC : O(N)
    // SC : O(1)
    private static int findBusiestPeriod(int[][] data) {
        int N = data.length;    // 9

        int maxPeopleAtAnyTime = 0;
        int runningCountOfPeople = 0;
        int timestampForMaxPeople = 0;

        for (int i=0; i<N; i++) {
            int people = 0;

            int j = i;
            int[] row = data[j];
            int timestamp = row[0];
            while (j < N && row[0] == timestamp) {
                if (row[2] == 1) {
                    people += row[1];
                } else {
                    people -= row[1];
                }
                j++;
                if (j < N) {
                    row = data[j];
                }
            }
            runningCountOfPeople += people;
            if (maxPeopleAtAnyTime < runningCountOfPeople) {
                maxPeopleAtAnyTime = runningCountOfPeople;
                timestampForMaxPeople = data[i][0];
            }

            i = j-1;
        }

        return timestampForMaxPeople;

    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASE
        System.out.println(findBusiestPeriod(new int[][] { {1487799425, 14, 1},
                {1487799425, 4,  0},
                {1487799425, 2,  0},
                {1487800378, 10, 1},
                {1487801478, 18, 0},
                {1487801478, 18, 1},
                {1487901013, 1,  0},
                {1487901211, 7,  1},
                {1487901211, 7,  0} }));
    }

}
