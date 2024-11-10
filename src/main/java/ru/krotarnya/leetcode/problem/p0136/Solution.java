package ru.krotarnya.leetcode.problem.p0136;

import java.util.Arrays;

import ru.krotarnya.leetcode.Complexity;
import ru.krotarnya.leetcode.Problem;

/**
 * <p>Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.</p>
 * <p>You must implement a solution with a linear runtime complexity and use only constant extra space.</p>
 */
@Problem(id = 136, name = "single-number", complexity = Complexity.EASY)
public class Solution {
    public int singleNumber(int[] nums) {
        return Arrays.stream(nums).reduce((a, b) -> a ^ b).orElseThrow();
    }
}
