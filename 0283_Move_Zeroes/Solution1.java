import java.util.Arrays;

public class Solution1 {
	public static void moveZeroes(int[] nums) {
		if (nums == null || nums.length < 1) {
			return;
		}

		int nonZeroCount = 0;
		// Just swapp non-0 element to the beginning incrementally
		for (int i = 0; i < nums.length; ++i) {
			if (nums[i] != 0) {
				int temp = nums[nonZeroCount];
				nums[nonZeroCount] = nums[i];
				nums[i] = temp;
				nonZeroCount++;
			}
		}
	}

	public static void main(String[] args) {
		int[] nums = {0, 1, 0, 3, 12};
		moveZeroes(nums);
		System.out.println(Arrays.toString(nums));
	}
}