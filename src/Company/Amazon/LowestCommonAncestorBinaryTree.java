package Company.Amazon;

import Trees.TreeUtils.TreeNode;
import Trees.TreeUtils.TreeUtil;

/**
 * @author gkabra
 * @since 29-01-2022 Sat
 **/

public class LowestCommonAncestorBinaryTree {

    private static TreeNode helper(TreeNode<Integer> root, TreeNode<Integer> p, TreeNode<Integer> q) {
        if((p.val < root.val && root.val < q.val) ||
                p.val > root.val && root.val > q.val) {
            return root;
        }
        if(p.val < root.val && q.val < root.val) {
            return helper(root.left, p, q);
        }
        return helper(root.right, p, q);
    }

    private static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == p || root == q) {
            return root;
        }
        return helper(root, p, q);
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASE
        TreeNode root = TreeUtil.getDummyBinaryTree1();
        System.out.println(lowestCommonAncestor(root, root, root.right).val);
    }

}
