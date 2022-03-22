/*
    Given a binary tree root and an integer target, delete all the leaf nodes with value target.
    Note that once you delete a leaf node with value target, if its parent node becomes a leaf node
    and has the value target, it should also be deleted (you need to continue doing that until you cannot).
 */
package Trees;

import Trees.TreeUtils.TreeNode;
import Trees.TreeUtils.TreeUtil;

/**
 * @author gauravkabra
 * @since 22/Mar/2022
 **/

public class DeleteLeavesOfGivenValue {

    private static boolean isModified = false;

    private static TreeNode<Integer> traverse(TreeNode<Integer> root, TreeNode<Integer> parent, int target) {
        if (root == null) {
            return null;
        }
        if (root.left == null && root.right == null) {
            if (root.val == target) {
                return null;
            }
        }

        if (root.left != null) {
            if (root.left.left == null && root.left.right == null) {
                if ((int) root.left.val == target) {
                    isModified = true;
                    root.left = null;
                }
            }
        }

        if (root.right != null) {
            if (root.right.left == null && root.right.right == null) {
                if ((int) root.right.val == target) {
                    isModified = true;
                    root.right = null;
                }
            }
        }

        root.left = traverse(root.left, root, target);
        root.right = traverse(root.right, root, target);
        return root;
    }

    // TC : O(N^2) if all nodes have same value as target
    // SC : O(1) explicit
    private static TreeNode<Integer> removeLeafNodes(TreeNode<Integer> root, int target) {
        do {
            isModified = false;
            root = traverse(root, null, target);
        } while (isModified);

        return root;
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASE
        TreeUtil.getTreePrintedInorder(removeLeafNodes(TreeUtil.getDummyBinaryTree3(), 0));
    }

}
