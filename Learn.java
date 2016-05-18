public class Learn {

	/*
	 *	DOUBLE LOOPS
	 */

	//Equal Lands
	static boolean equalLands(int[] array) {
		int split = 1;
		while (split < array.length) {
			int leftSum = 0;
			int rightSum = 0;
			for (int i = 0; i < split; i++) {
				leftSum += array[i];
			}
			for (int j = split; j < array.length; j++) {
				rightSum += array[j];
			}
			if (leftSum > 0 && leftSum == rightSum) return true;
			split++;
		}
		return false;
	}

	//Duplicate Diamonds
	static int duplicateDiamonds(int[] array) {
		int maxDistanceVal = 0;
		int maxDistance = 0;
		for (int i = 0; i < array.length; i++) {
			int leftIndex = i;
			int rightIndex = array.length - 1;
			while (leftIndex < rightIndex) {
				if (array[leftIndex] == array[rightIndex]) {
					if (maxDistance < rightIndex - leftIndex) {
						maxDistance = rightIndex - leftIndex;
						maxDistanceVal = array[leftIndex];
						break;
					}
				}
				rightIndex--;
			}
		}
		return maxDistanceVal;
		
	}

	//Duplicate Duplicates
	static int dopeDuplicates(int[] array) {
		int maxModeCount = 0;
		int mode = array[0];
		for (int i = 0; i < array.length; i++) {
			int duplicate = array[i];
			int modeCount = 1;
			for (int j = i+1; j < array.length; j++) {
				if (array[j] == duplicate) {
					modeCount++;
				}
			}
			if (modeCount > maxModeCount) {
				mode = duplicate;
			}
			maxModeCount = Math.max(modeCount, maxModeCount);
		}
		return mode;
	}
	 

	//Duplicates
	static void duplicates(int[] array) {
		for (int i = 0; i < array.length; i++) {
			int duplicate = array[i];
			for (int j = i+1; j < array.length; j++) {
				if (array[j] == duplicate) {
					System.out.println(array[j]);
					return;
				}
			}
		}
		//if there are no duplicates
		System.out.println("none");

	}
}