package com.bhatt.ds.sort.quicksort;

public class QuickSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		QuickSort qs = new QuickSort();
		int[] b = {4,2,1,6,3};
		b = qs.quicksort(b, 0, 4);
		
		for(int i=0;i<5;i++){
			System.out.println(b[i] + "\n");
		}

	}
	
	int[] A;
	
	
	public int[] quicksort(int[] A, int p, int r){
		if(p<r){
			int q = partition(A, p, r);
			quicksort(A,p,q);
			quicksort(A,q+1,r);
		}
		
		return A;
		
	}
	
	public int partition(int[] A, int p, int r){
		
		int x = A[p]; //first element of array A
		int i = p+1; //points to first element of A
		int j = r; //points to last element of A
		int tmp;
		while(true){
			
			while(A[j]>x)
				j = j-1;
			while (A[i]<x)
				i = i+1;
			
			if(i<j){
				tmp = A[i];
				A[i] = A[j];
				A[j] = tmp;
			}else{
				return j;
			}
		}
		
	}

}
