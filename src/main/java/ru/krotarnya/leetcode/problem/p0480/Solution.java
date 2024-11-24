package ru.krotarnya.leetcode.problem.p0480;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.stream.IntStream;

import ru.krotarnya.leetcode.Complexity;
import ru.krotarnya.leetcode.Problem;

/**
 * <p>The median is the middle value in an ordered integer list. If the size of the list is even, there is no middle
 * value. So the median is the mean of the two middle values.</p>
 * <p>You are given an integer array nums and an integer k. There is a sliding window of size k which is moving from
 * the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding
 * window moves right by one position.</p>
 * <p>Return the median array for each window in the original array. Answers within 10<sup>-5</sup> of the actual
 * value will be
 * accepted.</p>
 */
@SuppressWarnings("DataFlowIssue")
@Problem(id = 480, name = "sliding-window-median", complexity = Complexity.HARD)
public class Solution {
    private int k;
    private PriorityQueue<Integer> leftQueue;
    private PriorityQueue<Integer> rightQueue;

    public double[] medianSlidingWindow(int[] nums, int k) {
        if (k < 1) throw new IllegalArgumentException();
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
            else if (rightQueue.size() > leftQueue.size() + 1) leftQueue.offer(rightQueue.poll());
        }
        return (k % 2 == 1) ? rightQueue.peek() : ((double) leftQueue.peek() + (double) rightQueue.peek()) / 2;
    }
}
