package ru.krotarnya.leetcode.problem0003;

import java.util.HashMap;
import java.util.Map;

import ru.krotarnya.leetcode.Problem;

/**
 * Given a string s, find the length of the longest
 * substring without repeating characters.
 */

@Problem(id = 3, name = "longest-substring-without-repeating-characters")
class Solution {
    public static int lengthOfLongestSubstring(String s) {
        int longest = 0;
        int j = 0;
        Map<Character, Integer> charmap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            charmap.putIfAbsent(s.charAt(i), 0);
            charmap.put(s.charAt(i), charmap.get(s.charAt(i)) + 1);
            if (charmap.size() == i - j + 1)
                longest = Math.max(longest, i - j + 1);
            else for (; charmap.size() != i - j + 1; j++)
                if (charmap.get(s.charAt(j)) == 1) 
                    charmap.remove(s.charAt(j));
                else
                    charmap.put(s.charAt(j), charmap.get(s.charAt(j)) - 1);
        }

        return longest;
    }
}