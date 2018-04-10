package a5.cs3310.jkampf;

public class Node {
	Node left, right;
	int data;
	int height;

	/* Constructor */
	public Node() {
		left = null;
		right = null;
		data = 0;
		height = 0;
	}

	/* Constructor */
	public Node(int n) {
		left = null;
		right = null;
		data = n;
		height = 0;
	}

}
