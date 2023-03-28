package com.jaenyeong.programmers.book.ch02_string;

// [Lv1] 문자열 다루기 기본
// https://school.programmers.co.kr/learn/courses/30/lessons/12918
public class Solution13 {

    public boolean solution(String s) {
        return s.matches("[0-9]{4}|[0-9]{6}");
    }
}
