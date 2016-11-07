public class Solution {
    public int missingNumber(int[] nums) {
        int answer = 0;
        // XOR the given array
        for (int i = 0; i < nums.length; ++i) {
        	answer ^= nums[i];
        }
        // XOR the 0...n
        for (int i = 0; i <= nums.length; ++i) {
        	answer ^= i;
        }
        return answer;
    }
}
