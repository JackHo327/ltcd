package Algos;

public class OneTwoTwo_Best_Time_to_Buy_and_Sell_Stock_II {

	public static void main(String[] args) {
		int i = maxProfit(new int[] { 2, 0, 2, 1, 2 });
	}

	public static int maxProfit(int[] prices) {

		if (prices == null || prices.length == 0) {
			return 0;
		}

		// greedy algorithm

		// int total = 0;

		// for(int i = 0; i < prices.length-1; i++){
		// if(prices[i+1] > prices[i]) total+=(prices[i+1]-prices[i]);
		// }

		// return total;

		// in case the greedy algorithm is banned
		// use the algorithm below

		// find the local min and maximum and do subtractions
		// add the result to profit
		// loop the process until traversed all elements
		int profit = 0, i = 0;
		while (i < prices.length) {
			// find next local minimum
			while (i < prices.length - 1 && prices[i + 1] <= prices[i])
				i++;
			int min = prices[i++]; // need increment to avoid infinite loop for
			                       // "[1]"
			// find next local maximum
			while (i < prices.length - 1 && prices[i + 1] >= prices[i])
				i++;
			profit += i < prices.length ? prices[i++] - min : 0;
		}
		return profit;
	}

}
