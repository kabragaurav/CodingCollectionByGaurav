/**
 * Given the root of a binary tree, return the maximum width of the given tree.
 * The maximum width of a tree is the maximum width among all levels.
 * The width of one level is defined as the length between the end-nodes
 * (the leftmost and rightmost non-null nodes),
 * where the null nodes between the end-nodes are also counted into the length calculation.
 */
package Trees;

import Trees.TreeUtils.TreeNode;
import Trees.TreeUtils.TreeUtil;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;

/**
 * @author gaurav kabra
 * @since 29 Oct 2021
 **/

public class TreeWidth {
    /**
     * Logic:
     * Assosiate an index number with each node.
     * Suppose the index number of a root is say X , then index of its left child is 2X + 1 and index of right child is 2X + 2.
     * Perform BFS and for each level calculate the width = index of last element - index of first element + 1
     * Find the maximum of all widths.
     */
    public static int widthOfBinaryTree(TreeNode<Integer> root) {
        if(null == root) {
            return 0;
        }
        Map<TreeNode<Integer>, Integer> mp;
        ArrayDeque<Map<TreeNode<Integer>, Integer>> queue = new ArrayDeque<>();
        mp = new HashMap<>();
        mp.put(root, 0);
        queue.add(mp);
        int ans = 0;
        while(!queue.isEmpty()) {
            int sz = queue.size();
            Map<TreeNode<Integer>, Integer> first = queue.getFirst();
            Map<TreeNode<Integer>, Integer> last = queue.getLast();
            ans = Math.max(ans, (Integer) last.values().toArray()[0] - (Integer) first.values().toArray()[0] + 1);
            Map<TreeNode<Integer>, Integer> node;
            for (int i = 0; i < sz; i++) {
                node = queue.poll();
                TreeNode<Integer> n = (TreeNode<Integer>) node.keySet().toArray()[0];
                Integer value = (Integer) node.values().toArray()[0];
                if (n.left != null) {
                    mp = new HashMap<>();
                    mp.put(n.left, 2 * value + 1);
                    queue.add(mp);
                }
                if (n.right != null) {
                    mp = new HashMap<>();
                    mp.put(n.right, 2 * value + 2);
                    queue.add(mp);
                }
            }
        }
        return ans;
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASES
        System.out.println(widthOfBinaryTree(TreeUtil.getDummyBinarySearchTree()));
    }
}
