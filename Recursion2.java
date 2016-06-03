import java.util.*;

public class Recursion2 {
	public static void main(String[] args) {
		towerOfHanoi(5, 'A', 'B', 'C');

	}

	// static boolean groupNoAdj(int start, int[] nums, int target) {
	// 	System.out.println("GNA Index: " + start + " target is now: " + target);
	// 	if (start >= nums.length) return target == 0; //bc: checking if the start index is at the end

	// 	if (groupNoAdj(start + 2, nums, target - nums[start])) return true;

	// 	start++;

	// 	if (groupNoAdj(start + 2, nums, target - nums[start])) return true;

	// 	return false;
	// }

	static boolean groupSum6(int start, int[] nums, int target) {
		System.out.println("GS6 Index: " + start + " target is now: " + target);
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
		System.out.println("GS Index: " + start + " target is now: " + target);
		if (start >= nums.length) return target == 0; //bc: checking if the start index is at the end
		
		if (groupSum(start + 1, nums, target - nums[start])) return true;

		if (groupSum(start + 1, nums, target)) return true;

		return false;
		
		//
		//3 -4 false
		//2 4, 3 4 false 
		//1 8, 2 0 pause  
		//0 10 pause
		//
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
}