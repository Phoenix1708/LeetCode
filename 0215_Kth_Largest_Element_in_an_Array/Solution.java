public class Solution {
    public int findKthLargest(int[] nums, int k) {
        if (nums.length < 1) {
            return -1;
        }

        // assuming 1 ≤ k ≤ array's length
        if (nums.length == 1) {
            return nums[0];
        }

        if (nums.length == 2) {
            return (nums[k-1] < nums [0]) ? nums [k-1] : nums[0];
        }

        int left = 0;
        int right = nums.length - 1;
        while (true) {
            int pos = partition(nums, left, right);
            // if, after partitioning the pivot is happen to be k
            // then it is the kth largest
            if (pos == k - 1) return nums[pos];
            // if what we are looking for is larger than the pivot
            // i.e. it's left to the pivot, then we search the left
            // not including pos as it's not the kth largest clearly
            if (pos > k - 1) right = pos - 1;
                // likewise, we search the right
            else left = pos + 1;
        }
    }

    int partition(int[] nums, int left, int right) {
        // pick left as pivot
        int l = left + 1; // since we picked pivot
        int r = right;
        while (l <= r) {
            // swap bigger ones to the beginning
            // since we are looking for kth largest
            if (nums[l] < nums[left] && nums[r] > nums[left])
                swap(nums, l++, r--);
            // only move the left right when we determined whether
            // they are bigger, smaller or the same
            if (nums[l] >= nums[left]) l++;
            if (nums[r] <= nums[left]) r--;
        }
        swap(nums, left, r);
        // only interested in the position
        return r;
    }

    void swap(int[] nums, int l, int r) {
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }

    public static void main(String[] args) {
        int[] test = new int[] {-1,2,0};
        System.out.println(new Solution().findKthLargest(test, 3));
    }
}