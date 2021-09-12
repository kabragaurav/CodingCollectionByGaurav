package Trees;

import Trees.TreeUtils.TreeNode;

import static Trees.TreeUtils.TreeUtil.getDummyBinarySearchTree;

/**
 * @author gaurav kabra
 * @since 12 Sept 2021
 **/

public class PathSum {

    private static int counter;

    private static void getCount(TreeNode<Integer> root, int targetSum, int sumSoFar) {
        if(root == null) {
            return;
        }
        sumSoFar += root.val;
        if(sumSoFar == targetSum) {
            counter++;
        }
        getCount(root.left, targetSum, sumSoFar) ;
        getCount(root.right, targetSum, sumSoFar);

    }

    private static void recurse(TreeNode<Integer> root, int targetSum) {
        if(root == null) {
            return;
        }
        getCount(root, targetSum, 0);
        recurse(root.left, targetSum);
        recurse(root.right, targetSum);
    }

    /**
     * We want below method for a skewed tree such as
     * 1
     *   \
     *     2
     *       \
     *         3
     *           \
     *             4
     *              \
     *               5
     * and targetSum = 3.
     * Then answer is [1->2, 3]
     * We should count 3 only once (either in subtree at 1, or at 2 or at 3 itself)
     */
    private static int pathSum(TreeNode<Integer> root, int targetSum) {
        recurse(root, targetSum);
        return counter;
    }

    // driver - main method
    public static void main(String[] args) {
        TreeNode<Integer> root = getDummyBinarySearchTree();
        // TESTCASE
        System.out.println(pathSum(root, 7));
    }
}
