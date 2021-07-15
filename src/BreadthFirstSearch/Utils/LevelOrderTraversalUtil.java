package BreadthFirstSearch.Utils;

/**
 * @author gaurav kabra
 * @since June 16, 2021
 */

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import Trees.TreeUtils.TreeNode;

/**
 *	Performs Level Order Traversal of a binary tree
*/

public class LevelOrderTraversalUtil {
	
	// NULL is symbol that will denote end of a level in tree
	static TreeNode<Integer> NULL;
	
	static {
		NULL = new TreeNode<Integer>(Integer.MAX_VALUE);
	}
	
	/**
	 * @param TreeNode<Integer> root
	 * @return List<List<TreeNode<Integer>>> empty or having nodes in order of level wise traversal of tree
	 * 
	 * Time Complexity : O(N) since we traverse tree once
	 * Space Complexity : O(N) since we need storage depending on number of nodes in tree(i.e. N).
	 */
	
	public static List<List<TreeNode<Integer>>> levelOrderTraversal(TreeNode<Integer> root) {
		TreeNode<Integer> tempNode;															// holds a tree node temporarily
		Deque<TreeNode<Integer>> deque = new ArrayDeque<>();								// holds tree nodes and NULL
		List<TreeNode<Integer>> tempList = new ArrayList<>();								// holds tree nodes that are at same level. Finally we add it to our final answrer
		List<List<TreeNode<Integer>>> list = new ArrayList<List<TreeNode<Integer>>>();		// final answer
		
		if(root == null)
			return list;																	// return empty list if root is null
		deque.add(root);
		deque.add(NULL);																	// at root our first level completes
		boolean twoConsecutiveNull = false;													// at last of tree, we check if two NULL are there in deque, break out of while loop
		while(!deque.isEmpty()) {
			tempNode = deque.remove();														// remove first element
			
			/**
			 * if NULL that means one level is completed
			 * So check if two NULL are in list. If so break. Else add all elements at the level to our final answer
			 */
			
			if(tempNode == NULL) {					
				if(twoConsecutiveNull)
					break;
				twoConsecutiveNull = true;
				List<TreeNode<Integer>> tList = new ArrayList<>();
				tList.addAll(tempList);
				list.add(tList);
				
				// BEFORE CLEARING tempList, assign it to local variable (if global then clearing will clear data in list as well) to create deep copy
				tempList.clear();
				
				deque.add(NULL);
			} 
			else {
				twoConsecutiveNull = false;
				tempList.add(tempNode);
				if(tempNode.left != null)
					deque.add(tempNode.left);
				if(tempNode.right != null)
					deque.add(tempNode.right);
			}
		}
		return list;
	} 
	
}
