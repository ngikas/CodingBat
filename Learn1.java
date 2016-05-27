import java.util.*;

public class Learn1 {

	/*
	 *	LANGUAGE DETAILS
	 */
	static void rocketShip(int a, int b) {
		System.out.println((long)a * 365 * (long)b * 24);
	}

	static void nextFiveChars(char c) {
		StringBuilder sb = new StringBuilder();
		sb.append(c);
		for (int i = 1; i <= 5; i++) {
			sb.append(" " + ++c);
		}
		System.out.println(sb.toString());
	}

	static int oddCards(int[] cards){
		int sum = 0;
		for (int card : cards) {
			
			if (card % 2 == 1) {
				if (card % 3 == 0) return 0;
				sum += card;
			}
		}
		return sum;
	}

	/*
	 *	STRING PRACTICE 1-2
	 */
	static int countIng2(String text) {
		int count = 0;
		text = text.replaceAll("s", "");
		for (int i = 0; i < text.length() - 2; i++) {
			if (text.substring(i, i+3).equals("ing")) {
				if (i == text.length() - 3 || !Character.isLetter(text.charAt(i+3))) count++;
			}
		}
		return count;
	}

	static boolean semiAnagram(String word1, String word2) {
		word1 = sortWord(word1);
		word2 = sortWord(word2);
		
		//ensure word1 is always the shortest
		if (word1.length() > word2.length()) {
			String temp = word1;
			word1 = word2;
			word2 = temp;
		}
		
		if (word1.length() == word2.length()) { //check words with equal lengths
			return word1.equals(word2);
		} else { //check words with unequal lengths
			
			for (int i = 0; i < word1.length(); i++) {
				int j = i;
				while (j < word2.length() && word1.charAt(i) != word2.charAt(j)) {
					j++;
				} 
				if (j == word2.length()) return false;
			}
			return true;
		}
	}

	static boolean anagram(String word1, String word2) {
		if (word1.length() != word2.length()) return false;
		if (sortWord(word1).equals(sortWord(word2))) return true;

		return false;
	}

	static String sortWord(String word) {
		char[] charArray = word.toCharArray();
		Arrays.sort(charArray);
		return String.valueOf(charArray);
	}

	static boolean javaSandwich(String text) {
		text = text.toLowerCase();
		for (int i = 0; i < text.length() - 3; i++) {
			if (text.substring(i, i+4).equals("java")) {
				//i is also left side length
				int right = text.length() - i - 4;
				if (Math.abs(i-right) <= 2) return true;
			}
		}
		return false;
	}
	static boolean uniqueChar(String text) {
		text = text.toLowerCase();
		for (int i = 0; i < text.length(); i++) {
			int j = text.length() - 1;
			while (j >= 0) {
				if (j == i) {
					j--;
					continue;
				}
				if (text.charAt(i) == text.charAt(j)) return true;
				j--;
			}
		}
		return false;
	}

	static int countIng(String text) {
		int count = 0;
		for (int i = 0; i < text.length() - 2; i++) {
			if (text.substring(i, i + 3).equals("ing")) count++;
		}
		return count;
	}

	static int findWords(String text) {
		int count = 0;
		text = text.toLowerCase();
		text = text.replaceAll("s", "");
		for (int i = 0; i < text.length() - 3; i++) {
			if (text.substring(i, i + 4).equals("word")) count++;
		}
		return count;
	}

	static boolean checkForPalindrome(String word) {
		word = word.replaceAll(" ", "");
		int end = word.length() - 1;
		for (int i = 0; i < word.length(); i++) {
			if (i > end) break;
			if (word.charAt(i) != word.charAt(end)) return false;
			end--;
		}

		return true;
	}

	static String reverseOrder(String text) {
		StringBuilder sb = new StringBuilder();
		String[] sentence = text.split(" ");
		for (int i = sentence.length - 1; i >= 0; i--) {
			sb.append(sentence[i] + " ");
		}
		return sb.toString();
	}

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

	public static void main(String[] args) {
		int[] array = {51, 80, 63, 12, 40, 75, 15, 18};
		System.out.println(primePrime(array));
	}

	//Prime Prime
	static int primePrime(int[] array) {
		int max = 0;
		int primePrimeVal = 0;

		//sieve
		int[] primes = new int[10001];
		primes[0] = -1;
		primes[1] = -1;
		for (int i = 2; i < primes.length; i++) {
			if (primes[i] == 0) {
				for (int j = 2; i * j < primes.length; j++) {
					primes[i*j] = -1;
				}
			}
		}
		for (int i = 0; i < array.length; i++) {
			for (int j = 2; j <= array[i]; j++) {
				if (primes[j] >= 0 && array[i] % j == 0) {
					primes[j]++;
					if (primes[j] > max) {
						max = primes[j];
						primePrimeVal = j;
					}
				}
			}
		}
		return primePrimeVal;
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