package ru.krotarnya.leetcode.problem0011;

import java.util.Random;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static ru.krotarnya.leetcode.problem0011.Solution.maxArea1;
import static ru.krotarnya.leetcode.problem0011.Solution.maxArea2;

/**
 * @author ivblinov
 */
class SolutionTest {
    @Test
    void test() {
        int[] pool = new Random().ints(0, 100).limit(10).toArray();
        assertEquals(maxArea2(pool), maxArea1(pool)); 
    }
}