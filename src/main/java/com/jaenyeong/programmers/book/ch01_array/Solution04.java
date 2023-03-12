package com.jaenyeong.programmers.book.ch01_array;

// [Lv2] 행렬의 곱셈
// https://school.programmers.co.kr/learn/courses/30/lessons/12949
public class Solution04 {

    public int[][] solution(int[][] arr1, int[][] arr2) {
        final int[][] answer = new int[arr1.length][arr2[0].length];

        for (int i = 0; i < answer.length; i++) {
            for (int j = 0; j < answer[i].length; j++) {
                answer[i][j] = 0;

                for (int k = 0; k < arr1[i].length; k++) {
                    answer[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }

        return answer;
    }
}
