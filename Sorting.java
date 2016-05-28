import java.util.*;

public class Sorting {

	public static void main(String[] args) {
		int[] array = {4,5,3,9,1};
		partition(array);
		//System.out.println(partition(array));
	}
	
	//MergeSort
	//QuickSort
	static void partition(int[] ar) {
		//not in-place and uses Linked Lists (for now)
		int p = ar[0];
		List<Integer>lessAr = new LinkedList<Integer>();
		List<Integer>greatAr = new LinkedList<Integer>();
		for(int i=1; i<ar.length; i++){
			if(ar[i]<p)
				lessAr.add(ar[i]);
			else
				greatAr.add(ar[i]);
		}
		lessAr.add(p); //add pivot
		lessAr.addAll(greatAr); //add 2nd half
		//print
		for(int n: lessAr){
			System.out.print(n+" ");
		}
		System.out.println("");
	}

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

	static int insertionSort(int[] ar) {
		int shifts = 0;
		for (int i = 1; i < ar.length; i++) {
			for (int j = i; j > 0; j--) {
				if (ar[j] < ar[j-1]) {
					int temp = ar[j];
					ar[j] = ar[j-1];
					ar[j-1] = temp;
					shifts++;
				}
			}
		}
		return shifts;
	}

	//1 4 3 6 9 2
	//1 3 4 6 9 2
	//
	
}