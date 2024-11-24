package ru.krotarnya.leetcode.problem.p0480;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.stream.IntStream;

/**
 * O(N, K) = (N - K) * K
 */
@SuppressWarnings({"unused", "DataFlowIssue"})
public class BetterSolution {
    private int k;
    private PriorityQueue<Integer> leftQueue;
    private PriorityQueue<Integer> rightQueue;

    public double[] medianSlidingWindow(int[] nums, int k) {
        if (k == 1) return Arrays.stream(nums).mapToDouble(x -> x).toArray();
        if (k == 2) return IntStream.range(0, nums.length - 1)
                .mapToDouble(i -> ((double) nums[i] + nums[i + 1]) / 2)
                .toArray();

        this.k = k;
        this.leftQueue = new PriorityQueue<>(k, Comparator.reverseOrder());
        this.rightQueue = new PriorityQueue<>(k, Integer::compareTo);

        for (int i = 0; i < k; i++) leftQueue.add(nums[i]);
        double[] result = new double[nums.length - k + 1];
        result[0] = median();

        for (int i = 1; i < result.length; i++) {
            int previous = nums[i - 1];
            int current = nums[i + k - 1];
            if (previous >= rightQueue.peek()) rightQueue.remove(previous);
            else leftQueue.remove(previous);
            if (current >= rightQueue.peek()) rightQueue.add(current);
            else leftQueue.add(current);
            result[i] = median();
        }

        return result;
    }

    private double median() {
        while (!Set.of(leftQueue.size(), leftQueue.size() + 1).contains(rightQueue.size())) {
            if (leftQueue.size() > rightQueue.size()) rightQueue.offer(leftQueue.poll());
            else leftQueue.offer(rightQueue.poll());
        }
        return (k % 2 == 1) ? rightQueue.peek() : ((double) leftQueue.peek() + (double) rightQueue.peek()) / 2;
    }
}
