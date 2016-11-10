class Solution(object):
    def isValid(self, s):
        """
        :type s: str
        :rtype: bool
        """
        stack = []
        matches = {'(': ')', '[': ']', '{': '}'}
        for c in s:
        	if c in matches:
        		stack.append(c)
        	elif len(stack) == 0 or matches[stack.pop()] != c:
        		return False
        return len(stack) == 0
