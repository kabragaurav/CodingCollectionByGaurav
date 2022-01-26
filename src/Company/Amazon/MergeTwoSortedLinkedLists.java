/**
 * Given two sorted linked lists,
 * merge them so that the resulting linked list is also sorted.
 */
package Company.Amazon;

import LinkedList.CustomLL.CustomLinkedList;
import LinkedList.CustomLL.CustomLinkedList.Node;

/**
 * @author gkabra
 * @since 26-01-2022 Wed
 **/

public class MergeTwoSortedLinkedLists {

    private Node head;
    private Node lastRef;

    private void insert(Integer value) {
        if(lastRef == null) {
            this.lastRef = new Node(value);
            this.head = this.lastRef;
        } else {
            this.lastRef.next = new Node(value);
            this.lastRef = lastRef.next;
        }
    }

    // TC : O(M+N)
    // SC : O(M+N) as new LL is formed
    private Node mergeTwoLists(Node list1, Node list2) {
        Node ref1 = list1;
        Node ref2 = list2;
        Integer value = 0;

        while(ref1 != null && ref2 != null) {
            if((int)ref1.value <= (int) ref2.value) {
                value = (int) ref1.value;
                ref1 = ref1.next;
            } else {
                value = (int) ref2.value;
                ref2 = ref2.next;
            }
            insert(value);
        }

        while(ref1 != null) {
            value = (int) ref1.value;
            ref1 = ref1.next;
            insert(value);
        }
        while(ref2 != null) {
            value = (int) ref2.value;
            ref2 = ref2.next;
            insert(value);
        }
        return head;
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASE
        CustomLinkedList<Integer> customLinkedList = new CustomLinkedList();
        Node<Integer> head1 = customLinkedList.createLinkedList(1,2,4);
        Node<Integer> head2 = customLinkedList.createLinkedList(1,3,4);
        head1 = new MergeTwoSortedLinkedLists().mergeTwoLists(head1, head2);
        customLinkedList.displayLinkedList(head1);
    }

}
