/**
 * Given a binary search tree, return all modes.
 * Mode is the most frequently occurring value.
 */
package Trees;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import Trees.TreeUtils.TreeNode;

/**
 * @author gaurav kabra
 * @since June 13, 2021
 */
public class ModeInTree {
    
	// stores the magnitude of mode (E.g. if mode is 4 that occurs 2 times, then it stores 2)
    int modeMagnitude;
    // tracks number of values that occur modeMagnitude times
    int count;
    
    private void inOrder(TreeNode<Integer> root, Map<Integer, Integer> mp) {
        if(root == null)
            return;
        inOrder(root.left, mp);
        mp.put(root.val, mp.getOrDefault(root.val, 0) + 1);
        if(mp.get(root.val) > modeMagnitude) {
            modeMagnitude = mp.get(root.val);
            count = 1;
        }
        else if(mp.get(root.val) == modeMagnitude) {
            count++;
        }
        inOrder(root.right, mp);
    }
	
	
	private int[] findMode(TreeNode<Integer> root) {
		/**
		 * Time Complexity: O(N), where N is the number of nodes in the BST (We have to visit each node).
         * Space Complexity: O(N) (maximum amount of space utilized by the recursion stack in traversal would be N since the height of a skewed BST could be N).
         */
		
		// initialize here, so that values reset for each call
		modeMagnitude= Integer.MIN_VALUE;
		count = 0;
		
		// map to store frequency of each node
        Map<Integer, Integer> mp = new HashMap<>();
        
        // traverse the tree
        inOrder(root, mp);
        
        // array that stores node values that occur maximum in tree
        int[] arr = new int[count];
        int i = 0;
        
        for(Map.Entry<Integer, Integer> entry : mp.entrySet()) {
            if(entry.getValue() == modeMagnitude) {
                arr[i++] = entry.getKey();
            }
        }
        
        return arr;
        
    }
	
	// helper method to main
 	private static TreeNode<Integer> getTreeNode(Integer val) {
 	    TreeNode<Integer> treeNode = new TreeNode<Integer>(val);
 		return treeNode;
 	}
 	
 	// driver - main method
	public static void main(String[] args) {
		
		// make Tree
	    TreeNode<Integer> root = getTreeNode(6);
		TreeNode<Integer> two = getTreeNode(2);
		TreeNode<Integer> eight = getTreeNode(8);
		TreeNode<Integer> zero = getTreeNode(0);
		TreeNode<Integer> four_1 = getTreeNode(4);
		TreeNode<Integer> seven = getTreeNode(7);
		TreeNode<Integer> nine = getTreeNode(9);
		TreeNode<Integer> four_2 = getTreeNode(4);
		TreeNode<Integer> five = getTreeNode(5);
		TreeNode<Integer> three = getTreeNode(3);
				
		root.left = two;	
		root.right = eight;
		two.left = zero;
		two.right = four_1;
		eight.left = seven;
		eight.right = nine;
		four_1.left = four_2;
		four_1.right = five;	
		
		
		ModeInTree mit = new ModeInTree();
		
		// TESTCASES
		int[] arr = mit.findMode(root);
		System.out.println(Arrays.toString(arr));
		
		four_1.left = three;
		arr = mit.findMode(root);
		System.out.println(Arrays.toString(arr));
		
		arr = mit.findMode(null);
		System.out.println(Arrays.toString(arr));
	}

}
