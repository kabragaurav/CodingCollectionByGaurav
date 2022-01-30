/**
 * Given a binary tree, determine if it is height-balanced.
 */
package Company.Pramp;

import Trees.TreeUtils.TreeNode;
import Trees.TreeUtils.TreeUtil;

/**
 * @author gkabra
 * @since 30-01-2022 Sun
 **/

public class IsBalancedTree {

    private static int height(TreeNode root) {
        if(root == null) {
            return 0;
        }
        return 1 + Math.max(height(root.left),
                height(root.right));
    }

    private static boolean isBalanced(TreeNode root) {
        if(root == null) {
            return true;
        }
        int left = height(root.left);
        int right = height(root.right);

        return Math.abs(right-left) <= 1 &&
                isBalanced(root.left) &&
                isBalanced(root.right);
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASE
        System.out.println(isBalanced(TreeUtil.getDummyBinarySearchTree()));
    }

}
