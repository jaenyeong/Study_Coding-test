package com.jaenyeong.programmers.book.ch05_sort;

import java.util.Arrays;

// [Lv1] 문자열 내 마음대로 정렬하기
// https://school.programmers.co.kr/learn/courses/30/lessons/12915
public class Solution27 {

    public String[] solution(String[] strings, int targetIdx) {
        Arrays.sort(strings, (s1, s2) -> {
            final char c1 = s1.charAt(targetIdx);
            final char c2 = s2.charAt(targetIdx);

            if (c1 != c2) {
                return Character.compare(c1, c2);
            }

            return s1.compareTo(s2);
        });

        return strings;
    }
}
