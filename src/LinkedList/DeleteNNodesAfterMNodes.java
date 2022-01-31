package LinkedList;

import LinkedList.CustomLL.CustomLinkedList;
import LinkedList.CustomLL.CustomLinkedList.Node;

/**
 * @author gkabra
 * @since 31-01-2022 Mon
 **/

public class DeleteNNodesAfterMNodes {

    private static void linkdelete(Node head, int M, int N) {
        Node t = head;
        while(t != null) {
            for(int i=0; t!= null && i<M-1; i++) {
                t = t.next;
            }
            for(int i=0; t!= null && t.next != null && i<N; i++) {
                t.next = t.next.next;
            }
            try {
                t = t.next;
            } catch(NullPointerException ex) {
                // do nothing, it will terminate the while loop
            }
        }
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASES
        CustomLinkedList customLinkedList = new CustomLinkedList();
        Node node = customLinkedList.createLinkedList(1,2,3,4);
        linkdelete(node, 3, 1);
        customLinkedList.displayLinkedList(node);

        node = customLinkedList.createLinkedList(1,2,3,4);
        linkdelete(node, 4, 1);
        customLinkedList.displayLinkedList(node);
    }

}
