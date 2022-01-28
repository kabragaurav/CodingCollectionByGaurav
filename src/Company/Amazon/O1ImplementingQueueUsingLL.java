/**
 * Implement a Queue using Linked List.
 * Push TC: O(1)
 * Pop TC: O(1)
 */
package Company.Amazon;

/**
 * @author gkabra
 * @since 28-01-2022 Fri
 **/

public class O1ImplementingQueueUsingLL {

    private static class QueueNode {
        int data;
        QueueNode next;
        QueueNode(int a) {
            data = a;
            next = null;
        }
    }

    private static QueueNode front, rear;

    /**
     * Logic:
     * ADD TO REAR
     *
     * front -> ......-> rear
     * This operation adds a new node after rear and moves rear to the next node.
     *
     * TC : O(1)
     */
    private static void push(int a) {
        QueueNode node = new QueueNode(a);
        if(front == null) {
            front = rear = node;
        } else {
            rear.next = node;
            rear = node;
        }
    }

    /**
     * Logic:
     * REMOVE FROM FRONT
     *
     * front -> ......-> rear
     * This operation removes the front node and moves front to the next node.
     *
     * TC : O(1)
     */
    private static int pop() {
        if(front != null) {
            int val = front.data;
            front = front.next;
            return val;
        }
        return -1;
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASE
        push(2);
        push(3);
        System.out.println(pop());
        push(4);
        System.out.println(pop());
        System.out.println(pop());
        System.out.println(pop());
    }

}
