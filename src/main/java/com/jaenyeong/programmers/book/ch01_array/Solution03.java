package com.jaenyeong.programmers.book.ch01_array;

// [Lv2] 거리두기 확인하기
// https://school.programmers.co.kr/learn/courses/30/lessons/81302
public class Solution03 {
    private static final char PERSON = 'P';
    private static final char EMPTY_TABLE = 'O';
    private static final char PARTITION = 'X';

    private static final int[] dx = {-1, 0, 0, 1};
    private static final int[] dy = {0, -1, 1, 0};

    public int[] solution(String[][] places) {
        final int[] answer = new int[places.length];

        for (int i = 0; i < answer.length; i++) {
            final String[] place = places[i];
            final char[][] room = new char[place.length][];

            for (int j = 0; j < room.length; j++) {
                room[j] = place[j].toCharArray();
            }

            answer[i] = isDistanced(room) ? 1 : 0;
        }

        return answer;
    }

    private boolean isDistanced(char[][] room) {
        for (int x = 0; x < room.length; x++) {
            for (int y = 0; y < room.length; y++) {
                if (room[x][y] != 'P') {
                    continue;
                }
                if (!isDistanced(room, x, y)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isDistanced(char[][] room, int x, int y) {
        for (int d = 0; d < 4; d++) {
            final int nx = x + dx[d];
            final int ny = y + dy[d];

            if (ny < 0 || ny >= room.length || nx < 0 || nx >= room.length) {
                continue;
            }

            switch (room[nx][ny]) {
                case 'P': return false;
                case 'O':
                    if (isNextToVolunteer(room, nx, ny, 3 - d)) {
                        return false;
                    }
                    break;
                default:
                    break;
            }
        }
        return true;
    }

    private boolean isNextToVolunteer(char[][] room, int x, int y, int exclude) {
        for (int d = 0; d < 4; d++) {
            if (d == exclude) {
                continue;
            }

            final int nx = x + dx[d];
            final int ny = y + dy[d];
            if (ny < 0 || ny >= room.length || nx < 0 || nx >= room.length) {
                continue;
            }

            if (room[nx][ny] == 'P') {
                return true;
            }
        }
        return false;
    }
}
