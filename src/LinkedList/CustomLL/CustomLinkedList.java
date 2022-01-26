package LinkedList.CustomLL;

/**
 * An custom implementation for Linked List (LL)
 * 
 * @author gaurav kabra
 * @since 9 Nov 2021
 **/

public class CustomLinkedList<T> {
    
    // head of linked list
    private Node head;
    private String EMPTY_LIST_MSG = "The list is empty.";

    /**
     * Node of the LinkedList
     * Attributes : value and next pointer
     */
    public static class Node<T> {
        public T value;
        public Node next;
        public Node random;

        public Node(T value) {
            this.value = value;
            this.next = null;
            this.random = null;
        }
        
        public Node(T value, Node next) {
            this.value = value;
            this.next = next;
            this.random = null;
        }
        public Node(T value, Node next, Node random) {
            this.value = value;
            this.next = next;
            this.random = random;
        }
    }

    // create linked list and get its head node reference
    public Node<T> createLinkedList(T ...values) {
        head = null;
        Node prev = null;
        try {
            for (T value : values) {
                if (head == null) {
                    head = new Node(value, null);
                    prev = head;
                } else {
                    Node<T> t = new Node(value, null);
                    prev.next = t;
                    prev = t;
                }
            }
        } catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
        return head;
    }

    // print as well as return printed form of linked list
    public String displayLinkedList(Node head) {
        if(null == head) {
            System.out.println(EMPTY_LIST_MSG);
            return "";
        }
        Node t = head;
        String whole = "";
        while(null != t.next) {
            whole += t.value + "->";
            t = t.next;
        }
        whole += t.value;
        System.out.println(whole);
        return whole;
    }
    
}
