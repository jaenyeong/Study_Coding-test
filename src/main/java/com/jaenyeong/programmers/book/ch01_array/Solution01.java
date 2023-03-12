package com.jaenyeong.programmers.book.ch01_array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// [Lv2] 교점에 별 만들기
// https://school.programmers.co.kr/learn/courses/30/lessons/87377
public class Solution01 {
    private final List<Point> points = new ArrayList<>();

    public String[] solution(int[][] line) {
        // 모든 직선 쌍에 대해 반복
        for (int first = 0; first < line.length; first++) {
            for (int second = first + 1; second < line.length; second++) {
                // 교점 좌표 구해서 정수인 경우 저장
                addIntersectionToPoints(line[first], line[second]);
            }
        }

        // 저장된 정수들에 대해 x, y 좌표의 최댓값, 최솟값 구하기
        Point minPoint = getMinPoint();
        Point maxPoint = getMaxPoint();

        // 2차원 배열 생성하여 좌표 위치에 별 삽입
        final char[][] resultArray = generateResultArray(minPoint, maxPoint);

        // 문자열 배열로 변환 후 반환
        return toString(resultArray);
    }

    private void addIntersectionToPoints(int[] first, int[] second) {
        final long a1 = first[0];
        final long b1 = first[1];
        final long c1 = first[2];

        final long a2 = second[0];
        final long b2 = second[1];
        final long c2 = second[2];

        final double x = (double) (b1 * c2 - b2 * c1) / (a1 * b2 - a2 * b1);
        final double y = (double) (a2 * c1 - a1 * c2) / (a1 * b2 - a2 * b1);

        if (x % 1 != 0 || y % 1 != 0) {
            return;
        }

        // 정수 좌표만 저장
        points.add(new Point((long) x, (long) y));
    }

    private Point getMinPoint() {
        long minX = Long.MAX_VALUE;
        long minY = Long.MAX_VALUE;

        for (Point p : points) {
            if (p.x < minX) minX = p.x;
            if (p.y < minY) minY = p.y;
        }

        return new Point(minX, minY);
    }

    private Point getMaxPoint() {
        long maxX = Long.MIN_VALUE;
        long maxY = Long.MIN_VALUE;

        for (Point p : points) {
            if (p.x > maxX) maxX = p.x;
            if (p.y > maxY) maxY = p.y;
        }

        return new Point(maxX, maxY);
    }

    private char[][] generateResultArray(Point minPoint, Point maxPoint) {
        // 최댓값, 최솟값을 통해 2차원 배열 크기 결정
        final int width = (int) (maxPoint.x - minPoint.x + 1);
        final int height = (int) (maxPoint.y - minPoint.y + 1);

        // 2차원 배열 생성
        char[][] arr = new char[height][width];
        for (char[] row : arr) {
            Arrays.fill(row, '.');
        }

        // 2차원 배열에 별 표시
        for (Point point : points) {
            int x = (int) (point.x - minPoint.x);
            int y = (int) (maxPoint.y - point.y);
            arr[y][x] = '*';
        }
        return arr;
    }

    private static String[] toString(char[][] resultArray) {
        String[] result = new String[resultArray.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = String.valueOf(resultArray[i]);
        }

        return result;
    }

    private static class Point {
        final long x, y;

        Point(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }
}
