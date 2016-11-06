class Solution(object):
    def lexicalOrder(self, n):
        """
        :type n: int
        :rtype: List[int]
        """
        answer = list()
        # find the next number to add
        num = 1
        for i in range(1, n+1):
            # e.g 45
            answer.append(num)
            # 450 - going down the tree level
            if num * 10 <= n:
                num *= 10
            # when reached the lowest level
            # find node alone breadth
            # (left to right at this level)
            # until we reach the end of current branch i.e. 499
            elif num % 10 != 9 and num + 1 <= n:
                num += 1
            # When reached the edge we need to go
            # back up i.e. find the next upper level number
            # which is not on the edge
            else:
                # num / 10 --> going up one level
                num /= 10
                # while we still on the end
                while num % 10 == 9:
                    num /= 10
                # We should be up to the next "parent" level now
                # hence go to next parent level e.g. from tree of '5'
                # to tree of '6'
                num += 1
        return answer

# print Solution().lexicalOrder(49999)
