/**
 * Given a binary tree, return its level order traversal 
 * where the nodes in each level are ordered from left to right.
 */
package BreadthFirstSearch;

/**
 * @author gaurav kabra
 * @since June 16, 2021
 */

import java.util.List;
import BreadthFirstSearch.Utils.LevelOrderTraversalUtil;
import Trees.TreeUtils.TreeNode;
import Trees.TreeUtils.TreeUtil;


public class LevelOrderTraversal {
	
	private static List<List<TreeNode<Integer>>> levelOrderTraversal(TreeNode<Integer> root) {
		return LevelOrderTraversalUtil.levelOrderTraversal(root);
	}
	
	// prints the levels of tree
	private void printLevels(List<List<TreeNode<Integer>>> ls) {
		for(List<TreeNode<Integer>> l : ls) {
			for(TreeNode<Integer> node : l) {
				System.out.print(node.val + " ");
			}
			System.out.println();
		}
	}
	
	// driver - main method
	public static void main(String[] args) {
		TreeNode<Integer> root = TreeUtil.getDummyBinarySearchTree();
		LevelOrderTraversal lot = new LevelOrderTraversal();
		
		// TESTCASES
		List<List<TreeNode<Integer>>> ls1 = lot.levelOrderTraversal(root);
		lot.printLevels(ls1);
		List<List<TreeNode<Integer>>> ls2 = lot.levelOrderTraversal(null);
		lot.printLevels(ls2);
	}

}
