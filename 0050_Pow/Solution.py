class Solution(object):
    def myPow(self, x, n):
        """
        :type x: float
        :type n: int
        :rtype: float
        """
        absN = abs(n)
        ans = 1
        while absN > 0:
        	if absN & 1 == 1:
        		ans *= x
        	absN >>= 1
        	x *= x

        return 1/ans if n < 0 else ans

print Solution().myPow(3, 9)
