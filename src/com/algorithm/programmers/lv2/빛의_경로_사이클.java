package com.algorithm.programmers.lv2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class 빛의_경로_사이클 {
    public static void main(String[] args) {
        solution();
    }


    static int R, C;
    static int[] mr = {-1, 0, 1, 0};
    static int[] mc = {0, -1, 0, 1};
    static boolean[][][] move;
    public static List<Integer> solution() {
        String[] grid = {"SL","LR"};
        List<Integer> answer = new ArrayList<>();

        R = grid.length;
        C = grid[0].length();
        move = new boolean[R][C][4];
        //k -> [0] > 위, [1] > 오른쪽, [2] > 아래, [3] > 왼쪽
        for(int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++) {
                for(int m = 0; m < 4; m++) {
                    if(!move[i][j][m])
                        answer.add(cycle(grid, i, j, m));
                }
            }
        }
        answer.sort(Comparator.naturalOrder());
        return answer;
    }

    private static int cycle(String[] grid, int r, int c, int m) {
        int cnt = 0;

        while(true) {
            if(move[r][c][m]) break;
            cnt++;
            move[r][c][m] = true;

            if(grid[r].charAt(c) == 'L')
                m = m == 0 ? 3 : m-1;
            else if(grid[r].charAt(c) == 'R')
                m = m == 3 ? 0 : m+1;

            r = (r + mr[m] +R) %R;
            c = (c + mc[m] + C) % C;
        }

        return cnt;
    }
}
