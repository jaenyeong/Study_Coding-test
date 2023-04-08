package com.jaenyeong.programmers.book.ch04_bruteforce;

// [Lv2] 카펫
// https://school.programmers.co.kr/learn/courses/30/lessons/42842
public class Solution19 {

    public int[] solution(int brown, int yellow) {
        for (int width = 3; width < 5_000; width++) {
            for (int height = 3; height <= width; height++) {
                final int boundary = (width + height - 2) * 2;
                final int center = width * height - boundary;

                if (brown == boundary && yellow == center) {
                    return new int[]{width, height};
                }
            }
        }

        return null;
    }
}
