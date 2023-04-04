package com.jaenyeong.programmers.book.ch03_recursive;

import java.util.ArrayList;
import java.util.List;

// [Lv3] 하노이의 탑
// https://school.programmers.co.kr/learn/courses/30/lessons/12946
public class Solution16 {

    public int[][] solution(int n) {
        final List<int[]> histories = new ArrayList<>();
        move(n, 1, 3, histories);

        return histories.toArray(new int[0][]);
    }

    private void move(int currentDisks, int from, int to, List<int[]> histories) {
        if (currentDisks == 1) {
            histories.add(new int[]{from, to});
            return;
        }

        // 빈 기둥은 (6 - from - to)
        final int empty = 6 - from - to;

        move(currentDisks - 1, from, empty, histories);
        move(1, from, to, histories);
        move(currentDisks - 1, empty, to, histories);
    }
}
