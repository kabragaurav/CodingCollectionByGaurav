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
    public boolean isVisited;

    public Node() {
        this.children = null;
        this.parent = null;
        this.isVisited = false;
    }

    public Node(int cost) {
        this();
        this.cost = cost;
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

    /**
                   0
                /   |  \
            3--4    2 -- 1
              / \   /
             6    5

            7
     */
    public static Node[] getGraph1() {
        Node zero = new Node();
        Node one = new Node();
        Node two = new Node();
        Node three = new Node();
        Node four = new Node();
        Node five = new Node();
        Node six = new Node();
        Node seven = new Node();

        zero.children = new Node[] {
                four, two, one
        };
        one.children = new Node[] {
                zero, two
        };
        two.children = new Node[] {
                zero, one, five
        };
        three.children = new Node[] {
                four
        };
        four.children = new Node[] {
                zero, three, five, six
        };
        five.children = new Node[] {
                four, two
        };
        six.children = new Node[] {
                four
        };

        return new Node[] {
                zero, one, two, three, four, five, six, seven
        };
    }

}
