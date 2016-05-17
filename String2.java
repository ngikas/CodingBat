public class String2 {

	/*
	 *	WORD ENDS
	 */
	static String wordEnds(String str, String word) {
		//return string made of each char index-1 and index+1 every appearance in the string
		//return char twice if between two words
		String result = "";
		for (int i = 0; i <= str.length() - word.length(); i++) {
			if (str.substring(i, i + word.length()).equals(word)) {
				if (i > 0) result += str.charAt(i-1);
				if (i < str.length() - word.length()) result += str.charAt(i+word.length());
			}
		}
		return result;
	}

	/*
	 *	PLUS OUT
	 */
	static String plusOut(String str, String word) {

		String result = "";
		for (int i = 0; i < str.length(); i++) {
			if (i <= str.length() - word.length() && str.substring(i, i + word.length()).equals(word)) {
				result += word;
				i+=word.length() - 1;
			} else {
				result += "+";
			}
		}
		return result;
	}

	/*
	 *	STAR OUT
	 */
	static String starOut(String str) {
		String result = "";
		for (int i = 0; i < str.length(); i++) {
			if (i < str.length() - 1 && str.charAt(i+1) == '*' ||
				str.charAt(i) == '*' ||
				i > 0 && str.charAt(i-1) == '*') {
				continue; //skips to next iteration
			}
			result += str.charAt(i);
		}
		return result;
	}

	/*
	 *	ZIP ZAP
	 */
	static String zipZap(String str) {
		String result = "";
		for (int i = 0; i < str.length(); i++) {
			if (i < str.length() - 2 && str.charAt(i) == 'z' && str.charAt(i+2) == 'p') {
				result += "zp";
				i+=2;
			} else {
				result += str.charAt(i);
			}
		}
		return result;
	}

	/*
	 *	ONE TWO
	 */
	static String oneTwo(String str) {
		if (str.length() < 3) return "";

		return str.substring(1,3) + str.charAt(0) + oneTwo(str.substring(3));

	}

	/*
	 *	SAME STAR CHAR
	 */
	static boolean sameStarChar(String str) {
		for (int i = 1; i < str.length() - 1; i++) {
			if (str.charAt(i) == '*' && str.charAt(i-1) != str.charAt(i+1)) return false;
		}

		return true;
	}

	/*
	 *	GET SANDWICH
	 */
	static String getSandwich(String str) {
		for (int i = 0; i < str.length() - 4; i++) {
			if (str.substring(i, i+5).equals("bread")) {
				int j = str.length();
				while (j > i + 5) {
					if (str.substring(j - 5, j).equals("bread")) {
						return str.substring(i+5, j-5);
					}
					j--;
				}

			}
		}
		return "";
	}

	/*
	 *	XYZ MIDDLE
	 */
	static boolean xyzMiddle(String str) {
		if (str.length() <= 2) return false;

		//for strings of odd length, xyz must be in the direct middle to be true
		if (str.length() % 2 == 1 && str.substring(str.length() / 2 - 1, str.length() / 2 + 2).equals("xyz")) return true;

		if (str.length() % 2 == 0) {
			if (str.substring(str.length() / 2 - 1, str.length() / 2 + 2).equals("xyz") ||
				str.substring(str.length() / 2 - 2, str.length() / 2 + 1).equals("xyz")) {
				return true;
			}
		}

		return false;
	}

	/*
	 *	PREFIX AGAIN
	 */
	static boolean prefixAgain(String str, int n) {
		for (int i = n; i <= str.length() - n; i++) {
			if (str.substring(0, n).equals(str.substring(i, i + n))) {
				return true;
			}
		}
		return false;
	}


	/*
	 *	REPEAT SEPARATOR
	 */
	static String repeatSeparator(String word, String sep, int count) {
		String result = "";
		int separatorIndex = 0;
		while (separatorIndex < count) {
			result += word;
			if (separatorIndex < count - 1) {
				result += sep;
			}
			separatorIndex++;
		}
		return result;
	}

	/*
	 *	REPEAT FRONT
	 */
	static String repeatFront(String str, int n) {
		if (n == 0 || str.length() == 0) return "";

		return str.substring(0, n) + repeatFront(str, n - 1);
	}

	/*
	 *	REPEAT END
	 */
	static String repeatEnd(String str, int n) {
		String s = "";
		int count = 0;
		while (str.length() >= n && count < n) {
			s += str.substring(str.length() - n);
			count++;
		}
		return s;
	}

	/*
	 *	MIX STRING
	 */
	static String mixString(String a, String b) {
		String c = "";
		int aIndex = 0;
		int bIndex = 0;
		while (aIndex < a.length() && bIndex < b.length()) {
			c += a.charAt(aIndex);
			aIndex++;
			c += b.charAt(bIndex);
			bIndex++;
		}
		while (aIndex < a.length()) {
			c += a.charAt(aIndex);
			aIndex++;
		}
		while (bIndex < b.length()) {
			c += b.charAt(bIndex);
			bIndex++;
		}
		return c;

	}

	/*
	 *	XY BALANCE
	 */
	static boolean xyBalance(String str) {
		for (int i = str.length() - 1; i >= 0; i--) {
			if (str.charAt(i) == 'x') {
				return false;
			} else if (str.charAt(i) == 'y') {
				return true;
			}
		}
		return true;
	}

	/*
	 *	BOB THERE
	 */
	static boolean bobThere(String str) {
		boolean bob = false;
		for (int i = 0; i < str.length() - 2; i++) {
			if (str.charAt(i) == 'b' && str.charAt(i+2) == 'b') {
				bob = true;
				break;
			}
		}
		return bob;
	}

	/*
	 *	XYZ THERE
	 */
	static boolean xyzThere(String str) {
		boolean validXYZ = false;
		for (int i = 0; i < str.length() - 2; i++) {
			if (str.substring(i, i+3).equals("xyz")) {
				if (i > 0 && str.charAt(i-1) == '.') {
					validXYZ = false;
				} else {
					validXYZ = true;
					break;
				}
			}
		}
		return validXYZ;
	}

	/*
	 *	END OTHER
	 */
	static boolean endOther(String a, String b) {
		if (b.length() < a.length()) {
			String temp = b;
			b = a;
			a = temp;
		}

		a = a.toLowerCase();
		b = b.toLowerCase();
		System.out.println(a);
		System.out.println(b);
		int start = b.length() - a.length();

		return a.equals(b.substring(start)); 
	}

	/*
	 *	COUNT CODE
	 */
	static int countCode(String str) {
		int codeCount = 0;
		for (int i = 0; i < str.length() - 3; i++) {
			if (str.charAt(i) == 'c' && 
				str.charAt(i+1) == 'o' &&
				str.charAt(i+3) == 'e') {
				codeCount++;
			}
		}
		return codeCount;
	}

	/*
	 *	CAT DOG
	 */
	static boolean catDog(String str) {
		int catCount = 0;
		int dogCount = 0;
		for (int i = 0; i < str.length() - 2; i++) {
			if (str.substring(i, i+3).equals("cat")) catCount++;
			if (str.substring(i, i+3).equals("dog")) dogCount++;
		}

		return catCount == dogCount;
	}

	/*
	 *	COUNT HI
	 */
	static int countHi(String str) {
		int count = 0;
		for (int i = 0; i < str.length() - 1; i++) {
			if (str.substring(i, i+2).equals("hi")) {
				count++;
			}
		}
		return count;
	}

	/*
	 *	DOUBLE CHAR
	 */
	static String doubleChar(String str) {
		String word = "";
		for (int i = 0; i < str.length(); i++) {
			word = word + str.charAt(i) + str.charAt(i);
		}
		return word;
	}
}
