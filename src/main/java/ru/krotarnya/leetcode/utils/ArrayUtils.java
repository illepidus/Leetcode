package ru.krotarnya.leetcode.utils;

import java.util.Arrays;
import java.util.List;

public class ArrayUtils {
    public static int[] toIntArray(List<Integer> list) {
        int[] array = new int[list.size()];
        for(int i = 0; i < list.size(); i++) array[i] = list.get(i);
        return array;
    }

    public static List<Integer> toList(int[] array) {
        return Arrays.stream(array).boxed().toList();
    }
}
