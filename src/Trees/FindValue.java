/**
 * Google
 * Given the reference to the root of a binary search tree and a search value, 
 * return the reference to the node that contains the value if it exists and null otherwise.
 */
package Trees;

import Trees.TreeUtils.TreeNode;
import Trees.TreeUtils.TreeUtil;

/**
 * @author gaurav kabra
 * @since June 10, 2021
 */

public class FindValue {
	
	private TreeNode<Integer> getValueReference(TreeNode<Integer> root, int val) {
		/**
		 * Logic:
		 * If root is null or value that we want to find is same as value at root, return root.
		 * Else if value is less than value at root, search in left tree. Else search in right tree.
		 * 
		 * Time Complexity: O(N), where N is the number of nodes in the BST. In the worst case we might be visiting all the nodes of the BST.
         * Space Complexity: O(N). Because the maximum amount of space utilized by the recursion stack would be N since the height of a skewed BST could be N.
         */
		
		if(root == null || root.val == val) {
			return root;
		}
		
		return (root.val > val) ? getValueReference(root.left, val)
					            : getValueReference(root.right, val);
	}
	
	// driver - main method
	public static void main(String[] args) {
		TreeNode<Integer> root = TreeUtil.getDummyBinarySearchTree();
		// TESTCASES
		FindValue fv = new FindValue();
		System.out.println(fv.getValueReference(root, 5).val);
		System.out.println(fv.getValueReference(root, 1));
	}

}
