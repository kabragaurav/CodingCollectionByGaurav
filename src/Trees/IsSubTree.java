/**
 * Amazon
 * Given two trees s and t return whether t is a subtree of s.
 * For t to be a subtree of s not only must each node’s value in t match its corresponding node’s value in s,
 * but t must also exhibit the exact same structure as s.
 */

package Trees;

import Trees.TreeUtils.TreeNode;
import Trees.TreeUtils.TreeUtil;

/**
 * @author gaurav kabra
 * @since 4 Sept 2021
 **/

public class IsSubTree {
    private static boolean isSubTreeHelper(TreeNode<Integer> root1, TreeNode<Integer> root2) {
        /**
         * Logic:
         * If both are null, return true
         * If one is null but other is not, return false
         * Return if root1 and root2 are identical.
         */
        if(root1 == null && root2 == null) {
            return true;
        }
        if(root1 == null || root2 == null) {
            return false;
        }

        return root1.val == root2.val
                && isSubTreeHelper(root1.left, root2.left)
                && isSubTreeHelper(root1.right, root2.right);

    }


    private static boolean isSubTree(TreeNode<Integer> root1, TreeNode<Integer> root2) {
        /**
         * Logic:
         * We first see if root2 is subtree of root1
         *      If so, return true
         *      else
         *          Check for left and right subtrees of root1
         */
        if(isSubTreeHelper(root1, root2)) {
            return true;
        }
        return null != root1
                && (isSubTree(root1.left, root2) || isSubTree(root1.right, root2));
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASE
        TreeNode<Integer> root1 = TreeUtil.getDummyBinarySearchTree();
        TreeNode<Integer> root2 = root1;
        System.out.println(isSubTree(root1, root2));
    }
}
