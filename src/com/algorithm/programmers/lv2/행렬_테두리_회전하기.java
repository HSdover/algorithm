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
        int[] answer = {};

        int val = 1;
        int[][] sq = new int[rows][columns];
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < columns; j++)
                sq[i][j] = val++;
        }



        return answer;
    }
}
