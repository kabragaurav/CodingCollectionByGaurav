/**
 * Given the root of a binary search tree,
 * and an integer k, return the kth (k>=1) smallest element in the tree.
 */
package Trees;

import Trees.TreeUtils.TreeNode;
import Trees.TreeUtils.*;

/**
 * @author gaurav kabra
 * @since 18 Sept 2021
 **/

public class KthSmallest {
    private static int ans;
    private static int index;

    private static void inorder(TreeNode<Integer> root, int k) {
        if(root == null) {
            return;
        }
        inorder(root.left, k);
        index++;
        if(index == k) {
            ans = root.val;
            return;
        }
        inorder(root.right, k);
    }

    private static int kthSmallest(TreeNode root, int k) {
        /**
         * Logic:
         * Inorder traversal of BST leads ascending output.
         * So we just need to pick up kth index value in that output.
         */
        ans = index = 0;
        inorder(root, k);
        return ans;
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASE
        TreeNode<Integer> root = TreeUtil.getDummyBinarySearchTree();
        System.out.println(kthSmallest(root, 1));
    }
}
