public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums.length < 1) return ans;
        
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; ++i) {
            // since array is sorted if current nums is greater than 0
            // then it is impossible to sum to 0
            if (nums[i] > 0) break;
            // skip duplicates
            if (i != 0 && nums[i] == nums[i-1]) continue;
            // preparing pointers
            int low = i + 1, high = nums.length - 1, sum = 0 - nums[i];
            
            while (low < high) {
                if (nums[low] + nums[high] == sum) {
                    ans.add(Arrays.asList(nums[i], nums[low], nums[high]));
                    // skip duplicates
                    while (low < high && (nums[low] == nums[++low])) continue;
                    while (low < high && (nums[high] == nums[--high])) continue;
                }
                // skip duplicates and non-triplet numbers
                while (low < high && nums[low] + nums[high] < sum && (nums[low] == nums[++low])) continue;
                while (low < high && nums[low] + nums[high] > sum && (nums[high] == nums[--high])) continue;
            }
        }
        return ans;
    }
}
