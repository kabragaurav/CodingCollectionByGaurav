package LinkedList;

import LinkedList.CustomLL.CustomLinkedList;
import LinkedList.CustomLL.CustomLinkedList.Node;

/**
 * @author gaurav kabra
 * @since 18/Apr/2022
 **/

public class SortList {

    private static Node sortList(Node head) {

        if (head == null || head.next == null) {
            return head;
        }

        Node fast = head;
        Node slow = head;
        Node prev = slow;

        while (fast != null && fast.next != null) {
            prev = slow;
            fast = fast.next.next;
            slow = slow.next;
        }

        prev.next = null;

        Node l1 = sortList(head);
        Node l2 = sortList(slow);

        return merge(l1, l2);

    }

    private static Node merge(Node<Integer> l1, Node<Integer> l2) {
        Node h = new Node(0);
        Node t = h;
        while (l1 != null && l2 != null) {
            if (l1.value < l2.value) {
                t = t.next = l1;
                l1 = l1.next;
            } else {
                t = t.next = l2;
                l2 = l2.next;
            }
        }

        if (l1 != null) {
            t.next = l1;
        }

        if (l2 != null) {
            t.next = l2;
        }

        return h.next;
    }


    // driver - main method
    public static void main(String[] args) {
        // TESTCASE(S)
        CustomLinkedList head = new CustomLinkedList<Integer>();
        head.displayLinkedList(sortList(head.createLinkedList(4,2,1,3)));
    }

}
