/**
 * You have been given a binary tree with an integer value associated to each node.
 * You are supposed to choose a subset of these nodes such that the sum of these chosen nodes
 * is maximum. Keep in mind that no two of the chosen nodes must be adjacent to each other.
 * Two nodes are said to be adjacent to each other if they are directly connected to each other.
 * This means that if a node is taken as part of the sum,
 * then none of its children can be considered for the same and vice versa.
 *
 * All values in the tree nodes are positive.
 */
package Trees;

import Trees.TreeUtils.TreeNode;
import Trees.TreeUtils.TreeUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * @author gaurav kabra
 * @since 20 Oct 2021
 **/
public class MaxSumNonAdjacentNodes {

    private static Map<TreeNode<Integer>, Integer> mp;

    /**
     * Logic:
     * If root is null, return 0.
     * If root is leaf, then just return its value.
     * Else if a value is already present in map corresponding to root as key, return it.
     *
     * Now we can choose in two ways:
     *      1. Choose root and then its grandchildren (with)
     *      2. Choose children of root (without)
     * Return max of these two.
     */
    private static int getMaxSum(TreeNode<Integer> root) {
        if(null == root) {
            return 0;
        }
        if(root.left == null && root.right == null) {
            return root.val;
        }
        if(mp.containsKey(root)) {
            return mp.get(root);
        }
        int l = 0, r = 0;
        int with = root.val;
        if(null != root.left) {
            l += getMaxSum(root.left.left) + getMaxSum(root.left.right);
        }
        if(null != root.right) {
            r += getMaxSum(root.right.left) + getMaxSum(root.right.right);
        }

        with = with + l + r;

        int without = 0 + getMaxSum(root.left) + getMaxSum(root.right);
        int ans =  Math.max(with, without);
        mp.put(root, ans);
        return ans;
    }

    public static int maximumSumOfNodes(TreeNode<Integer> root) {
        // reset static variable
        mp = new HashMap<>();
        return getMaxSum(root);
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASES
        TreeNode<Integer> root1 = TreeUtil.getDummyBinaryTree1();
        System.out.println(maximumSumOfNodes(root1));

        TreeNode<Integer> root2 = TreeUtil.getDummyBinaryTree2();
        System.out.println(maximumSumOfNodes(root2));

        TreeNode<Integer> root3 = TreeUtil.getDummyBinarySearchTree();
        System.out.println(maximumSumOfNodes(root3));   // Selected: 6, 7, 9, 3, 5
    }
}
