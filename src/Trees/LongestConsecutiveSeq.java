/**
 * Google, Facebook
 * Given a binary tree, find the length of the longest consecutive sequence path.
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
    private static void traverse(TreeNode<Integer> root, int lenSoFar, int target, int[] maxLen) {
        if(null == root) {
            return;
        } else if(target == root.val) {
            lenSoFar++;
        } else {
            lenSoFar = 1;
        }
        maxLen[0] = Math.max(maxLen[0], lenSoFar);
        traverse(root.left, lenSoFar, root.val+1, maxLen);
        traverse(root.right, lenSoFar, root.val+1, maxLen);
    }

    private static int longestConsecutiveSeqLen(TreeNode<Integer> root) {
        int[] maxLen = new int[1];                   // pass by ref so that it can be changed in recursive calls and reflected here
        traverse(root, 0, 0, maxLen);   // initially target can be any value, here taking 0
        return maxLen[0];
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
