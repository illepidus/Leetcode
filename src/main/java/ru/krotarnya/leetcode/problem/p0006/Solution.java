package ru.krotarnya.leetcode.problem.p0006;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

import ru.krotarnya.leetcode.Complexity;
import ru.krotarnya.leetcode.Problem;

/**
 * <p>The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:</p>
 * <pre>
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * </pre>
 * <p>And then read line by line: "PAHNAPLSIIGYIR"</p>
 * <p>Write the code that will take a string and make this conversion given a number of rows:</p>
 */

@Problem(id = 6, name = "zigzag-conversion", complexity = Complexity.MEDIUM)
public class Solution {
    /**
     * Даже не спрашивайте зачем тут мапы, стрингбилдер и стримы.
     * Когда я начинал дизайн ответа, у меня было смутное представление о решении.
     * Пусть в этой песне всё остаётся как было.
     */
    public static String convert(String s, int numRows) {
        if (numRows < 2) return s;
        Map<Integer, StringBuilder> map = new HashMap<>(numRows);

        int row = 0;
        int step = 1;
        for (int i = 0; i < s.length(); i++) {
            map.putIfAbsent(row, new StringBuilder());
            map.get(row).append(s.charAt(i));

            if (row >= numRows - 1) step = -1;
            if (row <= 0) step = 1;
            row += step;
        }

        return map.entrySet()
                .stream()
                .sorted(Comparator.comparingInt(Map.Entry::getKey))
                .map(e -> e.getValue().toString())
                .reduce("", String::concat);
    }
}
