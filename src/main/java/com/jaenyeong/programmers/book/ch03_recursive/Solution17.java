package com.jaenyeong.programmers.book.ch03_recursive;

import java.util.ArrayList;
import java.util.List;

// [Lv2] 모음 사전
// https://school.programmers.co.kr/learn/courses/30/lessons/84512
public class Solution17 {
    private static final char[] keywords = "AEIOU".toCharArray();

    public int solution(String word) {
        final List<String> words = new ArrayList<>();

        generateKeywords("", words);

        return words.indexOf(word);
    }

    private void generateKeywords(String prefixWord, List<String> words) {
        words.add(prefixWord);

        if (prefixWord.length() == 5) {
            return;
        }

        for (char keyword : keywords) {
            generateKeywords(prefixWord + keyword, words);
        }
    }
}
