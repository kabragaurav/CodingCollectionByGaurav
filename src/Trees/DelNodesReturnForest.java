/**
 * Given the root of a binary tree, each node in the tree has a distinct value.
 * After deleting all nodes with a value in to_delete, we are left with a forest (a disjoint union of trees).
 * Return the roots of the trees in the remaining forest. You may return the result in any order.
 */
package Trees;

import Trees.TreeUtils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gaurav kabra
 * @since 18 Oct 2021
 **/

public class DelNodesReturnForest {

    // preorder traversal
    private static void traverse(TreeNode<Integer> node) {
        if(null == node) {
            return;
        }
        System.out.println(node.val + " ");
        traverse(node.left);
        traverse(node.right);
    }

    private static boolean deletionPossible(List<TreeNode<Integer>> roots, TreeNode<Integer> root, TreeNode<Integer> parent, boolean isLeft, boolean isRight, int to_del) {
        if(root == null) {
            return false;
        }
        // we need to delete and it is a leaf node
        if(root.val == to_del && root.left == null && root.right == null) {
            if(parent != null && isLeft == true) {          // if is in left then set left of parent to null
                parent.left = null;
            } else if(parent != null && isRight == true) {  // if is in right then set right of parent to null
                parent.right = null;
            } else if(parent == null) {                     // instead it has no parent, i.e., is root of a tree the simply remove it
                roots.remove(root);
            }
            return true;
        }
        // we need to delete and it is a non-leaf
        if(root.val == to_del) {
            if(parent != null && isLeft == true) {
                parent.left = null;
            } else if(parent != null && isRight == true) {
                parent.right = null;
            }
            if(root.left != null) {             // add left subtree to forest as new tree
                if(parent == null) {
                    roots.remove(root);
                }
                roots.add(root.left);
            }
            if(root.right != null) {            // add right subtree to forest as new tree
                if(parent == null) {
                    roots.remove(root);
                }
                roots.add(root.right);
            }
            return true;
        }

        return deletionPossible(roots, root.left, root, true, false, to_del) ||
                deletionPossible(roots, root.right, root, false, true, to_del);

    }

    // For each tree in forest we see if the node is there.
    // If so, we delete it
    private static void getDeleted(List<TreeNode<Integer>> roots, int to_del) {
        for(TreeNode<Integer> root : roots) {
            if(deletionPossible(roots, root, null, false, false, to_del)) {
                return;
            }
        }
    }

    /**
     * Logic:
     * We will store roots of each tree in forest in a list, roots.
     * We will return this as out answer.
     * But before that we pass it to a method that deletes the nodes.
     */
    private static List<TreeNode<Integer>> delNodes(TreeNode<Integer> root, int[] to_delete) {
        List<TreeNode<Integer>> roots = new ArrayList<>() {{
            add(root);
        }};
        for(int to_del : to_delete) {
            getDeleted(roots, to_del);
        }
        return roots;
    }
    
    public static void main(String[] args) {
        TreeNode<Integer> root = new TreeNode<>(1);
        TreeNode<Integer> two = new TreeNode<>(2);
        TreeNode<Integer> three = new TreeNode<>(3);
        TreeNode<Integer> four = new TreeNode<>(4);
        root.left = two;
        two.left = four;
        two.right = three;

        List<TreeNode<Integer>> ans = delNodes(root, new int[] {2,3});
        for(TreeNode<Integer> node : ans) {
            traverse(node);
            System.out.println();
        }
    }
}
