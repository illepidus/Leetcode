package ru.krotarnya.leetcode.problem;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static ru.krotarnya.leetcode.problem.p0004.Solution.findMedianSortedArrays1;
import static ru.krotarnya.leetcode.problem.p0004.Solution.findMedianSortedArrays2;

/**
 * @author ivblinov
 */
class Test0004 {
    @Test
    void testEven1() {
        int[] nums1 = {1, 2, 3, 4, 5, 6};
        int[] nums2 = {};
        assertEquals(findMedianSortedArrays1(nums1, nums2), findMedianSortedArrays2(nums1, nums2));
    }

    @Test
    void testEven2() {
        int[] nums1 = {};
        int[] nums2 = {1, 2, 3, 4, 5, 6};
        assertEquals(findMedianSortedArrays1(nums1, nums2), findMedianSortedArrays2(nums1, nums2));
    }

    @Test
    void testEven3() {
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};
        assertEquals(findMedianSortedArrays1(nums1, nums2), findMedianSortedArrays2(nums1, nums2));
    }

    @Test
    void testEven4() {
        int[] nums1 = {1, 5, 17, 44, 45, 46, 100};
        int[] nums2 = {6, 7, 13, 46, 50};
        assertEquals(findMedianSortedArrays1(nums1, nums2), findMedianSortedArrays2(nums1, nums2));
    }

    @Test
    void testEven5() {
        int[] nums1 = {1};
        int[] nums2 = {2};
        assertEquals(findMedianSortedArrays1(nums1, nums2), findMedianSortedArrays2(nums1, nums2));
    }

    @Test
    void testOdd1() {
        int[] nums1 = {-1};
        int[] nums2 = {};
        assertEquals(findMedianSortedArrays1(nums1, nums2), findMedianSortedArrays2(nums1, nums2));
    }

    @Test
    void testOdd2() {
        int[] nums1 = {};
        int[] nums2 = {-5};
        assertEquals(findMedianSortedArrays1(nums1, nums2), findMedianSortedArrays2(nums1, nums2));
    }

    @Test
    void testOdd3() {
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        assertEquals(findMedianSortedArrays1(nums1, nums2), findMedianSortedArrays2(nums1, nums2));
    }

    @Test
    void testOdd4() {
        int[] nums1 = {1, 2, 3, 4};
        int[] nums2 = {5, 6, 7, 8, 9};
        assertEquals(findMedianSortedArrays1(nums1, nums2), findMedianSortedArrays2(nums1, nums2));
    }

    @Test
    void testOdd5() {
        int[] nums1 = {1, 2, 4, 7};
        int[] nums2 = {3, 5, 6, 8, 9};
        assertEquals(findMedianSortedArrays1(nums1, nums2), findMedianSortedArrays2(nums1, nums2));
    }
}
