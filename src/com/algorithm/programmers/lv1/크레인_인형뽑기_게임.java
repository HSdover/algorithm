package com.algorithm.programmers.lv1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 크레인_인형뽑기_게임 {

    public static void main(String[] args) {
        solution();
    }

    public static int solution() {
        int[][] board = {{0,0,0,0,0},
                        {0,0,1,0,3},
                        {0,2,5,0,1},
                        {4,2,4,4,2},
                        {3,5,1,3,1}};
        int[] moves = {1,5,3,5,1,2,1,4};
        int answer = 0;

        List<Integer> doll = new ArrayList<Integer>();
        for(int num : moves) {
            for(int i = 0; i < board.length; i++) {
                if(board[i][num-1] != 0) {
                    doll.add(board[i][num-1]);
                    board[i][num-1] = 0;
                    break;
                }
            }
        }

        int idx = 1;
        while(true) {
            if(doll.get(idx) == doll.get(idx-1)) {
                doll.remove(idx);
                doll.remove(idx-1);
                answer += 2;
                idx = 1;
                if(doll.size() == 0 || doll.size() == 1) {
                    break;
                }
            }
            else if(idx == doll.size() - 1)
                break;
            else
                idx++;
        }
        return answer;
    }
}
