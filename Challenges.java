import java.util.*;

public class Challenges {
	public static void main(String[] args) {
		int[] arr = {6, 7, 3, 21, 0, 17, 5, 11, -1, 8, 32, 5, 8, 3, 7, 5};
		System.out.println(slidingMax(arr, 7));
	}

	static int slidingMax(int[] array, int k) { //O(nk) optimal is O(n)
		int j, max;
 		int count = 0;
    	for (int i = 0; i <= array.length-k; i++) {

        	max = array[i];
 
        	for (j = 1; j < k; j++) {
        		count++;	
            	if (array[i+j] > max) max = array[i+j];
        	}
        	
        	System.out.printf("%d ", max);
    	}
    	return count;
	}
}