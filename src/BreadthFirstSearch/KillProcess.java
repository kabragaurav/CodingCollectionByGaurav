/**
 * Bloomberg
 * In OS, each process has a unique PID (process id) and PPID (parent process id).
 * Each process only has one parent process, but may have one or more children processes. 
 * This is just like a tree structure. 
 * Only one process has PPID that is 0, which means this process has no parent process. 
 * All the PIDs will be distinct positive integers.
 * We use two list of integers to represent a list of processes, where the first list contains PID for 
 * each process and the second list contains the corresponding PPID.
 * Now given the two lists, and a PID representing a process you want to kill, 
 * return a list of PIDs of processes that will be killed in the end. 
 * You should assume that when a process is killed, all its children processes will be killed. 
 * No order is required for the final answer.
 * The given kill id is guaranteed to be one of the given PIDs.
 * There is at least one PID in the list.
 */
package BreadthFirstSearch;

/**
 * @author gaurav kabra
 * @since August 08, 2021
 */

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KillProcess {
	/**
     * @param pid: the process id
     * @param ppid: the parent process id
     * @param kill: a PID you want to kill
     * @return: a list of PIDs of processes that will be killed in the end
     */
	private static List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
		/**
		 * Logic:
		 * We can only return the list of processes that will be killed if we can get subtree, rooted at node 'kill'
		 * Since each parent process can have any number of child processes, so binary tree won't help.
		 * So we maintain a map, parentToChildrenMapping, that will contain mappings from a parent to the list of all its child processes.
		 * Then we can apply bfs on the map to get all processes to be reaped. 
		 */
        Deque<Integer> deque = new ArrayDeque<>();
        Map<Integer, List<Integer>> parentToChildrenMapping = new HashMap<>();
        
        // create parent-child mapping
        for(int i=0; i<pid.size(); i++) {
        	int parentId = ppid.get(i);
        	List<Integer> value = parentToChildrenMapping.get(parentId);
        	if(value == null) {
        		value = new ArrayList<Integer>();
        	}
        	value.add(pid.get(i));
        	parentToChildrenMapping.put(parentId, value);
        }
        
        List<Integer> ans = new ArrayList<>();
        // dfs
        deque.addLast(kill);
        while(!deque.isEmpty()) {
        	int poped = deque.removeFirst();
        	ans.add(poped);
        	List<Integer> value = parentToChildrenMapping.get(poped);
        	if(value == null) {
        		continue;
        	}
        	for(int val : value) {
        		deque.addLast(val);
        	}
        }
        
        return ans;
    }

	// driver - main method
	public static void main(String[] args) {
		List<Integer> pid = new ArrayList<>() {{
			add(2);
			add(5);
			add(10);
			add(15);
			add(13);
			add(12);
		}};
		List<Integer> ppid = new ArrayList<>() {{
			add(0);
			add(0);
			add(5);
			add(10);
			add(10);
			add(15);
		}};
		// TESTCASES
		System.out.println(killProcess(pid, ppid, 10));
		System.out.println(killProcess(pid, ppid, 0));
	}

}
