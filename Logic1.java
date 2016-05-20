public class Logic1 {

	public int sumLimit(int a, int b) {
  		if (String.valueOf(a + b).length() > String.valueOf(a).length()) return a;
  		return a + b;
	}	

	public boolean shareDigit(int a, int b) {
  		return (a % 10 == b % 10 || a / 10 % 10 == b / 10 % 10 ||
          a % 10 == b / 10 % 10 || a / 10 % 10 == b % 10);
	}

	public int blueTicket(int a, int b, int c) {
		if (a + b == 10 || b + c == 10 || a + c == 10) return 10;
		else if (a + b - (b + c) == 10 || a + b - (a + c) == 10) return 5;
		else return 0;
	}

	public int greenTicket(int a, int b, int c) {
  		if (a == b && b == c) return 20;
  		else if (a == b || b == c || a == c) return 10;
  		else return 0;
 	}

	public int redTicket(int a, int b, int c) {
  		if (a == b && b == c && a == 2) return 10;
		else if (a == b && b == c) return 5;
		else if (b != a && c != a) return 1;
		else return 0;
	}

	public int maxMod5(int a, int b) {
		if (a == b) return 0;
		if (b < a) {
			int temp = a;
			a = b;
			b = temp;
		}

		if (a % 5 == b % 5) {
			return a;
		} else {
			return b;
		}
	}

	public int withoutDoubles(int die1, int die2, boolean noDoubles) {
  		if (noDoubles && die1 == die2 && die1 + die2 != 12) return die1 + die2 + 1;
  		else if (noDoubles && die1 + die2 == 12) return 7;
  		else return die1 + die2;
	}


	public boolean lessBy10(int a, int b, int c) {
		//Math.abs(int) works here
  		return Math.abs(a-b) >= 10 || Math.abs(b-c) >= 10 || Math.abs(a-c) >= 10;
	}	

	public boolean lastDigit(int a, int b, int c) {
  		return a % 10 == b % 10 || a % 10 == c % 10 || b % 10 == c % 10;
	}

	public boolean inOrderEqual(int a, int b, int c, boolean equalOk) {
  		return a < b && b < c || equalOk && a <= b && b <= c;
	}

	public boolean inOrder(int a, int b, int c, boolean bOk) {
  		return b < c && (bOk || a < b);
	}

	public boolean twoAsOne(int a, int b, int c) {
  		return a + b == c || b + c == a || a + c == b;
	}

	public String fizzString2(int n) {
  		if (n % 3 == 0 && n % 5 == 0) return "FizzBuzz!";
  		else if (n % 3 == 0) return "Fizz!";
  		else if (n % 5 == 0) return "Buzz!";
  		else return String.valueOf(n) + "!";
	}

	public String fizzString(String str) {
		//startsWith(String firstLetter) and endsWith(String lastLetter) would also work
  		if (str.charAt(0) == 'f' && str.charAt(str.length() - 1) == 'b') return "FizzBuzz";
  		else if (str.charAt(0) == 'f') return "Fizz";
  		else if (str.charAt(str.length() - 1) == 'b') return "Buzz";
  		else return str; 
	}

	public int teaParty(int tea, int candy) {
  		if (tea < 5 || candy < 5) return 0;
  		else if (tea * 2 <= candy || candy * 2 <= tea) return 2;
  		else return 1;
	}

	public boolean answerCell(boolean isMorning, boolean isMom, boolean isAsleep) {
  		if (isAsleep || (isMorning && !isMom)) return false;
  		return true;
	}

	public int teenSum(int a, int b) {
  		if (a >= 13 && a <= 19 || b >= 13 && b <= 19) return 19;
  		return a + b;
	}

	public boolean nearTen(int num) {
  		return num % 10 >= 8 || num % 10 <= 2;
	}

	public boolean less20(int n) {
  		return n % 20 == 18 || n % 20 == 19;
	}

	public boolean old35(int n) {
  		return n % 3 == 0 ^ n % 5 == 0;
	}

	public boolean more20(int n) {
  		return n % 20 == 1 || n % 20 == 2;
	}

	public boolean specialEleven(int n) {
  		return n % 11 == 0 || n % 11 == 1;
	}
	
	public boolean in1To10(int n, boolean outsideMode) {
  		if (outsideMode) return n <= 1 || n >= 10;
  		return n > 0 && n <= 10;
	}

	public boolean love6(int a, int b) {
  		return a == 6 || b == 6 ||  a + b == 6 || Math.abs(a-b) == 6;
	}	

	public String alarmClock(int day, boolean vacation) {
  		if (vacation && (day == 0 || day == 6)) return "off";
		else if (!vacation && (day > 0 && day < 6)) return "7:00";
		else return "10:00";
	}

	public int sortaSum(int a, int b) {
		if (a + b >= 10 && a + b <= 19) return 20;

		return a + b;
	}

	public int caughtSpeeding(int speed, boolean isBirthday) {
  		if (isBirthday) speed -= 5;

  		if (speed <= 60) return 0;
  		else if (speed > 80) return 2;
  		else return 1;
	}

	public boolean squirrelPlay(int temp, boolean isSummer) {
  		return temp >= 60 && (temp <= 90 || isSummer && temp <= 100);
	}

	public int dateFashion(int you, int date) { //in the range of 0-10
		if (you <= 2 && you >= 0 || date <= 2 && date >= 0){
			return 0;
		} else if (you <= 10 && you >= 8 || date <= 10 && date >= 8)  {
			return 2;
		} else {
			return 1;
		}
	}

	public boolean cigarParty(int cigars, boolean isWeekend) {
  		return (isWeekend && cigars >= 40) || (cigars <= 60 && cigars >= 40);
	}

}