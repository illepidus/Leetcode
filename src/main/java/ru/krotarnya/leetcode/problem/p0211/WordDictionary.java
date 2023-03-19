package ru.krotarnya.leetcode.problem.p0211;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import ru.krotarnya.leetcode.Complexity;
import ru.krotarnya.leetcode.Problem;
import ru.krotarnya.leetcode.Resolution;

@Problem(id = 211, name = "design-add-and-search-words-data-structure", complexity = Complexity.MEDIUM, resolution = Resolution.TIMEOUT)
public class WordDictionary implements WordDict {
    private final Map<Integer, List<Map<Character, Set<String>>>> index;
    private final Map<Integer, Set<String>> dictionary;
    
    public WordDictionary() {
        index = new HashMap<>();
        dictionary = new HashMap<>();
    }
    
    public void addWord(String word) {
        dictionary.compute(word.length(), (k, v) -> {
            Set<String> set = (v == null) ? new HashSet<>() : v;
            set.add(word);
            return set;
        });
        
        if (!index.containsKey(word.length())) {
            index.put(word.length(), new ArrayList<>());
        }
        var list = index.get(word.length());
                
        for (int i = 0; i < word.length(); i++) {
            if (list.size() <= i)
                list.add(new HashMap<>());

            Map<Character, Set<String>> map = list.get(i);
            
            map.compute(word.charAt(i), (k, v) -> {
                Set<String> set = (v == null) ? new HashSet<>() : v;
                set.add(word);
                return set;
            });
        }
    }
    
    public boolean search(String pattern) {
        if (!pattern.contains("."))
            return dictionary.getOrDefault(pattern.length(), Set.of()).contains(pattern);
        
        Set<String> filter = new HashSet<>(dictionary.getOrDefault(pattern.length(), Set.of()));
        
        for (int i = 0; i < pattern.length(); i++) {
            if (pattern.charAt(i) != '.') {
                try {
                    filter.retainAll(index.get(pattern.length())
                            .get(i)
                            .get(pattern.charAt(i))
                    );
                }
                catch (Exception e) {
                    return false;
                }
            }
            if (filter.isEmpty()) return false;
        }
        return true;
    }
}
