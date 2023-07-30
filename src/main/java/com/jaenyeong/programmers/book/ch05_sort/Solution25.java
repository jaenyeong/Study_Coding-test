package com.jaenyeong.programmers.book.ch05_sort;

import java.util.Arrays;

// [Lv2] H-Index
// https://school.programmers.co.kr/learn/courses/30/lessons/42747
public class Solution25 {

    public int solution(int[] citations) {
        Arrays.sort(citations);

        for (int idx = citations.length; idx > 0; idx--) {
            if (isHIdx(citations, idx)) {
                return idx;
            }
        }

        return 0;
    }

    private boolean isHIdx(int[] citations, int curIdx) {
        final int targetIdx = citations.length - curIdx;
        return citations[targetIdx] >= curIdx;
    }
}
