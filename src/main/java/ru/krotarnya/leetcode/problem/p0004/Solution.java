package ru.krotarnya.leetcode.problem.p0004;

import java.util.Arrays;
import java.util.stream.IntStream;

import ru.krotarnya.leetcode.Complexity;
import ru.krotarnya.leetcode.Problem;
import ru.krotarnya.leetcode.Resolution;

/**
 * <p>Given two sorted arrays nums1 and nums2 of size m and n respectively,
 * return the median of the two sorted arrays.</p>
 * <p>The overall run time complexity should be O(log (m+n)).</p>
 */

@Problem(id = 4, name = "median-of-two-sorted-arrays", complexity = Complexity.HARD, resolution = Resolution.PASS)
public class Solution {
    @SuppressWarnings("unused")
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        return findMedianSortedArrays2(nums1, nums2);
    }
    
    public static double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        return findMedianSortedArray(IntStream.concat(Arrays.stream(nums1), Arrays.stream(nums2)).sorted().toArray());
    }

    public static double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int size = nums1.length + nums2.length;
        int i = 0;
        int j = 0;
        int current = Integer.MIN_VALUE;
        int previous = Integer.MIN_VALUE;
        
        for (int k = 0; k <= size / 2; k++) {
            previous = current;
            if ((j == nums2.length) || (i < nums1.length && nums1[i] <= nums2[j])) {
                current = nums1[i];
                i++;
            } 
            else {
                current = nums2[j];
                j++;
            }
        }
        if (size % 2 == 0)
            return (current + previous) / 2.0;
        else
            return current;
    }
    
    private static double findMedianSortedArray(int[] nums) {
        if (nums.length % 2 == 0) {
            return (nums[nums.length / 2 - 1] + nums[nums.length / 2]) / 2.0; 
        }
        return nums[nums.length / 2];
    }
}
