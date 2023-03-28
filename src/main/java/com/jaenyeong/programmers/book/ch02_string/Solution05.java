package com.jaenyeong.programmers.book.ch02_string;

// [Lv1] 자연수 뒤집어 배열로 만들기
// https://school.programmers.co.kr/learn/courses/30/lessons/12932
public class Solution05 {

    public int[] solution(long n) {
        final String givenValue = Long.toString(n);
        final String reversedValue = new StringBuilder(givenValue).reverse().toString();

        final char[] result = reversedValue.toCharArray();

        final int[] answer = new int[result.length];
        for (int i = 0; i < result.length; i++) {
            answer[i] = result[i] - '0';
        }

        return answer;
    }
}
