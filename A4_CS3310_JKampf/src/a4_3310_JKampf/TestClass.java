package a4_3310_JKampf;

import java.io.File;

import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class TestClass {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String[] array = readFile("starwars.txt");
		String array2[] = readFile("starwars_tiny.txt");
		String[] testArray = testFile(array,500); //for tests of different sizes
		/*To test different sized arrays, changed the int 
		 * parameter in testFile() and insert testArray into
		 * each calc__Avg method
		*/
		calcMinHeapAvg(array,array2 , 1);
		calcBSTAvg(array,array2 , 1);
		calcMaxHeapAvg(array,array2 , 1);
	}
/** 
 * 
 * @param fileName
 * @return
 * @throws IOException
 */
	public static String[] readFile(String fileName) throws IOException {
		String[] array = new String[getSize(fileName)];
		File file = new File(fileName);
		Scanner scan = new Scanner(file);
		int index = 0;
		while (scan.hasNext()) {
			array[index] = scan.nextLine();
			index++;
		}

		scan.close();

		return array;

	}
/**
 * 
 * @param fileName
 * @return
 * @throws IOException
 */
	public static int getSize(String fileName) throws IOException {
		int size = 0;
		File file = new File(fileName);
		Scanner scan = new Scanner(file);
		while (scan.hasNext()) {
			scan.nextLine();
			size++;
		}
		scan.close();
		return size;
	}
/**
 * 
 * @param file1
 * @param searchArray
 * @param n
 * @throws IOException
 */
	public static void calcMinHeapAvg(String[] array, String[] array2, int n) throws IOException {
		
		MinHeap min = new MinHeap(array.length);
		
		double average=0;
		for (int j = 0; j < n; j++) {
			double start = System.nanoTime();
			for (int i = 0; i < array.length; i++) {
			
				min.insert(array[i]);
			}
			double end = System.nanoTime();
			average +=end-start;
		}
		
		System.out.println("Min Heap:");
		System.out.printf("\tAverage insert time: %.2f nanoseconds.\n", average/array.length);
		
		min.minHeap();
		
		min.preOrder();
		System.out.println();
		System.out.println("\tMin: "+ min.findMin() +" Max:"+min.findMax());
		average=0;
		for (int i = 0; i < array2.length; i++) {
			System.out.println("\tSearching for "+array2[i]+":");
			
			min.search(array2[i]);
			
		}
		
	}
	/**
	 * 
	 * @param file1
	 * @param searchArray
	 * @param n
	 * @throws IOException
	 */
	public static void calcBSTAvg(String[] array, String[] array2, int n) throws IOException {
		
		BinarySearchTree BST = new BinarySearchTree();
		double average=0;
		for (int j = 0; j < n; j++) {
			double start = System.nanoTime();
			for (int i = 0; i < array.length; i++) {
				if(array[i]!=null) {
				BST.insert(array[i]);
				}
			}
			double end = System.nanoTime();
			average +=end-start;
		}
	
		System.out.println("Binary Search Tree:");
		System.out.printf("\tAverage insert time: %.2f nanoseconds.\n", average/array.length); 
		BST.inorder();
		System.out.println();
		System.out.println("\tMin: "+ BST.findMin() +" Max:"+BST.findMax());
		for(int i=0; i<array2.length; i++) {
			System.out.println("\tSearching for "+array2[i]+":");
			double start = System.nanoTime();
			BST.search(array2[i]);
			double end = System.nanoTime();
			System.out.printf("\t\tTime to find: %.2f\n",end-start);
		}
		
		
		
	} 
	/**
	 * 
	 * @param file1
	 * @param searchArray
	 * @param n
	 * @throws IOException
	 */
	public static void calcMaxHeapAvg(String[] array, String[] array2, int n) throws IOException{
		
		Arrays.sort(array);
		MaxHeap max = new MaxHeap();
		double average=0;
		for (int j = 0; j < n; j++) {
			double start = System.nanoTime();
			for (int i = array.length-1; i >0; i--) {
				if(array[i]!=null) {
				max.insert(array[i]);
				}
			}
			double end = System.nanoTime();
			average +=end-start;
		}
		System.out.println("Max Heap");
		System.out.printf("\tAverage insert time: %.2f nanoseconds.\n", average/array.length); 
		max.postorder();
		System.out.println();
		System.out.println("\tMin: "+ array[0] +" Max:"+max.findMax());
		for(int i=0; i<array2.length; i++) {
			System.out.println("\tSearching for "+array2[i]+":");
			double start = System.nanoTime();
			max.search(array2[i]);
			double end = System.nanoTime();
			System.out.printf("\t\tTime to find: %.2f\n",end-start);
		}
	}
	public static String[] testFile(String[] array, int size) {
		String[] testArray = new String[size];
		Random rand = new Random();
		System.out.println("n="+size);
		for(int i=0; i<size; i++) {
			int rn = rand.nextInt(array.length - 1) + 1;
			testArray[i] = array[rn];
		}
		
		return testArray;
		
		
	}
}
