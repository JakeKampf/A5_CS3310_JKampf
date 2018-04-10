package a4_3310_JKampf;

public class MyNode {
	MyNode left, right;
	String data;

	/**
	 * constructor
	 */
	public MyNode() {
		left = null;
		right = null;
		data = null;
	}

	/**
	 * constructor with data
	 *
	 * @param n
	 */
	public MyNode(String n) {
		left = null;
		right = null;
		data = n;
	}

	/**
	 * sets left leaf node
	 * @param n
	 */
	public void setLeft(MyNode n) {
		left = n;
	}

	/**
	 * sets right leaf node
	 * @param n
	 */
	public void setRight(MyNode n) {
		right = n;
	}

	/**
	 * returns left node
	 * @return
	 */
	public MyNode getLeft() {
		return left;
	}

	/**
	 * returns right leaf node
	 * @return
	 */
	public MyNode getRight() {
		return right;
	}

	/**
	 * sets data in node
	 * @param d
	 */
	public void setData(String d) {
		data = d;
	}

	/**
	 * returns node data
	 * @return
	 */
	public String getData() {
		return data;
	}

}
