package com.jaenyeong.programmers.book.ch05_sort;

import java.util.Collections;

// [Lv1] 문자열 내림차순으로 배치하기
// https://school.programmers.co.kr/learn/courses/30/lessons/12917
public class Solution26 {

    public String solution(String s) {
        return s.chars()
            .boxed()
            .sorted(Collections.reverseOrder())
            .collect(
                StringBuilder::new,
                StringBuilder::appendCodePoint,
                StringBuilder::append
            )
            .toString();
    }
}
