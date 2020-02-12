package com.algorithms.misc;

/**
 * @author - navsinn
 * @date - Jan 05, 2019
 * https://www.geeksforgeeks.org/stock-buy-sell/
 */
public class StockBuySell {
    public static void main(String[] args) {
        int[] prices = {1, 2};
        System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {
        int maxProfit = 0, i = 0, buy, sell;
        if (prices.length <= 1)
            return 0;

        while (i < prices.length) {
            while ((i < prices.length - 1) && (prices[i] >= prices[i + 1]))
                i++;
            buy = prices[i++];

            if(i >= prices.length)
                break;

            while ((i < prices.length - 1) && (prices[i + 1] >= prices[i]))
                i++;
            sell = prices[i++];
            maxProfit += sell - buy;
        }

        return maxProfit;
    }
}
