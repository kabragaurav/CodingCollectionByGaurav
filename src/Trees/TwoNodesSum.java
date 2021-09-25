/**
 * Given the root of a Binary Search Tree and a target number k, return true
 * if there exist two elements in the BST such that their sum is equal to the given target.
 */
package Trees;

import Trees.TreeUtils.TreeNode;

import java.util.HashSet;
import java.util.Set;
import Trees.TreeUtils.TreeUtil;

/**
 * @author gaurav kabra
 * @since 25 Sept 2021
 **/

public class TwoNodesSum {
    private Set<Integer> st;

    /**
     * Logic:
     * We traverse the tree and check if (k-value of current node) is there in set.
     * If so, then pair is (current node value, k-current node value) that add up to k. So, return true.
     * If not, we add value of current node to set and continue traversal.
     * If at end, we could not find any such pair, we return false.
     *
     * Time Complexity: O(N) since we visit each node in worst case.
     * Space Complexity: O(N-1) ~ O(N) since in worst case we visit each node and store it in set, except last node.
     */
    private boolean preorder(TreeNode<Integer> root, int k) {
        if(null == root) {
            return false;
        }
        if(st.contains(k-root.val)) {
            return true;
        }
        st.add(root.val);
        return preorder(root.left, k) || preorder(root.right, k);
    }

    private boolean findTarget(TreeNode<Integer> root, int k) {
        st = new HashSet<>();
        return preorder(root, k);
    }

    // driver - main method
    public static void main(String[] args) {
        TreeNode<Integer> root = TreeUtil.getDummyBinarySearchTree();
        TwoNodesSum tns= new TwoNodesSum();
        // TESTCASES
        System.out.println(tns.findTarget(root, 7));
        System.out.println(tns.findTarget(root, 12));
    }
}
