/**
121. Best Time to Buy and Sell Stock
You are given an array prices where prices[i] is the price of a given stock on the ith day.

You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.

Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
**/
public class BestTimeToBuyAndSellStock {
	public int maxProfit(int[] prices) {
		int max = 0;
		int curr = prices[0];
		for(int i = 1; i < prices.length; ++i) {
			if(prices[i] <= curr) {
				curr = prices[i];
			} else {
				max = Math.max(max, prices[i] - curr);
			}
		}

		return max;
	}
}
