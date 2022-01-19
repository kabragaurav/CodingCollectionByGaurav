/**
 * You are given two binary trees root1 and root2.
 * Imagine that when you put one of them to cover the other,
 * some nodes of the two trees are overlapped while the others are not.
 * You need to merge the two trees. The merge rule is that if two nodes overlap,
 * then sum node values up as the new value of the merged node.
 */
package Trees;

import Trees.TreeUtils.TreeNode;
import Trees.TreeUtils.TreeUtil;

/**
 * @author gkabra
 * @since 19-01-2022 Wed
 **/

public class MergeTrees {

    // TC : O(N) where N = min(edges in T1, edges in T2)
    // SC : O(N) for internal stack
    private static TreeNode<Integer> merge(TreeNode<Integer> root1, TreeNode<Integer> root2) {
        if(root1 != null && root2 != null) {
            root1.val += root2.val;
        } else {
            return root1 == null ? root2 : root1;
        }
        root1.left = merge(root1.left, root2.left);
        root1.right = merge(root1.right, root2.right);
        return root1;
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASE
        TreeUtil.getTreePrintedInorder(merge(TreeUtil.getDummyBinaryTree1(), TreeUtil.getDummyBinaryTree2()));
    }

}
