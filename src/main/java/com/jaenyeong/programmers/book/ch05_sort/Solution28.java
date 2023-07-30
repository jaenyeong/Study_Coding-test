package com.jaenyeong.programmers.book.ch05_sort;

import java.util.Arrays;
import java.util.stream.Collectors;

// [Lv2] 가장 큰 수
// https://school.programmers.co.kr/learn/courses/30/lessons/42746
public class Solution28 {

    public String solution(int[] numbers) {
        return Arrays.stream(numbers)
            .mapToObj(String::valueOf)
            .sorted((s1, s2) -> {
                final int sequence = Integer.parseInt(s1 + s2);
                final int reversed = Integer.parseInt(s2 + s1);

                return reversed - sequence;
            })
            .collect(Collectors.joining(""))
            .replaceAll("^0+", "0");
    }
}
