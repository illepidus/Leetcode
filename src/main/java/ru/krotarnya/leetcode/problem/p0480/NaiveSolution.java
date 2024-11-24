package ru.krotarnya.leetcode.problem.p0480;

import java.util.Arrays;

@SuppressWarnings("unused")
public class NaiveSolution {
    public double[] medianSlidingWindow(int[] nums, int k) {
        double[] result = new double[nums.length - k + 1];
        for (int i = 0; i < result.length; i++) {
            result[i] = median(nums, k, i);
        }
        return result;
    }

    private double median(int[] nums, int k, int from) {
        int[] sorted = Arrays.stream(nums, from, from + k)
                .sorted()
                .toArray();

        if (sorted.length % 2 != 0)
            return sorted[sorted.length / 2];

        return ((double) sorted[sorted.length / 2] + (double) sorted[sorted.length / 2 - 1]) / 2;
    }
}
