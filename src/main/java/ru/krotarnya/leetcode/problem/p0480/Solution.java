package ru.krotarnya.leetcode.problem.p0480;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.IntStream;

import ru.krotarnya.leetcode.Complexity;
import ru.krotarnya.leetcode.Problem;
import ru.krotarnya.leetcode.Resolution;

/**
 * <p>The median is the middle value in an ordered integer list. If the size of the list is even, there is no middle
 * value. So the median is the mean of the two middle values.</p>
 * <p>You are given an integer array nums and an integer k. There is a sliding window of size k which is moving from
 * the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding
 * window moves right by one position.</p>
 * <p>Return the median array for each window in the original array. Answers within 10<sup>-5</sup> of the actual
 * value will be
 * accepted.</p>
 *
 * O(N, K) = (N - K) * log(K)
 */
@Problem(id = 480, name = "sliding-window-median", complexity = Complexity.HARD, resolution = Resolution.FAIR)
public class Solution {
    private TreeSet<Entry> leftSet;
    private TreeSet<Entry> rightSet;

    public double[] medianSlidingWindow(int[] nums, int k) {
        if (k < 1) throw new IllegalArgumentException();
        if (k == 1) return Arrays.stream(nums).mapToDouble(x -> x).toArray();
        if (k == 2) return IntStream.range(0, nums.length - 1)
                .mapToDouble(i -> ((double) nums[i] + nums[i + 1]) / 2)
                .toArray();

        this.leftSet = new TreeSet<>(Entry.comparator);
        this.rightSet = new TreeSet<>(Entry.comparator);
        List<Entry> data = IntStream.range(0, nums.length).mapToObj(i -> new Entry(i, nums[i])).toList();

        for (int i = 0; i < k; i++) leftSet.add(data.get(i));
        double[] result = new double[nums.length - k + 1];
        result[0] = median(k);

        for (int i = 1; i < result.length; i++) {
            Entry previous = data.get(i - 1);
            Entry current = data.get(i + k - 1);
            leftSet.remove(previous);
            rightSet.remove(previous);

            if (current.value >= rightSet.first().value()) rightSet.add(current);
            else leftSet.add(current);
            result[i] = median(k);
        }

        return result;
    }

    private double median(int k) {
        while (!Set.of(leftSet.size(), leftSet.size() + 1).contains(rightSet.size())) {
            if (leftSet.size() > rightSet.size()) rightSet.add(leftSet.removeLast());
            else leftSet.add(rightSet.removeFirst());
        }
        return (k % 2 == 1) ? rightSet.first().value : (leftSet.last().value + rightSet.first().value) / 2;
    }

    private record Entry(int id, double value) {
        private static final Comparator<Entry> comparator = Comparator.comparingDouble(Entry::value)
                .thenComparingInt(Entry::id);
    }
}
