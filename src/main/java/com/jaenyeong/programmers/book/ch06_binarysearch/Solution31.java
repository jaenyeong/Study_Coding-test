package com.jaenyeong.programmers.book.ch06_binarysearch;

// [Lv3] 입국심사
// https://school.programmers.co.kr/learn/courses/30/lessons/43238
public class Solution31 {

    public long solution(int waitList, int[] times) {
        long startTime = 1L;
        long endTime = 1_000_000_000_000_000_000L;

        while (endTime > startTime) {
            final long midTime = (startTime + endTime) / 2;

            if (isValid(midTime, waitList, times)) {
                endTime = midTime;
            } else {
                startTime = midTime + 1;
            }
        }

        return startTime;
    }

    private boolean isValid(long targetTime, int waitList, int[] times) {
        long maxEnter = 0;

        for (int time : times) {
            maxEnter += (targetTime / time);
        }

        return maxEnter >= waitList;
    }
}
