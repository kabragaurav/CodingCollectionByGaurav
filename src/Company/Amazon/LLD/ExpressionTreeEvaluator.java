/*
Given the postfix tokens of an arithmetic expression, build and return the binary expression tree that represents
this expression.

Could you design the expression tree such that it is more modular?
For example, is your design able to support additional operators without making changes to your existing evaluate
implementation?
 */
package Company.Amazon.LLD;

import java.util.Stack;

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
