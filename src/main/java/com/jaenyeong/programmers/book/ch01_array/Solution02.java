package com.jaenyeong.programmers.book.ch01_array;

// [Lv2] 삼각 달팽이
// https://school.programmers.co.kr/learn/courses/30/lessons/68645/
public class Solution02 {
    private static final int[] dx = {1, 0, -1};
    private static final int[] dy = {0, 1, -1};
    private static final int EMPTY = 0;

    public int[] solution(int n) {
        final int[][] triangle = new int[n][n];

        int value = 1;
        int x = 0;
        int y = 0;
        int direction = 0;

        while (true) {
            triangle[x][y] = value++;
            int nextX = x + dx[direction];
            int nextY = y + dy[direction];

            if (isNotValidateRange(n, triangle, nextX, nextY)) {
                direction = (direction + 1) % 3;
                nextX = x + dx[direction];
                nextY = y + dy[direction];

                if (isNotValidateRange(n, triangle, nextX, nextY)) {
                    break;
                }
            }

            x = nextX;
            y = nextY;
        }

        // 결과를 1차원 배열에 담아 반환
        return generateResult(n, triangle, value);
    }

    private static boolean isNotValidateRange(int n, int[][] triangle, int nextX, int nextY) {
        return nextX == n || nextY == n || nextX == -1 || nextY == -1 || triangle[nextX][nextY] != EMPTY;
    }

    private static int[] generateResult(int n, int[][] triangle, int value) {
        int[] answer = new int[value - 1];
        int answerIdx = 0;
        for (int row = 0; row < n; row++) {
            for (int col = 0; col <= row; col++) {
                answer[answerIdx++] = triangle[row][col];
            }
        }

        return answer;
    }
}
