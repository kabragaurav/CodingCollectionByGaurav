/**
 * Given the root of a binary tree, print the vertical order traversal of the binary tree.
 * For each node at position (row, col), its left and right children will be at positions (row + 1, col - 1) and (row + 1, col + 1) respectively. The root of the tree is at (0, 0).
 * The vertical order traversal of a binary tree is a list of orderings for each column index starting from the leftmost column and ending on the rightmost column.
 * There may be multiple nodes in the same row and same column. In such a case, sort these nodes by their values in descending order.
 */
package Miscellaneous.UniqueConcepts;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Trees.TreeUtils.TreeNode;
import Trees.TreeUtils.TreeUtil;

/**
 * @author gaurav kabra
 * @since June 19, 2021
 *
 */
public class VerticalOrderTraversal {
	
	// hD is horizontal distance of a node from root.
	Map<Integer, List<Integer>> mp;			// stores hD as key, and all nodes with that hD as values
    int min, max;							// min as minimum hD and max as maximum hD. Will be used to iterate map keys
    
    public VerticalOrderTraversal() {
        mp = new HashMap<Integer, List<Integer>>();
        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;
    }
    
    private void traversal(TreeNode<Integer> root, int hD) {
        if(root == null)
            return;
        
        if(mp.containsKey(hD)) {
            List<Integer> ls = mp.get(hD);
            ls.add(root.val);
            mp.put(hD, ls);
        }
        else {
            mp.put(hD, new ArrayList<Integer>() {{
                add(root.val);
            }});
        }
        
        if(min > hD)    min = hD;
        if(max < hD)    max = hD;
        
        traversal(root.left, hD-1);
        traversal(root.right, hD+1);
        
    }
    
    private List<List<Integer>> verticalTraversal(TreeNode<Integer> root) {
        traversal(root, 0);
        
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> temp;
        
        for(int i=min; i<=max; i++) {
            temp = mp.get(i);
            Collections.sort(temp, Collections.reverseOrder());			// sort list in descending order
            ans.add(temp);
        }
        return ans;
    }
    
    // driver - main method
	public static void main(String[] args) {
		TreeNode root = TreeUtil.getDummyBinarySearchTree();
		
		VerticalOrderTraversal vot = new VerticalOrderTraversal();
		List<List<Integer>> ans = vot.verticalTraversal(root);
		
		// print ans
		ans.stream().forEach(l -> {
			l.stream().forEach(element -> System.out.print(element + " "));
			System.out.println();
		});
	}

}
