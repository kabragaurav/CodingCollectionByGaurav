/**
 * Google
 * A company is booking flights to send its employees to its two satellite offices A and B. 
 * The cost of sending the ith employee to office A and office B is given by 
 * prices[i][0] and prices[i][1] respectively. Given that half the employees must be sent to office A 
 * and half the employees must be sent to office B,
 * return the minimum cost the company must pay for all their employees’ flights.
 */
package Greedy;

import java.util.Arrays;

/**
 * @author gaurav kabra
 * @since July 13, 2021
 */

public class FlightPrices {
	
    private int twoCityCost(int[][] costs) {
    	/**
    	 * Logic:
    	 * The problem is to send N persons to city A and N persons to city B with minimum cost.
    	 * We start by sending each person to city A.
    	 * However, we need to send half (i.e. N) to city B. So send the cheapest ones to city B.
    	 * So, if we take one person that we sent to A, we can get a refund for that one person if we call it back to original place,
    	 * but we still have the cost of sending her to B. 
    	 * Refund the A cost subtracts from the cost, so -costs[i][0] + costs[i][1] gives the cost 
    	 * of sending the same person to B. We need to chose the cheapest N people to send to B.
    	 * So, we sort by difference of cost to B and cost to A and send the first N to B.
    	 * 
    	 * Time Complexity : O(NlogN) due to sorting
    	 * Space Complexity : O(N) since we store the cost difference to B and A.
    	 */
        int TwoN = costs.length;
        int sumIfAllToA = 0;
        int[] diffBAndA = new int[TwoN];
        
        for(int i=0; i<costs.length; i++) {
            int toA = costs[i][0];
            int toB = costs[i][1];
            sumIfAllToA += toA;
            diffBAndA[i] = toB - toA;
        }
        Arrays.sort(diffBAndA);
        
        for(int i=0; i<TwoN/2; i++) {
            sumIfAllToA += diffBAndA[i];
        }
        return sumIfAllToA;
    }
    
    // driver - main method
	public static void main(String[] args) {
		
		// TESTCASES
		System.out.println(new FlightPrices().twoCityCost(new int[][] {
			{10,20},
			{30,200},
			{400,50},
			{30,20}
		}));
		System.out.println(new FlightPrices().twoCityCost(new int[][] {
			{10,10},
			{30,30},
			{400,400},
			{30,30}
		}));
	}

}
