package ru.krotarnya.leetcode.problem.p0211;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Тут поломан контракт метода equals. Да и смысла от такой реализации немного,
 * потому что функция hash() порождает слишком много коллизий. 
 */
public class EqualsWordDictionary implements WordDict {
    private final Set<Wildcard> dictionary;
    public EqualsWordDictionary() {
        dictionary = new HashSet<>();
    }

    @Override
    public void addWord(String word) {
        dictionary.add(Wildcard.of(word));
    }

    @Override
    public boolean search(String word) {
        return dictionary.contains(Wildcard.of(word));
    }

    private static class Wildcard {
        private final String value;
        private final boolean isWildcard;

        private Wildcard(String value) {
            this.value = value;
            this.isWildcard = value.contains(".");
        }

        public static Wildcard of(String value) {
            return new Wildcard(value);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Wildcard that = (Wildcard) o;
            if (this.isWildcard && that.isWildcard) throw new UnsupportedOperationException();
            if (!this.isWildcard && !that.isWildcard) return Objects.equals(this.value, that.value);
            if (this.value.length() != that.value.length()) return false;

            String word = (isWildcard) ? that.value : this.value;
            String pattern = (isWildcard) ? this.value : that.value;

            return word.matches(pattern);
        }

        @Override
        public int hashCode() {
            return value.length();
        }
    }
}
