/**
 * Amazon
 * Given a linked list L of N nodes, sorted in ascending order based on the absolute values of '
 * its value,i.e. negative values are considered as positive ones. Sort the linked list
 * according to the actual values, consider negative numbers as negative and positive number
 * as positive.
 */
package Interviews;

import LinkedList.CustomLL.CustomLinkedList;
import LinkedList.CustomLL.CustomLinkedList.Node;
/**
 * @author gkabra
 * @since 05-03-2022 Sat
 **/

public class AbsoluteValueLinkedList {

    // TC : O(N)
    // SC : O(1)
    private static Node sortList(Node<Integer> head) {
        if(head == null) {
            return null;
        }
        Node<Integer> prev = head;
        Node<Integer> curr = head.next;

        while(curr != null) {
            if(curr.value >= prev.value) {
                prev = curr;
                curr = curr.next;
            } else {
                prev.next = curr.next;
                curr.next = head;
                head = curr;
                curr = prev;
            }
        }
        return head;
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASE
        CustomLinkedList customLinkedList = new CustomLinkedList<Integer>();
        customLinkedList.displayLinkedList(sortList(customLinkedList.createLinkedList(1, -2, -3, 4, -5)));
    }

}
