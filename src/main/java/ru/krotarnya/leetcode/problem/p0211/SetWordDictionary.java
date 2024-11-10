package ru.krotarnya.leetcode.problem.p0211;

import java.util.HashSet;
import java.util.Set;

public class SetWordDictionary implements WordDict {
    private final Set<String> dictionary;

    public SetWordDictionary() {
        dictionary = new HashSet<>();
    }

    @Override
    public void addWord(String word) {
        dictionary.add(word);
    }

    @Override
    public boolean search(String word) {
        if (word.contains("."))
            return dictionary.stream()
                    .map(w -> w.matches(word))
                    .reduce(false, (accumulator, element) -> accumulator || element);
        else
            return dictionary.contains(word);
    }
}
