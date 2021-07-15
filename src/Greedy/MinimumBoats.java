/**
 * Amazon
 * A ship is about to set sail and you are responsible for its safety precautions. 
 * More specifically, you are responsible for determining how many life rafts to carry onboard. 
 * You are given a list of all the passengers’ weights and are informed that a single life raft
 * has a maximum capacity of limit and can hold at most two people. 
 * Return the minimum number of life rafts you must take onboard to ensure the safety of all your passengers.
 * You may assume that a the maximum weight of any individual is at most limit.
 */
package Greedy;

import java.util.Arrays;

/**
 * @author gaurav kabra
 * @since July 11, 2021
 */

public class MinimumBoats {
    private int countBoats(int[] people, int limit) {
    	/**
    	 * Logic:
    	 * Sort people.
    	 * Why we need sorting?
    	 * Say people = {1,3,2,4,5}, limit = 5
    	 * Then if we don't sort -> {1,3},{2},{4},{5} -> 4 boats
    	 * If we sort -> {1,4},{2,3},{5} -> 3 boats only
    	 * For the current heaviest person, we try to let him go with the lightest person.
    	 * As all people need to get on the boat.
    	 * If the sum of weight is over the limit, we have to let the heaviest go alone.
    	 * No one can take the same boat with him.
    	 * 
    	 * Time Complexity : O(NlogN) for sorting
    	 * Space Complexity : O(1) since no extra space based on N is taken
    	 */
        Arrays.sort(people);
        int boat = 0;
        int left = 0;
        int right = people.length-1;
        while(left <= right) {
            if(people[left] == limit) {
                boat += right-left+1;
                break;
            }
            if(people[right] == limit) {
                boat++;
                right--;
            }
            if(people[left] + people[right] <= limit) {
                left++;
                right--;
                boat++;
            }
            else {
                right--;
                boat++;
            }
        }
        return boat;
    }
    
    // driver - main method
	public static void main(String[] args) {
		MinimumBoats mb = new MinimumBoats();
		// TESTCASES
		System.out.println(mb.countBoats(new int[] {1,3,2,4,5}, 5));
		System.out.println(mb.countBoats(new int[] {8, 7, 7, 4, 4, 2}, 16));
	}

}
