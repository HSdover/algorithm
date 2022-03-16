package com.algorithm.programmers.lv1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 카펫 {
    public static void main(String[] args) {
        카펫 t = new 카펫();
        t.solution(24, 24);
    }

    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int sum = brown + yellow;

        for(int i = 1; i < Math.sqrt(sum); i++) {
            if(sum % i == 0) {
                if((i-2) * (sum/i-2) == sum) {
                    if(i > sum/i) {
                        answer[0] = i;
                        answer[1] = sum/i;
                    }
                    else {
                        answer[0] = sum/i;
                        answer[1] = i;
                    }
                }
            }
        }


        return answer;
    }
}
