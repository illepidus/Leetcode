package ru.krotarnya.leetcode.util;

import java.util.Arrays;
import java.util.List;

public class ArrayUtils {
    public static List<Integer> toList(int[] array) {
        return Arrays.stream(array).boxed().toList();
    }
}
