/*
There are n children standing in a line. Each child is assigned a rating value given in the integer array ratings.

You are giving candies to these children subjected to the following requirements:

    Each child must have at least one candy.
    Children with a higher rating get more candies than their neighbors.

Return the minimum number of candies you need to have to distribute the candies to the children.
 */
package Company.Microsoft;

import java.util.Arrays;

/**
 * @author gaurav kabra
 * @since 08/Apr/2022
 **/

public class Candy {

    /*
        TC : O(N)
        SC : O(N)

        Excellent sweet explanation : https://tinyurl.com/leetcode-candy
     */
    private static int candy(int[] ratings) {
        int N = ratings.length;
        int[] distribution = new int[N];
        Arrays.fill(distribution, 1);
        int count = N;

        // left to right scan
        for (int i=1; i<N; i++) {
            if (ratings[i] > ratings[i-1] && distribution[i] <= distribution[i-1]) {
                count += (distribution[i-1] - distribution[i]) + 1;
                distribution[i] = distribution[i-1] + 1;
            }
        }

        // right to left scan
        for (int i=N-2; i>=0; i--) {
            if (ratings[i] > ratings[i+1] && distribution[i] <= distribution[i+1]) {
                count += (distribution[i+1] - distribution[i]) + 1;
                distribution[i] = distribution[i+1] + 1;
            }
        }
        return count;
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASE(S)
        System.out.println(candy(new int[] {1,2,2}));
        System.out.println(new int[]  {1,2,3,4,5});
        System.out.println(new int[] {1});
        System.out.println(new int[] {5,4,3,2,1});
    }

}
