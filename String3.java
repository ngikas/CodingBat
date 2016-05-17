public class String3 {

	/*
	 *	NOT REPLACE
	 */
	static String notReplace(String str) {
		String result = "";
		if (str.equals("is")) return "is not";
		if (str.length() < 2) return str;

		for (int i = 0; i < str.length(); i++) {
			if (i < str.length() - 1 && str.substring(i, i+2).equals("is")) {
				if (i == 0 && str.length() > 2 && !Character.isLetter(str.charAt(i+2))) {
					result += "is not";
					i++;
				} else if (i > 0 && !Character.isLetter(str.charAt(i-1))) {
					if (i < str.length() - 2 && Character.isLetter(str.charAt(i+2))) { 
						result += str.charAt(i);
					} else {
						result += "is not";
						i++;
					}
				} else {
					result += str.charAt(i);
				}
			} else {
				result += str.charAt(i);
			}
		}
		return result;
	}

	/*
	 *	SUM NUMBERS
	 */
	static int sumNumbers(String str) {
		int sum = 0;
		int firstDigit = 0;
		for (int i = 0; i < str.length(); i++) {
			if (Character.isDigit(str.charAt(i))) {
				firstDigit = i;
				while (i < str.length() && Character.isDigit(str.charAt(i))) {
					i++;
				}
				sum += Integer.parseInt(str.substring(firstDigit, i));
			}
		}
		return sum;
	}

	/*
	 *	MAX BLOCK
	 */
	static int maxBlock(String str) {
		if (str.length() < 2) return 0;
		int maxCount = 0;
		for (int i = 0; i < str.length() - 1; i++) {
			int count = 1;
			if (str.charAt(i) == str.charAt(i+1)) {
				count++;
				i+=1;
				while (i < str.length() - 1 && str.charAt(i) == str.charAt(i+1)) {
					count++;
					i++;
				}
			}
			maxCount = Math.max(maxCount, count);
		}
		return maxCount;
	}

	/*
	 *	MIRROR ENDS
	 */
	static String mirrorEnds(String string) {
		String result = "";
    	int len = string.length();
    	for (int i = 0, j = len - 1; i < len; i++, j--) {
        	if (string.charAt(i) == string.charAt(j)) {
        		result += string.charAt(i);
        	} else {
        		break;
        	}
        }
    	return result;
	}

	/*
	 *	SAME ENDS
	 */
	static String sameEnds(String string) {
		int startIndex = 0;
		int endIndex = string.length() - 1;
		String result = "";
		while (startIndex < endIndex) {
			if (string.substring(0, startIndex+1).equals(string.substring(endIndex))) {
				result = string.substring(endIndex);
			}
			startIndex++;
			endIndex--;
		}
		return result;
	}

	/*
	 *	SUM DIGITS
	 */
	static int sumDigits(String str) {
		if (str.length() == 0) return 0;
		if (Character.isDigit(str.charAt(0))) {
			return Integer.parseInt(str.substring(0, 1)) + sumDigits(str.substring(1));
		}
		return sumDigits(str.substring(1)); 
	}

	/*
	 *	COUNT TRIPLE
	 */
	static int countTriple(String str) {
		int count = 0;
		for (int i = 0; i < str.length() - 2; i++) {
			if (str.charAt(i) == str.charAt(i+1) && str.charAt(i+1) == str.charAt(i+2)) count++;
		}
		return count;
	}

	/*
	 *	G HAPPY
	 */
	static boolean gHappy(String str) {
		if (str.length() == 0) return true;
		if (str.length() == 1) return false;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == 'g') {
				if (i > 0 && str.charAt(i-1) != 'g' && i < str.length() - 1 && str.charAt(i+1) != 'g') return false;
				if (i == 0 && str.charAt(i+1) != 'g' || i == str.length() - 1 && str.charAt(i-1) != 'g') return false;
			}
		}	
		return true;
	}

	/*
	 *	EQUAL IS NOT
	 */
	static boolean equalIsNot(String str) {
		int isCount = 0;
		int notCount = 0;
		for (int i = 0; i < str.length(); i++) {
			if (i <= str.length() - 2 && str.substring(i, i+2).equals("is")) isCount++;
			if (i <= str.length() - 3 && str.substring(i, i+3).equals("not")) notCount++;
		}
		return isCount == notCount;
	}

	/*
	 *	WITHOUT STRING
	 */
	static String withoutString(String base, String remove) {
		String baseLC = base.toLowerCase();
		String removeLC = remove.toLowerCase();
		String result = "";
		for (int i = 0; i < base.length(); i++) {
			if (i <= base.length() - remove.length() && baseLC.substring(i, i + remove.length()).equals(removeLC)) {
				i += remove.length() - 1;
				continue;
			}
			result += base.charAt(i);
		}
		return result;
	}

	/*
	 *	COUNT YZ
	 */
	static int countYZ(String str) {
		int count = 0;
		str = str.toLowerCase();
		for (int i = 0; i < str.length(); i++) {
			if (i < str.length() - 1 && (str.charAt(i) == 'y' || str.charAt(i) == 'z') && !Character.isLetter(str.charAt(i+1))) {
				count++;
			}
			//checks last character
			if (i == str.length() - 1 && (str.charAt(i) == 'y' || str.charAt(i) == 'z')) count++;
		}
		return count;
	}
}	