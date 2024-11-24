package ru.krotarnya.leetcode.problem.p0012;

import ru.krotarnya.leetcode.Complexity;
import ru.krotarnya.leetcode.Problem;
import ru.krotarnya.leetcode.Resolution;

/**
 * <p>Given an integer, convert it to a roman numeral</p>
 * <p>1 <= num <= 3999</p>
 */

@Problem(id = 12, name = "integer-to-roman", complexity = Complexity.MEDIUM, resolution = Resolution.FAIR)
public class Solution {
    @SuppressWarnings("PointlessArithmeticExpression")
    public static String intToRoman(int num) {
        if ((num <= 0) || (num >= 4000)) throw new IllegalArgumentException("Unknown conversion");
        StringBuilder sb = new StringBuilder();

        update(sb, num / 1000 % 10, 'M', '?', '?');
        update(sb, num / 100 % 10, 'C', 'D', 'M');
        update(sb, num / 10 % 10, 'X', 'L', 'C');
        update(sb, num / 1 % 10, 'I', 'V', 'X');

        return sb.toString();
    }

    private static void update(StringBuilder sb, int digit, Character a, Character b, Character c) {
        switch (digit) {
            case 1 -> sb.append(a);
            case 2 -> sb.append(a).append(a);
            case 3 -> sb.append(a).append(a).append(a);
            case 4 -> sb.append(a).append(b);
            case 5 -> sb.append(b);
            case 6 -> sb.append(b).append(a);
            case 7 -> sb.append(b).append(a).append(a);
            case 8 -> sb.append(b).append(a).append(a).append(a);
            case 9 -> sb.append(a).append(c);
        }
    }
}
