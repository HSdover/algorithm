package com.algorithm.programmers.lv2;

import java.util.ArrayList;
import java.util.List;

public class 행렬_테두리_회전하기 {
    public static void main(String[] args) {
        solution();
    }

    public static int[] solution() {
        int rows = 6;
        int columns = 6;
        int[][] queries = {{2,2,5,4},{3,3,6,6},{5,1,6,3}};
        int[] answer = new int[queries.length];

        int val = 1;
        int[][] sq = new int[rows][columns];
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < columns; j++)
                sq[i][j] = val++;
        }

        for(int i = 0; i < queries.length; i++) {
            int x1 = queries[i][0] - 1;
            int y1 = queries[i][1] - 1;
            int x2 = queries[i][2];
            int y2 = queries[i][3];
            // 테두리 값 구하기
            for(int j = x1; j < x2; j++) {
                for(int k = y1; k < y2; k++) {
                    if(j == x1 || j == x2 - 1)
                        row.add(sq[j][k]);
                    else if(k == y1 || k == y2 - 1)
                        column.add(sq[j][k]);
                }
            }




        }

        return answer;
    }
}
