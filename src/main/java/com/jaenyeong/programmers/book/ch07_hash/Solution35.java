package com.jaenyeong.programmers.book.ch07_hash;

import java.util.HashMap;
import java.util.Map;

// [Lv0] A로 B 만들기
// https://school.programmers.co.kr/learn/courses/30/lessons/120886
public class Solution35 {
    private static final int CAN_NOT_MAKE_IT = 0;
    private static final int CAN_MAKE_IT = 1;

    public int solution(String before, String after) {
        if (before.length() != after.length()) {
            return CAN_NOT_MAKE_IT;
        }

        if (before.equals(after)) {
            return CAN_MAKE_IT;
        }

        final Map<Character, Long> beforeMap = toMap(before);
        final Map<Character, Long> afterMap = toMap(after);

        if (beforeMap.equals(afterMap)) {
            return CAN_MAKE_IT;
        }

        return CAN_NOT_MAKE_IT;
    }

    private static Map<Character, Long> toMap(String word) {
        final Map<Character, Long> charMap = new HashMap<>();

        for (Character c : word.toCharArray()) {
            final long count = charMap.getOrDefault(c, 0L) + 1L;
            charMap.put(c, count);
        }

        return charMap;
    }
}
