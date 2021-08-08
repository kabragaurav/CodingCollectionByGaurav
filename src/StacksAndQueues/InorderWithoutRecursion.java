/**
 * Perform inorder traversal of a binary tree without recursion.
 */
package StacksAndQueues;

import Trees.TreeUtils.TreeUtil;
import java.util.Stack;
import Trees.TreeUtils.TreeNode;

/**
 * @author gaurav kabra
 * @since August 08, 2021
 */

public class InorderWithoutRecursion {
	
	private static void inorderUsingStack(TreeNode<Integer> root) {
		/**
		 * Logic:
		 * Recursion is nothing but uses internal stack.
		 * So if we want to do inorder without recursion, we will need to maintain explicit stack (here stk).
		 * 
		 * We first put root and its left children. While poping, we see if poped element has right subtree, 
		 * then process that by putting right subtree root and all its left children in stack.
		 * We continue while all elements are processed, i.e., while stack is not empty.
		 */
		if(root == null) {
			return;
		}
		Stack<TreeNode<Integer>> stk = new Stack<>();
		stk.push(root);
		
		while(root.left != null) {
			stk.push(root.left);
			root = root.left;
		}
		
		while(!stk.isEmpty()) {
			TreeNode<Integer> poped = stk.pop();
			System.out.println(poped.val);
			if(poped.right != null) {
				root = poped.right;
				stk.push(root);
				while(root.left != null) {
					stk.push(root.left);
					root = root.left;
				}
			}
		}
		
	}
	
	// driver - main method
	// driver - main method
	public static void main(String[] args) {
		TreeNode<Integer> root = TreeUtil.getDummyBinarySearchTree();
		// TESTCASES
		inorderUsingStack(root);
		inorderUsingStack(null);
	}

}
