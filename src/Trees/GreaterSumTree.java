/**
 * Given the root of a Binary Search Tree (BST), convert it to a Greater Tree 
 * such that every key of the original BST 
 * is changed to the original key plus the sum of all keys greater than the original key in BST.
 */
package Trees;

import Trees.TreeUtils.TreeNode;
import Trees.TreeUtils.TreeUtil;
import java.util.HashMap;
import java.util.Map;

/**
 * @author gaurav kabra
 * @since 21 Oct 2021
 **/

public class GreaterSumTree {
    private static Map<TreeNode<Integer>, Integer> mp;
    private static int sumSoFar;

    /**
     * Logic:
     * For each node, we need to get sum of nodes larger than it.
     * In a BST, larger nodes are always in right subtree.
     * So we first recurse on right subtree and at last on left subtree.
     * In between for each node, we keep adding its value to sumSoFar.
     */
    private static void getGreaterTree(TreeNode<Integer> root) {
        if(root == null) {
            return;
        }
        if(root.left == null && root.right == null) {
            root.val = sumSoFar = root.val + sumSoFar;
            return;
        }

        getGreaterTree(root.right);
        root.val = sumSoFar = root.val + sumSoFar;
        getGreaterTree(root.left);
    }

    private static TreeNode<Integer> bstToGst(TreeNode<Integer> root) {
        mp = new HashMap<>();
        sumSoFar = 0;
        getGreaterTree(root);
        return root;
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASE
        TreeNode<Integer> root = TreeUtil.getDummyBinarySearchTree();
        bstToGst(root);
        TreeUtil.getTreePrintedInorder(root);
    }
}
