package com.jaenyeong.programmers.book.ch04_bruteforce;

import java.util.stream.IntStream;

// [Lv1] 모의고사
// https://school.programmers.co.kr/learn/courses/30/lessons/42840
public class Solution18 {
    private static final int[][] RULES = {
        {1, 2, 3, 4, 5},
        {2, 1, 2, 3, 2, 4, 2, 5},
        {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
    };

    public int[] solution(int[] answers) {
        final int[] corrects = new int[3];
        int max = 0;

        for (int problem = 0; problem < answers.length; problem++) {
            final int givenAnswer = answers[problem];

            for (int person = 0; person < RULES.length; person++) {
                final int pickedAnswer = getPicked(person, problem);

                if (givenAnswer == pickedAnswer) {
                    if (++corrects[person] > max) {
                        max = corrects[person];
                    }
                }
            }
        }

        final int maxCorrects = max;
        return IntStream.range(0, 3)
            .filter(i -> corrects[i] == maxCorrects)
            .map(i -> i + 1)
            .toArray();
    }

    private int getPicked(int person, int problem) {
        final int[] rule = RULES[person];
        final int index = problem % rule.length;

        return rule[index];
    }
}
