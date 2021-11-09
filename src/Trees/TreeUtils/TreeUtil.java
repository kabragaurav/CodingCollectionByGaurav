package Trees.TreeUtils;

/**
 * @author gaurav kabra
 * @since June 16, 2021
 * 
 * Util class having methods related to trees
 */

public class TreeUtil {
	
	// helper method for getDummyBinarySearchTree()
	public static TreeNode<Integer> getTreeNode(Integer val) {
	    TreeNode<Integer> treeNode = new TreeNode<Integer>(val);
		return treeNode;
	}
	
	/**
	 * @return TreeNode root of a sample binary search tree (BST)
	 */
	public static TreeNode getDummyBinarySearchTree() {
		
		/**
		 * Make this BST:
		 * 					6
		 * 				 /     \
		 * 				2       8
		 * 			  /   \    /  \
		 * 			0     4   7    9
		 *              /   \
		 *              3    5
		 */
	
	    TreeNode<Integer> root = getTreeNode(6);
		TreeNode<Integer> two = getTreeNode(2);
		TreeNode<Integer> eight = getTreeNode(8);
		TreeNode<Integer> zero = getTreeNode(0);
		TreeNode<Integer> four = getTreeNode(4);
		TreeNode<Integer> seven = getTreeNode(7);
		TreeNode<Integer> nine = getTreeNode(9);
		TreeNode<Integer> three = getTreeNode(3);
		TreeNode<Integer> five = getTreeNode(5);
				
		root.left = two;	
		root.right = eight;
		two.left = zero;
		two.right = four;
		eight.left = seven;
		eight.right = nine;
		four.left = three;
		four.right = five;
		
		return root;
	}
	
	
		// helper method for getDummyBinarySearchTreeLong()
		private static TreeNode<Long> getTreeNode(Long val) {
		    TreeNode<Long> treeNode = new TreeNode<>(val);
			return treeNode;
		}
		
		/**
		 * @return TreeNode root of a sample binary search tree (BST) having values of Long type
		 */
		public static TreeNode getDummyBinarySearchTreeLong() {
			
			/**
			 * Make this BST:
			 * 					6
			 * 				 /     \
			 * 				2       8
			 * 			  /   \    /  \
			 * 			0     4   7    9
			 *              /   \
			 *              3    5
			 */
		
		    TreeNode<Long> root = getTreeNode(6l);  
			TreeNode<Long> two = getTreeNode(2l);
			TreeNode<Long> eight = getTreeNode(8l);
			TreeNode<Long> zero = getTreeNode(0l);
			TreeNode<Long> four = getTreeNode(4l);
			TreeNode<Long> seven = getTreeNode(7l);
			TreeNode<Long> nine = getTreeNode(9l);
			TreeNode<Long> three = getTreeNode(3l);
			TreeNode<Long> five = getTreeNode(5l);
					
			root.left = two;	
			root.right = eight;
			two.left = zero;
			two.right = four;
			eight.left = seven;
			eight.right = nine;
			four.left = three;
			four.right = five;
			
			return root;
		}

	/**
	 * @return TreeNode root of a sample binary tree (BT)
	 */
	public static TreeNode getDummyBinaryTree1() {

		/**
		 * Make this BST:
		 * 					  1
		 * 				       \
		 * 				        3
		 * 			           /  \
		 * 			          2    4
		 * 						    \
		 * 							 5
		 */

		TreeNode<Integer> root = getTreeNode(1);
		TreeNode<Integer> two = getTreeNode(2);
		TreeNode<Integer> four = getTreeNode(4);
		TreeNode<Integer> three = getTreeNode(3);
		TreeNode<Integer> five = getTreeNode(5);

		root.right = three;
		three.left = two;
		three.right = four;
		four.right = five;

		return root;
	}

	/**
	 * @return TreeNode root of a sample binary tree (BT)
	 */
	public static TreeNode getDummyBinaryTree2() {

		/**
		 * Make this BST:
		 * 					  2
		 * 				       \
		 * 				        3
		 * 				       /
		 * 				      2
		 * 				     /
		 * 				    1
		 */

		TreeNode<Integer> root = getTreeNode(2);
		TreeNode<Integer> three = getTreeNode(3);
		TreeNode<Integer> two = getTreeNode(2);
		TreeNode<Integer> one = getTreeNode(1);

		root.right = three;
		three.left = two;
		two.left = one;

		return root;
	}


	public static TreeNode getDummyBinaryTree3() {

		/**
		 * Make this BST: [0,0,0,0,null,null,0,null,null,null,0]
		 * 					   0
		 * 					 /   \
		 * 					0     0
		 * 				   /	   \
		 * 				  0         0
		 * 				             \
		 * 				              0
		 */

		TreeNode<Integer> zero1 = getTreeNode(0);
		TreeNode<Integer> zero2 = getTreeNode(0);
		TreeNode<Integer> zero3 = getTreeNode(0);
		TreeNode<Integer> zero4 = getTreeNode(0);
		TreeNode<Integer> zero5 = getTreeNode(0);
		TreeNode<Integer> zero6 = getTreeNode(0);

		zero1.left = zero2;
		zero1.right = zero3;
		zero2.left = zero4;
		zero3.right = zero5;
		zero5.right = zero6;

		return zero1;
	}

	public static void getTreePrintedInorder(TreeNode<?> root) {
		if(null == root) {
			return;
		}
		getTreePrintedInorder(root.left);
		System.out.print(root.val + " ");
		getTreePrintedInorder(root.right);
	}

}
