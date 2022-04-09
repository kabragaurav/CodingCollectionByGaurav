package Company.Pramp;

import Trees.TreeUtils.TreeNode;
import Trees.TreeUtils.TreeUtil;

/**
 * @author gaurav kabra
 * @since 09/Apr/2022
 **/

public class LargestSmallerKey {


    private static void inorder(TreeNode<Integer> root, int[] largestKeySoFar, int num) {
        if (root == null) {
            return;
        }

        inorder(root.left, largestKeySoFar, num);

        if (root.val < num && root.val > largestKeySoFar[0]) {
            largestKeySoFar[0] = root.val;
        }

        if (root.val < num) {
            inorder(root.right, largestKeySoFar, num);
        }
    }


    // TC : O(N)
    // SC : O(N)
    private static int findLargestSmallerKey(TreeNode root, int num) {
        int[] largestKeySoFar = new int[] {-1};

        inorder(root, largestKeySoFar, num);

        return largestKeySoFar[0];
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASE(S)
        TreeNode root = TreeUtil.getDummyBinaryTree1();
        System.out.println(findLargestSmallerKey(root, 4));
        System.out.println(findLargestSmallerKey(root, 0));
        System.out.println(findLargestSmallerKey(root, 10));
        System.out.println(findLargestSmallerKey(root, 5));
    }

}
