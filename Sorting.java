import java.util.*;

public class Sorting {

	public static void main(String[] args) {
		Blob[] array = new Blob[20];
		array[0] = new Blob(0, "ab");
		array[1] = new Blob(6, "cd");
		array[2] = new Blob(0, "ef");
		array[3] = new Blob(6, "gh");
		array[4] = new Blob(4, "ij");
		array[5] = new Blob(0, "ab");
		array[6] = new Blob(6, "cd");
		array[7] = new Blob(0, "ef");
		array[8] = new Blob(6, "gh");
		array[9] = new Blob(0, "ij");
		array[10] = new Blob(4, "that");
		array[11] = new Blob(3, "be");
		array[12] = new Blob(0, "to");
		array[13] = new Blob(1, "be");
		array[14] = new Blob(5, "question");
		array[15] = new Blob(1, "or");
		array[16] = new Blob(2, "not");
		array[17] = new Blob(4, "is");
		array[18] = new Blob(2, "to");
		array[19] = new Blob(4, "the");
		fullCountingSort(array);
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
        int cIndex = 0;
        int blobIndex = 0;
        for (int i = 0; i < ar.length; i++) {
			//accessing original array
			while (i < ar.length && blobIndex < c[cIndex]) {
				if (ar[i].num == cIndex) {
					newArray[blobIndex] = ar[i].string;
					blobIndex++;
				}
				i++;
			}
			cIndex++;
			if (cIndex > c.length - 1 || blobIndex > ar.length - 1) break;
			i = -1;
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

		for (int i = 0; i < array.length; i++) {
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