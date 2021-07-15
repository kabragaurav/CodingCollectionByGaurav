/**
 * A path in a binary tree is a sequence of nodes where each pair of adjacent nodes in the sequence has an edge connecting them.
 * A node can only appear in the sequence at most once.
 * The path sum of a path is the sum of the node's values in the path.
 * Given the root of a binary tree, return the maximum path sum of any path.
 */

package DP.Trees;

/**
 * @author gaurav kabra
 * @since June 20, 2021
 */

import Trees.TreeUtils.TreeNode;
import Trees.TreeUtils.TreeUtil;

public class MaximumPathSum {
    int maxValue = Integer.MIN_VALUE;
    
    private int maxPathSumHelper(TreeNode<Integer> root) {
    	/**
    	 * Time Complexity: O(N) since we essentially traverse the tree
    	 * Space Complexity: O(N) since we use implicit stack in recursive calls
    	 */
        if(root == null)
            return 0;
        
        int left = Math.max(maxPathSumHelper(root.left), 0);
        int right = Math.max(maxPathSumHelper(root.right), 0);
        
        // The second maxValue contains the bigger between the left sub-tree and right sub-tree
        maxValue = Math.max(maxValue, left + right + root.val);
        
        // In the upper layer(after return statement), we cannot choose both left and right branches
        // so we need to select the larger one, so we use max(left, right) + root.val to prune the lower branch
        return Math.max(left, right) + root.val;
    }
    
    private int maxPathSum(TreeNode<Integer> root) {
        maxPathSumHelper(root);
        return maxValue;
    }

	public static void main(String[] args) {
		TreeNode<Integer> root = TreeUtil.getDummyBinarySearchTree();
		System.out.println(new MaximumPathSum().maxPathSum(root));
	}

}
