class Solution(object):
    def lexicalOrder(self, n):
        """
        :type n: int
        :rtype: List[int]
        """

        answer = list()
        for i in range(1, 10):
            if i > n:
                return answer
            self.dfs(i, n, answer)
        return answer

    def dfs(self, root, n, answer):
        # visit node
        answer.append(root)
        # visit all child node
        # only 0 - 9 ten digits anyway
        next_level_node = root * 10
        for i in range(next_level_node, next_level_node + 10):
            if i > n:
                return
            self.dfs(i, n, answer)


print Solution().lexicalOrder(49999)
