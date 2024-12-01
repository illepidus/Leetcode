package ru.krotarnya.leetcode.problem.p0056;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import ru.krotarnya.leetcode.Complexity;
import ru.krotarnya.leetcode.Problem;
import ru.krotarnya.leetcode.Resolution;

/**
 * Given an array of intervals where intervals[i] = [start<sub>i</sub>, end<sub>i</sub>], merge all overlapping
 * intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.
 */
@Problem(id = 56, name = "merge-intervals", complexity = Complexity.MEDIUM, resolution = Resolution.FAIR)
public class Solution {
    @SuppressWarnings("unused")
    public int[][] merge(int[][] intervals) {
        List<int[]> mergedIntervals = new ArrayList<>();

        Arrays.stream(intervals)
                .sorted(Comparator.comparingInt(i -> i[0]))
                .forEach(current -> {
                    if (mergedIntervals.isEmpty()) {
                        mergedIntervals.add(current);
                        return;
                    }

                    int[] last = mergedIntervals.getLast();
                    if (current[0] > last[1]) {
                        mergedIntervals.add(current);
                        return;
                    }

                    last[1] = Math.max(last[1], current[1]);
                });

        return mergedIntervals.toArray(new int[mergedIntervals.size()][]);
    }
}
