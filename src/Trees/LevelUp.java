/**
 * Given a BST, modify it so that all greater values in the given BST are added to every TreeNode.
 */
package Trees;

import Trees.TreeUtils.TreeNode;
import Trees.TreeUtils.TreeUtil;

/**
 * @author gaurav kabra
 * @since 30 Oct 2021
 **/

public class LevelUp {

    private static int sumSoFar = 0;

    private static void traverse(TreeNode<Integer> root) {
        if(null == root) {
            return;
        }
        traverse(root.right);
        root.val = sumSoFar += root.val;
        traverse(root.left);
    }

    /**
     * Logic:
     * We do traversal in order right -> root -> left and keep adding values of nodes.
     *
     * TC : O(N)
     * SC : O(1)
     */
    public static TreeNode<Integer> modify(TreeNode<Integer> root) {
        traverse(root);
        return root;
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASE
        TreeUtil.getTreePrintedInorder(modify(TreeUtil.getDummyBinarySearchTree()));
    }
}
