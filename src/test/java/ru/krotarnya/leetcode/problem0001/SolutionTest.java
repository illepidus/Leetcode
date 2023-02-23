package ru.krotarnya.leetcode.problem0001;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static ru.krotarnya.leetcode.utils.ArrayUtils.*;

class SolutionTest {

    @Test
    void test() {
        assertTrue(test(List.of(1,2,3,4,5,6,7), 3,  List.of(0,1)));
        assertTrue(test(List.of(1,2,3,4,5,6,7), 4,  List.of(0,2)));
        assertTrue(test(List.of(1,2,3,4,5,6,7), 5,  List.of(0,3)));
        assertTrue(test(List.of(1,2,3,4,5,6,7), 13, List.of(5,6)));
    }

    boolean test(List<Integer> input1, int input2, List<Integer> output) {
        List<Integer> result = toList(Solution.twoSum(toIntArray(input1), input2));
        return result.equals(output);
    }
}