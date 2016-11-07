class Solution(object):
    def mySqrt(self, x):
        """
        :type x: int
        :rtype: int
        """
        if x < 2:
        	return x

        start = 0;
        end = x;
        while start != end-1:
        	mid = (start + end) / 2
        	if x/mid == mid:
        		return mid
        	elif x/mid < mid:
        		end = mid
        	else:
        		start = mid

        # sqrt(2) 1.414 hence 1
        return start
