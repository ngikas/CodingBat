public class Recursion2 {
	public static void main(String[] args) {
		int[] array = {2,5,10,4};
		System.out.println(groupNoAdj(0, array, 7));

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
}