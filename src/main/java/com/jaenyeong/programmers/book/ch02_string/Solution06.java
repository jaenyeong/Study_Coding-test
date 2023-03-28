package com.jaenyeong.programmers.book.ch02_string;

// [Lv1] 시저 암호
// https://school.programmers.co.kr/learn/courses/30/lessons/12926
public class Solution06 {

    public String solution(String s, int n) {
        final StringBuilder answer = new StringBuilder();
        for (char c : s.toCharArray()) {
            answer.append(push(c, n));
        }

        return answer.toString();
    }

    private char push(char c, int pushCount) {
        // 공백 등 문자가 아닌 경우
        if (!Character.isAlphabetic(c)) {
            return c;
        }

        // 대문자 또는 소문자 오프셋
        final int offset = Character.isUpperCase(c) ? 'A' : 'a';
        // 알파벳의 변환된 값 계산
        int position = c - offset;
        // 범위를 벗어나는 경우 0부터 다시 시작
        position = (position + pushCount) % ('Z' - 'A' + 1);

        return (char) (offset + position);
    }
}
