package com.jaenyeong.programmers.book.ch06_binarysearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

// [Lv2] 순위 검색
// https://school.programmers.co.kr/learn/courses/30/lessons/72412
public class Solution30 {

    public int[] solution(String[] infos, String[] queries) {
        final Map<String, List<Integer>> scoresMap = buildScoresMap(infos);

        int[] answer = new int[queries.length];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = count(queries[i], scoresMap);
        }

        return answer;
    }

    private Map<String, List<Integer>> buildScoresMap(String[] infos) {
        final Map<String, List<Integer>> scoresMap = new HashMap<>();

        for (String info : infos) {
            final String[] infoTokens = info.split(" ");
            final int score = Integer.parseInt(infoTokens[infoTokens.length - 1]);

            forEachKey(0, "", infoTokens, key -> {
                scoresMap.putIfAbsent(key, new ArrayList<>());
                scoresMap.get(key).add(score);
            });
        }

        for (List<Integer> list : scoresMap.values()) {
            Collections.sort(list);
        }

        return scoresMap;
    }

    private void forEachKey(int index, String prefixKey, String[] infoTokens, Consumer<String> action) {
        if (index == infoTokens.length - 1) {
            action.accept(prefixKey);
            return;
        }

        forEachKey(index + 1, prefixKey + infoTokens[index], infoTokens, action);
        forEachKey(index + 1, prefixKey + "-", infoTokens, action);
    }

    private int count(String queries, Map<String, List<Integer>> scoresMap) {
        final String[] queryTokens = queries.split(" (and )?");
        final String key = String.join("", Arrays.copyOf(queryTokens, queryTokens.length - 1));

        if (!scoresMap.containsKey(key)) {
            return 0;
        }

        final List<Integer> scores = scoresMap.get(key);
        final int score = Integer.parseInt(queryTokens[queryTokens.length - 1]);

        return scores.size() - binarySearch(score, scores);
    }

    private int binarySearch(int score, List<Integer> scores) {
        int start = 0;
        int end = scores.size() - 1;

        while (end > start) {
            final int mid = (start + end) / 2;

            if (scores.get(mid) >= score) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        if (scores.get(start) < score) {
            return scores.size();
        }

        return start;
    }
}
