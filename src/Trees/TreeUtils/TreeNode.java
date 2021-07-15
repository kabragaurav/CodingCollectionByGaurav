package Trees.TreeUtils;

/**
 * Implementation of Binary Tree Node
 * @author gaurav kabra
 * @since June 10, 2021
 */

public class TreeNode<T extends Number> {
	/**
	 * val is value in particular TreeNode instance
	 * left and right are references to other TreeNode instances, on left and right, respectively
	 * All are having public access identifier
	 */
	public T val;
	public TreeNode left;
	public TreeNode right;
	
	/**
	 *  one argument constructor
	 *  @param Takes value of TreeNode instance to be created as argument
	 *  Sets left and right references to null
	 */
	public TreeNode(T val) {
		this.val = val;
		this.left = this.right = null;
	}
	
}
