package ru.krotarnya.leetcode.problem;

import java.util.List;
import java.util.Set;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import ru.krotarnya.leetcode.problem.p0022.Solution;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static ru.krotarnya.leetcode.problem.p0022.Solution.generateParenthesisPrecalculated;
import static ru.krotarnya.leetcode.problem.p0022.Solution.generateParenthesisRecursive;

public class Test0022 {
    @ValueSource(strings = {"", "()", "()()", "(())"})
    @ParameterizedTest
    void validateParenthesisTestTrue(String s) {
        assertTrue(validateParenthesis(s));
    }

    @ValueSource(strings = {"(", ")", "((", ")(", "))", "((()", ")()("})
    @ParameterizedTest
    void validateParenthesisTestFalse(String s) {
        assertFalse(validateParenthesis(s));
    }

    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8})
    @ParameterizedTest
    void generateParenthesisRecursiveTest(int n) {
        List<String> result = generateParenthesisRecursive(n);
        assertEquals(result.size(), Set.copyOf(result).size());
        result.forEach(s -> assertTrue(validateParenthesis(s)));
    }

    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8})
    @ParameterizedTest
    void generateParenthesisPrecalculatedTest(int n) {
        assertEquals(generateParenthesisRecursive(n), generateParenthesisPrecalculated(n));
    }

    boolean validateParenthesis(String s) {
        return Solution.validateParenthesis(s.toCharArray());
    }
}
