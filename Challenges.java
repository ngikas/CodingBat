import java.util.*;
import java.text.*;

public class Challenges {
	public static void main(String[] args) {
	}

	public static void estimatePi(long n) {
		System.out.println("i\tm(i)");
		System.out.println("-----------------");
		int four = 4;
		double fractions = 0;
		for (int i = 1; i <= n; i++) {
			fractions += (double) (Math.pow(-1, i + 1) / (2 * i - 1)); 
			double pi = four * fractions;
			if (i % 100 == 1) System.out.println(i + "\t" + String.format("%.15f", pi));
		}
		System.out.println("PI:\t" + Math.PI);
	}

	public static void sumSeries(int n) {
		System.out.println("i\tm(i)");
		System.out.println("-----------------");
		double product = 0;
		for (int i = 1; i <= n; i++) {
		 	product += ((double) i / ((double)i + 1));
			System.out.println(i + "\t" + String.format("%.4f", product)); //.format method returns a string
		}
	}

	public static double futureInvestmentValue(double investmentAmount, double monthlyInterestRate, int years) {
		System.out.println("Years\tFuture Value");
		double rate = monthlyInterestRate / 1200;
		
		for (int i = 1; i <= years; i++) {	
			double increasedAmount = investmentAmount * Math.pow(rate + 1, i * 12);
			System.out.println(i + "\t" + String.format("%.2f", increasedAmount));
		}
		return investmentAmount; //final investment amount
	}

	public static void displayPattern(int n) {
		for (int i = 1; i <= n; i++) {
			for (int j = n; j > 0; j--) {
				if (j > i) System.out.print(" " + " ");
				else System.out.print(j + " ");
			}
			System.out.println();
		}
	}

	public static boolean isPalindrome(int number) {
		return number == reverse(number);
	}

	// Return the reversal of an integer, i.e., reverse(456) returns 654
	public static int reverse(int number) {
		StringBuilder rev = new StringBuilder();
		while (number > 0) {
			rev.append(number % 10);
			number /= 10;
		}

		return Integer.parseInt(rev.toString());
	}

	public static int getPentagonalNumber(int n) {
		return ((n * n * 3) - n) / 2;
	}

	static boolean balanced(String text) {
		Stack<Character> stack = new Stack<>();
	   	for (int i = 0; i < text.length(); i++) {
	   	char c = text.charAt(i);
			if (c == '(' || c == '[' || c == '{') {
				stack.push(c);
			} else if (c == ')') {
				if (stack.empty() || stack.pop() != '(') return false;
			} else if (c == ']') {
				if (stack.empty() || stack.pop() != '[') return false;
			} else if (c == '}') {
				if (stack.empty() || stack.pop() != '{') return false;
			}
		}
		return stack.empty();
	}

	static int slidingMax(int[] array, int k) {
		int max = Integer.MIN_VALUE;
		LinkedList<Integer> queue = new LinkedList<>();
		int n = 0;
		int whereMaxIs = 0;
		int count = 0;
		while (n < k) {
			count++;
			queue.offer(array[n]);
			if (array[n] > max) {
				max = array[n];
				whereMaxIs = n;
			}
			n++;
		}
		System.out.print(max + " ");
		for (int i = n; i < array.length; i++) {
			System.out.println(queue.toString());
			count++;
			if (queue.poll() == max) {
				queue.clear();
				max = Integer.MIN_VALUE;
				n = whereMaxIs + 1;
				int val = n;
				while (n < array.length && n < k + val) {
					queue.offer(array[n]);
					if (array[n] > max) {
						max = array[n];
						whereMaxIs = n;
					}
					n++;
				}
				i = n - 1;
				System.out.print(max + " ");
			} else {
				//if max is not the value that is polled off, 
				//just compare max to the next value to be offered
				queue.offer(array[i]);
				if (array[i] > max) {
					max = array[i];
					whereMaxIs = i;
				}
				System.out.print(max + " ");
			}
		}

		return count;
	}

	static void decimalToBinary(long n) { //works for only positive values
		Stack<Long> stack = new Stack<>();
		int count = 0;
		while (n > 0) {
			count++;
			stack.push(n % 2);
			n /= 2;
		}
		for (int i = 0; i < count; i++) {
			System.out.print(stack.pop());
		}
		System.out.println();
	}

	static int decimalToBinary(int n) {
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        int mostConsecutiveOnes = 0;
        while (n > 0) {
        	System.out.println("CHECKING " + n);
            stack.push(n % 2);
            if (n % 2 == 1) {
                mostConsecutiveOnes++;
                System.out.println("MCO " + mostConsecutiveOnes);
                max = Math.max(max, mostConsecutiveOnes);
            } else {
                mostConsecutiveOnes = 0;
            }
            n /= 2;
        }
        return max;
    }
}