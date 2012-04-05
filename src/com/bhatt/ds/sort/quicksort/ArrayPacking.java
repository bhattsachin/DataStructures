package com.bhatt.ds.sort.quicksort;

public class ArrayPacking {

	/**
	 * Sort binary data into non-increasing order
	 * usecase: on Pandora we want to play songs liked by user instead of suggested by music genome project
	 * @param args
	 */
	public static void main(String[] args) {
		int[] pandoraList = {1,0,1,0,0,0,1,1,0,1,0,0,1,1,1,0,1};
		ArrayPacking pack = new ArrayPacking();
		pandoraList = pack.quicklikesort(pandoraList, 0, pandoraList.length-1);
		
		for(int i=0;i<pandoraList.length;i++){
			System.out.println(pandoraList[i] + ",");
		}

	}

	public int[] quicklikesort(int[] A, int p, int r) {
		while (true) {
			while (A[p] > 0) {
				p = p + 1;
			}
			while (A[r] < 1) {
				r = r - 1;
			}
			if (p < r) {
				// swap
				A[p] = 1;
				A[r] = 0;
			} else {
				return A;
			}

		}

	}

}
