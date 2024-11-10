package ru.krotarnya.leetcode.problem.p0704;

import ru.krotarnya.leetcode.Complexity;
import ru.krotarnya.leetcode.Problem;

@Problem(id = 704, name = "binary-search", complexity = Complexity.EASY)
public class Solution {
    public int search(int[] nums, int target) {
        if (nums.length == 0) return -1;

        int from = 0;
        int to = nums.length - 1;

        while (from <= to) {
            int i = split(from, to);
            int val = nums[i];

            if (val == target) return i;
            if (val < target) from = i + 1; else to = i - 1;
        }

        return -1;
    }

    private int split(int from, int to) {
        return from + (to - from) / 2;
    }
}
