package Trees.TreeUtils;

/**
 * General Node to be used in Graph
 *
 * @author gkabra
 * @since 20-01-2022 Thu
 **/

public class Node {
    // keeping public for now
    public int cost;           // value in node
    public Node[] children;
    public Node parent;

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public Node[] getChildren() {
        return children;
    }

    public void setChildren(Node[] children) {
        this.children = children;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public Node(int cost) {
        this.cost = cost;
        children = null;
        parent = null;
    }

    /*
        Note that parent info in each node is null when we return root.
        In most problems, we need to go reverse from child -> parent and thus so.
                     0
                  / |  \
                5   3   6
              /   /  \  / \
            4   2    0  1   5
              /     /
            1      10
            /
            1

     */
    public static Node getANonBinaryTree() {
        Node root = new Node(0);
        Node five = new Node(5);
        Node three = new Node(3);
        Node six = new Node(6);
        Node four = new Node(4);
        Node two = new Node(2);
        Node zero = new Node(0);
        Node one = new Node(1);
        Node _five = new Node(5);
        Node _one = new Node(1);
        Node ten = new Node(10);
        Node __one = new Node(1);

        root.children = new Node[] {five, three, six};
        five.children = new Node[] {four};
        three.children = new Node[] {two, zero};
        six.children = new Node[] {one, _five};
        two.children = new Node[] {_one};
        zero.children = new Node[] {ten};
        _one.children = new Node[] {__one};

        return root;
    }

}
