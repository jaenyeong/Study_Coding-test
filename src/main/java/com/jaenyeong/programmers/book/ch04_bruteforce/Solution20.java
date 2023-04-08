package com.jaenyeong.programmers.book.ch04_bruteforce;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// [Lv2] 수식 최대화
// https://school.programmers.co.kr/learn/courses/30/lessons/67257
public class Solution20 {
    private static final String[][] precedences = {
        "+-*".split(""),
        "+*-".split(""),
        "-+*".split(""),
        "-*+".split(""),
        "*+-".split(""),
        "*-+".split("")
    };

    public static long solution(final String expression) {
        final StringTokenizer tokenizer = new StringTokenizer(expression, "+-*", true);
        final List<String> tokens = new ArrayList<>();
        while (tokenizer.hasMoreTokens()) {
            tokens.add(tokenizer.nextToken());
        }

        long max = 0;
        for (String[] precedence : precedences) {
            long value = Math.abs(calculate(new ArrayList<>(tokens), precedence));
            if (value > max) {
                max = value;
            }
        }

        return max;
    }

    private static long calculate(List<String> tokens, String[] precedence) {
        for (String operator : precedence) {
            for (int i = 0; i < tokens.size(); i++) {
                if (!tokens.get(i).equals(operator)) {
                    continue;
                }

                final long leftHs = Long.parseLong(tokens.get(i - 1));
                final long rightHs = Long.parseLong(tokens.get(i + 1));
                final long result = calculate(leftHs, rightHs, operator);

                tokens.remove(i - 1);
                tokens.remove(i - 1);
                tokens.remove(i - 1);
                tokens.add(i - 1, String.valueOf(result));
                i -= 2;
            }
        }

        return Long.parseLong(tokens.get(0));
    }

    private static long calculate(long leftHs, long rightHs, String operator) {
        return switch (operator) {
            case "+" -> leftHs + rightHs;
            case "-" -> leftHs - rightHs;
            case "*" -> leftHs * rightHs;
            default -> 0;
        };
    }
}
