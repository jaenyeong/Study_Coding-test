package com.jaenyeong.programmers.book.ch07_hash;

import java.util.HashSet;
import java.util.Set;

// [Lv1] 없는 숫자 더하기
// https://school.programmers.co.kr/learn/courses/30/lessons/86051
public class Solution36 {

    public int solution(int[] numbers) {
        final Set<Integer> existNumbers = toExistNumbers(numbers);

        int result = 0;
        for (int i = 1; i <= 9; i++) {
            if (!existNumbers.contains(i)) {
                result += i;
            }
        }

        return result;
    }

    private static Set<Integer> toExistNumbers(int[] numbers) {
        final Set<Integer> existNumbers = new HashSet<>();
        for (int num : numbers) {
            existNumbers.add(num);
        }

        return existNumbers;
    }
}
