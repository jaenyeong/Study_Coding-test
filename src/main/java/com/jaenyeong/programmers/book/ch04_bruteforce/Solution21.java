package com.jaenyeong.programmers.book.ch04_bruteforce;

import java.util.HashSet;
import java.util.Set;

// [Lv2] 소수 찾기
// https://school.programmers.co.kr/learn/courses/30/lessons/42839
public class Solution21 {
    public int solution(String nums) {
        final Set<Integer> primes = new HashSet<>();

        final int[] numbers = nums.chars().map(c -> c - '0').toArray();
        return getPrimes(0, numbers, new boolean[numbers.length], primes).size();
    }

    private static Set<Integer> getPrimes(int acc, int[] numbers, boolean[] isUsed, Set<Integer> primes) {
        if (isPrime(acc)) {
            primes.add(acc);
        }

        for (int i = 0; i < numbers.length; i++) {
            if (isUsed[i]) {
                continue;
            }

            final int nextAcc = acc * 10 + numbers[i];

            isUsed[i] = true;
            getPrimes(nextAcc, numbers, isUsed, primes);
            isUsed[i] = false;
        }

        return primes;
    }

    private static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }

        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }
}
