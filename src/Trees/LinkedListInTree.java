package Trees;

import LinkedList.CustomLL.CustomLinkedList;
import LinkedList.CustomLL.CustomLinkedList.Node;
import Trees.TreeUtils.TreeNode;
import Trees.TreeUtils.TreeUtil;

/**
 * @author gauravkabra
 * @since 23/Mar/2022
 **/

public class LinkedListInTree {

    // TC : O(N * min(H, L)). For each node (total nodes N), we need to search if LinkedList is there (length L) and go to max depth (H). In worst case, we don't fine list in tree.
    // SC :O(1) explicit, O(H) implicit
    private static boolean isSubPath(TreeNode root, Node<Integer> head) {
        if (head == null) {
            return true;
        }
        if (root == null) {
            return false;
        }
        return helper(root, head) ||
                isSubPath(root.left, head) ||
                isSubPath(root.right, head);
    }

    private static boolean helper(TreeNode root, Node<Integer> head) {
        if (head == null) {
            return true;
        }
        if (root == null) {
            return false;
        }

        return root.val == head.value && ( helper(root.left, head.next) ||
                                            helper(root.right, head.next));
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASES
        CustomLinkedList customLinkedList = new CustomLinkedList();
        TreeNode<Integer> root = TreeUtil.getDummyBinaryTree1();

        Node<Integer> head = customLinkedList.createLinkedList(1,4);
        System.out.println(isSubPath(root, head));

        head = customLinkedList.createLinkedList(3,4);
        System.out.println(isSubPath(root, head));
    }

}
