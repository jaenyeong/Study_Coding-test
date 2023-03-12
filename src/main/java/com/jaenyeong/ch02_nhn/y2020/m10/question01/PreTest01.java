package com.jaenyeong.ch02_nhn.y2020.m10.question01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringJoiner;

public class PreTest01 {
    /*
    [문제]
    모든 원소가 0 또는 1 인 행렬이 있습니다. 1 로 표시된 원소는 영역을 나타냅니다.
    여기에서 상하좌우에 인접한 1 은 같은 영역이라고 가정합니다. 각 영역의 크기는 1의 개수로 정의합니다.
    주어진 NxN 크기의 행렬에서 영역의 개수와 각 영역의 크기를 오름차순으로 출력하세요.

    [입력 제한사항]
    • 첫 번째 행은 행렬의 크기인 N 입니다. N은 1 이상 10 이하의 자연수입니다.
    • 입력 두 번째 행부터는 공백으로 구분된 0 과 1 로 행렬이 주어집니다. 각 행은 개행 문자(newline,\n)로 구분됩니다.

    [출력 제한사항]
    • 첫 번째 행은 영역의 개수를 출력합니다.
    • 두 번째 행은 각 영역의 크기를 공백으로 구분하여 오름차순으로 출력합니다.
    • 한 행의 끝은 불필요한 공백 없이 개행 문자(newline, \n)로 끝나야 합니다.
    • 영역이 존재하지 않을 경우 영역 수 0으로 1 행으로만 출력합니다.

    [행렬 및 영역 예시]
    0 1 1 0 0 0
    0 1 1 0 1 1
    0 0 0 0 1 1
    0 0 0 0 1 1
    1 1 0 0 1 0
    1 1 1 0 0 0

    영역 개수 : 3
    각 영역의 크기 : 4, 5, 7

    [예시 입/출력]

    [입력 1]
    6
    011000
    011011
    000011
    000011
    110010
    111000
    [출력 1]
    3
    457

    [입력 2]
    4
    0000
    0000
    0000
    0000
    [출력 2]
    0

    [입력 3]
    4
    1000
    1000
    0000
    0011
    [출력 3]
    2
    22

     */

    private static final int EMPTY = 0;
    private static final int ZONE = 1;

    private static final int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public static final int VISITED = -1;

    public static void main(String[] args) {
        // 기댓값 :
        // 3
        // 4 5 7
//        final int n = 6;
//        final int[][] board = new int[n][n];
//        board[0] = new int[]{0, 1, 1, 0, 0, 0};
//        board[1] = new int[]{0, 1, 1, 0, 1, 1};
//        board[2] = new int[]{0, 0, 0, 0, 1, 1};
//        board[3] = new int[]{0, 0, 0, 0, 1, 1};
//        board[4] = new int[]{1, 1, 0, 0, 1, 0};
//        board[5] = new int[]{1, 1, 1, 0, 0, 0};

        // 기댓값 :
        // 0
//        final int n = 4;
//        final int[][] board = new int[n][n];
//        board[0] = new int[]{0, 0, 0, 0};
//        board[1] = new int[]{0, 0, 0, 0};
//        board[2] = new int[]{0, 0, 0, 0};
//        board[3] = new int[]{0, 0, 0, 0};

        // 기댓값 :
        // 2
        // 2 2
        final int n = 4;
        final int[][] board = new int[n][n];
        board[0] = new int[]{1, 0, 0, 0};
        board[1] = new int[]{1, 0, 0, 0};
        board[2] = new int[]{0, 0, 0, 0};
        board[3] = new int[]{0, 0, 1, 1};

        solution(board, n);
    }

    private static void solution(final int[][] board, final int n) {
        final List<Integer> sizesOfZones = new ArrayList<>();

        // 각 영역을 순회
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (board[row][col] == ZONE) {
                    sizesOfZones.add(getSizeOfZone(board, n, row, col, 0));
                }
            }
        }

        printResult(sizesOfZones);
    }

    private static int getSizeOfZone(final int[][] board, final int n, final int row, final int col, int sizeOfZone) {
        // 유효 범위 여부 확인
        if ((0 > row) || (row >= n) || (0 > col) || (col >= n)
            // 빈 영역인 경우 종료
            || (board[row][col] == EMPTY)
            // 이미 방문한 영역인 경우 종료
            || (board[row][col] == VISITED)) {
            return sizeOfZone;
        }

        // 방문 처리
        board[row][col] = VISITED;

        // 영역 크기 증가
        sizeOfZone++;

        // 상하좌우 순회
        for (int[] dir : DIRECTIONS) {
            sizeOfZone = getSizeOfZone(board, n, row + dir[0], col + dir[1], sizeOfZone);
        }

        return sizeOfZone;
    }

    private static void printResult(final List<Integer> sizesOfZones) {
        final int size = sizesOfZones.size();

        // 영역 개수 출력
        System.out.println(size);

        // 영역 개수가 0 이하인 경우 종료
        if (size <= 0) return;

        // 영역 크기 오름차순 정렬
        Collections.sort(sizesOfZones);

        // 정렬된 영역 크기 출력
        StringJoiner sj = new StringJoiner(" ");
        sizesOfZones.forEach(s -> sj.add(s.toString()));
        System.out.println(sj.toString());
    }
}
