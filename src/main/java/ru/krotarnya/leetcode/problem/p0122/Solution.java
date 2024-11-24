package ru.krotarnya.leetcode.problem.p0122;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

import ru.krotarnya.leetcode.Complexity;
import ru.krotarnya.leetcode.Problem;
import ru.krotarnya.leetcode.Resolution;

/**
 * <p>You are given an integer array prices where prices[i] is the price of a given stock on the ith day.</p>
 * <p>On each day, you may decide to buy and/or sell the stock. You can only hold at most one share of the stock at
 * any time. However, you can buy it then immediately sell it on the same day.</p>
 * <p>Find and return the maximum profit you can achieve.</p>
 */
@Problem(id = 122,
        name = "best-time-to-buy-and-sell-stock-ii",
        complexity = Complexity.MEDIUM,
        resolution = Resolution.FAIR)
public class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length <= 2) return maxProfitUnsafe(prices);

        AtomicInteger prevPrice = new AtomicInteger(prices[0] + 1);
        return maxProfitUnsafe(Arrays.stream(prices)
                .filter(price -> price != prevPrice.get())
                .peek(prevPrice::set)
                .toArray());
    }

    public int maxProfitUnsafe(int[] prices) {
        if (prices.length <= 1) return 0;
        if (prices.length == 2) return Math.max(0, prices[1] - prices[0]);

        Action[] actions = new Action[prices.length];
        actions[0] = (prices[0] < prices[1]) ? Action.BUY : Action.NOTHING;

        actions[prices.length - 1] = (prices[prices.length - 1] > prices[prices.length - 2])
                ? Action.SELL
                : Action.NOTHING;

        for (int i = 1; i < actions.length - 1; i++) {
            if ((prices[i] < prices[i - 1]) && (prices[i] < prices[i + 1])) {
                actions[i] = Action.BUY;
            } else if ((prices[i] > prices[i - 1]) && (prices[i] > prices[i + 1])) {
                actions[i] = Action.SELL;
            } else {
                actions[i] = Action.NOTHING;
            }
        }

        int profit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (actions[i] == Action.BUY) profit -= prices[i];
            else if (actions[i] == Action.SELL) profit += prices[i];
        }

        return profit;
    }

    private enum Action {
        NOTHING,
        BUY,
        SELL
    }
}
