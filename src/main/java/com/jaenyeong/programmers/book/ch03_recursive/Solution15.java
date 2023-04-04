package com.jaenyeong.programmers.book.ch03_recursive;

// [Lv2] 쿼드압축 후 개수 세기
// https://school.programmers.co.kr/learn/courses/30/lessons/68936
public class Solution15 {

    public int[] solution(int[][] arr) {
        Count count = count(0, 0, arr.length, arr);

        return new int[]{count.zero, count.one};
    }

    private Count count(int offsetX, int offsetY, int size, int[][] arr) {
        int halfSize = size / 2;

        for (int x = offsetX; x < offsetX + size; x++) {
            for (int y = offsetY; y < offsetY + size; y++) {

                if (arr[x][y] != arr[offsetX][offsetY]) {
                    return count(offsetX, offsetY, halfSize, arr)
                        .add(count(offsetX + halfSize, offsetY, halfSize, arr))
                        .add(count(offsetX, offsetY + halfSize, halfSize, arr))
                        .add(count(offsetX + halfSize, offsetY + halfSize, halfSize, arr));
                }
            }
        }

        if (arr[offsetX][offsetY] == 1) {
            return new Count(0, 1);
        }

        return new Count(1, 0);
    }

    private static class Count {
        final int zero;
        final int one;

        public Count(int zero, int one) {
            this.zero = zero;
            this.one = one;
        }

        public Count add(Count other) {
            return new Count(zero + other.zero, one + other.one);
        }
    }
}
