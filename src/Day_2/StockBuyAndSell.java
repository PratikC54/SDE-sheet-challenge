package Day_2;

/**
 * Question link -: <a href="https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/">...</a>
 *
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 *
 * You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
 *
 * Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
 * Example 1:
 *
 * Input: prices = [7,1,5,3,6,4]
 * Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 * Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
 */

/*
Intuition:
To maximize profit, we need to buy at the lowest price and sell at the
highest price after the buy day.

Instead of checking every possible buy-sell pair, we traverse the array
once while maintaining:

1. minPrice  -> Lowest stock price seen so far.
2. maxProfit -> Maximum profit achievable so far.

For each day's price:
- Treat it as a potential selling price.
- Profit if sold today = currentPrice - minPrice.
- Update maxProfit if this profit is larger.
- Update minPrice if a lower buying price is found.

This works because at every step we already know the best buying price
available before the current day.

Example:
prices = [7, 1, 5, 3, 6, 4]

Day 1: minPrice = 7
Day 2: minPrice = 1
Day 3: profit = 5 - 1 = 4
Day 5: profit = 6 - 1 = 5 (maximum)

Answer = 5

Time Complexity: O(n)
Space Complexity: O(1)
*/

public class StockBuyAndSell {
    public static int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE,
            maxProfit = 0;
        for (int price : prices) {
            minPrice = Math.min(minPrice, price);
            maxProfit = Math.max(maxProfit, price-minPrice);
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] arr = {7,1,5,3,6,4};
        System.out.println(maxProfit(arr));
    }
}
