/**
 * Given head, the head of a linked list, determine if the linked list has a cycle in it.
 */
package Company.Amazon;

import LinkedList.CustomLL.CustomLinkedList;
import LinkedList.CustomLL.CustomLinkedList.*;
/**
 * @author gkabra
 * @since 27-01-2022 Thu
 **/

public class DetectCycle {

    // Floyd's cycle detection algo
    // TC : O(N)
    // SC : O(1)
    private static boolean hasCycle(Node head) {
        if(head == null) {
            return false;
        }
        Node slow = head;
        Node fast = head;

        do {
            if(fast == null || fast.next == null) { // first check fast != null
                return false;
            }
            fast = fast.next.next;
            slow = slow.next;
            if(slow == fast) {
                return true;
            }
        } while(slow != fast);
        return false;
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASE
        Node head = new CustomLinkedList().createLinkedList(1,2,3,4);
        System.out.println(hasCycle(head));
        head.next.next.next.next = head.next;
        System.out.println(hasCycle(head));
    }

}
