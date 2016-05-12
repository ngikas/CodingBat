public class Recursion1 { //every method should have a base case
	public static void main(String[] args) {
		int[] array = {1,2,21};
		System.out.println(strCopies("iiijjj", "ii", 2));
	}

	/*
	 *	STR DIST
	 */
	static int strDist(String str, String sub) {
		return helperFunc(str, sub).length(); 
	}

	static String helperFunc(String str, String sub) {
	  int strlen = str.length();
	  int sublen = sub.length();
	  if (str.equals("")) return str;
	  if (str.startsWith(sub)) {
	    if (str.substring(strlen-sublen, strlen).equals(sub))
	      return str;
	    else
	      return helperFunc(str.substring(0, strlen-1), sub);
	  }
	  else
	    return helperFunc(str.substring(1), sub);
	}

	/*
	 *	STR COPIES
	 */
	static boolean strCopies(String str, String sub, int n) {
		if (sub.length() > str.length() || str.length() == 0 || n == 0) return n == 0; //bc

		if (str.substring(0, sub.length()).equals(sub)) {
			return strCopies(str.substring(1), sub, n-1);
		}
		return strCopies(str.substring(1), sub, n);

	}

	/*
	 *	STR COUNT
	 */
	static int strCount(String str, String sub) {
		if (sub.length() > str.length() || str.length() == 0) return 0; //bc

		if (str.substring(0, sub.length()).equals(sub)) {
			return 1 + strCount(str.substring(sub.length()), sub);
		}

		return strCount(str.substring(1), sub);
	}

	/*
	 *	NEST PAREN
	 */
	static boolean nestParen(String str) {
		if (str.length() == 0) return true; //bc

		if (str.charAt(0) == '(' && str.charAt(str.length() - 1) == ')') {
			return nestParen(str.substring(1, str.length() - 1));
		} else {
			return false;
		}	
	}

	/*
	 *	PAREN BIT
	 */
	static String parenBit(String str) { //assumption is every string contains a pair of parentheses
		if (str.equals("")) return str; //bc 

		if (str.charAt(0) == '(') {
			if (str.charAt(str.length() - 1) == ')') { //find closing parenthesis
				return str;
			}
			return parenBit(str.substring(0, str.length() - 1)); //if not, move endIndex one to the left
		}

		return parenBit(str.substring(1)); //find opening parenthesis
	}

	/*
	 *	COUNT HI 2
	 */
	static int countHi2(String str) {
		System.out.println(str);
		if (str.length() < 2) return 0; //bc

		if (str.substring(0,2).equals("hi")) {
			return 1 + countHi2(str.substring(2));
		} else if (str.length() > 2 && str.substring(1,3).equals("hi")) {
			if (str.charAt(0) != 'x') {
				return 1 + countHi2(str.substring(2));
			} else {
				return countHi2(str.substring(2));
			}
		} else {
			return countHi2(str.substring(1));
		}

	}

	/*
	 *	STRING CLEAN
	 */
	static String stringClean(String str) {
		if (str.length() <= 1) return str; //bc

		if (str.charAt(0) == str.charAt(1)) {
			return stringClean(str.substring(1)); //drop letter to the left that is the same then move to next
		}
		return str.charAt(0) + stringClean(str.substring(1));
	}

	/*
	 *	COUNT11
	 */
	static int count11(String str) {
		if (str.length() <= 1) return 0; //bc

		if (str.substring(0, 2).equals("11")) {
			return 1 + count11(str.substring(2));
		}

		return count11(str.substring(1));
	}

	/*
	 *	COUNT ABC
	 */
	static int countAbc(String str) {
		if (str.length() <= 2) return 0; //bc
		int count = 0;

		if (str.substring(0, 3).equals("abc") || 
			str.substring(0, 3).equals("aba")) {
			count++;
		}
		return count + countAbc(str.substring(1));
	}

	/*
	 *	COUNT PAIRS
	 */
	static int countPairs(String str) {
		if (str.length() <= 2) return 0; //bc
		int count = 0;

		if (str.charAt(0) == str.charAt(2)) count++;
		return count + countPairs(str.substring(1));
	}

	/*
	 *	END X
	 */
	static String endX(String str) {
		if (str.length() == 0) return str; //bc

		if (str.charAt(0) == 'x') {
			return endX(str.substring(1)) + "x";
		}

		return str.charAt(0) + endX(str.substring(1));
	}

	/*
	 *	PAIR STAR
	 */
	static String pairStar(String str) {
		if (str.length() <= 1) return str; //bc

		if (str.charAt(0) == str.charAt(1)) {
			return str.charAt(0) + "*" + pairStar(str.substring(1));
		}
		return str.charAt(0) + pairStar(str.substring(1));
	}

	/*
	 *	ALL STAR
	 */
	static String allStar(String str) {
		if (str.length() <= 1) return str; //bc
		return str.charAt(0) + "*" + allStar(str.substring(1));
	}

	/*
	 *	ARRAY220
	 */
	static boolean array220(int[] nums, int index) {
		if (index >= nums.length - 1) return false; //bc (stop at last index)
		if (nums[index] * 10 == nums[index+1]) return true;

		return array220(nums, index+1);
	}

	/*
	 *	ARRAY11
	 */
	static int array11(int[] nums, int index) {
		if (index == nums.length) return 0; //bc
		int count = 0;

		if (nums[index] == 11) count++;
		return count + array11(nums, index+1);
	}

	/*
	 *	ARRAY6
	 */
	static boolean array6(int[] nums, int index) {
		if (index == nums.length) return false; //bc
		if (nums[index] == 6) return true; //bc (stop looking once a 6 is found)
		return array6(nums, index+1);
	}

	/*
	 *	NO X
	 */
	static String noX(String str) {
		if (str.length() == 0) return ""; //bc

		if (str.charAt(0) == 'x') return "" + noX(str.substring(1));
		return str.charAt(0) + noX(str.substring(1));
	}

	/*
	 *	CHANGE PI
	 */
	static String changePi(String str) {
		if (str.length() < 2) return str; //bc

		if (str.substring(0, 2).equals("pi")) return "3.14" + changePi(str.substring(2));
		return str.charAt(0) + changePi(str.substring(1));
	}

	/*
	 *	CHANGE XY
	 */
	static String changeXY(String str) {
		if (str.length() == 0) return ""; //bc

		if (str.charAt(0) == 'x') return "y" + changeXY(str.substring(1));
		return str.charAt(0) + changeXY(str.substring(1));
	}

	/*
	 *	COUNT HI
	 */
	static int countHi(String str) {
		if (str.length() <= 1) return 0; //bc

		//move string along by 1 char until there is no more string
		if (str.substring(0, 2).equals("hi")) return 1 + countHi(str.substring(1)); 
		return countHi(str.substring(1));

	}

	/*
	 *	COUNT X
	 */
	static int countX(String str) {
		int check = 0;
		if (str.length() == 0) return 0; //bc

		//move string along by 1 char until there is no more string
		if (str.charAt(0) == 'x') check++; 
		return check + countX(str.substring(1));

	}

	/*
	 *	POWER N
	 */
	static int powerN(int base, int n) {
		if (n == 0) return 1; //bc
		return base * powerN(base, n-1);
	}

	/*
	 *	COUNT8
	 */
	static int count8(int n) {
		if (n == 0) return 0; //bc

		if (n % 10 == 8 && (n / 10) % 10 == 8) return 2 + count8(n / 10);
		if (n % 10 == 8) return 1 + count8(n / 10);
		return count8(n / 10);
	}

	/*
	 *	COUNT7
	 */
	static int count7(int n) {
		if (n == 0) return 0; //bc

		if (n % 10 == 7) return 1 + count7(n / 10);
		return count7(n / 10);
	}

	/*
	 *	SUM DIGITS
	 */
	static int sumDigits(int n) {
		if (n == 0) return 0; //bc
		return n % 10 + sumDigits(n / 10);
	}

	/*
	 *	TRIANGLE
	 */
	static int triangle(int rows) {
		if (rows == 0) return 0; //bc
		return rows + triangle(rows-1);
	}

	/*
	 *	BUNNY EARS 2
	 */
	static int bunnyEars2(int bunnies) {
		if (bunnies == 0) return 0; //bc

		if (bunnies % 2 == 0) {
			return 3 + bunnyEars2(bunnies-1);
		} else {
			return 2 + bunnyEars2(bunnies-1);
		}
	}

	/*
	 *	FIBONACCI
	 */
	static int fibonacci(int n) {
		//bc
		if (n == 0) return 0; 
		if (n == 1) return 1;

		return fibonacci(n - 2) + fibonacci(n-1);
	}

	/*
	 *	BUNNY EARS
	 */
	static int bunnyEars(int bunnies) {
		if (bunnies == 0) return 0; //bc
		return 2 + bunnyEars(bunnies-1);
	}


	/*
	 *	FACTORIAL
	 */
	static int factorial(int n) {
		if (n < 2) return 1; //bc
		return n * factorial(n-1);
	}
}
