/**
 * Given an unordered list of flights taken by someone, each represented as (origin, destination) pairs, 
 * and a starting airport, compute the person's itinerary.
 * All of the tickets belong to a man who departs from "JAIPUR", thus, the itinerary must begin with "JAIPUR". 
 * If there are multiple valid itineraries, you should return the itinerary that has the smallest lexicographical order 
 * when read as a single string.
 * For example, the itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"].
 * You may assume all tickets form at least one valid itinerary. You must use all the tickets once and only once.
 */

package DepthFirstSearch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author gaurav kabra
 * @since July 24, 2021
 */

public class FlightItinerary {
	private static LinkedList<String> itinerary;
	
	private static void dfs(String from, Map<String, PriorityQueue<String>> adjacencyList) {
		PriorityQueue<String> to = adjacencyList.get(from);
		while(to != null && !to.isEmpty()) {
			dfs(to.poll(), adjacencyList);
		}
		itinerary.addFirst(from);
	}
	
	private static Map<String, PriorityQueue<String>> getAdjacencyListRepr(List<List<String>> tickets) {
		/**
		 * Logic:
		 * Construct the graph using adjacency list representation
		 */
		Map<String, PriorityQueue<String>> mp = new HashMap<>();
		for(List<String> ticket : tickets) {
			String from = ticket.get(0);
			String to = ticket.get(1);
			mp.putIfAbsent(from, new PriorityQueue<>());
			mp.get(from).add(to);
		}
		return mp;
	}
	
	private static List<String> findItinerary(List<List<String>> tickets) {
		/**
		 * Logic:
		 * Since we have to travel all neighbors of a node, starting from lexicographically 
		 * smallest one, we use PriorityQueue which is min-heap by default in Java.
		 */
        Map<String, PriorityQueue<String>> adjacencyList = getAdjacencyListRepr(tickets);
        itinerary = new LinkedList<String>();
        dfs("JAIPUR", adjacencyList);
        return itinerary;
    }
	
	// driver - main method
	public static void main(String[] args) {
		// TESTCASES
		List<List<String>> ls = new ArrayList<>();
		ls.add(new ArrayList<String>() {{
			add("DELHI");
			add("MUMBAI");
			}});
		ls.add(new ArrayList<String>() {{
			add("JAIPUR");
			add("DELHI");
			}});
		ls.add(new ArrayList<String>() {{
			add("KOLKATA");
			add("MADRAS");
			}});
		ls.add(new ArrayList<String>() {{
			add("MUMBAI");
			add("KOLKATA");
			}});
		
		System.out.println(findItinerary(ls));
		
				
		ls = new ArrayList<>();
		ls.add(new ArrayList<String>() {{
			add("JAIPUR");
			add("DELHI");
			}});
		ls.add(new ArrayList<String>() {{
			add("JAIPUR");
			add("MADRAS");
			}});
		ls.add(new ArrayList<String>() {{
			add("DELHI");
			add("MADRAS");
			}});
		ls.add(new ArrayList<String>() {{
			add("MADRAS");
			add("JAIPUR");
			}});
		ls.add(new ArrayList<String>() {{
			add("MADRAS");
			add("DELHI");
			}});
		System.out.println(findItinerary(ls));
	}

}
