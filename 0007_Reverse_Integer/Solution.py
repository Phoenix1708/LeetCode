class Solution(object):
    def reverse(self, x):
        """
        :type x: int
        :rtype: int
        """
        answer = 0
        while x > 0:
            answer = answer * 10 + x % 10
            x /= 10

        return 0 if answer > sys.maxint or answer < -sys.maxint else answer
            
        