package com.jaenyeong.ch01_kakao.y2020.m09.question03;

import java.util.*;

public class GemShopping {
    /*
    [문제]
    보석 쇼핑
    개발자 출신으로 세계 최고의 갑부가 된 어피치는 스트레스를 받을 때면 이를 풀기 위해 오프라인 매장에 쇼핑을 하러 가곤 합니다.
    어피치는 쇼핑을 할 때면 매장 진열대의 특정 범위의 물건들을 모두 싹쓸이 구매하는 습관이 있습니다.
    어느 날 스트레스를 풀기 위해 보석 매장에 쇼핑을 하러 간 어피치는 이전처럼 진열대의 특정 범위의 보석을 모두 구매하되 특별히 아래 목적을 달성하고 싶었습니다.
    - 진열된 모든 종류의 보석을 적어도 1개 이상 포함하는 가장 짧은 구간을 찾아서 구매

    예를 들어 아래 진열대는 4종류의 보석(RUBY, DIA, EMERALD, SAPPHIRE) 8개가 진열된 예시입니다.
    진열대 번호  1   2    3    4   5   6       7        8
    보석 이름    DIA RUBY RUBY DIA DIA EMERALD SAPPHIRE DIA

    진열대의 3번부터 7번까지 5개의 보석을 구매하면 모든 종류의 보석을 적어도 하나 이상씩 포함하게 됩니다.

    진열대의 3, 4, 6, 7번의 보석만 구매하는 것은 중간에 특정 구간(5번)이 빠지게 되므로 어피치의 쇼핑 습관에 맞지 않습니다.

    진열대 번호 순서대로 보석들의 이름이 저장된 배열 gems가 매개변수로 주어집니다.
    이때 모든 보석을 하나 이상 포함하는 가장 짧은 구간을 찾아서 return 하도록 solution 함수를 완성해주세요.
    가장 짧은 구간의 시작 진열대 번호와 끝 진열대 번호를 차례대로 배열에 담아서 return 하도록 하며,
    만약 가장 짧은 구간이 여러 개라면 시작 진열대 번호가 가장 작은 구간을 return 합니다.

    [제한사항]
    * gems 배열의 크기는 1 이상 100,000 이하입니다.
      * gems 배열의 각 원소는 진열대에 나열된 보석을 나타냅니다.
      * gems 배열에는 1번 진열대부터 진열대 번호 순서대로 보석이름이 차례대로 저장되어 있습니다.
      * gems 배열의 각 원소는 길이가 1 이상 10 이하인 알파벳 대문자로만 구성된 문자열입니다.

    [입출력 예]
    gems                                                                 result
    ["DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"]  [3, 7]
    ["AA", "AB", "AC", "AA", "AC"]                                       [1, 3]
    ["XYZ", "XYZ", "XYZ"]                                                [1, 1]
    ["ZZZ", "YYY", "NNNN", "YYY", "BBB"]                                 [1, 5]

    [입출력 예에 대한 설명]

    입출력 예 #1
    문제 예시와 같습니다.

    입출력 예 #2
    3종류의 보석(AA, AB, AC)을 모두 포함하는 가장 짧은 구간은 [1, 3], [2, 4]가 있습니다.
    시작 진열대 번호가 더 작은 [1, 3]을 return 해주어야 합니다.

    입출력 예 #3
    1종류의 보석(XYZ)을 포함하는 가장 짧은 구간은 [1, 1], [2, 2], [3, 3]이 있습니다.
    시작 진열대 번호가 가장 작은 [1, 1]을 return 해주어야 합니다.

    입출력 예 #4
    4종류의 보석(ZZZ, YYY, NNNN, BBB)을 모두 포함하는 구간은 [1, 5]가 유일합니다.
    그러므로 [1, 5]를 return 해주어야 합니다.

     */

    public static void main(String[] args) {
        // 기댓값 : [3, 7]
//        String[] gems = {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"};

        // 기댓값 : [1, 5]
        String[] gems = {"ZZZ", "YYY", "NNNN", "YYY", "BBB"};

        // 기댓값 : [1, 1]
//        String[] gems = {"XYZ", "XYZ", "XYZ"};

        System.out.println(Arrays.toString(solution(gems)));
    }

    private static int[] solution(final String[] gems) {
        // 나열된 총 보석 수
        final int gemsSize = gems.length;
        // 나열된 보석 종류 수
        final int gemsKinds = new HashSet<>(Arrays.asList(gems)).size();
        // 보석을 담을 카트
        final Map<String, Integer> shoppingCart = new HashMap<>();

        // 반환할 결과값 (시작 위치, 끝 위치)
        final int[] answer = new int[2];

        // 보석 사이 최소 길이
        int minLength = 0;
        // 현재 보석 사이 길이
        int currLength = 0;

        // 반복 횟수
        final int loopLimit = gemsSize - gemsKinds;
        // 보석 위치
        int start = 0;
        int end = start;

        while ((start <= loopLimit) && (end <= gemsSize)) {
            // 모든 보석이 담겼는지 확인하기
            if (gemsKinds == shoppingCart.size()) {
                if (currLength == 0) {
                    // 현재 길이를 계산하여 삽입
                    currLength = getCurrLength(shoppingCart, currLength);
                }

                // 최소거리가 초기화되지 않았거나 현재 계산한 거리보다 큰 경우
                if ((minLength == 0) || (minLength > currLength)) {
                    answer[0] = start + 1;
                    answer[1] = end;
                    minLength = currLength;
                }

                // 카트에 담은 보석 제거
                int gemQty = shoppingCart.getOrDefault(gems[start], 0);
                if (gemQty <= 1) {
                    shoppingCart.remove(gems[start]);
                } else {
                    shoppingCart.put(gems[start], gemQty - 1);
                }

                start++;
                currLength--;
                continue;
            }

            // 배열의 범위를 벗어나면 탈출
            if (end >= gemsSize) break;

            // 모든 보석이 담겨있지 않다면 해당 위치 보석 삽입
            shoppingCart.put(gems[end], shoppingCart.getOrDefault(gems[end], 0) + 1);
            currLength++;
            end++;
        }

        return answer;
    }

    private static int getCurrLength(Map<String, Integer> shoppingCart, int sum) {
        for (Map.Entry<String, Integer> gem : shoppingCart.entrySet()) {
            sum += gem.getValue();
        }
        return sum;
    }
}
