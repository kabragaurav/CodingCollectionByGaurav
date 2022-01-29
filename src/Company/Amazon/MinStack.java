/**
 * Implement O(1) stack using Stack<> in Java.
 * Push, pop, min(), top() should all be O(1).
 */
package Company.Amazon;

import java.util.Stack;

/**
 * @author gkabra
 * @since 29-01-2022 Sat
 **/

public class MinStack {

    private static Stack<Integer> stk;
    private static Stack<Integer> helper;

    public MinStack() {
        stk = new Stack<>();
        helper = new Stack<>();
    }

    /**
     * 1) push x to the first stack (the stack with actual elements)
     * 2) compare x with the top element of the second stack (the auxiliary stack). Let the top element be y.
     * …..a) If x is smaller than y then push x to the auxiliary stack.
     * …..b) If x is greater than y then push y to the auxiliary stack.
     */
    private static void push(int val) {
        stk.push(val);
        if(!helper.isEmpty()) {
            int top = helper.peek();
            if(val < top) {
                helper.push(val);
            } else {
                helper.push(top);
            }
        } else {
            helper.push(val);
        }
    }

    /**
     * 1) pop the top element from the auxiliary stack.
     * 2) pop the top element from the actual stack and return it.
     * Step 1 is necessary to make sure that the auxiliary stack is also updated for future operations.
     */
    private static void pop() {
        if(!stk.isEmpty() && !helper.isEmpty()) {
            stk.pop();
            helper.pop();
        }
    }

    private static int top() {
        return stk.peek();
    }

    private static int getMin() {
        if(!helper.isEmpty()) {
            return helper.peek();
        }
        return -1;
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASE
        stk = new Stack<>();
        helper = new Stack<>();
        push(2);
        push(4);
        System.out.println(getMin());
        pop();
        push(1);
        System.out.println(getMin());
    }

}
