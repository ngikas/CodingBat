public class AP1 {
	public static void main(String[] args) {
	}

	/*
	 *	WORDS FRONT
	 */
	static String[] wordsFront(String[] words, int n) {
		String[] newArray = new String[n];
		for (int i = 0; i < n; i++) {
			newArray[i] = words[i];
		}
		return newArray;
	}

	/*
	 *	WORDS COUNT
	 */
	static int wordsCount(String[] words, int len) {
		int count = 0;
		for (String word : words) {
			if (word.length() == len) count++;
		}
		return count;
	}

	/*
	 *	SCORES AVERAGE
	 */
	static int scoresAverage(int[] scores) {
		//compute int average of the first half and second half
		return Math.max(average(scores, 0, scores.length / 2 - 1), average(scores, scores.length / 2, scores.length - 1));
	}
	static int average(int[] scores, int start, int end) {
		int sum = 0;
		for (int i = start; i <= end; i++) {
			sum += scores[i];
		}
		return sum / (end - start + 1);
	}

	/*
	 *	SCORES CLUMP
	 */
	static boolean scoresClump(int[] scores) {
		for (int i = 0; i < scores.length - 2; i++) {
			if (Math.abs(scores[i] - scores[i+1]) <= 2 && 
				Math.abs(scores[i+1] - scores[i+2]) <= 2 &&
				Math.abs(scores[i] - scores[i+2]) <= 2) {
				return true;
			}
		}
		return false;
	}

	/*
	 *	SCORES 100
	 */
	static boolean scores100(int[] scores) {
		for (int i = 0; i < scores.length - 1; i++) {
			if (scores[i] == 100 && scores[i+1] == 100) {
				return true;
			}
		}
		return false;
	}

	/*
	 *	SCORES INCREASING
	 */
	static boolean scoresIncreasing(int[] scores) {
		for (int i = 0; i < scores.length - 1; i++) {
			//look for any previous score less than current and return false
			if (scores[i] > scores[i+1]) {
				return false;
			}
		}
		return true;
	}
}