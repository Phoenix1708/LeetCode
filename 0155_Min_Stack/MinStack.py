import sys


class MinStack(object):

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.stack = list()
        self.min = sys.maxint

    def push(self, x):
        """
        :type x: int
        :rtype: void
        """
        if x <= self.min:
            # store current min in order to update
            # when minimal number is popped
            if not len(self.stack) == 0:
                self.stack.append(self.min)
            self.min = x

        self.stack.append(x)

    def pop(self):
        """
        :rtype: void
        """
        if not len(self.stack) == 0:
            if self.min == self.stack.pop():
                    self.min = self.stack.pop() if not len(self.stack) == 0 else sys.maxint

    def top(self):
        """
        :rtype: int
        """
        return self.stack[len(self.stack) - 1]

    def getMin(self):
        """
        :rtype: int
        """
        return self.min
