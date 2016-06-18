import java.util.*;

public class Challenges {
	public static void main(String[] args) {
		decimalToBinary(7770);
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
}