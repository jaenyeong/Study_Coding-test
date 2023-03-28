package com.jaenyeong.programmers.book.ch02_string;

// [Lv1] 3진법 뒤집기
// https://school.programmers.co.kr/learn/courses/30/lessons/68935
public class Solution09 {

    public int solution(int n) {
        final String givenStr = Integer.toString(n, 3);

        final String reversed = new StringBuilder(givenStr).reverse().toString();

        return Integer.valueOf(reversed, 3);
    }
}
