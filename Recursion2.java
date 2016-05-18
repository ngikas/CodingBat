public class Recursion2 {
	public static void main(String[] args) {
		int[] array = {2,4,8};
		System.out.println(groupSum(0, array, 10));
	}

	static boolean groupSum(int start, int[] nums, int target) {
		System.out.println("Start: " + start + " target is now: " + target);
		if (start >= nums.length) return target == 0; //bc: checking if the start index is at the end
		
		if (groupSum(start + 1, nums, target - nums[start])) return true;

		if (groupSum(start + 1, nums, target)) return true;

		return false;
		
		//
		//3 -4 false
		//2 4, 3 4 false 
		//1 8, 2 0 pause  
		//0 10 pause
	}
}