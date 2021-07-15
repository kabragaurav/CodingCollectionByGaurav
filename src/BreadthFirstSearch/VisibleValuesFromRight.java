/**
 * Given a binary tree return all the values you’d be able to see 
 * if you were standing on the right side of it with values ordered from top to bottom.
 */
package BreadthFirstSearch;

import java.util.List;
import BreadthFirstSearch.Utils.LevelOrderTraversalUtil;
import Trees.TreeUtils.TreeNode;
import Trees.TreeUtils.TreeUtil;

/**
 * @author gaurav kabra
 * @since June 16, 2021
 */

/**
 * The logic is same as LevelOrderTraversal.java
 * In fact, it is just a slight variation of LevelOrderTraversal.java program
 */
public class VisibleValuesFromRight {
	
	/**
	 * Logic:
	 * Perform the level order traversal.
	 * If you view a tree from right side, you will see last element of each level.
	 * So return last element of each level from level order traversal.
	 * 
	 * Time Complexity : O(N) since we traverse tree once
	 * Space Complexity : O(N) since we need storage depending on number of nodes in tree(i.e. N).
	 */
	private static List<List<TreeNode<Integer>>> levelOrderTraversal(TreeNode<Integer> root) {
		return LevelOrderTraversalUtil.levelOrderTraversal(root);
	}
	
	private void getRightView(List<List<TreeNode<Integer>>> ls) {
		for(List<TreeNode<Integer>> l : ls) {
			System.out.println(l.get(l.size()-1).val);		 // last element at each level
		}
	}
	
	// driver - main method
	public static void main(String[] args) {
		TreeNode<Integer> root = TreeUtil.getDummyBinarySearchTree();
		VisibleValuesFromRight vvfr = new VisibleValuesFromRight();
		List<List<TreeNode<Integer>>> ls = vvfr.levelOrderTraversal(root);
		vvfr.getRightView(ls);
	}

}
