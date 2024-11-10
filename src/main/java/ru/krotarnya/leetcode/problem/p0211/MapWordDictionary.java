package ru.krotarnya.leetcode.problem.p0211;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


public class MapWordDictionary implements WordDict {
    private final Map<Integer, Set<String>> dictionary;

    public MapWordDictionary() {
        dictionary = new HashMap<>();
    }

    @Override
    public void addWord(String word) {
        if (dictionary.containsKey(word.length())) {
            dictionary.get(word.length()).add(word);
        } else {
            HashSet<String> set = new HashSet<>();
            set.add(word);
            dictionary.put(word.length(), set);
        }
    }

    @Override
    public boolean search(String word) {
        if (word.contains("."))
            return dictionary.getOrDefault(word.length(), Set.of()).stream()
                    .map(w -> w.matches(word))
                    .reduce(false, (accumulator, element) -> accumulator || element);
        else
            return dictionary.getOrDefault(word.length(), Set.of()).contains(word);
    }
}
