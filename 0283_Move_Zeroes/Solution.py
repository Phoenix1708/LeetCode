class Solution(object):
    def moveZeroes(self, nums):
        """
        :type nums: List[int]
        :rtype: void Do not return anything, modify nums in-place instead.
        """
        nonZeroCount = 0;

        for i in range(0, len(nums)):
        	if nums[i] != 0:
        		temp = nums[nonZeroCount]
        		nums[nonZeroCount] = nums[i]
        		nums[i] = temp
        		nonZeroCount += 1
