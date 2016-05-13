public class Recursion2 {
	public static void main(String[] args) {
		int[] array = {2,4,8};
		System.out.println(groupSum(0, array, 10));
	}

	static boolean groupSum(int start, int[] nums, int target) {
		System.out.println("Checking index " + start + " on nums with target " + target);
		if (start >= nums.length) return target == 0; //bc

		if (groupSum(start + 1, nums, target - nums[start])) {
			System.out.println("1. Target has been reached. " + target);
			return true;
		}
			
		if (groupSum(start + 1, nums, target)) {
			System.out.println("2. Target has been reached. " + target);
			return true;
		} 

		System.out.println("Target cannot be reached. " + target);
		return false;
	}
}