class Solution(object):

    def findMedianSortedArrays(self, nums1, nums2):
        """
        Find median of 2 sorted Array by comparing array medians

        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: float
        """

        # create length variables to save function calls
        m = len(nums1)
        n = len(nums2)

        # Step 1: find median of two arrays in order to compare
        m1 = findMedian(nums1, m)
        m2 = findMedian(nums2, n)

        # if both array have same median then it is the answer
        if m1 == m2:
            return m1  # or m2
        # when m1 < m2, median must be within num1[m1 - end] -- num2[start - m2]
        # we can cut off mun1[start - m1] and num2[m2 - end]
        elif m1 < m2:
            # m1 m2 are not index so we need to find out the cut-off index.
            # Note 1: can not cut the element(s) used to get current median
            # Node 2: the number of elements cut from each array must be the
            # same
            cut_point_1 = (m % 2 == 0)? m / 2 - 1: m / 2
            cut_point_2 = n - 1 - n / 2
            k = min(cut_point_1, cut_point_2)
            return findMedianSortedArrays(self, nums1[k:m - 1], nums2[:n - k - 1])

        # The oppsite case is simliar
        elif m2 < m1:
            cut_point_2 = (n % 2 == 0)? n / 2 - 1: n / 2
            cut_point_1 = m - 1 - m / 2
            k = min(cut_point_1, cut_point_2)
            return findMedianSortedArrays(self, nums1[:m - k - 1], nums2[k:n - 1])


    def findMedian(self, nums, nums_size):
        if nums is None | | nums_size == 0:
            return None

        if nums_size % 2 == 0:
            return (nums[nums_size / 2] + nums[nums_size / 2 - 1]) / 2
        else:
            return nums[nums_size / 2]
