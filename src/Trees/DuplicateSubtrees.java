/**
 * Two trees are duplicate if they have the same structure with the same node values.
 * Given the root of a binary tree, return all duplicate subtrees.
 * For each kind of duplicate subtrees,return the root node of any one of them.
 */
package Trees;

import Trees.TreeUtils.TreeNode;
import Trees.TreeUtils.TreeUtil;

import java.util.*;

/**
 * @author gaurav kabra
 * @since 9 Nov 2021
 **/

public class DuplicateSubtrees {
    private static String traversal(Map<String, Integer> mp, Set<TreeNode> st, TreeNode root) {
        if(null == root) {
            return null;
        }
        String l = traversal(mp, st, root.left);
        String r = traversal(mp, st, root.right);
        /**
         * CRUX : to know if two subtrees has same structure, use inorder traversal string (root -> left -> right)
         *
         * order of adding and empty strings matter
         * E.g. if we do
         * l + " " + root.val + " " +  r;
         * Then we have same result for
         *          0              0
         *         /     and        \
         *        0                  0
         *     i.e. null 0 null 0 null
         *
         *     Also spaces are important since
         *     a traversal string, say 111 can be 1 11 or 11 1.
         */
        String whole = root.val + " " + l + " " +  r;
        mp.put(whole, mp.getOrDefault(whole, 0) + 1);
        // only add when duplicate
        // E.g. if it is 3 then don't include root again
        if(mp.get(whole) == 2) {
            st.add(root);
        }
        return whole;
    }

    private static List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        // map to maintain {string : its frequency}
        Map<String, Integer> mp = new HashMap<>();
        // set to store root of one of duplicate subtrees
        Set<TreeNode> st = new HashSet<>();
        traversal(mp, st, root);
        return new ArrayList<>(st);
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASE
        System.out.println(findDuplicateSubtrees(TreeUtil.getDummyBinaryTree3()).size());
    }
}
