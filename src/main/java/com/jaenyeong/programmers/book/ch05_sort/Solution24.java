package com.jaenyeong.programmers.book.ch05_sort;

import java.util.HashSet;
import java.util.Set;

// [Lv1] 두 개 뽑아서 더하기
// https://school.programmers.co.kr/learn/courses/30/lessons/68644
public class Solution24 {

    public int[] solution(int[] numbers) {
        final Set<Integer> sumNumbers = new HashSet<>();

        for (int first = 0; first < numbers.length - 1; first++) {
            for (int second = first + 1; second < numbers.length; second++) {
                sumNumbers.add(numbers[first] + numbers[second]);
            }
        }

        return sumNumbers.stream().mapToInt(i -> i).sorted().toArray();
    }
}
