package a4_3310_JKampf;

public class MaxHeap {
	MyNode root;
	public MaxHeap() {
		root = null;
	}
/**
 * 
 * @param data
 */
	public void insert(String data) {
		root = insert(root, data);
	}
/**
 * inserts data
 * @param node
 * @param data
 * @return
 */
	private MyNode insert(MyNode node, String data) {

		if (node == null)
			node = new MyNode(data);
		else {
			if (this.height(node.left) < this.height(node.right))
				node.left = insert(node.left, data);
			else if (this.height(node.left) > this.height(node.right))
				node.right = insert(node.right, data);
			else {
				node.left = insert(node.left, data);
			}
		}

		return node;

	}

	/**
	 * checks if tree is balanced
	 * @param MyNode
	 * @return
	 */
	boolean isBalanced(MyNode MyNode) {
		int lh; /* for height of left subtree */

		int rh; /* for height of right subtree */

		/* If tree is empty then return true */
		if (MyNode == null)
			return true;

		/* Get the height of left and right sub trees */
		lh = height(MyNode.left);
		rh = height(MyNode.right);

		if (Math.abs(lh - rh) <= 1 && isBalanced(MyNode.left) && isBalanced(MyNode.right))
			return true;

		/* If we reach here then tree is not height-balanced */
		return false;
	}

	/**
	 * returns height of node
	 * @param MyNode
	 * @return
	 */
	int height(MyNode MyNode) {
		
		if (MyNode == null)
			return 0;

		
		return 1 + Math.max(height(MyNode.left), height(MyNode.right));
	}
	/**
	 * counts nodes in subtree
	 * @return
	 */
	public int countNodes() {
		return countNodes(root);
	}
/**
 * 
 * @param r
 * @return
 */
	private int countNodes(MyNode r) {
		if (r == null)
			return 0;
		else {
			int l = 1;
			l += countNodes(r.getLeft());
			l += countNodes(r.getRight());
			return l;
		}
	}
/**
 * returns root
 * @return
 */
	public MyNode getRoot() {
		return root;
	}
/**
 * checks if node is a leaf
 * @param node
 * @return
 */
	private boolean isLeaf(MyNode node) {
		if (node.left == null && node.right == null) {
			return true;
		} else
			return false;
	}
/**
 * finds specified node
 * @param val
 * @return
 */
	public boolean search(String val) {
		return search(root, val);
	}

	
	private boolean search(MyNode r, String val) {
		boolean found = false;
		
		if(r!=null) {
			if(val.compareToIgnoreCase(r.getData())!=0) {
			search(r.getLeft(), val);
			
			search(r.getRight(), val);
			
			}
			else {
				System.out.println("\t\tFound.");
				System.out.println("\t\tDepth: " + height(r));
				if (this.isLeaf(r)) {
					System.out.println("\t\tLeaf Node.");
				}
				System.out.println("\t\tSubtree Size: " + this.countNodes(r));
				
				return true;
				
				
			}
		}
		

		return found;
	}
	/**
	 * finds max node
	 * @return
	 */
	public String findMax() {
		return this.root.data;
	}
	/**
	 * finds min node
	 * @return
	 */
	public String findMin() {
		return "";
	}
	/**
	 * prints heap using post order traversal
	 */
	public void postorder() {
		postorder(root);
	}
/**
 * 
 * @param r
 */
	private void postorder(MyNode r) {
		if (r != null) {
			postorder(r.getLeft());
			postorder(r.getRight());
			System.out.print(r.getData() + ",");
		}
	}
}
