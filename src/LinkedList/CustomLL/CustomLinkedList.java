package LinkedList.LinkedList;

import java.util.LinkedList;
import java.util.List;

/**
 * An implementation of LinkedList
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
        
        Node(T value, Node next) {
            this.value = value;
            this.next = next;
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

    // print linked list
    public void displayLinkedList(Node head) {
        if(null == head) {
            System.out.println(EMPTY_LIST_MSG);
            return;
        }
        Node t = head;
        while(null != t.next) {
            System.out.print(t.value + "->");
            t = t.next;
        }
        System.out.println(t.value);
    }
    
}
