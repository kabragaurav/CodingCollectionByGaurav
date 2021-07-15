/**
 * Given a binary tree, return its maximum depth.T
 * The maximum depth is defined as the number of nodes along the longest path 
 * from root node to leaf node.
 */
package DepthFirstSearch;

import Trees.TreeUtils.TreeNode;
import Trees.TreeUtils.TreeUtil;

/**
 * @author gaurav kabra
 * @since June 21, 2021
 */

public class MaxDepthOfTree {
	
	private int maxDepth(TreeNode<Integer> root) {
		/**
		 * Logic:
		 * Since root has to be there so we add 1.
		 * Now we can only take height of either left and right subtree in final answer.
		 * So we find the subtrees' heights and take maximum of them.
		 * 
		 * Time Complexity: O(N) since we traverse whole tree which in worst case can be skewed
		 * Space Complexity: O(N) because of implicit stack in recursion
		 */
        if(root == null)
            return 0;
        return 1 + Math.max(maxDepth(root.left), 
        					maxDepth(root.right));
    }
	
	// driver - main method
	public static void main(String[] args) {
		TreeNode<Integer> root = TreeUtil.getDummyBinarySearchTree();
		
		// TESTCASE
		System.out.println(new MaxDepthOfTree().maxDepth(root));

	}

}
