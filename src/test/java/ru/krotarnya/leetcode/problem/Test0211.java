package ru.krotarnya.leetcode.problem;

import java.lang.reflect.Constructor;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import ru.krotarnya.leetcode.problem.p0211.EqualsWordDictionary;
import ru.krotarnya.leetcode.problem.p0211.MapWordDictionary;
import ru.krotarnya.leetcode.problem.p0211.SetWordDictionary;
import ru.krotarnya.leetcode.problem.p0211.WordDict;
import ru.krotarnya.leetcode.problem.p0211.WordDictionary;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Test0211 {
    @ParameterizedTest
    @ValueSource(classes = {
            WordDictionary.class,
            SetWordDictionary.class,
            MapWordDictionary.class,
            EqualsWordDictionary.class,
    })
    <T extends WordDict> void quickTest(Class<T> clazz) {
        Constructor<T> constructor;
        try {
            constructor = clazz.getConstructor();
            T wordDict = constructor.newInstance();
            quickTest(wordDict);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException("No such a constructor", e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    <T extends WordDict> void quickTest(T wordDict) {
        wordDict.addWord("bad");
        wordDict.addWord("dad");
        wordDict.addWord("mad");

        assertFalse(wordDict.search("...."));
        assertFalse(wordDict.search(".adb"));
        assertFalse(wordDict.search("pad"));
        assertTrue(wordDict.search("bad"));
        assertTrue(wordDict.search(".ad"));
        assertTrue(wordDict.search("b.."));
        assertFalse(wordDict.search(".z."));
        assertTrue(wordDict.search("..."));
        assertFalse(wordDict.search(".."));
        assertFalse(wordDict.search("."));
    }
}
