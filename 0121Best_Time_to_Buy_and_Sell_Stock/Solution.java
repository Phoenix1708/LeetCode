import java.lang.Math;

public class Solution {
    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
        	return 0;
        }
        
        // in case the price drop all the way
        // we should set maxProfit to prices[1] - prices[0] to
        // get the maxProfit / smallest lost this way
        int maxProfit = prices[1] - prices[0];
        int minPrice = prices[0];

        for (int i = 1; i < prices.length; ++i) {
        	// current max profile given current minPrice
        	maxProfit = Math.max(maxProfit, prices[i] - minPrice);
        	// Update the minPrice
        	minPrice = Math.min(minPrice, prices[i]);
        }

        return maxProfit;
    }

    public static void main(String[] args) {
    	// int[] prices = new int[]{7, 1, 5, 3, 6, 4};
    	int[] prices = {100, 90, 80, 70, 60};
    	System.out.println(maxProfit(new int[0]));
    }
}