package com.bhatt.ds.heap;

public class MinHeap {

	private int MAX_SIZE = 10;

	public MinHeap(int size) {
		MAX_SIZE = size;
		heap = new int[MAX_SIZE];
		// if min heap make all to max value
		for (int i = 0; i < MAX_SIZE; i++) {
			heap[i] = MAX_VALUE;
		}
	}

	int[] heap;
	private int HEAP_MAX = -1;
	private int MAX_VALUE = 999999;

	// heapify at element i; heap[i]
	/**
	 * There can be several cases like if the number is smaller than both it's
	 * children if parent is smaller than left but greater than right if parent
	 * is smaller than right but greater than left if parent is greater than
	 * both
	 */
	public void minHeapify(int i) {
		if (i < 0)
			return;
		int right = getRight(i);
		int left = getLeft(i);
		if (right > HEAP_MAX)
			return; // if we are already at bottom
		int min, tmp;
		// if greater than both
		if (heap[i] <= heap[left] && heap[i] <= heap[right]) {
			return;
		}
		min = (heap[left] <= heap[right]) ? left : right;
		// switch with max
		tmp = heap[min];
		heap[min] = heap[i];
		heap[i] = tmp;
		minHeapify(min);
	}

	public void buildHeap() {
		for (int i = (HEAP_MAX+1) / 2; i >= 0; i--) {
			minHeapify(i);
		}
	}

	public void insert(int val) {
		if (HEAP_MAX+1 >= MAX_SIZE) {
			if(val<heap[0]) return; // if value is less than top element ignore it
			// delete top and add it and minheapify it
			heap[0] = val;
			minHeapify(0);
		} else {
			HEAP_MAX += 1;
			heap[HEAP_MAX] = val;
			if(HEAP_MAX>=MAX_SIZE-1){
				buildHeap(); //after this point heap is full and sorted in order
			}
		}

	}

	private int getLeft(int i) {
		return (i << 1) + 1; // 2n + 1
	}

	private int getRight(int i) {
		return (i << 1) + 2; // 2n + 2
	}

	public void print() {
		for (int i = 0; i <= HEAP_MAX; i++) {
			System.out.print(heap[i] + ",");
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int i = 0;
		System.out.println("" + String.valueOf(i >> 1));

		MinHeap heap = new MinHeap(9);
		heap.insert(3);
		heap.insert(1);
		heap.insert(6);
		heap.insert(8);
		heap.insert(10);
		heap.insert(40);
		heap.insert(20);
		heap.insert(9);
		heap.print();

		// let me heapify this now
		heap.buildHeap();

		System.out
				.println("\n-------------- AFTER HEAPIFY -------------------");
		heap.print();

		heap.insert(9);
		heap.insert(2);
		heap.insert(1);
		heap.insert(4);
		heap.insert(20);
		heap.insert(13);
		heap.insert(14);
		heap.insert(15);

		System.out
				.println("\n-------------- AFTER ADDING MORE ELEMENTS WE CAN FIT -------------------");
		heap.print();
		
		heap.insert(2);
		heap.insert(3);
		heap.insert(6);
		System.out
		.println("\n-------------- AFTER ADDING FEW MORE SMALL ELEMENTS -------------------");
		heap.print();
		
		heap.insert(200);
		heap.insert(30);
		heap.insert(60);
		System.out
		.println("\n-------------- AFTER ADDING FEW BIG NUMBERS ELEMENTS -------------------");
		heap.print();

	}

}
