/**
122. Best Time to Buy and Sell Stock II
You are given an integer array prices where prices[i] is the price of a given stock on the ith day.

On each day, you may decide to buy and/or sell the stock. You can only hold at most one share of the stock at any time. However, you can buy it then immediately sell it on the same day.

Find and return the maximum profit you can achieve.

Complexity Analysis

    Time complexity : O(n) Single pass.

    Space complexity : O(1) Constant space required.
**/
public class BestTimeToBuyAndSellStockTwo {
	public int maxProfit(int[] prices) {
		int maxProfit = 0;
		int peak = prices[0];
		int valley = prices[0];
		int index = 0;
		while(index < prices.length - 1) {
			while(index < prices.length - 1 && prices[index] >= prices[index + 1]) {
				++index;
			}
			valley = prices[index];
			while(index < prices.length - 1 && prices[index] <= prices[index + 1]) {
				++index;
			}
			peak = prices[index];

			maxProfit += peak - valley;
		}

		return maxProfit;
	}

	public int maxProfitSimple(int[] prices) {
		int maxProfit = 0;
		for(int i = 1; i < prices.length; ++i) {
			if(prices[i - 1] < prices[i]) {
				maxProfit += prices[i] - prices[i - 1];
			}
		}

		return maxProfit;
	}
}
