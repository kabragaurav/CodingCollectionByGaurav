/*
Given a binary tree root, a node X in the tree is named good if in the path from root to X there are
no nodes with a value greater than X.
Return the number of good nodes in the binary tree.
 */
package Trees;

import Trees.TreeUtils.TreeNode;
import Trees.TreeUtils.TreeUtil;

/**
 * @author gaurav kabra
 * @since 08/May/2022
 **/

public class CountGoodNodes {

    // TC : O(N), N = number of nodes in tree
    // SC : O(N) implicit stack in case of skewed tree

    private static int goodNodes(TreeNode<Integer> root) {
        int[] count = new int[1];
        helper(root, count, Integer.MIN_VALUE);
        return count[0];
    }

    private static void helper(TreeNode<Integer> root, int[] count, int maxSoFar) {
        if (root == null) {
            return;
        }

        if (root.val >= maxSoFar) {
            count[0] += 1;
            maxSoFar = root.val;
        }

        helper(root.left, count, maxSoFar);
        helper(root.right, count, maxSoFar);
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASE(S)
        TreeNode root = TreeUtil.getDummyBinaryTree1();
        System.out.println(goodNodes(root));
    }

}
