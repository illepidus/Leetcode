package ru.krotarnya.leetcode.problem.p0020;

import java.util.Map;
import java.util.Set;
import java.util.Stack;

import ru.krotarnya.leetcode.Complexity;
import ru.krotarnya.leetcode.Problem;
import ru.krotarnya.leetcode.Resolution;

/**
 * <p>Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is
 * valid.</p>
 * An input string is valid if:
 * <ol>
 * <li> Open brackets must be closed by the same type of brackets.</li>
 * <li> Open brackets must be closed in the correct order.</li>
 * <li> Every close bracket has a corresponding open bracket of the same type.</li>
 * </ol>
 */
@Problem(id = 20, name = "valid-parentheses", complexity = Complexity.EASY, resolution = Resolution.FAIR)
public class Solution {
    private static final Set<Character> OPENING_BRACKETS = Set.of('(', '{', '[');
    private static final Map<Character, Character> CLOSING_BRACKETS = Map.of(')', '(', '}', '{', ']', '[');

    @SuppressWarnings("unused")
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char curChar = s.charAt(i);
            if (OPENING_BRACKETS.contains(curChar)) {
                stack.push(curChar);
            } else if (CLOSING_BRACKETS.containsKey(curChar)) {
                try {
                    char opening = stack.pop();
                    if (!CLOSING_BRACKETS.get(curChar).equals(opening)) return false;
                } catch (Exception e) {
                    return false;
                }
            } else {
                return false;
            }
        }

        return stack.isEmpty();
    }
}
