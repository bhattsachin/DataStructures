package com.bhatt.ds.heap;

public class Heap {
	
	private int MAX_SIZE = 10;
	
	
	int[] heap;
	private int HEAP_MAX = -1;
	private int MIN_VALUE = -1;
	private int MAX_VALUE = 999999;
	
	public Heap(int size){
		MAX_SIZE = size;
		heap = new int[MAX_SIZE];
		//if min heap make all to max value
		for(int i=0;i<MAX_SIZE;i++){
			heap[i] = MAX_VALUE;
		}
	}
	
	//heapify at element i; heap[i]
	/**
	 * There can be several cases like 
	 * if the number is greater than both it's children
	 * if parent is smaller than left but greater than right
	 * if parent is smaller than right but greater than left
	 * if parent is smaller than both
	 */
	public void heapify(int i){
		if(i<0) return;
		int right = getRight(i);
		int left = getLeft(i);
		if(left>HEAP_MAX) return; //if we are already at bottom
		int max, tmp;
		//if greater than both
		if(heap[i]>heap[left]&& heap[i]>heap[right]){
			return;
		}
		max = (heap[left]>heap[right])?left:right;
		//switch with max
		tmp = heap[max];
		heap[max] = heap[i];
		heap[i] = tmp;
		heapify(max);
	}
	
	public void minHeapify(int i){
		if(i<0) return;
		int right = getRight(i);
		int left = getLeft(i);
		if(left>HEAP_MAX) return; //if we are already at bottom
		int min, tmp;
		//if greater than both
		if(heap[i]<=heap[left]&& heap[i]<=heap[right]){
			return;
		}
		min = (heap[left]<=heap[right])?left:right;
		//switch with max
		tmp = heap[min];
		heap[min] = heap[i];
		heap[i] = tmp;
		minHeapify(min);
	}
	
	public void buildHeap(){
		
		for(int i=HEAP_MAX/2;i>=0;i--){
			minHeapify(i);
		}
		
		
	}
	
	public void insert(int val){
		if(HEAP_MAX>=MAX_SIZE) return; //cannot add if size goes beyond limit
		HEAP_MAX +=1;
		heap[HEAP_MAX] = val;
	}
	
	//returns parent of an element
	private int getParent(int i){
		return i>>1; //shift one bit
	}
	
	private int getLeft(int i){
		return (i<<1) + 1; //2n + 1
	}
	
	private int getRight(int i){
		return (i<<1) + 2; //2n + 2
	}
	
	public void print(){
		for(int i=0;i<=HEAP_MAX;i++){
			System.out.print(heap[i] + ",");
		}
	}
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		int i = 0;
		System.out.println("" + String.valueOf(i>>1));
		
		Heap heap = new Heap(10);
		heap.insert(3);
		heap.insert(1);
		heap.insert(6);
		heap.insert(8);
		heap.insert(10);
		heap.insert(40);
		heap.insert(20);
		heap.insert(9);
		heap.print();
		
		//let me heapify this now
		heap.buildHeap();
		
		System.out.println("\n-------------- AFTER HEAPIFY -------------------");
		heap.print();
		
		
	}

}
