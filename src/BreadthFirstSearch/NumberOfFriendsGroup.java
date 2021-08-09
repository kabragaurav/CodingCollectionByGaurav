/**
 * Facebook
 * You are given a two dimensional matrix, friends, that represents relationships between coworkers in an office. 
 * If friends[i][j] = 1 then coworker i is friends with coworker j and coworker j is friends with coworker i. 
 * Similarly if friends[i][j] = 0 then coworker i is not friends with coworker j and coworker j is not friend 
 * with coworker i. Friendships in the office are transitive 
 * (i.e. if coworker#1 is friends with coworker#2 and coworker#2 is friends with coworker#3, coworker#1 is also friends with coworker#3). 
 * Given the friendships in the office defined by friends, return the total number of distinct friends groups in the office.
 * Each coworker is friends with themselves (i.e.friends[i][i] = 1)
 */

package BreadthFirstSearch;

/**
 * @author gaurav kabra
 * @since August 09, 2021
 */

import java.util.ArrayDeque;
import java.util.Deque;

public class NumberOfFriendsGroup {
	
	private static int numberOfFriendsGroups(int[][] friends) {
		/**
		 * Logic:
		 * We use bfs. From a friend (i.e. node) we see how many friends we can reach.
		 * 
		 * We start by creating a queue for bfs. N is number of friends. Initially number of friend groups is 0.
		 * We start at each column, j from [0,N).
		 * For each j, we traverse whole row, i.
		 * If any cell there has [i][j] value as 1, we found a new group.
		 * 		We set [i][j] = -1 to indicate we have visited it (to prevent INF loop)
		 * 		We add j to queue.
		 * 		While queue is not empty
		 * 			We take front element and again traverse its whole row, k.
		 * 			If any cell is 1, we add that row number, k to queue.
		 */
        Deque<Integer> queue = new ArrayDeque<>();
        int groups = 0;
        int N = friends.length;
        for(int j=0; j<N; j++) {
        	for(int i=0; i<N; i++) {
        		if(friends[i][j] == 1) {
        			groups++;
        			friends[i][j] = -1;
        			queue.addLast(j);
        			while(!queue.isEmpty()) {
        				int poped = queue.removeFirst();
        				for(int k=0; k<N; k++) {
        					if(friends[k][poped] == 1) {
        						friends[k][poped] = -1;
        						queue.addLast(k);
        					}
        				}
        			}
        		}
        	}
        }
        return groups;
    }
	
	// driver - main method
	public static void main(String[] args) {
		// TESTCASES
		int[][] friends = {{1,0,0,1},{0,1,1,0},{0,1,1,1},{1,0,1,1}};
		System.out.println(numberOfFriendsGroups(friends));
		
		friends = new int[][]{{1,1,0},{1,1,0},{0,0,1}};
		System.out.println(numberOfFriendsGroups(friends));
		
		friends = new int[][]{{1,0,0},{0,1,0},{0,0,1}};
		System.out.println(numberOfFriendsGroups(friends));
	}

}
