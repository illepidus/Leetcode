package ru.krotarnya.leetcode.problem.p0001;

import java.util.HashMap;

import ru.krotarnya.leetcode.Complexity;
import ru.krotarnya.leetcode.Problem;
import ru.krotarnya.leetcode.Resolution;

/**
 * <p>Given an array of integers nums and an integer target,
 * return indices of the two numbers such that they add up to target.</p>
 * <p>You may assume that each input would have exactly one solution, and you may not use the same element twice.</p>
 * <p>You can return the answer in any order.</p>
 */
@Problem(id = 1, name = "two-sum", complexity = Complexity.EASY, resolution = Resolution.FAIR)
public class Solution {
    public static int[] twoSum(int[] nums, int target) {
        return solution2(nums, target);
    }

    @SuppressWarnings("unused")
    public static int[] solution1(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) return new int[]{i, j};
            }
        }
        return new int[]{};
    }

    public static int[] solution2(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) map.put(nums[i], i);
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i]) && i != map.get(target - nums[i])) {
                return new int[]{i, map.get(target - nums[i])};
            }
        }
        return new int[]{};
    }
}
