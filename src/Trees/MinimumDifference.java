/**
 * Given a binary search tree, return the minimum difference between any two nodes in the tree.
 */
package Trees;

import java.util.ArrayList;
import java.util.List;

import Trees.TreeUtils.TreeNode;
import Trees.TreeUtils.TreeUtil;
/**
 * @author gaurav kabra
 * @since June 12, 2021
 */
public class MinimumDifference {
	
	// list that will hold values of all nodes
    List<Integer> ls = new ArrayList<>();
    
    private void traverse(TreeNode<Integer> root) {
        if(root == null)    
            return;
        traverse(root.left);
        ls.add(root.val);
        traverse(root.right);
    }
    
    
    public int getMinimumDifference(TreeNode<Integer> root) {
    	/**
    	 * Logic:
    	 * Before finding the difference, we first need to traverse the tree.
    	 * So we traverse the tree and store value of each node in the list, ls.
    	 * We sort the list in end (No need if traverse is inorder, since then list is already sorted).
    	 * Then to find minimum difference, we just track differences of adjacent values and return minimum of them.
    	 * 
    	 * Time Complexity : O(N) for we traverse the tree (which can be skewed in worst case) + we trace the list to find differences.
    	 * Note that it will be O(NlogN) if your traversal is not inorder (since then you will need to sort as well)
    	 * 
    	 * Space Complexity : O(N) for internal stack in recursion involved in traversal and list to store all values present in tree.
    	 */
        traverse(root);
        
        int mini = Integer.MAX_VALUE, diff;
        
        for(int i=0; i<ls.size()-1; i++) {
            diff = ls.get(i+1) - ls.get(i);
            mini = Math.min(mini, diff);
        }
        
        return mini;
    }
 	
 	// driver - main method
	public static void main(String[] args) {
		TreeNode<Integer> root = TreeUtil.getDummyBinarySearchTree();
		
		// TESTCASE
		MinimumDifference md = new MinimumDifference();
		System.out.println(md.getMinimumDifference(root));

	}

}
