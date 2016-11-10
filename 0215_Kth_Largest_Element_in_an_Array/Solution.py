class Solution(object):

    def findKthLargest(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """
        # assuming 1 ≤ k ≤ array's length
        if len(nums) == 1:
        	return nums[0]

        if len(nums) == 2:
        	return nums[0] if nums[k - 1] > nums[0] else nums[1]

        left = 0;
        right = len(nums) - 1
        while true:
        	pos = partition(nums, left, right)
        	if pos == k - 1:
        		return nums[pos]
        	# the rank of the element we want is higher
        	# than the ranking of pivot, we search left
        	if pos > k - 1:
        		right = pos - 1
            else: 
                left =  pos + 1

     def partition(self, nums, left, right):
     	# pick left as pivot
     	l = left + 1
     	r = right
     	while l <= r:
     		if nums[l] < nums[left] && nums[r] > nums[left]:
     			# swap
     			nums[l], nums[r] = nums[l++], nums[r--]

     		if nums[l] > nums[left]: l++
     		if nums[r] < nums[right]: r--
     	# swap pivot
     	nums[left], nums[r] = nums[r], nums[left]
     	return r     	
