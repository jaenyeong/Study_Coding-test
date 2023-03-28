package com.jaenyeong.programmers.book.ch02_string;

// [Lv1] 문자열 내 p와 y의 개수
// https://school.programmers.co.kr/learn/courses/30/lessons/12916
public class Solution11 {

    boolean solution(String s) {
        s = s.toLowerCase();

        final int totalSize = s.length();
        final int sizeWithoutP = totalSize - s.replace("p", "").length();
        final int sizeWithoutY = totalSize - s.replace("y", "").length();

        return sizeWithoutP == sizeWithoutY;
    }
}
