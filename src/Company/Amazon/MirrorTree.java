/**
 * Given the root of a binary tree,
 * check whether it is a mirror of itself (i.e., symmetric around its center).
 */
package Company.Amazon;

import Trees.TreeUtils.TreeNode;
import Trees.TreeUtils.TreeUtil;

/**
 * @author gkabra
 * @since 29-01-2022 Sat
 **/

public class MirrorTree {

    private static boolean helper(TreeNode left, TreeNode right) {
        if(left == null && right == null) {
            return true;
        }
        if(left == null || right == null) {
            return false;
        }
        return left.val == right.val &&
                helper(left.left, right.right) &&
                helper(left.right, right.left);
    }

    private static boolean isSymmetric(TreeNode root) {
        if(root == null || (root.left == null && root.right == null)) {
            return true;
        }
        if(root.left == null || root.right == null) {
            return false;
        }
        return root.left.val == root.right.val &&
                helper(root.left, root.right);
    }

    public static void main(String[] args) {
        TreeNode root = TreeUtil.getDummyBinaryTree1();

        System.out.println(isSymmetric(root));
    }

}
