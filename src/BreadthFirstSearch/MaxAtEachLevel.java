/**
 * Given a binary tree, return the largest value in each of its levels.
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

/**
 * The logic is same as LevelOrderTraversal.java
 * In fact, it is just a slight variation of LevelOrderTraversal.java program
 */
public class MaxAtEachLevel {
	
	/**
	 * Time Complexity : O(N) since we traverse tree once
	 * Space Complexity : O(N) since we need storage depending on number of nodes in tree(i.e. N).
	 */
	private static List<List<TreeNode<Integer>>> levelOrderTraversal(TreeNode<Integer> root) {
		return LevelOrderTraversalUtil.levelOrderTraversal(root);
	}
	
	// finds and prints the max at each level of tree
	private void printMaxAtEachLevel(List<List<TreeNode<Integer>>> ls) {
		for(List<TreeNode<Integer>> l : ls) {
			int max = Integer.MIN_VALUE;
			for(TreeNode<Integer> node : l) {
				max = (node.val > max ? node.val 
									  : max
					   );
			}
			System.out.println(max);
		}
	}
	
	// driver - main method
	public static void main(String[] args) {

		TreeNode<Integer> root = TreeUtil.getDummyBinarySearchTree();
		MaxAtEachLevel mael = new MaxAtEachLevel();
		
		// TESTCASES
		List<List<TreeNode<Integer>>> ls1 = mael.levelOrderTraversal(root);
		mael.printMaxAtEachLevel(ls1);
		List<List<TreeNode<Integer>>> ls2 = mael.levelOrderTraversal(null);
		mael.printMaxAtEachLevel(ls2);
	}

}
