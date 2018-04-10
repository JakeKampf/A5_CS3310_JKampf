package a4_3310_JKampf;

public class MinHeap {
	private String[] array;

	private int size;
	private int maxsize;

	/**
	 * contstructor
	 * @param maxsize
	 */
	public MinHeap(int maxsize) {
		this.maxsize = maxsize;
		this.size = 0;
		array = new String[this.maxsize + 1];

	}
	/**
	 * returns parent node
	 * @param pos
	 * @return
	 */
	private int parent(int pos) {
		return pos / 2;
	}
	/**
	 * returns left child node
	 * @param pos
	 * @return
	 */
	private int leftChild(int pos) {
		return (2 * pos);
	}
	/**
	 * returns right child node
	 * @param pos
	 * @return
	 */
	private int rightChild(int pos) {
		return (2 * pos) + 1;
	}
	/**
	 * determines if leaf node
	 * @param pos
	 * @return
	 */
	private boolean isLeaf(int pos) {
		if (pos >= (size / 2) && pos <= size) {
			return true;
		}
		return false;
	}
	
	/**
	 * swap for heapify
	 * @param fpos
	 * @param spos
	 */
	private void swap(int fpos, int spos) {
		String tmp;
		tmp = array[fpos];
		array[fpos] = array[spos];
		array[spos] = tmp;
	}
	/**
	 * heapify
	 * @param pos
	 */
	private void minHeapify(int pos) {
		if (!isLeaf(pos)) {
			if (array[pos].compareTo(array[leftChild(pos)]) > 0 || array[pos].compareTo(array[rightChild(pos)]) > 0) {
				if (array[leftChild(pos)].compareTo(array[rightChild(pos)]) < 0) {
					swap(pos, leftChild(pos));
					minHeapify(leftChild(pos));
				} else {
					swap(pos, rightChild(pos));
					minHeapify(rightChild(pos));
				}
			}
		}
	}
	/**
	 * insert data in to heap
	 * @param element
	 */
	public void insert(String element) {
		array[++size] = element;
		int current = size;
		try {
			while (array[current].compareTo(array[parent(current)]) < 0) {
				swap(current, parent(current));
				current = parent(current);
			}
		} catch (NullPointerException e) {

		}
	}
	/**
	 * prints heap data in pre order
	 */
	public void preOrder() {
		for (int i = 0; i < (size / 2)-1; i++) {
			if(array[i]!=null)
			System.out.print(array[i] + "," + array[2 * i] + "," + array[2 * i + 1] + ",");
		
		}
	}
	
	public void minHeap() {
		for (int pos = (size / 2); pos >= 1; pos--) {
			minHeapify(pos);
		}
	}

	public String[] getArray() {
		return array;
	}
	/**
	 * finds depth of node
	 * @param pos
	 * @return
	 */
	private int findDepth(int pos) {
		int depth = 0;
		if (array[pos] == null) {
			depth = 0;
		} else
			depth += (pos + 1);

		return depth;
	}
	/**
	 * counts nodes in subtree
	 * @param pos
	 * @return
	 */
	private int countNodes(int pos) {
		if (array[pos] == null) {
			return 0;
		} else {
			int total = 1;
			if (this.leftChild(pos) < this.array.length && this.rightChild(pos) < this.array.length) {
				total += countNodes(this.leftChild(pos));
				total += countNodes(this.rightChild(pos));
			}
			return total;
		}
	}
	/**
	 * searches for particular node
	 * @param element
	 * @return
	 */
	public boolean search(String element) {

		boolean found = false;

		double start = System.nanoTime();
		for (int i = 0; i < array.length; i++) {

			try {

				if (element.compareToIgnoreCase(array[i]) == 0) {
					double end = System.nanoTime();

					System.out.println("\t\tFound: " + array[i] + " at index " + i);
					System.out.println("\t\tDepth: " + this.findDepth(i));
					System.out.println("\t\tFound: " + array[i] + " at index " + i);
					System.out.println("\t\tDepth: " + this.findDepth(i));
					if (this.isLeaf(i)) {
						System.out.println("\t\tLeaf Node.");
					}
					System.out.println("\t\tSubtree size: " + this.countNodes(i));
					System.out.printf("\t\tTime to find: %.2f\n", end - start);
					return true;
				}
			} catch (NullPointerException e) {

			}
		}

		return found;
	}
	/**
	 * finds min node
	 * @return
	 */
	public String findMin() {

		return array[1];
	}
	/**
	 * finds max node
	 * @return
	 */
	public String findMax() {
		String max = array[1];

		for (int i = 1; i < array.length; i++) {
			if (array[i].compareToIgnoreCase(max) > 0) {
				max = array[i];
			}
		}

		return max;
	}
}
