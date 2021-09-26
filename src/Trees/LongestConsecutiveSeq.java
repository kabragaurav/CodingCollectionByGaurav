/**
 * Google, Facebook
 * Given a binary tree, find the length og the longest consecutive sequence path.
 * Path may start from any node and has to be from parent to child (not reverse).
 */
package Trees;

import Trees.TreeUtils.TreeNode;
import Trees.TreeUtils.TreeUtil;

/**
 * @author gaurav kabra
 * @since 26 Sept 2021
 **/
public class LongestConsecutiveSeq {

    /**
     * TC: O(N) due to entire traversal of tree
     * SC: O(N) if the tree is skewed then in recursive call stack
     */
    private static int traverse(TreeNode<Integer> root, int lenSoFar, Integer prevVal) {
        if(null == root) {
            return lenSoFar;
        }
        if(null == prevVal || root.val == prevVal + 1) {
            lenSoFar += 1;
            int l = traverse(root.left, lenSoFar, root.val);
            int r = traverse(root.right, lenSoFar, root.val);
            lenSoFar = Math.max(l, r);
        }
        int l = 0, r = 0;
        if(null != root.left) {
            l = traverse(root.left, 1, (Integer) root.val);
        }
        if(null != root.right) {
            r = traverse(root.right, 1, (Integer) root.val);
        }
        return Math.max(lenSoFar, Math.max(l, r));
    }

    private static int longestConsecutiveSeqLen(TreeNode<Integer> root) {
        return traverse(root, 0, null);    // since root has no parent, prevVal = null
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASE
        TreeNode<Integer> root = TreeUtil.getDummyBinaryTree1();
        System.out.println(longestConsecutiveSeqLen(root));
        root = TreeUtil.getDummyBinaryTree2();
        System.out.println(longestConsecutiveSeqLen(root));
    }
}
