package com.jaenyeong.programmers.book.ch02_string;

import java.util.ArrayList;
import java.util.List;

// [Lv2] 문자열 압축
// https://school.programmers.co.kr/learn/courses/30/lessons/60057
public class Solution08 {

    public int solution(String s) {
        int minValue = Integer.MAX_VALUE;

        for (int length = 1; length <= s.length(); length++) {
            int compressedSize = compress(s, length);
            if (compressedSize < minValue) {
                minValue = compressedSize;
            }
        }

        return minValue;
    }

    private int compress(String source, int length) {
        final StringBuilder compressStr = new StringBuilder();

        String last = "";
        int count = 0;

        for (String token : split(source, length)) {
            if (token.equals(last)) {
                count++;
                continue;
            }

            if (count > 1) {
                compressStr.append(count);
            }

            compressStr.append(last);
            last = token;
            count = 1;

        }

        // 마지막 남은 토큰 처리
        if (count > 1) {
            compressStr.append(count);
        }
        compressStr.append(last);

        return compressStr.length();
    }

    private List<String> split(String source, int length) {
        final List<String> tokens = new ArrayList<>();

        for (int startIdx = 0; startIdx < source.length(); startIdx += length) {
            int endIdx = startIdx + length;

            if (endIdx > source.length()) {
                endIdx = source.length();
            }
            tokens.add(source.substring(startIdx, endIdx));
        }

        return tokens;
    }
}
