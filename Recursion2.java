import java.util.*;

public class Recursion2 {
	public static void main(String[] args) {
		gcdEuclid(89, 55);
	}

	static boolean split53(int[] nums) {
		return split53(nums, 0, 0, 0);
	}

	static boolean split53(int[] nums, int lSum, int rSum, int start) {
		if (start >= nums.length) return lSum == rSum;

		if (nums[start] % 5 == 0) //always go in the left group sum
			return split53(nums, lSum + nums[start], rSum, start + 1);

		if (nums[start] % 3 == 0) //always go in the right group sum
			return split53(nums, lSum, rSum + nums[start], start + 1);

		//if neither, add to sum like normal
		return split53(nums, lSum + nums[start], rSum, start + 1) || 
				split53(nums, lSum, nums[start] + rSum, start + 1);

	}

	static boolean splitOdd10(int[] nums) {
		return splitOdd10(nums, 0, 0, 0);
	}

	static boolean splitOdd10(int[] nums, int lSum, int rSum, int start) {
		if (start >= nums.length) return lSum % 10 == 0 && rSum % 2 == 1;
		return splitOdd10(nums, lSum + nums[start], rSum, start + 1) || 
				splitOdd10(nums, lSum, nums[start] + rSum, start + 1);
	}

	static boolean splitArray(int[] nums) {
		return splitArray(nums, 0, 0, 0);
	}

	static boolean splitArray(int[] nums, int lSum, int rSum, int start) {
		if (start >= nums.length) return lSum == rSum;

		if (splitArray(nums, lSum + nums[start], rSum, start + 1)) return true;
		if (splitArray(nums, lSum, rSum + nums[start], start + 1)) return true;
		return false;

	} 

	static boolean groupSumClump(int start, int[] nums, int target) {
		if (start >= nums.length) return target == 0;

		int sum = nums[start];
		while (start < nums.length - 1 && nums[start] == nums[start + 1]) {
			start++;
			sum += nums[start];
		}

		if (groupSumClump(start + 1, nums, target - sum)) return true;

		if (groupSumClump(start + 1, nums, target)) return true;

		return false;
	}

	static boolean groupSum5(int start, int[] nums, int target) {
		//find groups of integers such that the group sums to given target
		//Rule 1: groups must include multiples of 5
		//Rule 2: if multiple of 5 is followed by a 1, that multiple must not be chosen
		if (start >= nums.length) return target == 0;

		//requires multiples of 5
		if (nums[start] % 5 == 0) {
			return groupSum5(start + 1, nums, target - nums[start]);
		}

		//if 1 is right after a multiple of 5, exclue the 1 from the group
		if (nums[start] == 1 && start > 0 && nums[start - 1] % 5 == 0) {
			return groupSum5(start + 1, nums, target);
		}

		//otherwise, choose the value or not
		if (groupSum5(start + 1, nums, target - nums[start])) return true;

		if (groupSum5(start + 1, nums, target)) return true;

		return false;

	}

	static boolean groupNoAdj(int start, int[] nums, int target) {
		if (start >= nums.length) return target == 0; //bc: checking if the start index is at the end

		if (groupNoAdj(start + 2, nums, target - nums[start])) return true;
		//start can't be chosen move to the next option
		if (groupNoAdj(start + 1, nums, target)) return true;

		return false;
	}

	static boolean groupSum6(int start, int[] nums, int target) {
		if (start >= nums.length) return target == 0; //bc: checking if the start index is at the end

		//requires 6 to be chosen every time
		if (nums[start] == 6) {
			return groupSum6(start + 1, nums, target - nums[start]);
		}

		if (groupSum6(start + 1, nums, target - nums[start])) return true;

		if (groupSum6(start + 1, nums, target)) return true;

		return false;
	}

	static boolean groupSum(int start, int[] nums, int target) {
		System.out.println("Start: " + start + " target is now: " + target);
		if (start >= nums.length) return target == 0; //bc: checking if the start index is at the end
		System.out.println("Start is less than nums length");
		if (groupSum(start + 1, nums, target - nums[start])) return true;
		System.out.println("Including " + nums[start] + " did not work");
		if (groupSum(start + 1, nums, target)) return true;
		System.out.println("Excluding " + nums[start] + " did not work");

		return false;
		
	}

	public static boolean isPalindrome(String str, int low, int high) {
		if (low >= high) {
			return true;
		} else if (str.charAt(low) != str.charAt(high)) {
			return false;
		} else {
			return isPalindrome(str, low + 1, high - 1);
		}
	}

	public static boolean recurBS(int[] ar, int leftI, int rightI, int val) {
		System.out.println(leftI + ", " + rightI + ", " + val);
		int mid = (leftI + rightI) / 2;
		if (val == ar[mid]) return true; //bc
		else if (leftI == rightI) return false; //bc
		else if (val < ar[mid]) return recurBS(ar, leftI, mid - 1, val);
		else return recurBS (ar, mid + 1, rightI, val);
	}

	public static void towerOfHanoi(int num, char fromTower, char auxTower, char toTower) {
		if (num == 1) {
			System.out.println("Moving " + num + " from " + fromTower + " to " + toTower);
		} else {
			towerOfHanoi(num - 1, fromTower, toTower, auxTower);
			System.out.println("Moving " + num + " from " + fromTower + " to " + toTower);
			towerOfHanoi(num - 1, auxTower, fromTower, toTower);
		}
	}

	public static int gcdEuclid(int m, int n) {
		System.out.println(m + " " + n);
		if (m % n == 0) return n;
		return gcdEuclid(n, m % n);
	}

	public static void mystery(int i) {
		if (i <= 0) return;
		// recursive case
		System.out.println(i);
		mystery(i - 1);
		System.out.println(i);
	}
}