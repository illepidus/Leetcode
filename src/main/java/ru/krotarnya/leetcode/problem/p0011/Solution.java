package ru.krotarnya.leetcode.problem.p0011;

import ru.krotarnya.leetcode.Complexity;
import ru.krotarnya.leetcode.Problem;

/**
 * <p>You are given an integer array height of length n.
 * There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).</p>
 * <p>Find two lines that together with the x-axis form a container,
 * such that the container contains the most water.</p>
 * <p>Return the maximum amount of water a container can store.</p>
 * <p>Notice that you may not slant the container.</p>
 */

@Problem(id = 11, name = "container-with-most-water", complexity = Complexity.MEDIUM)
public
class Solution {
    @SuppressWarnings("unused")
    public static int maxArea(int[] height) {
        return maxArea2(height);
    }

    public static int maxArea1(int[] height) {
        int max = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i; j < height.length; j++) {
                max = Math.max(max, Math.min(height[i], height[j]) * (j - i));
            }
        }
        return max;
    }

    public static int maxArea2(int[] height) {
        int max = 0;
        int left = 0;
        int right = height.length - 1;
        while (right - left > 0) {
            max = Math.max(max, Math.min(height[left], height[right]) * (right - left));
            if (height[left] > height[right])
                right--;
            else
                left++;
        }
        return max;
    }
}
