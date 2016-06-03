import java.util.*;

public class Sorting {

	public static void main(String[] args) {
	
	}

	//Quicksort
	static void partition(int[] ar) {

	}

	//Full counting sort (for extra data)
	static void fullCountingSort(Blob[] ar) {
		int[] c = new int[100];
        for (int i = 0; i < ar.length; i++) {
        	c[ar[i].num]++;
        }
        int sum = 0;
        for (int i = 0; i < c.length; i++) {
        	sum += c[i];
        	c[i] = sum;
        }
        
        String[] newArray = new String[ar.length];
        for (int i = ar.length - 1; i >= 0; i--) {
			//accessing original array
			c[ar[i].num]--;
			newArray[c[ar[i].num]] = ar[i].string;
		}
        
        for (String str : newArray) {
        	System.out.print(str + " ");
        }
        System.out.println();

	}

	//Counting Sort
	static void countingSort(int[] array) {
		int max = array[0];
		//if range of values is known 
		//initialize array of size max + 1
		//if not, traverse array to find max then init array
		for (int val : array) {
			max = Math.max(val, max);
		}
		int[] c = new int[max + 1];
		for (int i = 0; i < array.length; i++) {
			c[array[i]]++; //c
		}
		int sum = 0;
		for (int i = 0; i < c.length; i++) {
			sum += c[i];
			c[i] = sum; //c'
		}
		int[] newArray = new int[array.length];

		for (int i = array.length - 1; i >= 0; i--) {
			//accessing original array
			c[array[i]]--;
			newArray[c[array[i]]] = array[i];
		}
		for (int val : newArray) {
			System.out.print(val + " ");
		}

	}

	//Insertion Sort (descending order)
	static void insertionSortDesc(int[] array) {
		for (int i = 1; i <= array.length - 1; i++) {
			for (int j = i; j > 0; j--) {
				if (array[j] > array[j-1]) { //THE ONLY THING THAT CHANGES : >
					int temp = array[j];
					array[j] = array[j-1];
					array[j-1] = temp;
				} else {
					break;
				}
			}
		}
	}

	//Insertion Sort (ascending order)
	static void insertionSortAsc(int[] array) {
		for (int i = 1; i <= array.length - 1; i++) {
			for (int j = i; j > 0; j--) {
				if (array[j] < array[j-1]) {
					int temp = array[j];
					array[j] = array[j-1];
					array[j-1] = temp;
				} else { //since the values before index j-1 are sorted,
					break; //makes sorting faster because it doesn't check values unnecessarily
				}
			}
		}
	}
}

class Blob{
	String string;
	int num;
	
	public Blob(int n, String str) 
	{
		num=n;
		string=str;
	}	
}