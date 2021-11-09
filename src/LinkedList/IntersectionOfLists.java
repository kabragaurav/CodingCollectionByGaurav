/**
 * Given the heads of two singly linked-lists headA and headB,
 * return the node at which the two lists intersect.
 * If the two linked lists have no intersection at all, return null.
 */
package LinkedList;

/**
 * @author gaurav kabra
 * @since 9  Nov 2021
 **/

import LinkedList.LinkedList.CustomLinkedList;

public class IntersectionOfLists {

    /**
     * Logic:
     * We first try to move headA or headB sp that length of rest linked lists are equal.
     * Then we move both headA and headB till they are equal (i.e. pointing to same node - that is our answer).
     * If they are never equal, we return null.
     *
     * TC : O(N) since we traverse lists once
     * SC : O(1)
     */
    private static CustomLinkedList.Node getIntersectionNode(CustomLinkedList.Node headA, CustomLinkedList.Node headB) {
        int l1 = 0, l2 = 0;
        CustomLinkedList.Node t = headA;
        while(t != null) {
            l1++;
            t = t.next;
        }
        t = headB;
        while(t != null) {
            l2++;
            t = t.next;
        }
        int lengthDiff = Math.abs(l1-l2);
        if(l1 > l2) {
            for(int i=0; i<lengthDiff; i++) {
                headA = headA.next;
            }
        } else {
            for(int i=0; i<lengthDiff; i++) {
                headB = headB.next;
            }
        }
        while(headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASES
        LinkedList.LinkedList.CustomLinkedList<Integer> obj = new CustomLinkedList<Integer>();
        CustomLinkedList.Node<Integer> headA = obj.createLinkedList(2,6,4);
        CustomLinkedList.Node<Integer> headB = obj.createLinkedList(5, 7);
        obj.displayLinkedList(getIntersectionNode(headA, headB));

        CustomLinkedList.Node<Integer> node1 = obj.createLinkedList(1);
        CustomLinkedList.Node<Integer> node2 = obj.createLinkedList(2);
        CustomLinkedList.Node<Integer> node3 = obj.createLinkedList(3);
        CustomLinkedList.Node<Integer> node4 = obj.createLinkedList(4);
        CustomLinkedList.Node<Integer> node5 = obj.createLinkedList(5);
        CustomLinkedList.Node<Integer> node6 = obj.createLinkedList(6);
        node1.next = node2;
        node2.next = node3;
        node3.next = node5;
        node4.next = node5;
        node5.next = node6;
        obj.displayLinkedList(getIntersectionNode(node1, node4));
    }
}
