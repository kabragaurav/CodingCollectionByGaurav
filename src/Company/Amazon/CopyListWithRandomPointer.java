package Company.Amazon;

import java.util.HashMap;
import LinkedList.CustomLL.CustomLinkedList;
import LinkedList.CustomLL.CustomLinkedList.Node;

/**
 * @author gkabra
 * @since 26-01-2022 Wed
 **/

public class CopyListWithRandomPointer {

    private static Node getClone(Node node) {
        return new Node(node.value);
    }

    /**
     * Logic:
     * Two passes over original LL.
     * In first pass, clone each node and store in map <old, new>
     * In second pass, set next and random ptr refs using this map.
     *
     * TC : O(N) due to two linear passes
     * SC : O(N) due to map
     */
    private static Node copyRandomList(Node head) {
        HashMap<Node, Node> oldToNewMap = new HashMap<>();

        Node ptr = head;
        Node retHead = null;
        while(ptr != null) {
            Node clone = getClone(ptr);
            oldToNewMap.put(ptr, clone);
            ptr = ptr.next;
            if(retHead == null) {
                retHead = clone;
            }
        }

        ptr = head;
        while(ptr != null) {
            Node nxt = ptr.next;
            Node rand = ptr.random;
            Node clone = oldToNewMap.get(ptr);
            clone.next = oldToNewMap.get(nxt);
            clone.random = oldToNewMap.get(rand);
            ptr = ptr.next;
        }
        return retHead;

    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASE

        /**
         *          1 -> 2 -> 3
         *          |   |____|
         *           _________
         */
        CustomLinkedList customLinkedList = new CustomLinkedList();
        Node head = customLinkedList.createLinkedList(1,2,3);

        head.random = head.next.next;
        head.next.random = head.next.next;
        head.next.next.random = head.next;
        customLinkedList.displayLinkedList(copyRandomList(head));
    }

}
