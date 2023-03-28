package com.jaenyeong.programmers.book.ch02_string;

// [Lv1] 이상한 문자 만들기
// https://school.programmers.co.kr/learn/courses/30/lessons/12930
public class Solution07 {

    public String solution(String s) {
        final StringBuilder answer = new StringBuilder();
        // 공백 후 인덱스 초기화하여 단어별로 짝수 대문자 처리를 위한 플래그
        boolean evenMark = true;

        for (char character: s.toCharArray()) {
            // 공백문자인 경우 그대로
            if (!Character.isAlphabetic(character)) {
                answer.append(character);
                evenMark = true;
                continue;
            }

            answer.append(evenMark ? Character.toUpperCase(character) : Character.toLowerCase(character));
            evenMark = !evenMark;
        }

        return answer.toString();
    }
}
