package com.jaenyeong.programmers.book.ch07_hash;

// [Lv0] 평행
// https://school.programmers.co.kr/learn/courses/30/lessons/120875
public class Solution33 {

    public int solution(int[][] dots) {
        if (getSlope(dots[0], dots[1]) == getSlope(dots[2], dots[3])) {
            return 1;
        }

        if (getSlope(dots[0], dots[2]) == getSlope(dots[1], dots[3])) {
            return 1;
        }

        if (getSlope(dots[0], dots[3]) == getSlope(dots[1], dots[2])) {
            return 1;
        }

        return 0;
    }

    private static double getSlope(int[] dot1, int[] dot2) {
        return Math.abs((double) (dot2[1] - dot1[1]) / (dot2[0] - dot1[0]));
    }
}
