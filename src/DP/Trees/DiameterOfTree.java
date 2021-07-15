/**
 * The diameter of a tree is the number of nodes on the longest path between any two nodes in the tree.
 * Given the root of a binary tree, return the length of the diameter of the tree.
 */
package DP.Trees;

/**
 * @author gaurav kabra
 * @since June 20, 2021
 */

import Trees.TreeUtils.TreeNode;
import Trees.TreeUtils.TreeUtil;

public class DiameterOfTree {
	
	int maxValue = Integer.MIN_VALUE;
	
	private int diameterOfBinaryTreeHelper(TreeNode<Integer> root) {
        if(root == null)
        	return 0;
        
        int leftHeight = diameterOfBinaryTreeHelper(root.left);
        int rightHeight = diameterOfBinaryTreeHelper(root.right);
        
        maxValue = Math.max(maxValue, leftHeight + rightHeight + 1);
        
        // In the upper layer(after return statement), we cannot choose both left and right branches
        // so we need to select the larger one, so we use max(left, right) + root.val to prune the lower branch
        return 1 + Math.max(leftHeight, rightHeight);
		
	}
	
	private int diameterOfBinaryTree(TreeNode<Integer> root) {
		diameterOfBinaryTreeHelper(root);
		return maxValue;
    }
	
	// driver - main method
	public static void main(String[] args) {
		TreeNode<Integer> root = TreeUtil.getDummyBinarySearchTree();
		System.out.println(new DiameterOfTree().diameterOfBinaryTree(root));
	}

}
