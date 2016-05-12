public class String2 {
	public static void main(String[] args) {
		System.out.println(xyBalance("yxyx"));
	}

	/*
	 *	XY BALANCE
	 */
	static boolean xyBalance(String str) {
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
