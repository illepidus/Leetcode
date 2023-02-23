package ru.krotarnya.leetcode.problem0011;

/**
 * @author ivblinov
 */
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