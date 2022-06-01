/*
Given the postfix tokens of an arithmetic expression, build and return the binary expression tree that represents
this expression.

Could you design the expression tree such that it is more modular?
For example, is your design able to support additional operators without making changes to your existing evaluate
implementation?
 */
package Company.Amazon.LLD;

import java.util.Stack;

/*
    OOD principles -

    S - Single-responsibility Principle.
    O - Open-closed Principle.
    L - Liskov Substitution Principle.
    I - Interface Segregation Principle.
    D - Dependency Inversion Principle.

    S and O are followed by Node and ExpressionTreeEvaluator
    L -  parent class should be replaceable by its child class.
    I - A client should never be forced to implement an interface that it doesn't use.
         larger interfaces should be split into smaller ones. By doing so,
         we can ensure that implementing classes only need to be concerned about the methods that are of interest to them.
    D - Entities must depend on abstractions  (interfaces/abstract classes), not on concretions (implementations) (decoupling)

    E.g.

    public class Windows98Machine {

        private final StandardKeyboard keyboard;
        private final Monitor monitor;

        public Windows98Machine() {
            monitor = new Monitor();
            keyboard = new StandardKeyboard();
    }

    By declaring the StandardKeyboard and Monitor with the new keyword, we've tightly coupled these three classes together.

    So let us Decouple/Dependency inversion:

    public interface Keyboard { }
    public class StandardKeyboard implements Keyboard { }
    public class Windows98Machine{

        private final Keyboard keyboard;
        private final Monitor monitor;

        public Windows98Machine(Keyboard keyboard, Monitor monitor) {
            this.keyboard = keyboard;
            this.monitor = monitor;
    }
}

}

 */

public class ExpressionTreeEvaluator {

    private static Stack<Node> stk;

    public static Node makeTree(String[] postfix) {
        for (String val : postfix) {
            switch (val) {
                case "+":
                case "-":
                case "*":
                case "/":
                    Node right = stk.pop();
                    Node left = stk.pop();
                    stk.push(new Node(val, left, right));
                    break;
                default:
                    stk.push(new Node(val, null, null));
            }
        }
        return stk.pop();
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASE(S)
        stk = new Stack<>();
        Node root = makeTree(new String[] {"3","4","+","2","*","7","/"});
        System.out.println(root.evaluate());

        stk = new Stack<>();
        root = makeTree(new String[] {"4","5","7","2","+","-","*"});
        System.out.println(root.evaluate());

        stk = new Stack<>();
        root = makeTree(new String[] {"4","2","+","3","5","1","-","*","+"});
        System.out.println(root.evaluate());

        stk = new Stack<>();
        root = makeTree(new String[] {"100","200","+","2","/","5","*","7","+"});
        System.out.println(root.evaluate());
    }

}


class Node {
    String val;
    Node left;
    Node right;

    Node (String val, Node left, Node right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public int evaluate() {
        if (left == null && right == null)
            return Integer.valueOf(val);

        int left = this.left.evaluate();
        int right = this.right.evaluate();

        switch (val) {
            case "+":
                return left + right;
            case "-":
                return left - right;
            case "*":
                return left * right;
            case "/":
                return left / right;
            default:
                return -1;
        }
    }

}
