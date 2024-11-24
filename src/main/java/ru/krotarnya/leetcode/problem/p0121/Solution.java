package ru.krotarnya.leetcode.problem.p0121;

import ru.krotarnya.leetcode.Complexity;
import ru.krotarnya.leetcode.Problem;
import ru.krotarnya.leetcode.Resolution;

/**
 * <p>You are given an array prices where prices[i] is the price of a given stock on the ith day.</p>
 * <p>You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the
 * future to sell that stock.</p>
 * <p>Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.</p>
 */
@Problem(id = 121, name = "best-time-to-buy-and-sell-stock", complexity = Complexity.EASY, resolution = Resolution.FAIR)
public class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;

        int[] maxPricesAfter = new int[prices.length];
        int maxPriceAfter = 0;
        for (int i = prices.length - 1; i >= 0 ; i--) {
            maxPriceAfter = Math.max(maxPriceAfter, prices[i]);
            maxPricesAfter[i] = maxPriceAfter;
        }

        int bestDeal = 0;
        for (int i = 0; i < prices.length; i++) {
            bestDeal = Math.max(bestDeal, maxPricesAfter[i] - prices[i]);
        }

        return bestDeal;
    }
}
