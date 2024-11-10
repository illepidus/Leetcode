package ru.krotarnya.leetcode.problem;

import java.util.Arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import ru.krotarnya.leetcode.problem.p0122.Solution;

public class Test0122 {
    private final Solution stock = new Solution();

    @ValueSource(strings = {
            "7,1,5,3,6,4;7",
            "1,2,3,4,5;4",
            "1,9,8,9;9",
            "1,2;1",
            "2,1;0",
            "2,2,5;3",
            "2,5,5;3",
            "2,5;3",
            "5,7,2,7,3,3,5,3,0;9",
            "7,6,4,3,1;0",
    })
    @ParameterizedTest
    void test(String data) {
        String[] dataParts = data.split(";");
        int[] input = Arrays.stream(dataParts[0].split(","))
                .filter(s -> !s.isBlank())
                .mapToInt(Integer::parseInt)
                .toArray();
        int expected = Integer.parseInt(dataParts[1]);
        Assertions.assertEquals(expected, stock.maxProfit(input));
    }
}
