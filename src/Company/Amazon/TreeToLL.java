/**
 * Given the root of a binary tree, flatten the tree into a "linked list":
 * The "linked list" should use the same TreeNode class where the right child pointer
 * points to the next node in the list and the left child pointer is always null.
 * The "linked list" should be in the same order as a pre-order traversal of the binary tree.
 */
package Company.Amazon;

import Trees.TreeUtils.TreeNode;
import Trees.TreeUtils.TreeUtil;

/**
 * @author gkabra
 * @since 28-01-2022 Fri
 **/

public class TreeToLL {

    /**
     * Logic:
     *
     * TC:
     * T(n) = 2*T(n/2) + O(n) assume this is a balanced tree -> O(nlogn).
     * T(n) = T(n-1) + O(n) assume skew left tree-> O(n^2)
     */
    private static void flatten(TreeNode root) {
        if(root == null) {
            return;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;

        root.right = left;
        root.left = null;

        flatten(left);
        flatten(right);

        TreeNode temp = root;
        while(temp.right != null) {
            temp = temp.right;
        }
        temp.right = right;
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASE
        TreeNode root = TreeUtil.getDummyBinarySearchTree();
        flatten(root);
        TreeUtil.getTreePrintedInorder(root);
    }

}
