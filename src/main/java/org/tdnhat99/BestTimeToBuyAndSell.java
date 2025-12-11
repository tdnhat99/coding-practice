package org.tdnhat99;

/**
 * https://neetcode.io/problems/buy-and-sell-crypto/question?list=neetcode150
 * Best Time to Buy and Sell Stock (Easy)
 * You are given an array prices where prices[i] is the price of a given stock on
 */
public class BestTimeToBuyAndSell {

    /**
     * Best Time to Buy and Sell Stock (Easy)
     * You are given an array prices where prices[i] is the price of a given stock on the ith day.
     * You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
     * Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
     *
     * @param prices
     * @return maximum profit
     */
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE; // Start with a very high buy price
        int maxProfit = 0;                // Start with 0 profit

        for (int price : prices) {
            // 1. Update minimum price if current price is lower
            if (price < minPrice) {
                minPrice = price;
            }
            // 2. Check if selling today yields a better profit
            else if (price - minPrice > maxProfit) {
                maxProfit = price - minPrice;
            }
        }

        return maxProfit;
    }
}
