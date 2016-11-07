public class Solution {
    public int maxSubArray(int[] nums) {
        if (nums.length < 1) {
            return 0;
        }

        int maxAtI = nums[0];
        int currentMax = maxAtI;
        for (int i = 1; i < nums.length; ++i) {
            // Decide whether to use (start from) current number
            // or the sum of previous numbers
            // (i.e. whether to drop previous numbers)
            maxAtI = Math.max(nums[i], maxAtI + nums[i]);
            // Store the global max since maxAtI only concerns previous position
            currentMax = Math.max(maxAtI, currentMax);
        }
        return currentMax;
    }

    public static void main(String[] args) {
        int [] nums = new int[] {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(new Solution().maxSubArray(nums));
    }
}
