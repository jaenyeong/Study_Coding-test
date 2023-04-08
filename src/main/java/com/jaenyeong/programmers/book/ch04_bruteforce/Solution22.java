package com.jaenyeong.programmers.book.ch04_bruteforce;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Function;

// [Lv3] 불량 사용자
// https://school.programmers.co.kr/learn/courses/30/lessons/64064
public class Solution22 {

    public int solution(String[] userIds, String[] bannedIds) {
        final String[][] bans = Arrays.stream(bannedIds)
            .map(bannedId -> bannedId.replace('*', '.'))
            .map(matchBy(userIds))
            .toArray(String[][]::new);

        final Set<Set<String>> banSet = new HashSet<>();
        count(0, new HashSet<>(), bans, banSet);

        return banSet.size();
    }

    private static Function<String, String[]> matchBy(String[] userIds) {
        return bannedId ->
            Arrays.stream(userIds)
                .filter(userId -> userId.matches(bannedId))
                .toArray(String[]::new);
    }

    private void count(int index, Set<String> banned, String[][] bans, Set<Set<String>> banSet) {
        if (index == bans.length) {
            banSet.add(new HashSet<>(banned));
            return;
        }

        for (String id : bans[index]) {
            if (banned.contains(id)) {
                continue;
            }

            banned.add(id);
            count(index + 1, banned, bans, banSet);
            banned.remove(id);
        }
    }
}
