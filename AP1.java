import java.util.*;

public class AP1 {
	public static void main(String[] args) {

	}

	/*
	 *	COMMON TWO
	 */
	static int commonTwo(String[] a, String[] b) {
		if (a.length > b.length) {
			String[] temp = a;
			a = b;
			b = temp;
		}
		ArrayList<String> letters = new ArrayList<String>();
		int count = 0;

		int j = 0; //for b2
		for (int i = 0; i < a.length; i++) {
			while (j < b.length && a[i].compareTo(b[j]) > 0) {
				j++;
			}
			if (j == b.length) break;
			if (a[i].equals(b[j]) && !letters.contains(a[i])) {
				letters.add(b[j]);
				count++;
			} 
		}

		return count;
	}


	/*
	 *	MERGE TWO
	 */
	static String[] mergeTwo(String[] a, String[] b, int n) {
		String[] newArray = new String[n];
		int i = 0; //for a
		int j = 0; //for b
		int k = 0;
		while (k < n) {
			if (a[i].compareTo(b[j]) < 0) {
				newArray[k] = a[i];
				i++;
			} else if (a[i].compareTo(b[j]) == 0){
				newArray[k] = a[i];
				i++;
				j++;
			} else {
				newArray[k] = b[j];
				j++;
			}
			k++;
		}
		return newArray;
	}

	/*
	 *	USER COMPARE
	 */
	static int userCompare(String aName, int aId, String bName, int bId) {
		if (aName.equals((bName))) {
			if (aId < bId) {
				return -1;
			} else if (aId == bId) {
				return 0;
			} else {
				return 1;
			}
		} else {
			if (aName.compareTo(bName) < 0) {
				return -1;
			} else {
				return 1;
			}
		}
	}

	/*
	 *	BIG HEIGHTS
	 */
	static int bigHeights(int[] heights, int start, int end) {
		int bigSteps = 0;
		for (int i = start; i < end; i++) {
			if (Math.abs(heights[i] - heights[i + 1]) >= 5) bigSteps++;
		}
		return bigSteps;
	}

	/*
	 *	SUM HEIGHTS 2
	 */
	static int sumHeights2(int[] heights, int start, int end) {
		int sum = 0;
		for (int i = start; i < end; i++) {
			int change = heights[i] - heights[i + 1];
			if (change < 0) change *= 2; //if change is an increase (i.e. from 3 to 5 yields a negative) then double the change;
			sum += Math.abs(change);
		}
		return sum;
	}

	/*
	 *	SUM HEIGHTS
	 */
	static int sumHeights(int[] heights, int start, int end) {
		int sum = 0;
		for (int i = start; i < end; i++) {
			sum += Math.abs(heights[i] - heights[i + 1]);
		}
		return sum;
	}

	/*
	 *	SCORES SPECIAL
	 */
	static int scoresSpecial(int[] a, int[] b) {
		return highestSpecial(a) + highestSpecial(b);  
	}
	static int highestSpecial(int[] array) {
		if (array.length < 1) return 0;
		int highest = 0;
		for (int val : array) {
			if (val % 10 == 0) highest = Math.max(highest, val);
		}
		return highest;
	}

	/*
	 *	WORDS WITHOUT
	 */
	static String[] wordsWithout(String[] words, String target) {
		int length = 0;
		for (String word : words) {
			if (!word.equals(target)) length++;
		}
		String[] newArray = new String[length];
		int j = 0;
		for (int i = 0; i < words.length; i++) {
			if (words[i].equals(target)) continue; //skip if word equals target
			newArray[j] = words[i];
			j++;
			if (j == length) break;
		}
		return newArray;
	}

	/*
	 *	SCORE UP
	 */
	static int scoreUp(String[] key, String[] answers) {
		int score = 0;
		for (int i = 0; i < key.length; i++) {
			if (key[i].equals(answers[i])) {
				score += 4;
			} else if (answers[i].equals("?")) {
				//do nothing (score += 0)
			} else {
				score -= 1;
			}
		}
		return score;
	}

	/*
	 *	MATCH UP
	 */
	static int matchUp(String[] a, String[] b) {
		int count = 0;
		for (int i = 0; i < a.length; i++) {
			if (a[i].length() > 0 && 
				b[i].length() > 0 && a[i].charAt(0) == b[i].charAt(0)) count++;
		}
		return count;
	}

	/*
	 *	COPY ENDY
	 */
	static int[] copyEndy(int[] nums, int count) {
		int[] newArray = new int[count];
		int j = 0;
		for (int i = 0; i < nums.length; i++) {
			if (isEndy(nums[i])) {
				newArray[j] = nums[i];
				j++;
			}
			if (j == count) break;
		}
		return newArray;
	}
	static boolean isEndy(int n) {
		return (n >= 0 && n <= 10) || (n >= 90 && n <= 100);
	}

	/*
	 *	COPY EVENS
	 */
	static int[] copyEvens(int[] nums, int count) {
		int[] newArray = new int[count];
		int j = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] % 2 == 0) {
				newArray[j] = nums[i];
				j++;
			}
			if (j == count) break;
		}
		return newArray;
	}

	/*
	 *	DIVIDES SELF
	 */
	static boolean dividesSelf(int n) {
		int fullVal = n;
		while (n > 0) {
			//if a digit does not divide into the number evenly or the digit itself is 0 return false
			if (n % 10 == 0 || fullVal % (n % 10) != 0) return false;
			n /= 10;
		}
		return true;
	}

	/*
	 *	HAS ONE
	 */
	static boolean hasOne(int n) {
		System.out.println("Checking " + n);
		if (n == 0) return false; //bc
		if (n % 10 == 1) return true;

		return hasOne(n / 10); 

	}

	/*
	 *	WORDS WITHOUT LIST
	 */
	static List wordsWithoutList(String[] words, int len) {
		ArrayList<String> strList = new ArrayList<String>();
		for (String word : words) {
			if (word.length() != len) strList.add(word);
		}
		return strList;
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