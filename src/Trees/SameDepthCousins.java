/**
 * Given the root of a binary tree with unique values
 * and the values of two different nodes of the tree x and y, return true if the nodes
 * corresponding to the values x and y in the tree are cousins, or false otherwise.
 * Two nodes of a binary tree are cousins if they have the same depth with different parents.
 * Note that in a binary tree, the root node is at the depth 0, and children of each depth k
 * node are at the depth k + 1.
 */
package Trees;

import Trees.TreeUtils.TreeNode;
import Trees.TreeUtils.TreeUtil;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Queue;

/**
 * @author gkabra
 * @since 17-02-2022 Thu
 **/

public class SameDepthCousins {

    private static HashMap<Integer, Integer> mp = new HashMap<>();

    public static boolean isCousins(TreeNode<Integer> root, int x, int y) {
        mp.clear();
        int depth1 = 0, depth2 = 0;
        Queue<TreeNode<Integer>> queue = new ArrayDeque<>();
        queue.offer(root);
        int depth = -1;
        while(!queue.isEmpty()) {
            depth++;
            int sz = queue.size();
            for(int i=0; i<sz; i++) {
                TreeNode<Integer> pop = queue.poll();
                if(pop.val == x) {
                    depth1 = depth;
                } else if(pop.val == y) {
                    depth2 = depth;
                }
                if(pop.left != null) {
                    putIfXOrY(pop, pop.left, x, y);
                    queue.offer(pop.left);
                }
                if(pop.right != null) {
                    putIfXOrY(pop, pop.right, x, y);
                    queue.offer(pop.right);
                }
            }

        }
        return depth1 == depth2 && mp.get(x) != mp.get(y);
    }

    private static void putIfXOrY(TreeNode<Integer> root, TreeNode<Integer> child, int x, int y) {
        if(child.val == x) {
            mp.put(x, root.val);
        } else if(child.val == y) {
            mp.put(y, root.val);
        }
    }

    public static void main(String[] args) {
        TreeNode<Integer> root = TreeUtil.getDummyBinarySearchTree();
        System.out.println(isCousins(root, 4, 9));
        System.out.println(isCousins(root, 6, 6));
        System.out.println(isCousins(root, 3, 7));
    }

}
