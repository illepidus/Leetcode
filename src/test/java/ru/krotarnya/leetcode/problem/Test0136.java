package ru.krotarnya.leetcode.problem;

import java.util.Arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import ru.krotarnya.leetcode.problem.p0136.Solution;

public class Test0136 {
    private final Solution singleNumber = new Solution();

    @ValueSource(strings = {
            "2,2,1;1",
            "4,1,2,1,2;4",
            "1;1",
    })
    @ParameterizedTest
    void test(String data) {
        String[] dataParts = data.split(";");
        int[] input = Arrays.stream(dataParts[0].split(","))
                .filter(s -> !s.isBlank())
                .mapToInt(Integer::parseInt)
                .toArray();
        int expected = Integer.parseInt(dataParts[1]);
        Assertions.assertEquals(expected, singleNumber.singleNumber(input));
    }
}
