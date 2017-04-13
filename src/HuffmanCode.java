
/**
 * HW3 Q2 @author Animesh Jain
 * 
 * */

import java.util.Scanner;
import java.util.PriorityQueue;

public class HuffmanCode {
	public static final char FIRST_CHAR = 'a';
	static PriorityQueue<HuffmanNode> priorityQueue = new PriorityQueue<>();
	public static int instructionCounter=0;  
	public static void main(String args[]) {
		int n;
		Scanner keyboard = new Scanner(System.in);
		System.out.println("size of alphabet(n):");
		n = keyboard.nextInt();
		int frequencyArray[] = new int[n];
		char ch = FIRST_CHAR;
		for (int i = 0; i < n; i++) {
			System.out.print("Frequency of " + ch + " :");
			frequencyArray[i] = keyboard.nextInt();
			System.out.println();
			ch++;
		}
		HuffmanCode.compress(frequencyArray, n);
		System.out.println("Instruction counter "+instructionCounter);
		keyboard.close();
	}

	public static void compress(int frequency[], int n) {
		char c = FIRST_CHAR;
		
		for (int i = 0; i < n; i++) {
			// Add all chars to the PQ
			instructionCounter++;
			HuffmanNode node = new HuffmanNode(frequency[i], c);
			if(frequency[i]>0)
			priorityQueue.add(node);
			c++;
		}
		if (n % 2 == 0) {
			HuffmanNode hash = new HuffmanNode();
			hash.character = '#';
			hash.frequency =0;
			priorityQueue.add(hash);
			n++;
		}
		if (n == 1) {
			HuffmanNode hash1 = new HuffmanNode();
			hash1.character = '#';
			hash1.frequency = Integer.MAX_VALUE;
			priorityQueue.add(hash1);
			HuffmanNode hash2 = new HuffmanNode();
			hash2.character = '#';
			hash2.frequency = Integer.MAX_VALUE;
			priorityQueue.add(hash2);
			n+=2;
		}
		
		for (int i = 0; i <n/2; i++) {
			instructionCounter++;
			HuffmanNode leftNode = priorityQueue.poll();
			HuffmanNode centerNode = priorityQueue.poll();
			HuffmanNode rightNode = priorityQueue.poll();
			HuffmanNode z = new HuffmanNode();
			z.frequency=0;
			if (rightNode != null)
					z.frequency += rightNode.frequency;
			if(centerNode !=null)
					z.frequency +=  centerNode.frequency;
			if(leftNode!=null)
					z.frequency+=leftNode.frequency;
			z.left = leftNode;
			z.center = centerNode;
			z.right = rightNode;
			priorityQueue.add(z);
			
		}
		System.out.println("Huffman Tree values:");
		HuffmanTree(priorityQueue.peek(), "");
	}

	static void HuffmanTree(HuffmanNode currentNode, String code) {
		instructionCounter++;
		if (currentNode.left != null) {
			HuffmanTree(currentNode.left, code + "0");
		}
		if (currentNode.center != null) {
			HuffmanTree(currentNode.center, code + "1");
		}
		if (currentNode.right != null) {
			HuffmanTree(currentNode.right, code + "2");
		}
		if (currentNode.left == null && currentNode.right == null && currentNode.center == null) {
			if(!(currentNode.character=='#'))	
			System.out.println(currentNode.character + " = " + code);
			return;
		}
	}
}
