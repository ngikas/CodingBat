import java.util.*;

public class Sorting {

	public static void main(String[] args) {
		int[] array = {63, 25, 73, 1, 98, 73, 56, 84, 86, 57, 16, 83, 8, 25, 81, 56, 9, 53, 98, 67, 99, 12, 83, 89, 80, 91, 39, 86, 76, 85, 74, 39, 25, 90, 59, 10, 94, 32, 44, 
			3, 89, 30, 27, 79, 46, 96, 27, 32, 18, 21, 92, 69, 81, 40, 40, 34, 68, 78, 24, 87, 42, 69, 23, 41, 78, 22, 6, 90, 99, 89, 50, 30, 20, 1, 43, 3, 70, 95, 33, 46, 44, 9, 69, 48, 33, 60, 65, 16, 82, 67, 61, 32, 21, 79, 75, 75, 13, 87, 70, 33, 69};
		countingSort(array);
	}
	
	//MergeSort
	//QuickSort
	//CountingSort
	static void countingSort(int[] ar) { //for an array of numbers 0-99
		//for any value, find the maximum value in the array, then add one for the length of the new array
		int[] countingArray = new int[ar.length];
		int i;
		for (i = 0; i < countingArray.length; i++) {
			//ar[i] is value in ar
			countingArray[ar[i]]++;
		}
		int[] countingArray2 = new int[ar.length]; //for 1000 
		int indexForCA2 = 0;
		for (i = 0; i < countingArray.length; i++) {
			if (countingArray[i] == 0) continue;
			while (countingArray[i] > 0) {
				countingArray2[indexForCA2] = i;
				indexForCA2++;
				countingArray[i]--;
			}
		}

		for (int val : countingArray2) {
			System.out.print(val + " ");
		}
	}

	//InsertionSort

	static void iS(int[] ar) {
		int rightmost = ar[ar.length - 1];
		int i;
		for (i = ar.length - 1; i > 0; i--) {
			if (rightmost < ar[i-1]) {
				ar[i] = ar[i-1];
			} else {
				break;
			}
			System.out.println(Arrays.toString(ar));
			
		}
		ar[i] = rightmost;
		System.out.println(Arrays.toString(ar));
	}

	static void insertionSort(int[] ar) {
		int unsortedVal;
		for (int i = 0; i < ar.length; i++) {
			for (int j = i+1; j < ar.length - 1; j++) {
				if (ar[j] < ar[i]) {

				}
			}
		}
	}

	//1 4 3 6 9 2
	//1 3 4 6 9 2
	//
	
}