/**
 * Given a binary tree, print all paths from root to leaf paths 
 * (including one node only once in a path).
 */
package DepthFirstSearch;

import java.util.ArrayList;
import java.util.List;

import Trees.TreeUtils.TreeNode;
import Trees.TreeUtils.TreeUtil;

/**
 * @author gaurav kabra
 * @since June 25, 2021
 */

public class RootToLeafPaths {
	
	private void getRootToLeafPaths(TreeNode<Integer> root, String s) {
		/**
		 * Logic:
		 * When we come to end of a branch, we will print the string s.
		 * Else we will move to left and right subtrees separately, including root.val in both branches to be printed.
		 * 
		 * Time Complexity : O(N) since in worst case tree can be skewed
		 * Space Complexity : O(N) since using implicit stack in recursive calls
		 */
		
		if(root == null) {
			System.out.println(s);
			return;
		}
		else if(root.left == null && root.right == null) {
			System.out.println(s + root.val);
		}
		if(root.left != null) {
			String s1  = s + root.val + "->";
			getRootToLeafPaths(root.left, s1);
		}
		
		if(root.right != null) {
			String s2  = s + root.val + "->";
			getRootToLeafPaths(root.right, s2);
		}
	}
	
	// driver - main method
	public static void main(String[] args) {
		
		TreeNode<Integer> root = TreeUtil.getDummyBinarySearchTree();
		RootToLeafPaths rtlp = new RootToLeafPaths();
		rtlp.getRootToLeafPaths(root, new String());
	}
}
