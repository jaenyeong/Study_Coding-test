package com.jaenyeong.programmers.book.ch05_sort;

import java.util.Arrays;

// [Lv1] K번째 수
// https://school.programmers.co.kr/learn/courses/30/lessons/42748
public class Solution23 {

    public int[] solution(int[] array, int[][] commands) {
        final int[] answers = new int[commands.length];

        for (int i = 0; i < answers.length; i++) {
            final int[] command = commands[i];
            final int from = command[0] - 1;
            final int to = command[1];
            final int targetIdx = command[2] - 1;

            final int[] targetRange = Arrays.copyOfRange(array, from, to);
            Arrays.sort(targetRange);

            answers[i] = targetRange[targetIdx];
        }

        return answers;
    }
}
