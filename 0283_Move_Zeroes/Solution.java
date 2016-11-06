import java.util.Arrays;

public class Solution {
	public static void moveZeroes(int[] nums) {
		if (nums == null || nums.length < 1) {
			return;
		}

		int nonZeroCount = 0;
		// Fill the beginning of the array with non-zeros
		for (int i = 0; i < nums.length; ++i) {
			if (nums[i] != 0) {
				nums[nonZeroCount++] = nums[i];
			}
		}

		// Fill the end of the array with 0
		while (nonZeroCount < nums.length) {
			nums[nonZeroCount++] = 0;
		}
	}

	public static void main(String[] args) {
		int[] nums = {0, 1, 0, 3, 12};
		moveZeroes(nums);
		System.out.println(Arrays.toString(nums));
	}
}