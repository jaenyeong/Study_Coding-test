package com.jaenyeong.programmers.book.ch07_hash;

import java.util.HashSet;
import java.util.Set;

// [Lv0] 중복된 문자 제거
// https://school.programmers.co.kr/learn/courses/30/lessons/120888
public class Solution34 {

    public String solution(String word) {
        final StringBuilder result = new StringBuilder();
        final Set<Character> seenChars = new HashSet<>();

        for (char c : word.toCharArray()) {
            if (!seenChars.contains(c)) {
                seenChars.add(c);
                result.append(c);
            }
        }

        return result.toString();
    }
}
