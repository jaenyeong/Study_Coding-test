package com.jaenyeong.programmers.book.ch07_hash;

import java.util.HashMap;
import java.util.Map;

// [Lv1] 완주하지 못한 선수
// https://school.programmers.co.kr/learn/courses/30/lessons/42576
public class Solution37 {

    public String solution(String[] participants, String[] completions) {
        final Map<String, Integer> completionMap = toMap(completions);

        for (String participant : participants) {
            int count = completionMap.getOrDefault(participant, 0);
            if (count == 0) {
                return participant;
            }

            completionMap.put(participant, --count);
        }

        return "";
    }

    private static Map<String, Integer> toMap(String[] completions) {
        final Map<String, Integer> completionMap = new HashMap<>();

        for (String completion : completions) {
            completionMap.put(completion, completionMap.getOrDefault(completion, 0) + 1);
        }

        return completionMap;
    }
}
