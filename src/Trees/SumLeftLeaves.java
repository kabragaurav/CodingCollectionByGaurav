/**
 * Given a binary tree, return the sum of all left leaves of the tree. 
 */
package Trees;

/**
 * @author gaurav kabra
 * @since July 02, 2021
 */

import Trees.TreeUtils.TreeNode;
import Trees.TreeUtils.TreeUtil;

public class SumLeftLeaves {
	
	// our final answer initialization
	private int sum = 0;
    
    private void helperSumOfLeftLeaves(TreeNode<Integer> root, boolean isLeft) {
    	/**
    	 * Logic:
    	 * if tree is empty, return. Since sum is still 0, so 0 will be returned.
    	 * If branch is left (i.e. isLeft is true) and node is leaf, that means we add its value to our answer
    	 * Else,
    	 * We move to left and right branches.
    	 * 
    	 * Time Complexity : O(N) since in worst case, tree is skewed
    	 * Space Complexity : O(N) since in worst case, tree is skewed and hence implicit stack in recursion has N nodes.
    	 */
        if(root == null) {
            return;
        }
        if(isLeft == true && root.left == null && root.right == null) {
            sum += root.val;
            return;
        }
        helperSumOfLeftLeaves(root.left, true);
        helperSumOfLeftLeaves(root.right, false);
    }
    
    private int sumOfLeftLeaves(TreeNode<Integer> root) {
        helperSumOfLeftLeaves(root, false);
        return sum;
    }
    
    // driver - main method
	public static void main(String[] args) {
		TreeNode<Integer> root = TreeUtil.getDummyBinarySearchTree();
		// TESTCASE
		System.out.println(new SumLeftLeaves().sumOfLeftLeaves(root));

	}

}
