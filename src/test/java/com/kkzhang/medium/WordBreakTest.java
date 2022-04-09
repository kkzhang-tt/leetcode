package com.kkzhang.medium;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class WordBreakTest {
    private WordBreak solution = new WordBreak();

    @Test
    public void testWordBreak() {
        String s = "leetcode";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("leet");
        wordDict.add("code");
        System.out.println(solution.wordBreak(s, wordDict));
    }

    @Test
    public void testWordBreak_1() {
        String s = "applepenapple";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("apple");
        wordDict.add("pen");
        System.out.println(solution.wordBreak(s, wordDict));
    }

    @Test
    public void testWordBreak_2() {
        String s = "catsandog";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("cats");
        wordDict.add("dog");
        wordDict.add("sand");
        wordDict.add("and");
        wordDict.add("cat");
        System.out.println(solution.wordBreak(s, wordDict));
    }
}
