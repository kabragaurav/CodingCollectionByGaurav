/**
 * The car manufacturer Honda holds their distribution system in the form of a tree
 * (not necessarily binary). The root is the company itself, and every node in the tree
 * represents a car distributor that receives cars from the parent node and ships them
 * to its children nodes. The leaf nodes are car dealerships that sell cars direct to consumers.
 * In addition, every node holds an integer that is the cost of shipping a car to it.
 *
 * A path from Honda’s factory to a car dealership, which is a path from the root to a leaf
 * in the tree, is called a Sales Path.
 * The cost of a Sales Path is the sum of the costs for every node in the path.
 *
 * Honda wishes to find the minimal Sales Path cost in its distribution tree.
 * Given a node rootNode, write a function getCheapestCost that calculates the minimal
 * Sales Path cost in the tree.
 *
 * Implement your function in the most efficient manner and analyze its time and space complexities.
 */
package Trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import Trees.TreeUtils.Node;

/**
 * @author gkabra
 * @since 20-01-2022 Thu
 **/

public class SalesPath {

    private static int minCost(Node root, int money) {
        if(root == null) {
            return money;
        }
        money += root.cost;
        if(root.children != null) {
            int min = Integer.MAX_VALUE;
            for (Node child : root.children) {
                min = Math.min(min, minCost(child, 0));
            }
            money += min;
        }
        return money;
    }

    // wrapper
    private static int getCheapestCost(Node rootNode) {
        return minCost(rootNode, 0);
    }

    // with min cost, if we want all paths with that cost
    private static List<String> findAllPathWithSum(Node root, int money, int curr, List<String> ls, String path) {
        if(root == null) {
            return ls;
        }
        if(root.children == null && curr+root.cost == money) {
            path += root.cost;
            ls.add(path);
        }
        path += root.cost;
        if(root.children != null) {
            for (Node child : root.children) {
                findAllPathWithSum(child, money, curr + root.cost, ls, path+" ");
            }
        }
        return ls;
    }


    // METHOD 2

    private static class QNode {
        int sum;
        Node node;

        QNode(Node node, int sum) {
            this.node = node;
            this.sum = sum;
        }
    }

    // TC : O(N)
    // SC : O(N)
    private static int getCheapestCostEfficient(Node root) {
        Queue<QNode> q = new ArrayDeque<>();
        QNode qn = new QNode(root, 0);
        q.offer(qn);
        int ans = Integer.MAX_VALUE;

        while(!q.isEmpty()) {
            QNode pop = q.poll();
            Node node = pop.node;
            int sum = pop.sum + node.cost;
            if(node.children == null) {    // leaf
                ans = Math.min(ans, sum);
            } else {
                for(Node child : node.children) {
                    q.offer(new QNode(child, sum));
                }
            }
        }
        return ans;
    }

    // driver - main method
    public static void main(String[] args) {
        // TESTCASE
        Node root = Node.getANonBinaryTree();
        int money = getCheapestCost(root);
        System.out.println(money);
        List<String> ls = findAllPathWithSum(root, money, 0, new ArrayList<String>(), "");
        for(String s : ls) {
            System.out.println(s);
        }

        money = getCheapestCostEfficient(root);
        System.out.println(money);
        ls = findAllPathWithSum(root, money, 0, new ArrayList<String>(), "");
        for(String s : ls) {
            System.out.println(s);
        }
    }
}


/**
 * Solution by peer from Pramp
 *
 * def get_cheapest_cost(rootNode):
 *
 *   # running min over the leaves
 *   res = float("inf")
 *   s = [[rootNode, 0]]
 *
 *   while s:
 *
 *     node, sm = s.pop()
 *
 *     sm += node.cost
 *
 *     if node.children:
 *       for child in node.children:
 *         s.append([child, sm])
 *     # leaf
 *     else:
 *       res = min(res, sm)
 *
 *   return res
 *
 * ##########################################
 * # Use the helper code below to implement #
 * # and test your function above           #
 * ##########################################
 *
 * # stack
 * # [node, running sum before visiting node]
 *
 * # [root, 0]
 * # [5, 0], [3, 0], [6, 0]
 * #
 *
 * # A node
 * class Node:
 *
 *   # Constructor to create a new node
 *   def __init__(self, cost):
 *     self.cost = cost
 *     self.children = []
 *     self.parent = None
 *
 * l1 = [Node(0)]
 * l2 = [Node(5), Node(3), Node(6)]
 * l3 = [Node(4), Node(2), Node(0), Node(1), Node(5)]
 * l4 = [Node(1), Node(10)]
 * l5 = [Node(1)]
 *
 * # 0 -> 5 3 6
 * l1[0].children = l2
 * # 5 -> 4
 * l2[0].children = l3[:1]
 * # 3 -> 2 0
 * l2[1].children = l3[1:3]
 * # 6 -> 1 5
 * l2[2].children = l3[3:5]
 * # 2 -> 1
 * l3[1].children = l4[:1]
 * # 0 -> 10
 * l3[2].children = l4[1:2]
 * # 1 -> 1
 * l4[0].children = l5
 *
 *
 * print(get_cheapest_cost(l1[0]))
 */