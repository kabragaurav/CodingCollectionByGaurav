/**
 * Given a binary search tree, rearrange the tree such that 
 * it forms a list where all its values are in ascending order.
 */
package Trees;

import java.util.ArrayList;
import java.util.List;

import Trees.TreeUtils.TreeNode;
import Trees.TreeUtils.TreeUtil;

/**
 * @author gaurav kabra
 * @since June 10, 2021
 */

public class BSTToArray {
	
	private void inOrderTraversal(List<Integer> ls, TreeNode<Integer> root) {
		/**
		 * Logic:
		 * Inorder traversal (left -> root -> right) of tree gives us sorted (ascending) list.
		 * 
		 * Time Complexity: O(N), where N is the number of nodes in the BST (We have to visit each node).
         * Space Complexity: O(N) since we maintain a list to store all nodes of tree. Also the maximum amount of space utilized by the recursion stack would be N since the height of a skewed BST could be N.
         */
     
		if(root == null)
			return;
		if((root.left == null ) && (root.right == null)) {
			ls.add(root.val);
		} 
		else {
			inOrderTraversal(ls, root.left);
			ls.add(root.val);
			inOrderTraversal(ls, root.right);
		}
	}
	
	// driver - main method
	public static void main(String[] args) {
		// create empty list to hold sorted numbers from tree traversal
		List<Integer> ls = new ArrayList<>();
		
		TreeNode<Integer> root = TreeUtil.getDummyBinarySearchTree();
		
		BSTToArray bta = new BSTToArray();
		bta.inOrderTraversal(ls, root);
		
		for(Integer i : ls) {
			System.out.println(i);
		}
	}

}
