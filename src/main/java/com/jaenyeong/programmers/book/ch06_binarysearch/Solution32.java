package com.jaenyeong.programmers.book.ch06_binarysearch;

import java.util.Arrays;

// [Lv4] 징검다리
// https://school.programmers.co.kr/learn/courses/30/lessons/43236
public class Solution32 {

    public int solution(int distance, int[] rocks, int numberOfRemoval) {
        rocks = Arrays.copyOf(rocks, rocks.length + 1);
        rocks[rocks.length - 1] = distance;
        Arrays.sort(rocks);

        int startDistance = 1;
        int endDistance = distance + 1;

        while (endDistance - startDistance > 1) {
            int midDistance = (startDistance + endDistance) / 2;

            if (isValid(midDistance, rocks, numberOfRemoval)) {
                startDistance = midDistance;
            } else {
                endDistance = midDistance;
            }
        }

        return startDistance;
    }

    private boolean isValid(int distance, int[] rocks, int numberOfRemoval) {
        int removedRockCount = 0;
        int lastRock = 0;

        for (int rock : rocks) {
            if (rock - lastRock < distance) {
                removedRockCount++;
                continue;
            }

            lastRock = rock;
        }

        return removedRockCount <= numberOfRemoval;
    }
}
