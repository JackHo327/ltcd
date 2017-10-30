package Algos;

/*
say you have an array for which the ith element is the price of a given stock on day i.
If you were only permitted to complete at most one transaction 
(ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.
*/

// Time Limit Exceeded
public class OneTwoOne_Best_Time_Two_Buy_and_Sell_Stock {
	public int maxProfit(int[] prices) {

		int max = 0;

		for (int i = 0; i < prices.length; i++) {
			for (int k = i + 1; k < prices.length; k++) {

				if (prices[k - 1] == prices[k]) {
					continue;
				}

				if (prices[k] - prices[i] > max) {
					max = prices[k] - prices[i];
				}

			}
		}

		return max;

	}
}
// Complexity Analysis:
// Time complexity : O(n^2)
// 鈥嬧�婰oop runs (n-1)/2 times.
// 鈥婼pace complexity : O(1).
// Only two variables - maxprofit and profit are used.

// Suggested Answer:
// public class Solution {
// public int maxProfit(int prices[]) {
// int minprice = Integer.MAX_VALUE;
// int maxprofit = 0;
// for (int i = 0; i < prices.length; i++) {
// if (prices[i] < minprice)
// minprice = prices[i];
// else if (prices[i] - minprice > maxprofit)
// maxprofit = prices[i] - minprice;
// }
// return maxprofit;
// }
// }
// Complexity Analysis
// Time complexity : O(n).
// Only a single pass is needed.
// Space complexity : O(1).
// Only two variables are used.