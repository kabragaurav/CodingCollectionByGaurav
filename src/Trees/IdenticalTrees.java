/**
 * Given two binary trees, return whether or not the two trees are identical. 
 * Identical meaning they exhibit the same structure and the same values at each node. 
 */
package Trees;

import Trees.TreeUtils.TreeNode;

/**
 * @author gaurav kabra
 * @since June 11, 2021
 */

public class IdenticalTrees {
	
	private boolean areIdenticalTrees(TreeNode<Integer> p, TreeNode<Integer> q) {
		/**
		 * Logic:
		 * If one of p and q is null, then for identical trees, the other one should also be null.
		 * Else compare values at p and q, compare their left parts and compare their right parts.
		 * Return true if all are same. Else return false.
		 * 
		 * Time Complexity: O(N), where N is the number of nodes in the BST. In the worst case we might be visiting all the nodes of the BST.
         * Space Complexity: O(N). Because the maximum amount of space utilized by the recursion stack would be N since the height of a skewed BST could be N.
         */
		if(p == null) {
            return q == null;
        }
        if(q == null) {
            return p == null;
        }
        return (p.val == q.val)
               && areIdenticalTrees(p.left, q.left)
               && areIdenticalTrees(p.right, q.right);
	}
	
	// helper method to main
	private static TreeNode<Integer> getTreeNode(Integer val) {
	    TreeNode<Integer> treeNode = new TreeNode<Integer>(val);
		return treeNode;
	}
	
	// driver - main method
	public static void main(String[] args) {
		// make trees - having roots as root1 and root2 respectively
		TreeNode<Integer> root1 = getTreeNode(2);
		TreeNode<Integer> root2 = getTreeNode(2);
		TreeNode<Integer> three = getTreeNode(3);
		TreeNode<Integer> one = getTreeNode(1);
		TreeNode<Integer> four = getTreeNode(4);
		
		root1.left = one;	
		root1.right = three;
		root2.left = one;	
		root2.right = three;
		
		IdenticalTrees it = new IdenticalTrees();
		
		// TESTCASES
		System.out.println(it.areIdenticalTrees(root1, root2));
		
		root2.right = four;
		System.out.println(it.areIdenticalTrees(root1, root2));
		

	}

}
