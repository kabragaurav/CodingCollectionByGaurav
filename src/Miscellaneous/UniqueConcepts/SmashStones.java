/**
 * Amazon
 * You are given a group of stones, all of which have a positive weight. 
 * At each turn, we select the heaviest two stones and smash them together. 
 * When smashing these two stones together, one of two things can happen:
 * If the stones are both the same weight, both stones are destroyed
 * If the weights of the stones are not equal, the smaller of the two stones is destroyed and the remaining stone’s weight is updated to the difference 
 * (i.e. if we smash two stones together of weight 3 and weight 5 the stone with weight 3 is destroyed and the stone with original weight 5 now has weight 2).
 * Continue smashing stones together until there is at most one stone left and return the weight of the remaining stone. 
 * If not stones remain, return 0.
 */
package Miscellaneous.UniqueConcepts;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

/**
 * @author gaurav kabra
 * @since July 10, 2021
 */

public class SmashStones {
	
	private int usingPriorityQueue(int[] stones) {
		/**
		 * Logic:
		 * Make a max heap
		 * Time Complexity: Creating a heap takes O(N) time while inserting into a heap (or priority queue) takes O(logN) time due to at most logN comparisons. So total time complexity is O(NlogN)
		 * Note - Removing N items from the priority queue also is O(NlogN)).
		 * Space Complexity: O(N)
		 */
		
		/**
		 * Lambda functions are slow. So you may also use
		       Comparator cmp = new Comparator<Integer>(){
			       public int compare(Integer first, Integer second){
			            return second.compareTo(first);
			        }
			    };
    			Queue<Integer> heap = new PriorityQueue<>(cmp);
		 */
		
		// You may also write below statement as
		// PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder())
		PriorityQueue<Integer> pq = new PriorityQueue<>((first, second)-> second - first);
        for (int stone : stones)
            pq.offer(stone);
        while (pq.size() >= 2)
            pq.offer(pq.poll() - pq.poll());		// no need for abs() since we know it is max heap
        return pq.poll();
	}
	
	private int usingSorting(int[] stones) {
        if(stones.length == 1)		// cannot be smashed
            return stones[0];
        
        // convert int[] to ArrayList
        List<Integer> ls = Arrays.stream(stones).boxed().collect(Collectors.toList());
        
        while(ls.size() > 2) {
            Collections.sort(ls);
            int last = ls.remove(ls.size()-1);
            int secondLast = ls.remove(ls.size()-1);
            
            int newStone = last - secondLast;
            ls.add(newStone);		// even if it is 0, add it
        }
        
        int zero = ls.remove(0);
        int one = ls.remove(0);
        return Math.abs(zero-one);		// you may also sort first, the return bigger-smaller value
	}
	
	// driver - main method
	public static void main(String[] args) {
		SmashStones ss = new SmashStones();
		// TESTCASES
		System.out.println(ss.usingSorting(new int[] {1}));
		System.out.println(ss.usingSorting(new int[] {2,7,4,1,8,1}));
		
		System.out.println(ss.usingPriorityQueue(new int[] {1}));
		System.out.println(ss.usingPriorityQueue(new int[] {2,7,4,1,8,1}));
	}

}
