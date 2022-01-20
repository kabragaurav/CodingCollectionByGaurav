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

import java.util.ArrayList;
import java.util.List;
import Trees.TreeUtils.Node;

/**
 * @author gkabra
 * @since 20-01-2022 Thu
 **/

public class SalesPath {

    private static int minCost(Node root, int money, String path) {
        if(root == null) {
            return money;
        }
        money += root.cost;
        path += root.cost + " ";
        if(root.children != null) {
            int min = Integer.MAX_VALUE;
            for (Node child : root.children) {
                min = Math.min(min, minCost(child, 0, path));
            }
            money += min;
        }
        return money;
    }

    // wrapper
    private static int getCheapestCost(Node rootNode, String path) {
        return minCost(rootNode, 0, path);
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

    // driver - main method
    public static void main(String[] args) {
        // TESTCASE
        Node root = Node.getANonBinaryTree();
        int money = getCheapestCost(root, "");
        System.out.println(money);
        List<String> ls = findAllPathWithSum(root, money, 0, new ArrayList<String>(), "");
        for(String s : ls) {
            System.out.println(s);
        }
    }
}