/**
 * Facebook
 * Given a reference to the root of a binary tree,
 * return a list containing the average value in each level of the tree.
 */
package BreadthFirstSearch;

import BreadthFirstSearch.Utils.LevelOrderTraversalUtil;
import Trees.TreeUtils.TreeNode;
import Trees.TreeUtils.TreeUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author gaurav kabra
 * @since 19 August 2021
 **/

public class AverageAtEachLevel {
    private static List<Double> getAverageAtEachLevel(TreeNode<Integer> root) {
        List<List<Long>> lists = LevelOrderTraversalUtil.levelOrderTraversalWithValues(root);

        List<Double> ans = new ArrayList<>();

        for(List<Long> ls : lists) {
            Optional<Long> sum = ls.stream().reduce((x, y) -> x+y);
            ans.add(sum.get() * 1d/ls.size());
        }
        return ans;
    }
    
    // driver - main method
    public static void main(String[] args) {

        // TESTCASES
        System.out.println(getAverageAtEachLevel(TreeUtil.getDummyBinarySearchTree()));

        // very large numbers
        TreeNode<Integer> root = TreeUtil.getTreeNode(2147483647);
        TreeNode<Integer> left = TreeUtil.getTreeNode(2147483647);
        TreeNode<Integer> right = TreeUtil.getTreeNode(2147483647);
        root.left = left;
        root.right = right;
        System.out.println(getAverageAtEachLevel(root));
    }
}
