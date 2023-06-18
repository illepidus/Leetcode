package ru.krotarnya.leetcode.problem;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import ru.krotarnya.leetcode.problem.p0038.Solution;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Test0038 {
    private static final Solution SOLUTION = new Solution();
    @CsvSource({
            "1,  1",
            "2,  11",
            "3,  21",
            "4,  1211",
            "5,  111221",
            "6,  312211",
            "7,  13112221",
            "8,  1113213211",
            "9,  31131211131221",
            "10, 13211311123113112211",
            "11, 11131221133112132113212221",
            "12, 3113112221232112111312211312113211",
            "13, 1321132132111213122112311311222113111221131221",
            "14, 11131221131211131231121113112221121321132132211331222113112211",
            "15, 311311222113111231131112132112311321322112111312211312111322212311322113212221",
    })
    @ParameterizedTest
    void test(Integer n, String expected) {
        assertEquals(expected, SOLUTION.countAndSay(n));
    }
}
