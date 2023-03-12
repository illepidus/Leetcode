package ru.krotarnya.leetcode.problem;

import org.junit.jupiter.api.Test;
import ru.krotarnya.leetcode.problem.p0001.Solution;
import ru.krotarnya.leetcode.util.ArrayUtils;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.shadow.com.univocity.parsers.common.ArgumentUtils.toIntArray;

class Test0001 {
    @Test
    void test() {
        assertEquals(test(List.of(1, 2), 3), List.of(0, 1));
        assertEquals(test(List.of(3, 5, 5, 11), 10), List.of(1, 2));
        assertEquals(test(List.of(3, 2, 4), 6), List.of(1, 2));
        assertEquals(test(List.of(1, 1, 1, 1, 1, 4, 1, 1, 1, 1, 1, 7, 1, 1, 1, 1, 1), 11), List.of(5, 11));
    }
    
    List<Integer> test(List<Integer> input1, int input2) {
        return ArrayUtils.toList(Solution.twoSum(toIntArray(input1), input2));
    }
}