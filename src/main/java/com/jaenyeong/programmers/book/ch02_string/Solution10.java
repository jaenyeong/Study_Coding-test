package com.jaenyeong.programmers.book.ch02_string;

import java.util.Arrays;

// [Lv2] 이진 변환 반복하기
// https://school.programmers.co.kr/learn/courses/30/lessons/70129
public class Solution10 {

    public int[] solution(String s) {
        int loop = 0;
        int removed = 0;

        while (!s.equals("1")) {
            int zerosQty = countZero(s);
            loop++;
            removed += zerosQty;

            int ones = s.length() - zerosQty;
            s = Integer.toString(ones, 2);
        }

        return new int[] {loop, removed};
    }

    private int countZero(String s) {
        int zeros = 0;
        for (char c : s.toCharArray()) {
            if (c == '0') {
                zeros++;
            }
        }

        return zeros;
    }
}
