class Solution(object):

    def maxProfit(self, prices):
        """
        :type prices: List[int]
        :rtype: int
        """
        if prices is None or len(prices) <= 1:
            return 0

        maxProfit = 0
        minPrice = prices[0]

        for i in range(1, prices.length):
        	maxProfit = max(maxProfit, prices[i] - minPrice)
        	minPrice = min(minPrice, prices[i])

        return maxProfit
