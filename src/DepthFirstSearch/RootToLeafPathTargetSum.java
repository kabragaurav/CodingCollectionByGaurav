/**
 * Given a binary tree and a target, return whether or not 
 * there exists a root to leaf path 
 * such that all values along the path sum to the target.
 */
package DepthFirstSearch;

import Trees.TreeUtils.TreeNode;
import Trees.TreeUtils.TreeUtil;

/**
 * @author gaurav kabra
 * @since June 25, 2021
 */

public class RootToLeafPathTargetSum {
	
	private boolean getRootToLeafPathTargetSum(TreeNode<Integer> root, int target, int currentSum) {
		
		/**
		 * Logic:
		 * When we come to end of a branch, we will check if target sum equals sum so far.
		 * Else we will move to left and right subtrees separately, including root.val in both branches.
		 * If any one branch returns true, we return true. Else false.
		 * 
		 * Time Complexity : O(N) since in worst case tree can be skewed
		 * Space Complexity : O(N) since using implicit stack in recursive calls
		 */
		
		// say tree = [] and target = 0
		if(root == null)
            return false; 
		
		if(root.left == null && root.right == null) {
			return (currentSum + root.val) == target;
		}
		boolean b1 = false, b2 = false;
		if(root.left != null) {
			int sum1  = currentSum + root.val;
			b1 = getRootToLeafPathTargetSum(root.left, target, sum1);
		}
		
		if(root.right != null) {
			int sum2  = currentSum + root.val;
			b2 = getRootToLeafPathTargetSum(root.right, target, sum2);
		}
		
		return b1 || b2;
	}
	
	// driver - main method
	public static void main(String[] args) {
		
		TreeNode<Integer> root = TreeUtil.getDummyBinarySearchTree();
		RootToLeafPathTargetSum rtlp = new RootToLeafPathTargetSum();
		// TESTCASE
		System.out.println(rtlp.getRootToLeafPathTargetSum(root, 17, 0));
	}
}
