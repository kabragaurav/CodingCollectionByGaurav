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
	/**
	 * @param TreeNode<Integer> root
	 * @return List<List<TreeNode<Integer>>> empty or having nodes in order of level wise traversal of tree
	 */
	
	public static List<List<TreeNode<Integer>>> levelOrderTraversal(TreeNode<Integer> root) {
		if(null == root) {
			return new ArrayList<>();
		}
		List<List<TreeNode<Integer>>> lists = new ArrayList<>();
		Deque<TreeNode<Integer>> deque = new ArrayDeque<>();
		deque.addLast(root);

		while(!deque.isEmpty()) {
			int size = deque.size();
			List<TreeNode<Integer>> list = new ArrayList<>();
			for(int i=0; i<size; i++) {
				TreeNode<Integer> front = deque.pollFirst();
				list.add(front);
				if(front.left != null) {
					deque.addLast(front.left);
				}
				if(front.right != null) {
					deque.addLast(front.right);
				}
			}
			lists.add(list);
		}

		return lists;
	}


	/**
	 * @param TreeNode<Integer> root
	 * @return List<List<Integer>> empty or having nodes in order of level wise traversal of tree
	 */

	public static List<List<Long>> levelOrderTraversalWithValues(TreeNode<Integer> root) {
		if(null == root) {
			return new ArrayList<>();
		}
		List<List<Long>> lists = new ArrayList<>();
		Deque<TreeNode<Integer>> deque = new ArrayDeque<>();
		deque.addLast(root);

		while(!deque.isEmpty()) {
			int size = deque.size();
			List<Long> list = new ArrayList<>();
			for(int i=0; i<size; i++) {
				TreeNode<Integer> front = deque.pollFirst();
				list.add((long)front.val);
				if(front.left != null) {
					deque.addLast(front.left);
				}
				if(front.right != null) {
					deque.addLast(front.right);
				}
			}
			lists.add(list);
		}

		return lists;
	}

}
