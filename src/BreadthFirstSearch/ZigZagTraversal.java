/**
 * Given a binary tree, return its zig-zag level order traversal (i.e. its level order traversal 
 * from left to right the first level, right to left the level the second, etc.).
 */
package BreadthFirstSearch;

/**
 * @author gaurav kabra
 * @since June 19, 2021
 */

import java.util.Collections;
import java.util.List;

import BreadthFirstSearch.Utils.LevelOrderTraversalUtil;
import Trees.TreeUtils.TreeNode;
import Trees.TreeUtils.TreeUtil;

public class ZigZagTraversal {
	
	/**
	 * Time Complexity : O(N) since we traverse tree once
	 * Space Complexity : O(N) since we need storage depending on number of nodes in tree(i.e. N).
	 */
	private static List<List<TreeNode<Integer>>> levelOrderTraversal(TreeNode<Integer> root) {
		return LevelOrderTraversalUtil.levelOrderTraversal(root);
	}
	
	private void printZigZagFashioned(List<List<TreeNode<Integer>>> ls) {
		/**
		 * Logic:
		 * Print one level left to right, next right to left, next left to right and so on.
		 * For that we keep a flag.
		 * If true, then we print left to right. Else right to left.
		 */
		boolean flag = true;
		for(List<TreeNode<Integer>> l : ls) {
            if(flag) {
                for(TreeNode<Integer> node : l) {
				    System.out.print(node.val + " ");
			    }
                flag = false;
            }
            else {
                Collections.reverse(l);
                for(TreeNode<Integer> node : l) {
                	System.out.print(node.val + " ");
			    }
                flag = true;
            }
		}
	}
	
	// driver - main method
	public static void main(String[] args) {
		TreeNode<Integer> root = TreeUtil.getDummyBinarySearchTree();
		ZigZagTraversal zzt = new ZigZagTraversal();
		
		// TESTCASE
		List<List<TreeNode<Integer>>> ls = zzt.levelOrderTraversal(root);
		zzt.printZigZagFashioned(ls);
		
	}

}
