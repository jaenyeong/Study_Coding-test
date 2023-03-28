package com.jaenyeong.programmers.book.ch02_string;

// [Lv1] 숫자 문자열과 영단어
// https://school.programmers.co.kr/learn/courses/30/lessons/81301
public class Solution12 {
    private static final String[] words = {
        "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"
    };

    public int solution(String s) {
        s = s.toLowerCase();

        for (int i = 0; i < words.length; i++) {
            s = s.replace(words[i], Integer.toString(i));
        }

        return Integer.parseInt(s);
    }
}
