/**
 * Amazon
 * You are at a birthday party and are asked to distribute cake to your guests.
 * Each guest is only satisfied if the size of the piece of cake they’re given, matches
 * their appetite (i.e. is greater than or equal to their appetite).
 * Given two arrays, appetite and cake where the ith element of appetite represents the
 * ith guest’s appetite, and the elements of cake represents the sizes of cake you have
 * to distribute, return the maximum number of guests that you can satisfy.
 */
package Greedy;

import java.util.Arrays;

/**
 * @author gaurav kabra
 * @since 4 Sept 2021
 **/

public class SatisfiedCustomer {

    private static int maxSatifiedGuestCount(int[] appetite, int[] cake) {
        /**
         * Logic:
         * Sort the two arrays. This way we will ensure minimum wastage of cake. E.g. a person with appetite 3 is satisfied with cake with value 4. So why give him cake with value 5? 
         * We iterate over appetite array and see if present cake can satisfy 
         * If not then we remain at same appetite but go to next cake.
         * If so we increase the answer.
         */
        Arrays.sort(appetite);
        Arrays.sort(cake);
        int maxSatisfactionCount = 0;
        int j = 0;
        for(int i=0; i<appetite.length;) {
            if(cake[j] >= appetite[i]) {
                maxSatisfactionCount++;
                j++;
                i++;
            } else {
                j++;
            }
            if(j >= cake.length) {
                break;
            }
        }
        return maxSatisfactionCount;
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASES
        System.out.println(maxSatifiedGuestCount(new int[] {1,2,3}, new int[]{1,2,3}));
        System.out.println(maxSatifiedGuestCount(new int[] {3,4,5}, new int[]{2}));
        System.out.println(maxSatifiedGuestCount(new int[] {3,4,5}, new int[]{4,4,3}));
        System.out.println(maxSatifiedGuestCount(new int[] {3,4,5}, new int[]{4,4,3,7}));
        System.out.println(maxSatifiedGuestCount(new int[] {3,4,5}, new int[]{4,4,1}));
    }
}
