package a4_3310_JKampf;

public class BinarySearchTree {
	private MyNode root;
	private int index = 0;

	/**
	 * constructor
	 */
	public BinarySearchTree() {
		root = null;
	}

	/**
	 * checks if node is empty
	 * @return
	 */
	public boolean isEmpty() {
		return root == null;
	}

	/**
	 * isnerts data in to tree
	 * @param data
	 */
	public void insert(String data) {
		root = insert(root, data);
	}

	/**
	 * inserts data in to tree
	 * @param node
	 * @param data
	 * @return
	 */
	private MyNode insert(MyNode node, String data) {
		try {
			if (node == null)
				node = new MyNode(data);
			else {
				if (data.compareTo(node.getData()) <= 0)
					node.left = insert(node.left, data);
				else
					node.right = insert(node.right, data);
			}
		} catch (NullPointerException e) {

		}
		return node;
	}


	/**
	 * inserts data in to tree
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
	 * checks if leaf node
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
	 * seaches for specified node
	 * @param val
	 * @return
	 */
	public boolean search(String val) {
		return search(root, val);
	}

	/**
	 * searches for specified node
	 * @param r
	 * @param val
	 * @return
	 */
	private boolean search(MyNode r, String val) {
		boolean found = false;

		while ((r != null) && !found) {

			String rval = r.getData();
			if (val.compareTo(rval) < 0) {
				index++;
				r = r.getLeft();
			} else if (val.compareTo(rval) > 0) {
				index++;
				r = r.getRight();
			} else {
				found = true;
				System.out.println("\t\tFound.");
				System.out.println("\t\tDepth: " + index);
				if (this.isLeaf(r)) {
					System.out.println("\t\tLeaf Node.");
				}
				System.out.println("\t\tSubtree Size: " + this.countNodes(r));
				break;
			}

			found = search(r, val);

		}

		return found;
	}
	
	public String findMax() {
		return findMax(root);
	}

	/**
	 * finds max node
	 * @param node
	 * @return
	 */
	private String findMax(MyNode node) {
		if (node == null)
			return "Null";

		String res = node.getData();
		String lres = findMax(node.left);
		String rres = findMax(node.right);

		if (lres.compareTo(res) > 0)
			res = lres;
		if (rres.compareTo(res) > 0)
			res = rres;
		return res;
	}

	
	public void inorder() {
		inorder(root);
	}
	/**
	 * prints nodes using in order traversal
	 * @param r
	 */
	private void inorder(MyNode r) {
		if (r != null) {
			inorder(r.getLeft());
			System.out.print(r.getData() + ",");
			inorder(r.getRight());
		}
	}

	/**
	 * finds min node
	 * @return
	 */
	public String findMin() {
		return root.getData();
	}
}
