/**
 * Design a class to implement a stack using only a single queue. 
 * Your class, StackUsingSingleQueue, should support the following stack methods: 
 * push() (adding an item), pop() (removing an item), peek() 
 * (returning the top value without removing it), and empty() 
 * (whether or not the stack is empty).
 */
package StacksAndQueues;
/**
 * @author gaurav kabra
 * @since June 6, 2021
 */
import java.util.ArrayDeque;
import java.util.Deque;

public class StackUsingSingleQueue<T> {
	/**
	 * Time Complexity : O(N) since for each of the operations: push, pop or peek, it is O(1) and for N elements, it will be O(N)
	 * Space Complexity: O(N) since in worst case, all N elements are in queue.
	 */
	private Deque<T> queue;
	
	public StackUsingSingleQueue() {
		// We will use this object as stack
		// queue is FIFO whereas stack is LIFO structure
		this.queue = new ArrayDeque<T>();
	}
	
	private void push(T element) {
		// pushing adds element to last
		queue.addLast((T)element);
	}
	
	private T pop() {
		// remove and return last element
		return (T) queue.removeLast();
	}
	
	private T peek() {
		// if queue is not empty, return value of last element. Else null
		if(!queue.isEmpty())
			return (T) queue.getLast();
		return null;
	}
	
	// driver - main method
	public static void main(String[] args) {
		StackUsingSingleQueue<Integer> susq = new StackUsingSingleQueue<>();
		
		// TESTCASES
		susq.push(1);
		susq.push(2);
		System.out.println(susq.peek());
		susq.pop();
		System.out.println(susq.peek());
		susq.pop();
		System.out.println(susq.peek());
	}

}
