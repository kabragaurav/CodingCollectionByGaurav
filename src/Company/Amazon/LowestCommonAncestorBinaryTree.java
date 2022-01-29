package Company.Amazon;

import Trees.TreeUtils.TreeNode;
import Trees.TreeUtils.TreeUtil;

/**
 * @author gkabra
 * @since 29-01-2022 Sat
 **/

public class LowestCommonAncestorBinaryTree {

    /**
     * Logic:
     *
     *      Best video: https://tinyurl.com/lowest-common-ancestor-bt
     */
    private static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // if any one is null, return other
        if(left == null) {
            return right;
        }
        if(right == null) {
            return left;
        }
        // else return root
        return root;
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASE
        TreeNode root = TreeUtil.getDummyBinaryTree1();
        System.out.println(lowestCommonAncestor(root, root, root.right).val);
    }

}
