package ru.krotarnya.leetcode.problem;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static ru.krotarnya.leetcode.problem.p0012.Solution.intToRoman;
import static ru.krotarnya.leetcode.problem.p0013.Solution.romanToInt;

class Test0012 {
    @ValueSource(ints = {1, 2, 3, 9, 36, 72, 100, 135, 525, 759, 1001, 3999})
    @ParameterizedTest
    void test(int num) {
        assertEquals(num, romanToInt(intToRoman(num)));
    }
}