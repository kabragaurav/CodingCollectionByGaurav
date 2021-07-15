/**
 * Given the root of a binary tree, 
 * check whether it is a mirror of itself (i.e. symmetric around its center).
 */
package Trees;

import Trees.TreeUtils.TreeNode;
import Trees.TreeUtils.TreeUtil;

/**
 * @author gaurav kabra
 * @since June 26, 2021
 */

public class ReflectionTree {
	
	private boolean helperIsReflection(TreeNode<Integer> leftNode, TreeNode<Integer> rightNode) {
		/**
		 * Left subtree should be similar to right subtree and vice-versa for reflection
		 */
        if(leftNode == null && rightNode == null)
            return true;
        if(leftNode == null || rightNode == null)
            return false;
        return (leftNode.val == rightNode.val)
               && helperIsReflection(leftNode.left, rightNode.right)
               && helperIsReflection(leftNode.right, rightNode.left);
    }
	
	private boolean isReflection(TreeNode<Integer> root) {
		/*
		 * Logic:
		 * If tree is empty or have just one node then it is reflection of itself
		 * Else if left subtree is empty but right subtree is not (or vice versa), return false
		 * else check for left and right subtrees recursively.
		 * 
		 * Time Complexity: O(log N) since for being reflection, tree must be balanced and in case of being skewed, we will return false soon
		 * Space Complexity: O(log N) since all nodes will be stores in implicit stack and in worst case of balanced tree, height is logN
		 */
		if(root == null || (root.left == null && root.right == null))
			return true;
		if(root.left == null || root.right == null)
			return false;
		return helperIsReflection(root.left, root.right);
	}
	
	// driver - main method
	public static void main(String[] args) {
		TreeNode<Integer> root = TreeUtil.getDummyBinarySearchTree();
		ReflectionTree rt = new ReflectionTree();
		
		// TESTCASE
		System.out.println(rt.isReflection(root));
		
	}

}
