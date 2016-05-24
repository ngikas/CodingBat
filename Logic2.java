public class Logic2 {

	public int makeChocolate(int small, int big, int goal) {
  		//maximum number of big bricks that can be used
		//for example, 1,4,17
		int bigLimit = goal / 5;
		//not enough bricks
		if (small + 5 * big < goal) return -1;
		//not enough small bricks
		if (goal - (bigLimit * 5) > small) return -1;
		else if (goal - (bigLimit * 5) < small) return goal - (Math.min(bigLimit, big) * 5);
		else return small;
	}

	public boolean evenlySpaced(int a, int b, int c) {
  		if (a == b && b == c) return true;
  		return  Math.abs(a-b) == Math.abs(a-c) && Math.abs(b-c) > 0 || 
          		Math.abs(b-a) == Math.abs(b-c) && Math.abs(a-c) > 0 || 
          		Math.abs(c-a) == Math.abs(c-b) && Math.abs(a-b) > 0;
	}

	public int blackjack(int a, int b) {
		//better solution
		if (a > 21) a = 0;
		if (b > 21) b = 0;
		return Math.max(a, b);

		// int which = 0;
  		// if (a > 21 && b > 21) return which;
  		// if (a > b && a <= 21) which = a;
		// if (b > a && b <= 21) which = b;
		// if (a == b && b <= 21) which = a;
		// if (a < b && b > 21) which = a;
		// if (b < a && a > 21) which = b;
		// return which;
	}

	public boolean closeFar(int a, int b, int c) {
		boolean bIsClose = true;
		boolean bIsFar = true;
		boolean cIsClose = true;
		boolean cIsFar = true;
		if (Math.abs(a-b) > 1) bIsClose = false;
		if (Math.abs(a-c) > 1) cIsClose = false;
		if (Math.abs(c-a) < 2 || Math.abs(c-b) < 2) cIsFar = false;
		if (Math.abs(b-a) < 2 || Math.abs(b-c) < 2) bIsFar = false;
		return bIsClose && cIsFar || bIsFar && cIsClose;
	}


	public int roundSum(int a, int b, int c) {
  		return round10(a) + round10(b) + round10(c);
	}

	public int round10(int num) {
		if (num % 10 < 5) return num - (num % 10); //round down
		return num + (5 - num % 5); //round up
	}

	public int noTeenSum(int a, int b, int c) {
		return fixTeen(a) + fixTeen(b) + fixTeen(c);
	}

	public int fixTeen(int n) {
		if (n >= 13 && n <= 19 && n != 15 && n != 16) return 0;
		return n;
	}

	public int luckySum(int a, int b, int c) {
		int sum = 0;
		if (a == 13) return sum;
		sum += a;
		if (b == 13) return sum;
		sum += b;
		if (c == 13) return sum;
		sum += c;
		return sum;
	}

	public int loneSum(int a, int b, int c) {
		int sum = 0;
		if (a != b && a != c) sum += a;
		if (b != a && b != c) sum += b;
		if (c != a && c != b) sum += c;
		return sum;
	}

	public boolean makeBricks(int small, int big, int goal) {
		//maximum number of bricks that can be used
		//for example, 1,4,17
		int bigLimit = goal / 5;
		//not enough bricks
		if (small + 5 * big < goal) return false;
		//not enough small bricks
		if (goal - (bigLimit * 5) > small) return false;
		return true;
	}

}