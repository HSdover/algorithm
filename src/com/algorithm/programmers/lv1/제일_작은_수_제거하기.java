package com.algorithm.programmers.lv1;

import java.util.Arrays;

public class 제일_작은_수_제거하기 {
    public static void main(String[] args) {
        solution();
    }

    public static int[] solution() {
        int[] arr = {4,3,2,1};
        int[] answer;
        if(arr.length != 1)
            answer = new int[arr.length-1];
        else
            answer = new int[1];

        int min = arr[0], minIdx = 0;
        for(int i = 1; i < arr.length; i++) {
            if(arr[i] < min) {
                min = arr[i];
                minIdx = i;
            }
        }
        int idxA = 0, idxArr = 0;
        if(answer.length != 1) {
            while(idxA < answer.length) {
                if(minIdx != idxArr)
                    answer[idxA++] = arr[idxArr++];
                else
                    idxArr++;
            }
        }
        else
            answer[0] = -1;

        return answer;
    }
}
