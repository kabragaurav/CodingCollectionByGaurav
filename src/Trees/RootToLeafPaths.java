/**
 * Given the root of a binary tree, return all root-to-leaf paths in any order.
 */
package Trees;

import Trees.TreeUtils.TreeNode;
import Trees.TreeUtils.TreeUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author gkabra
 * @since 04-03-2022 Fri
 **/

public class RootToLeafPaths {

    private static void traverse(TreeNode root, String s, List<String> ls) {
        if(root == null) {
            return;
        }
        s += root.val + "->";
        if(root.left == null && root.right == null) {
            ls.add(s.substring(0, s.length()-2));
            return;
        }
        traverse(root.left, s, ls);
        traverse(root.right, s, ls);
    }

    private static List<String> binaryTreePaths(TreeNode root) {
        List<String> ls = new ArrayList<>();
        traverse(root, "", ls);
        return ls;
    }

    public static void main(String[] args) {
        binaryTreePaths(TreeUtil.getDummyBinarySearchTree())
                .stream()
                .forEach(x -> System.out.println(x));
    }

}
