class Solution(object):
    def firstUniqChar(self, s):
        """
        :type s: str
        :rtype: int
        """

        charCount = dict()
        
        for c in s:
        	if c in charCount:
        		charCount[c] += 1
        	else:
        		charCount[c] = 1
        for i in range(len(charCount)):
        	if charCount[s[i]] == 1:
        		return i
        return -1
