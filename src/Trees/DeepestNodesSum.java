/**
 * Given the root of a binary tree, return the sum of values of its deepest leaves.
 */
package Trees;

import Trees.TreeUtils.TreeNode;
import Trees.TreeUtils.TreeUtil;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author gkabra
 * @since 15-03-2022 Tue
 **/

public class DeepestNodesSum {

    // TC : O(N) due to level order traversal
    // SC : O(N)
    private static int deepestLeavesSum(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        Queue<TreeNode> last = new ArrayDeque<>();
        if(root == null) {
            return 0;
        }
        queue.add(root);
        while(!queue.isEmpty()) {
            last = new ArrayDeque<>(queue);
            int size = queue.size();
            for(int i=0; i<size; i++) {
                TreeNode front = queue.poll();
                if(front.left != null) {
                    queue.add(front.left);
                }
                if(front.right != null) {
                    queue.add(front.right);
                }
            }
        }
        int sum = 0;
        for(TreeNode node : last) {
            sum += (Integer) node.val;
        }
        return sum;
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASE
        System.out.println(deepestLeavesSum(TreeUtil.getDummyBinarySearchTree()));
    }

}
