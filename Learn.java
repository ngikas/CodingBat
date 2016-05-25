public class Learn {
	public static void main(String[] args) {
		System.out.println(reverseEach("knowledge is power"));
	}

	/*
	 *	STRING PRACTICE 1-2
	 */
	static String reverseEach(String text) {
		StringBuilder sb = new StringBuilder();
		String[] sentence = text.split(" ");
		for (String word : sentence) {
			sb.append(reverse(word) + " ");
		}
		return sb.toString();
	}

	static String reverse(String text) {
		StringBuilder sb = new StringBuilder();
		for (int i = text.length() - 1; i >= 0; i--) {
			sb.append(text.charAt(i));
		}
		return sb.toString();
	}

	static String pigLatinSentences(String text) {
		StringBuilder sb = new StringBuilder();
		String[] sentence = text.split(" "); //returns an array with each word
		for (String word : sentence) {
			sb.append(pigLatin(word) + " ");
		}
		return sb.toString();
	}

	static String pigLatin(String word){
		for (int i = 0; i < word.length(); i++) {
			char capital = Character.toLowerCase(word.charAt(i));
			if (capital == 'a' || capital == 'e' ||
				capital == 'i' || capital == 'o' ||
				capital == 'u') {
				word = word.substring(i) + word.substring(0,i);
				break;
			}
			else
			continue;
		
		}
		
		return word + "ay";
	}

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

	//Swap W/O a temp variable
	static void auxSwap(int x, int y) {
		System.out.println("x: " + x + " y: " + y);
		x = x ^ y;
		y = x ^ y;
		x = x ^ y;
		System.out.println("x: " + x + " y: " + y);
	}
}