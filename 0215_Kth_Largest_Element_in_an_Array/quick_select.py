class Solution(object):

    def findKthLargest(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """
        pivot = nums[0]
        smaller = [l for l in nums if l < pivot]
        equal   = [e for e in nums if e == pivot]
        bigger  = [r for r in nums if r > pivot]

        # If the kth is within those bigger ones
        if k <= len(bigger):
        	return self.findKthLargest(bigger, k)
        # If the kth is outside the biggers but within
        # the range of those equals
        elif k - len(bigger) <= len(equal):
        	return equal[0]
        # Else the kth is in the smaller group
        # and the rank i.e. the 'k' of this number we want
        # within the smaller group is whatever that is left 
        # after we passed all bigger and equal elements imagine 
        # all elements are sorted in descending order
        else:
        	return self.findKthLargest(smaller, k - len(bigger) - len(equal))

