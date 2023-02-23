package ru.krotarnya.leetcode.problem0001;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static ru.krotarnya.leetcode.utils.ArrayUtils.*;

class SolutionTest {
    @Test
    void test() {
        assertEquals(test(List.of(1, 2), 3), List.of(0, 1));
        assertEquals(test(List.of(3, 5, 5, 11), 10), List.of(1, 2));
        assertEquals(test(List.of(3, 2, 4), 6), List.of(1, 2));
        assertEquals(test(List.of(1, 1, 1, 1, 1, 4, 1, 1, 1, 1, 1, 7, 1, 1, 1, 1, 1), 11), List.of(5, 11));
    }

    List<Integer> test(List<Integer> input1, int input2) {
        return toList(Solution.twoSum(toIntArray(input1), input2));
    }
}