package ru.krotarnya.leetcode.problem.p0692;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import ru.krotarnya.leetcode.Complexity;
import ru.krotarnya.leetcode.Problem;
import ru.krotarnya.leetcode.Resolution;

/**
 * <p>Given an array of strings words and an integer k, return the k most frequent strings.</p>
 * <p>Return the answer sorted by the frequency from highest to lowest. Sort the words with the same frequency by
 * their lexicographical order.</p>
 */
@Problem(id = 692, name = "top-k-frequent-words", complexity = Complexity.MEDIUM, resolution = Resolution.FAIR)
public class Solution {
    @SuppressWarnings("unused")
    public List<String> topKFrequent(String[] words, int k) {
        return Arrays.stream(words)
                .collect(Collectors.groupingBy(word -> word, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Comparator.<Map.Entry<String, Long>>comparingLong(Map.Entry::getValue)
                        .reversed()
                        .thenComparing(Map.Entry::getKey))
                .map(Map.Entry::getKey)
                .limit(k)
                .toList();
    }
}
