import java.util.*;

public class Array3 {
	public static void main(String[] args) {
		int[] array = {1, 2, 1, 20, 21, 1, 2, 1, 2, 23, 24, 2, 1, 2, 1, 25};
		int[] array2 = {2,4};
		//System.out.println(Arrays.toString(seriesUp(5)));
		System.out.println(maxMirror(array));

	}

	static int countClumps(int[] nums) {
		int clumpCount = 0;

		if (nums.length < 2) return 0;

		for (int i = 0; i < nums.length - 1; i++) {
			if (nums[i] == nums[i+1]) {
				clumpCount++; //if there are 2 adjacent elements of the same value, check for more
				//stop index when value at i differs from value at i + 1
				while (i < nums.length - 1 && nums[i] == nums[i+1]) {
					i++;
				}
			}
			
		}
		return clumpCount;

	}

	static int maxMirror(int[] nums) {
		//have two indices
		//if values at both indices are equal increment and decrement accordingly
		//if not just decrement
		//try for all values, starting at index 0, and increment to see if there is mirror length greater than the previous
		int max = 0;
    
    	for(int start = 0; start < nums.length; start++) {
        	for(int begin = nums.length - 1; begin >= 0; begin--) {
		        int size = 0;
		        int i = start;
		        int j = begin;
		                              
		        while(i < nums.length && j >= 0 && nums[i] == nums[j]) {
		            size++;
		            i++;
		            j--;
		        }
		                                                                          
		        max = Math.max(max, size);
		    }
    	}
                                                                                            
    	return max;
		// if (nums.length == 1) return 1;

		// int maxMirrorLength = 0;
		
		// for (int i = 0; i < nums.length; i++) {
		// 	int leftIndex = i;
		// 	int rightIndex = nums.length - 1;
		// 	int mirrorLength = 0;
		// 	while (leftIndex < rightIndex && rightIndex > 0) {
				
		// 		System.out.println("comparing " + nums[leftIndex] + " and " + nums[rightIndex]);
		// 		if (nums[leftIndex] == nums[rightIndex]) {
		// 			mirrorLength++;
		// 			System.out.println(mirrorLength + "<-- mirrorLength");
		// 			if (rightIndex - leftIndex == 2) {
		// 				//double mirror length if one value separates the indices
		// 				System.out.println("indices close");
		// 				mirrorLength = mirrorLength + mirrorLength + 1;
		// 				System.out.println(mirrorLength + "<-- mirrorLength");
		// 				break;
		// 			} else if (rightIndex - leftIndex == 1) {
		// 				System.out.println("indices even closer");
		// 				mirrorLength++;
		// 				System.out.println(mirrorLength + "<-- mirrorLength");
		// 				break;
		// 			}
		// 			leftIndex++;
		// 		} else {
		// 			rightIndex--;
		// 			mirrorLength = 0;
		// 		}
				

		// 	}
		// 	maxMirrorLength = Math.max(mirrorLength, maxMirrorLength);
		// }
		
		// return maxMirrorLength;

	}

	/*
	 *	SERIES UP
	 */
	static int[] seriesUp(int n) {
		int[] newArray = new int[n*(n+1)/2];
		int portion = 1;
		int index = 0;
		int value = 1;
		while (value <= n && index < newArray.length) {

			value = 1; //reset
			while (value <= portion) {
				newArray[index] = value;
				value++;
				index++;
			}
			
			portion++;

		}
		return newArray;
		//3
		//1 1 2 1 2 3
	}

	/*
	 *	SQUARE UP
	 */
	static int[] squareUp(int n) {
		int[] newArray = new int[n*n];

		int counter = 0; //stops rightIndex according to the value of i
		for (int i = 1; i <= n; i++) {
			//start from the right and insert i until rightIndex is less than 0 then increment i
			int rightIndex = newArray.length - i;
			while (rightIndex >= counter) {
				newArray[rightIndex] = i;
				rightIndex -= n;
			}
			counter += n;
		}

		return newArray;

	}

	/*
	 *	LINEAR IN
	 */
	static boolean linearIn(int[] outer, int[] inner) {
		int outerIndex;
		int innerIndex = 0;
		while (innerIndex < inner.length) {
			for (outerIndex = 0; outerIndex < outer.length; outerIndex++) {
				if (outer[outerIndex] == inner[innerIndex]) {
					innerIndex++;
					break;
				}
			}
			if (outerIndex == outer.length) return false; //this means value in inner array was not found in the outer
		}

		return true;

	}

	/*
	 *	CAN BALANCE
	 */
	static boolean canBalance(int[] nums) {
		if (nums.length <= 1) return false;

		//split between 0 and 1.
		//if sum of 0 and sum of 1 to nums.length - 1 are not equal, move to 1 and 2...
		int split = 1;
		while (split < nums.length) {
			int leftSum = 0;
			for (int left = 0; left < split; left++) {
				leftSum += nums[left];
			}
			int rightSum = 0;
			for (int right = split; right < nums.length; right++) {
				rightSum += nums[right];
			}
			if (leftSum == rightSum) return true;
			split++; //if not equal, increase split index until it reaches array length, in which case exit loop

		}

		return false;

		//1,1,1,2,1
		//1 < 5

	}

	/*
	 *	FIX 45
	 */
	static int[] fix45(int[] nums) {
		//assumptions are equal amount of 4s and 5s, 4s cannot be moved, 5s can appear anywhere
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 5) {
				for (int j = 0; j < nums.length - 1; j++) {
					if (nums[j] == 4 && nums[j+1] != 5) {
						int temp = nums[j+1];
						nums[j+1] = nums[i]; //inserts the 5 into the index next to 4
						nums[i] = temp;
						break; //stop looking for 4s, go back to previous loop to find the next 5
					}
				}
			}
		}

		return nums;

	}

	/*
	 *	FIX 34
	 */
	static int[] fix34(int[] nums) {
		//assumptions are equal amount of 3s and 4s, 3s cannot be moved, a 3 appears before any 4
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 4) {
				for (int j = 0; j < nums.length - 1; j++) {
					if (nums[j] == 3 && nums[j+1] != 4) {
						int temp = nums[j+1];
						nums[j+1] = nums[i]; //inserts the 4 into the index next to 3
						nums[i] = temp;
						break; //stop looking for 3s, go back to previous loop to find the next 4
					}
				}
			}
		}

		return nums;

	}

	/*
	 *	MAX SPAN
	 */
	static int maxSpan(int[] nums) {
		if (nums.length == 0) return 0;
		//leftIndex, rightIndex
		int longestSpan = 1;
		//start index on left and right
		int leftIndex = 0;
		int rightIndex = nums.length - 1;

		while (leftIndex < nums.length && leftIndex <= rightIndex) {
			if (nums[leftIndex] == nums[rightIndex]) {
				int span = rightIndex - leftIndex + 1;
				longestSpan = Math.max(longestSpan, span);
				leftIndex++;
				rightIndex = nums.length; //start over from the rightmost with the next value in the array
			} 
			
			rightIndex--; //move rightIndex to the left regardless
		
		}

		return longestSpan;
	}
}