package com.algorithm.programmers.lv2;

import java.util.Arrays;

public class 거리두기_확인하기 {
    public static void main(String[] args) {
        solution();
    }

    private static int[] x = {-1,0,1,0,-1,-1,1,1,-2,2,0,0};
    private static int[] y = {0,1,0,-1,-1,1,1,-1,0,0,-2,2};
    public static int socialDistance(String[] place) {
        int check = 1;
        // 강의실 사람 1명씩 나누기
        char[][] p = new char[5][5];
        for(int i = 0; i < 5; i++)
            p[i] = place[i].toCharArray();

        // 좌석 거리 당 검사
        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < 5; j++) {
                if(p[i][j] == 'P') {
                    for(int k = 0; k < x.length; k++) {
                        int x2 = i + x[k];
                        int y2 = j + y[k];
                        if((x2 < 0 || x2 >= 5) || (y2 < 0 || y2 >= 5))
                            continue;

                        if(p[x2][y2] == 'P') {
                            if (k < 4) {
                                check = 0;
                                return check;
                            } else if (k == 4) {
                                if(p[x2+1][y2] == 'O' || p[x2][y2+1] == 'O') {
                                    check = 0;
                                    return check;
                                }
                            } else if (k == 5) {
                                if(p[x2+1][y2] == 'O' || p[x2][y2-1] == 'O') {
                                    check = 0;
                                    return check;
                                }
                            } else if (k == 6) {
                                if(p[x2-1][y2] == 'O' || p[x2][y2-1] == 'O') {
                                    check = 0;
                                    return check;
                                }
                            } else if (k == 7) {
                                if(p[x2-1][y2] == 'O' || p[x2][y2+1] == 'O') {
                                    check = 0;
                                    return check;
                                }
                            } else if (k == 8) {
                                if(p[x2+1][y2] == 'O') {
                                    check = 0;
                                    return check;
                                }
                            } else if (k == 9) {
                                if(p[x2-1][y2] == 'O') {
                                    check = 0;
                                    return check;
                                }
                            } else if (k == 10) {
                                if(p[x2][y2+1] == 'O') {
                                    check = 0;
                                    return check;
                                }
                            } else if (k == 11) {
                                if(p[x2][y2-1] == 'O') {
                                    check = 0;
                                    return check;
                                }
                            }
                        }
                    }
                }
            }
        }
        return check;
    }

    public static int[] solution() {
        String[][] places = {{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
                {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"}, {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
                {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"}, {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};
        int[] answer = new int[places.length];

        for(int i = 0; i < places.length; i++)
            answer[i] = socialDistance(places[i]);

        return answer;
    }
}