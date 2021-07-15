/**
 * Given a binary tree, containing unique values, determine if it is a strict valid binary search tree.
 */
package Trees;

import Trees.TreeUtils.TreeNode;
import Trees.TreeUtils.TreeUtil;

/**
 * @author gaurav kabra
 * @since June 25, 2021
 */

public class ValidateBST {
    
	private boolean isStrictBST(TreeNode<Long> root, long minVal, long maxVal) {
		/**
		 * Logic:
		 * All values to the left of a given node are less than the current node’s value, 
		 * all values to the right of a given node are greater than the current node’s value, 
		 * and both the left and right subtrees of a given node must also be BSTs.
		 * 
		 * Time Complexity: O(N) since in worst case, tree can be skewed
		 * Space Complexity: O(N) since using implicit stack due to recursion
		 */
		if (root == null) return true;
        if (root.val >= maxVal || root.val <= minVal) return false;
        return isStrictBST(root.left, minVal, root.val) && isStrictBST(root.right, root.val, maxVal);
	}
	
	public boolean isValidBST(TreeNode<Long> root) {
        return isStrictBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
	
	// driver - main method
	public static void main(String[] args) {
		
		ValidateBST vbst = new ValidateBST();
		// TESTCASE
		System.out.println(vbst.isValidBST(TreeUtil.getDummyBinarySearchTreeLong()));
	}

}
