package Company.Amazon;

import Trees.TreeUtils.TreeNode;
import Trees.TreeUtils.TreeUtil;

/**
 * @author gkabra
 * @since 29-01-2022 Sat
 **/

public class TreeMaxPathSum {

    private static int max;

    private static int helper(TreeNode<Integer> root) {
        if(root == null) {
            return 0;
        }
        int left = Math.max(helper(root.left), 0);
        int right = Math.max(helper(root.right), 0);

        max = Math.max(max, root.val + left + right);

        return root.val + Math.max(left, right);
    }

    private static int maxPathSum(TreeNode root) {
        max = Integer.MIN_VALUE;
        helper(root);
        return max;
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASE
        System.out.println(maxPathSum(TreeUtil.getDummyBinaryTree1()));
    }

}
